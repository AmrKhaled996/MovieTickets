package com.mycompany.movie;
import com.mycompany.movie.Hall.Hall;

import com.mycompany.movie.Movies.Movie;
import com.mycompany.movie.Movies.ScreenTime;
import com.mycompany.movie.Movies.enGenre;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    
    private static final String URL = "jdbc:mysql://localhost:3306/movietickets";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    /*
    *add Delete movie.
    
    *add update hall seats.
    
    *add list receipts.
    
    */
    
    
    
    
    public static Date parseDate(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
           
    public static String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
    
    
    
    public static void addScreenTime(ScreenTime screenTime, int movieID) throws ParseException {
    try (Connection conn = getConnection();
         PreparedStatement checkStmt = conn.prepareStatement(
             "SELECT * FROM screentime WHERE Hall_idHall = ? AND startDate = ? AND endDate = ?")) {

//        2024-11-21 00:00:00
        
       
        checkStmt.setByte(1, (byte) screenTime.getHall().getID());
        // to date from string
            checkStmt.setString(2, formatDate(new java.sql.Date(screenTime.getStartDate().getTime())));
            checkStmt.setString(3, formatDate(new java.sql.Date(screenTime.getEndDate().getTime())));
//        System.out.println(checkStmt.getString(2, new java.sql.Date(screenTime.getStartDate().getTime())));

        ResultSet rs = checkStmt.executeQuery();
        if (rs.next()) { 
            System.out.println("ScreenTime already exists. Skipping insertion.");
            return;
        }

        // Insert if no duplicate
        try (PreparedStatement stmt = conn.prepareStatement(
            "INSERT INTO screentime (Hall_idHall, startDate, endDate, Movies_movieID) VALUES (?, ?, ?, ?)")) {

            stmt.setByte(1, (byte) screenTime.getHall().getID());
            stmt.setString(2, formatDate(new java.sql.Date(screenTime.getStartDate().getTime())));
            stmt.setString(3, formatDate(new java.sql.Date(screenTime.getEndDate().getTime())));
            stmt.setInt(4, movieID);

            stmt.executeUpdate();
            System.out.println("ScreenTime added successfully.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


  


    public static void addMovieWithScreenTimes(Movie movie) throws ParseException {
        String sql = "INSERT INTO movies (title, genre, duration, poster) VALUES (?, ?, ?,?)";
try (Connection connection = Database.getConnection();
         PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
         
         stmt.setString(1, movie.getTitle());
         stmt.setString(2, movie.getGenre());
         stmt.setFloat(3, movie.getDuration());
         stmt.setString(4, movie.getPoster());

        int affectedRows = stmt.executeUpdate();
        if (affectedRows > 0) {
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int movieId = generatedKeys.getInt(1);
                    
                    System.out.println("Movie added with ID: " + movieId);

                    // Add ScreenTimes
                    for (ScreenTime screenTime : movie.getScreenTimes()) {
                        addScreenTime(screenTime, movieId);
                    }
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        }
public static List<Movie> listMoviesWithScreenTimes() { 
    
            List<ScreenTime> screenTimes = new ArrayList<>();
    String movieandHallSql = "SELECT * FROM movies , hall";
    
    String screenTimeSql = "SELECT st.startDate, st.endDate, h.idHall, h.numberOfRows, h.numberOfCols " +
                           "FROM screentime st " +
                           ", hall h " +
                           "WHERE st.Movies_movieID = ? AND st.Hall_idHall = ? ";
    List<Movie> movies = new ArrayList<>();

    try (Connection connection = Database.getConnection();
         PreparedStatement movieStmt = connection.prepareStatement(movieandHallSql);
         ResultSet movieResultSet = movieStmt.executeQuery()) {

        while (movieResultSet.next()) {
            int movieId = movieResultSet.getInt("movieID");
            int hallId=movieResultSet.getInt("idHall");
            String title = movieResultSet.getString("title");
            enGenre genre = enGenre.valueOf(movieResultSet.getString("genre").toUpperCase());
            float duration = movieResultSet.getFloat("duration");
            String poster = movieResultSet.getString("poster");

            try (PreparedStatement screenTimeStmt = connection.prepareStatement(screenTimeSql)) {
                screenTimeStmt.setInt(1, movieId);
                screenTimeStmt.setInt(2, hallId);

                try (ResultSet screenTimeResultSet = screenTimeStmt.executeQuery()) {
                    while (screenTimeResultSet.next()) { 
                        
                        Date startDate = parseDate(screenTimeResultSet.getString("startDate"));
                       
                        Date endDate = parseDate(screenTimeResultSet.getString("endDate"));
                        
                        Hall hall = new Hall(
                            (byte) screenTimeResultSet.getInt("idHall"),
                            screenTimeResultSet.getInt("numberOfRows"),
                            screenTimeResultSet.getInt("numberOfCols")
                        );
                        
                        screenTimes.add(new ScreenTime(hall, startDate, endDate));
                        
                    }
                }
            }
                        

            // Ensure screenTimes is not empty before creating the Movie object
            if (screenTimes.isEmpty()) {
                System.out.println("No screen times found for movie ID: " + movieId + ". Skipping movie.");
                continue; // Skip this movie
            }
           

            movies.add(new Movie(title, genre, screenTimes, poster));
        }
    } catch (SQLException | IllegalArgumentException e) {
        e.printStackTrace();
    }

    return movies;
}
public static List<ScreenTime> listMovieScreenTimes(Movie movie) { 
    
            List<ScreenTime> screenTimes = new ArrayList<>();
    String movieandHallSql = "SELECT * FROM movies , hall";
    
    String screenTimeSql = "SELECT st.startDate, st.endDate, h.idHall, h.numberOfRows, h.numberOfCols " +
                           "FROM screentime st " +
                           ", hall h " +
                           "WHERE st.Movies_movieID = "+ movie.getID() +"  AND st.Hall_idHall = ? ";
    

    try (Connection connection = Database.getConnection();
         PreparedStatement movieStmt = connection.prepareStatement(movieandHallSql);
         ResultSet movieResultSet = movieStmt.executeQuery()) {

        while (movieResultSet.next()) {
            int movieId = movieResultSet.getInt("movieID");
            int hallId=movieResultSet.getInt("idHall");
            

            try (PreparedStatement screenTimeStmt = connection.prepareStatement(screenTimeSql)) {
                screenTimeStmt.setInt(1, movieId);
                screenTimeStmt.setInt(2, hallId);

                try (ResultSet screenTimeResultSet = screenTimeStmt.executeQuery()) {
                    while (screenTimeResultSet.next()) { 
                        
                        Date startDate = parseDate(screenTimeResultSet.getString("startDate"));
                       
                        Date endDate = parseDate(screenTimeResultSet.getString("endDate"));
                        
                        Hall hall = new Hall(
                            (byte) screenTimeResultSet.getInt("idHall"),
                            screenTimeResultSet.getInt("numberOfRows"),
                            screenTimeResultSet.getInt("numberOfCols")
                        );
                        
                        screenTimes.add(new ScreenTime(hall, startDate, endDate));
                        
                    }
                }
            }
                        

            // Ensure screenTimes is not empty before creating the Movie object
            if (screenTimes.isEmpty()) {
                System.out.println("No screen times found for movie ID: " + movieId + ". Skipping movie.");
                return null; // Skip this movie
            }
           

            
        }
    } catch (SQLException | IllegalArgumentException e) {
        e.printStackTrace();
    }

    return screenTimes;
}

    public static void insertSeatsIntoHall(int hallId, int numberOfRows, int numberOfCols ,Hall.Seat seats[][]) {
        String insertSeatSql = "INSERT INTO Seats (idSeats, Hall_idHall, isAvailable, price, classType) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSeatSql)) {

            // Loop through rows and columns to generate seat IDs
            for (char row = 'A'; row < 'A' + numberOfRows; row++) {
                for (int col = 1; col <= numberOfCols; col++) {
                    String seatId = row + String.valueOf(col); // Generate seat ID (e.g., "A1", "B2")

                    // Set parameters for the SQL query
                    preparedStatement.setString(1, seatId);         // idSeats
                    preparedStatement.setInt(2, hallId);           // Hall_idHall
                    preparedStatement.setBoolean(3, true);         // isAvailable (default true)
                    preparedStatement.setFloat(4, seats[row][col].getPrice());   // price
                    preparedStatement.setString(5, seats[row][col].getClassType());     // classType

                    // Execute the insert query
                    preparedStatement.addBatch(); // Add to batch for efficiency
                }
            }

            // Execute the batch
            preparedStatement.executeBatch();
            System.out.println("Seats successfully inserted for Hall ID: " + hallId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void updateSeatAvailability(String seatId, byte hallId, boolean isAvailable) {
        String updateSql = "UPDATE Seats SET isAvailable = ? WHERE idSeats = ? AND Hall_idHall = ?";

        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateSql)) {

            preparedStatement.setBoolean(1, isAvailable); // Set availability (true/false)
            preparedStatement.setString(2, seatId);       // Set the seat ID (e.g., "A1")
            preparedStatement.setInt(3, hallId);          // Set the hall ID

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Seat availability updated successfully.");
            } else {
                System.out.println("No matching seat found to update.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
     public static void addCustomer(String name , int age ) {
        String sql = "INSERT INTO customer ( name, age) VALUES (?, ?)";

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            statement.setInt(2, age);
            
            statement.executeUpdate();
            System.out.println("Customer added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listCustomers() {
        String sql = "SELECT * FROM customer";

        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("CustomerID") +
                                   ", Name: " + resultSet.getString("name") +
                                   ", Age: " + resultSet.getString("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
     public static void addReceipt(int movieId, int customerId, float totalPrice, int hallId, List<String> seatIds) {
    String receiptSql = "INSERT INTO receipt (ScreenTime_Movies_movieID, Customer_CustomerID, totalPrice, ScreenTime_Hall_idHall) VALUES (?, ?, ?, ?)";
    String seatSql = "INSERT INTO seats_has_receipt (Receipt_ReceiptID, Seats_idSeats) VALUES (?, ?)";

    try (Connection connection = Database.getConnection()) {
        connection.setAutoCommit(false); // Begin transaction

        int receiptId = -1; // Declare receiptId outside the try block

        // Insert into receipts
        try (PreparedStatement receiptStmt = connection.prepareStatement(receiptSql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            receiptStmt.setInt(1, movieId);
            receiptStmt.setInt(2, customerId);
            receiptStmt.setFloat(3, totalPrice);
            receiptStmt.setInt(4, hallId);
//            receiptStmt.setInt(5, screenTimeId);
            receiptStmt.executeUpdate();

            ResultSet keys = receiptStmt.getGeneratedKeys();
            if (keys.next()) {
                receiptId = keys.getInt(1);
            } else {
                throw new SQLException("Receipt insertion failed, no ID obtained.");
            }
        }

        // Insert into receipt_seats
        try (PreparedStatement seatStmt = connection.prepareStatement(seatSql)) {
            for (String seatId : seatIds) {
                seatStmt.setInt(1, receiptId);
                seatStmt.setString(2, seatId);
                seatStmt.addBatch();
            }
            seatStmt.executeBatch();
        }

        connection.commit(); // Commit transaction
        System.out.println("Receipt added successfully with ID: " + receiptId);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    
}