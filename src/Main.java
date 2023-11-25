/**
 * Main class which creates the objects for this program. Once the
 * initializations are done, flow is dictated by the controller.
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

class Main {

    /** 
     * Main method.
     *
     * @author Michael De Santis
     * @version 20231123
     */
    public static void main(String[] args) {

        System.out.println("\n**** PROGRAM START: Main.java ****");
        System.out.println("Author: Michael De Santis (101213450)");

        // Create the Model
        System.out.println("\nInitializing Model...");
        Model model = new Model();

        // Create the View
        System.out.println("\nInitializing View...");
        View view = new View(model);

        // Create the Controller
        System.out.println("\nInitializing Controller...");
        Controller controller = new Controller(model, view);

    }
}
