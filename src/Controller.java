/** 
 * Controller for MVC pattern.
 *
 * This class wires together the view and model, allowing graphical interaction
 * with the view to effect change in the model.
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
     * @version 20231123
     */
    public Controller(Model model, View view) {
        
        /* Fields */
        this.model = model;
        this.view = view;

        /* Register Listeners on View Components */
        view.addStudentButton.addActionListener(this);
        view.updateStudentEmailButton.addActionListener(this);
        view.deleteStudentButton.addActionListener(this);
        view.getAllStudentsButton.addActionListener(this);

        /* Initial Methods */

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

                // Get the text fields from the View boxes
                String first_name = view.addFirstNameTextPane.getText();
                String last_name = view.addLastNameTextPane.getText();
                String email = view.addEmailTextPane.getText();
                String enrollment_date = view.addEnrollmentDateTextPane.getText();

                // Invoke the model's operation, which will issue the dbop
                model.addStudentButtonMethod(first_name, last_name, email, enrollment_date);
                
            }

            // Case: view.updateStudentEmailButton
            if (sourceJButton == view.updateStudentEmailButton) {

                // Debug
                System.out.println("updateStudentEmailButton clicked.");

                // Get the text fields from the View boxes
                String student_id = view.updateStudentIdTextPane.getText();
                String email = view.updateStudentEmailTextPane.getText();
                
                // Invoke the model's operation, which will issue the dbop
                model.updateStudentEmailButtonMethod(student_id, email);
                
            }

            // Case: view.deleteStudentButton
            if (sourceJButton == view.deleteStudentButton) {

                // Debug
                System.out.println("deleteStudentButton clicked.");

                // Get the text fields from the View boxes
                String student_id = view.deleteStudentTextPane.getText();
                
                // Invoke the model's operation, which will issue the dbop
                model.deleteStudentButtonMethod(student_id);
                
            }

            // Case: view.getAllStudentsButton (ie. refresh)
            if (sourceJButton == view.getAllStudentsButton) {

                // Debug
                System.out.println("getAllStudentsButton clicked.");
                
                // Note: Don't actually have to do anything here, since
                // we always do our refreshes after any button click,
                // as immediately below, so leave it!
                
            }

            /* Default Routine After ANY JButton Event */

            // Get the current tuple strings for print
            model.refreshStudentsArray();

            // Automatically refresh the display of all tuples in students
            view.refreshStudentsDisplay(model.getStudentsArray());
            
        }

        /* Default Actions After ANY View Event */

    }


}
