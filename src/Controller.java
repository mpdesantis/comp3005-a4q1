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

public class Controller implements ActionListener, ListSelectionListener {



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
     * @version 20231123
     */
    public Controller(Model model, View view) {
        
        /* Fields */
        this.model = model;
        this.view = view;

        /* Register Listeners on View Components */

        view.addStudentButton.addActionListener(this);
        view.updateEmailButton.addActionListener(this);
        view.deleteStudentButton.addActionListener(this);

        view.studentList.addListSelectionListener(this);

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
     * @version 20231123
     */
    public void actionPerformed(ActionEvent e) {

        // Get the source of the ActionEvent as an Object
        Object source = e.getSource();

        // Check what type of Swing component the source was

        // Case: JButton
        if (source instanceof JButton) {

            // Typecast the source to the appropriate component
            JButton sourceJButton = (JButton)source;

            // Case: view.addStudentButton
            if (sourceJButton == view.addStudentButton) {

                // Debug
                System.out.println("addStudentButton clicked.");

                /* Model Methods */

                //model.someMethod();

                model.addStudentButtonMethod();
                
            }

            // Case: view.updateEmailButton
            if (sourceJButton == view.updateEmailButton) {

                // Debug
                System.out.println("updateEmailButton clicked.");

                /* Model Methods */

                //model.someMethod();

                model.updateEmailButtonMethod();
                
            }

            // Case: view.deleteStudentButton
            if (sourceJButton == view.deleteStudentButton) {

                // Debug
                System.out.println("deleteStudentButton clicked.");

                /* Model Methods */

                //model.someMethod();

                model.deleteStudentButtonMethod();
                
            }

            /* Default Routine After ANY JButton Event */
            
            // N/A

        }

        /* Default Actions After ANY View Event */

        // View Refreshes

    }

    /**
     * Implementation of ListSelectionListener interface method valueChanged.
     * Registers event when value in this list is changed.
     * 
     * @param e The list selection event triggered.
     *
     * @author Michael De Santis
     * @version 20231123
     */
    public void valueChanged(ListSelectionEvent e) {

        Object source = e.getSource();

        // JList
        if (source instanceof JList) {
            JList<String> sourceJList = (JList<String>)source;
            if (!sourceJList.getValueIsAdjusting()) {
                // Get the list of selected indices
                int[] selectedItemIndices = view.studentList.getSelectedIndices();

                // Print the currently selected items
                System.out.println("JList selection changed.");
                System.out.println("JList value(s) currently selected:");
                for (int i = 0; i < selectedItemIndices.length; i++) {
                    //System.out.println("\t"+studentList[selectedItemIndices[i]]);
                }

                // Update the display with first selection
                if (selectedItemIndices.length > 0) {
                    int firstIndex = selectedItemIndices[0];
                    String displayString = new String();
                    displayString = "\nStudent ID: " + "xxx" +
                        "\nFirst Name: " + "xxx" +
                        "\nLast Name: " + "xxx" +
                        "\nNumber: " + "xxx" +
                        "\nemail: " + "xxx";
                    // TODO
                    //displayStudentTextPane.setText(displayString);
                }

            }
        }    
    }

}
