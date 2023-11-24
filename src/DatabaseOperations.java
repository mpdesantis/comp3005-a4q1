/**
 * Java interface to PostgreSQL.
 *
 * NOTE: Adapted from demonstration code taken from Professor A. Orogat's GitHub
 * repository, COMP3005_DBMS, which was provided as a reference in lecture.
 *
 * Thanks for providing this reference. You saved me a big crawl through the
 * documentation!!
 *
 * @author A. Orogat
 * @version original
 *
 * @author Michael De Santis
 * @version 20231123
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

    // Query all tuples in the relation, and also return a string array 
    // for easy prints to GUI
    public ArrayList<String> getAllStudents() {

        // ArrayList to hold records
        ArrayList<String> resultArray = new ArrayList<String>();

        String SQL = "SELECT * FROM students ORDER BY student_id ASC";
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
                //System.out.println(tupleString);

                // Add to array for return
                resultArray.add(tupleString);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        // Return the String ArrayList
        return resultArray;
    }

    // Add a student to the relation
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

    // Update student e-mail by ID
    public void updateStudentEmail(String student_id, String new_email) {
        String SQL = "UPDATE students SET email=? WHERE student_id=?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, new_email);
            pstmt.setInt(2, Integer.parseInt(student_id));
            pstmt.executeUpdate();
            System.out.println("Student e-mail updated!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Delete student tuple by ID
    public void deleteStudent(String student_id) {
        String SQL = "DELETE FROM students WHERE student_id=?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setInt(1, Integer.parseInt(student_id));
            pstmt.executeUpdate();
            System.out.println("Student deleted!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
