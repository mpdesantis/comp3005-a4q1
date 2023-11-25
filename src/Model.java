/** 
 * Model for MVC pattern.
 *
 * This model instantiates the DatabaseOperations class, and manages
 * calls to it.
 *
 * @author Michael De Santis
 * @version 20231123
 */

import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.Component;
import java.util.Random;

public class Model {

    /**************************************************************************
     * CONSTANTS
     */

    public static final String ANSI_ESC_CLEAR = "\033[H\033[2J";


    /**************************************************************************
     * INSTANCE VARIABLES
     */

    public DatabaseOperations dbops;
    private ArrayList<String> studentsArray;
    private String user;
    private String password;


    /**************************************************************************
     * CONSTRUCTORS
     */

    /**
     * Default constructor for Model.
     *
     * @author Michael De Santis
     * @version 20231118
     */
    public Model() {

        /* Fields */
        this.dbops = new DatabaseOperations();
        this.studentsArray = new ArrayList<String>();
        this.user = null;
        this.password = null;

        // Get credentials here before launching GUI because I'm too lazy to
        // scratch up a dialog box in the GUI.
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nUsername:\n>> ");
        user = scanner.nextLine();
        System.out.print("\nPassword:\n>> ");
        password = scanner.nextLine();
        // Clear the console, as a pathetic security measure
        System.out.print(ANSI_ESC_CLEAR);

        // Give credentials to dbops
        dbops.setCredentials(user, password);
        

    }

    /**************************************************************************
     * METHODS
     */

    /** 
     * Return the ArrayList of Strings representing the tuples in the students 
     * relation.
     *
     * @author Michael De Santis
     * @version 20231123
     */
    public ArrayList<String> getStudentsArray() {
        return this.studentsArray;
    }

    /** 
     * Print the ArrayList of Strings representing the tuples in the students 
     * relation.
     *
     * @author Michael De Santis
     * @version 20231123
     */
    public void printStudentsArray() {
        for (String s : studentsArray) {
            System.out.println("- " + s);
        }
    }

    /** 
     * Add a String to the ArrayList of Strings representing the tuples in the 
     * students relation.
     *
     * @author Michael De Santis
     * @version 20231123
     */
    public void addStudentString(String studentString) {
        this.studentsArray.add(studentString);
        return;
    }

    /** 
     * Invoke the addStudent operation on the DB.
     *
     * @author Michael De Santis
     * @version 20231123
     */
    public void addStudentButtonMethod(String first_name, String last_name, String email, String enrollment_date) {

        // Debug
        System.out.println("Invoking model method for addStudentButton event...");
        System.out.println("first_name: " + first_name);
        System.out.println("last_name: " + last_name);
        System.out.println("email: " + email);
        System.out.println("enrollment_date: " + enrollment_date);
        System.out.println();

        // DB Operation
        dbops.addStudent(first_name, last_name, email, enrollment_date);

        return;
    }

    /** 
     * Invoke the updateStudentEmail operation on the DB.
     *
     * @author Michael De Santis
     * @version 20231123
     */
    public void updateStudentEmailButtonMethod(String student_id, String email) {

        // Debug
        System.out.println("Invoking model method for updateStudentEmailButton event...");
        System.out.println("student_id: " + student_id);
        System.out.println("email: " + email);

        // DB Operation
        dbops.updateStudentEmail(student_id, email);

        return;
    }

    /** 
     * Invoke the deleteStudent operation on the DB.
     *
     * @author Michael De Santis
     * @version 20231123
     */
    public void deleteStudentButtonMethod(String student_id) {

        // Debug
        System.out.println("Invoking model method for updateStudentEmailButton event...");
        System.out.println("student_id: " + student_id);

        // DB Operation
        dbops.deleteStudent(student_id);

        return;
    }

    /** 
     * Invoke the getAllStudents operation on the DB to refresh the ArrayList 
     * of Strings representing the tuples in the students relation.
     *
     * @author Michael De Santis
     * @version 20231123
     */
    public void refreshStudentsArray() {
        studentsArray = dbops.getAllStudents();
    }


}
