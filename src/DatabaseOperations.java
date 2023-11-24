/**
 * Java interface to PostgreSQL.
 *
 * Adapted from demonstration code taken from Professor A. Orogat's GitHub 
 * repository, COMP3005_DBMS, which was provided as a reference in lecture.
 *
 * Thanks for providing this!
 *
 * @author A. Orogat
 * @version 2023
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.ArrayList;


public class DatabaseOperations {

    // Constants
    private final String url = "jdbc:postgresql://localhost:5432/a4q1_student_DB";

    // Instance Variables
    private String user;
    private String password;

    // Constructor
    public DatabaseOperations() {
        this.user = null;
        this.password = null;
    }

    // Set DB credentials for access
    public void setCredentials(String user, String password) {
        this.user = user;
        this.password = password;
        System.out.println("Access credentials updated for DB " + url + ".");
    }

    // Print all tuples
    public ArrayList<String> getAllStudents() {

        // ArrayList to hold records
        ArrayList<String> resultArray = new ArrayList<String>();

        String SQL = "SELECT * FROM students";
        ResultSet rs;

        try (Connection conn = DriverManager.getConnection(url, user, password);

            Statement stmt = conn.createStatement()) {
            rs = stmt.executeQuery(SQL);
            System.out.println("Query successfully!");

            // Print and also accumulate to Strings for return
            while (rs.next()) {

                String tupleString = "";
                tupleString += "student_id: " + rs.getInt("student_id");
                tupleString += ", first_name: " + rs.getString("first_name");
                tupleString += ", last_name: " + rs.getString("last_name");
                tupleString += ", email: " + rs.getString("email");
                tupleString += ", enrollment_date: " + rs.getString("enrollment_date");

                // Console print
                System.out.println(tupleString);

                // Add to array for return
                resultArray.add(tupleString);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        // Return the String ArrayList
        return resultArray;
    }

    // Add a user
    public void addStudent(String first_name, String last_name, String email, String enrollment_date) {
        String SQL = "INSERT INTO students(first_name,last_name,email,enrollment_date) VALUES(?,?,?,?::date)";

        System.out.println("addStudent: " + first_name + " " + last_name + " " + email + " " + enrollment_date);

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            pstmt.setString(3, email);
            pstmt.setString(4, enrollment_date);
            pstmt.executeUpdate();
            System.out.println("Student added successfully!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Update user's email based on name
    public void modifyUserEmail(String name, String newEmail) {
        String SQL = "UPDATE users SET email=? WHERE name=?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, newEmail);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
            System.out.println("User email updated!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Delete user based on name
    public void deleteUser(String name) {
        String SQL = "DELETE FROM users WHERE name=?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, name);
            pstmt.executeUpdate();
            System.out.println("User deleted!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /*
    public static void main(String[] args) {
      DatabaseOperations dbOps = new DatabaseOperations();
      Scanner scanner = new Scanner(System.in);
      
      // Add a user
      System.out.println("Would you like to add a user? (yes/no)");
      if (scanner.nextLine().equalsIgnoreCase("yes")) {
          dbOps.addUser("John Doe", "john@example.com");
      }
  
      // Modify user's email
      System.out.println("Would you like to modify a user's email? (yes/no)");
      if (scanner.nextLine().equalsIgnoreCase("yes")) {
          dbOps.modifyUserEmail("John Doe", "john.doe@example.com");
      }
  
      // Delete user
      System.out.println("Would you like to delete a user? (yes/no)");
      if (scanner.nextLine().equalsIgnoreCase("yes")) {
          dbOps.deleteUser("John Doe");
      }
      scanner.close();
  }
  */
}
