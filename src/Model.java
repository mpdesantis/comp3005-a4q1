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

        // Populate Array with Strings
        for (int i = 0; i < ARRAY_SIZE; i++) {
            modelArray.add("Element[" + i + "]");
        }

    }

    /**************************************************************************
     * METHODS
     */

    public void oneButtonMethod() {
        System.out.println("Invoking model method for oneButton event...");
        // TODO
        return;
    }

    public void twoButtonMethod() {
        System.out.println("Invoking model method for twoButton event...");
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
