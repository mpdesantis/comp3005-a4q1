/** 
 * Model for MVC pattern.
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

    public enum someEnum {
        ONE,
        TWO,
        THREE
    }

    public static final int ARRAY_SIZE = 5;


    /**************************************************************************
     * INSTANCE VARIABLES
     */

    public DatabaseOperations dbops;
    private ArrayList<String> modelArray;
    private ArrayList<String> studentsArray;
    private String modelString;

    private String user;
    private String password;



    /**************************************************************************
     * CONSTRUCTORS
     */

    /**
     * Default constructor for Model
     *
     * @author Michael De Santis
     * @version 20231118
     */
    public Model() {

        /* Fields */
        this.dbops = new DatabaseOperations();
        this.modelArray = new ArrayList<String>(ARRAY_SIZE);
        this.studentsArray = new ArrayList<String>();
        this.modelString = null;
        this.user = null;
        this.password = null;

        // Get credentials here before launching GUI because I'm lazy
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nUsername:\n>> ");
        user = scanner.nextLine();
        System.out.print("\nPassword:\n>> ");
        password = scanner.nextLine();
        System.out.println("Username: " + user + " Password: " + password);

        // Give credentials to dbops
        dbops.setCredentials(user, password);
        

    }

    /**************************************************************************
     * METHODS
     */

    public ArrayList<String> getStudentsArray() {
        return this.studentsArray;
    }

    public void refreshStudentsArray() {
        studentsArray = dbops.getAllStudents();
    }

    public void printStudentsArray() {
        for (String s : studentsArray) {
            System.out.println("- " + s);
        }
    }

    public void addStudentString(String studentString) {
        this.studentsArray.add(studentString);
        return;
    }

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

    public void updateStudentEmailButtonMethod(String student_id, String email) {
        // Debug
        System.out.println("Invoking model method for updateStudentEmailButton event...");
        System.out.println("student_id: " + student_id);
        System.out.println("email: " + email);

        // Cast to int JKJK
        //int student_id_int = Integer.parseInt(student_id);

        // DB Operation
        dbops.updateStudentEmail(student_id, email);

        return;
    }

    public void deleteStudentButtonMethod(int student_id) {

        // Debug
        System.out.println("Invoking model method for deleteStudentButton event...");

        // DB Operation
        //dbops.deleteStudent(student_id);

        return;
    }

    public void getAllStudentsButtonMethod() {

        // Debug
        System.out.println("Invoking model method for getAllStudentsButton event...");

        // DB Operation
        dbops.getAllStudents();

        // Model method
        refreshStudentsArray();

        return;
    }

    public void printArray() {
        System.out.println("Printing modelArray...");
        for (String s : this.modelArray) {
            System.out.println(s.toString());
        }
        return;
    }

}
