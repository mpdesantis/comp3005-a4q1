/** 
 * Controller for MVC pattern.
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

public class Controller implements ActionListener {

    /**************************************************************************
     * CONSTANTS
     */

    /**************************************************************************
     * INSTANCE VARIABLES
     */

    /**************************************************************************
     * CONSTRUCTORS
     */

    /* Instance Variables */
    private Model model;
    private View view;

    /* Constructors */

    /**
     * Default constructor for Controller. 
     *
     * @param model The model for this MVC pattern.
     * @param view The view for this MVC pattern.
     *
     * @author Michael De Santis
     * @version 20231118
     */
    public Controller(Model model, View view) {
        
        /* Fields */
        this.model = model;
        this.view = view;

        /* Register Listeners on View Components */
        view.oneButton.addActionListener(this);
        view.twoButton.addActionListener(this);

        /* Initial Model Methods */
        
        // model.someInitialMethod();

    }

    /**************************************************************************
     * METHODS
     */

    /**
     * Interface: ActionListener
     *
     * Implement the actionPerformed() method so that the controller can listen
     * for ActionEvents on the View component of MVC, and perform any required
     * actions on the View or Model as needed.
     * 
     * @param e The ActionEvent that has fired.
     *
     * @author Michael De Santis
     * @version 20231118
     */
    public void actionPerformed(ActionEvent e) {

        // Get the source of the ActionEvent as an Object
        Object source = e.getSource();

        // Check what type of Swing component the source was

        // Case: JButton
        if (source instanceof JButton) {

            // Typecast the source to the appropriate component
            JButton sourceJButton = (JButton)source;

            // Case: view.oneButton
            if (sourceJButton == view.oneButton) {

                // Debug
                System.out.println("oneButton clicked.");

                /* Model Methods */

                //model.someMethod();

                model.oneButtonMethod();
                
            }

            // Case: view.twoButton
            if (sourceJButton == view.twoButton) {

                // Debug
                System.out.println("twoButton clicked.");

                /* Model Methods */

                //model.someMethod();

                model.twoButtonMethod();
                
            }

            /* Default Routine After ANY JButton Event */
            
            // N/A

        }

        /* Default Actions After ANY View Event */

        // View Refreshes

    }

}
