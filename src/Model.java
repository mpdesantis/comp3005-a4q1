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

    private ArrayList<String> modelArray;
    private String modelString;

    private String username;
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
        this.modelArray = new ArrayList<String>(ARRAY_SIZE);
        this.modelString = null;
        this.username = null;
        this.password = null;

        // Get credentials here before launching GUI.
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nUsername:\n>> ");
        username = scanner.nextLine();
        System.out.print("\nPassword:\n>> ");
        password = scanner.nextLine();
        System.out.println("Username: " + username + " Password: " + password);


        // Populate Array with Strings
        for (int i = 0; i < ARRAY_SIZE; i++) {
            modelArray.add("Element[" + i + "]");
        }

    }

    /**************************************************************************
     * METHODS
     */

    public void addStudentButtonMethod() {
        System.out.println("Invoking model method for addStudentButton event...");
        // TODO
        return;
    }

    public void updateEmailButtonMethod() {
        System.out.println("Invoking model method for updateEmailButton event...");
        // TODO
        return;
    }

    public void deleteStudentButtonMethod() {
        System.out.println("Invoking model method for deleteStudentButton event...");
        // TODO
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
