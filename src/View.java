/** 
 * View for MVC pattern.
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

public class View extends JFrame {

    /**************************************************************************
     * GUI COMPONENTS
     */

    /* JFrame */
    private JFrame frame;

    /* JLabels. */

    /* JPanels */
    JPanel displayPanel;
    JPanel addStudentPanel;
    JPanel updateEmailPanel;
    JPanel deleteStudentPanel;
    JPanel scrollPanePanel;

    /* JLists */
    JList studentList;

    /* JScrollPanes */
    JScrollPane aJScrollPane;

    /* JButtons */
    JButton addStudentButton;
    JButton updateEmailButton;
    JButton deleteStudentButton;

    /* JTextPanes */
    JTextPane inputFirstNameTextPane;
    JTextPane inputLastNameTextPane;
    JTextPane inputEmailTextPane;
    JTextPane inputEnrollmentDateTextPane;
    JTextPane displayStudentTextPane;

    /**************************************************************************
     * CONSTANTS
     */

    /* Dimensions */

    // Frame
    public static final int FRAME_WIDTH = 800;
    public static final int FRAME_HEIGHT= 400;

    // DisplayPanel
    public static final int DISPLAY_PANEL_WIDTH = FRAME_WIDTH;
    public static final int DISPLAY_PANEL_HEIGHT = FRAME_HEIGHT/2;

    // AddStudentPanel
    public static final int ADD_STUDENT_PANEL_WIDTH = FRAME_WIDTH;
    public static final int ADD_STUDENT_PANEL_HEIGHT = FRAME_HEIGHT * (1/6);

    // UpdateEmailPanel
    public static final int UPDATE_EMAIL_PANEL_WIDTH = FRAME_WIDTH;
    public static final int UPDATE_EMAIL_PANEL_HEIGHT = FRAME_HEIGHT * (1/6);

    // DeleteStudentPanel
    public static final int DELETE_STUDENT_PANEL_WIDTH = FRAME_WIDTH;
    public static final int DELETE_STUDENT_PANEL_HEIGHT = FRAME_HEIGHT * (1/6);

    /**************************************************************************
     * INSTANCE VARIABLES
     */

    /* Model */

    private Model model;


    /**************************************************************************
     * CONSTRUCTORS
     */


    /**
     * Default constructor for View. 
     *
     * @param model The model for this MVC pattern.
     *
     * @author Michael De Santis
     * @version 20231123
     */
    public View(Model model) {
        
        /* Fields */
        this.model = model;

        /* GUI Components */

        // Frame
        this.setTitle("StudentDB");
        this.setMinimumSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        // Content Pane
        Container contentPane = this.getContentPane();
        contentPane.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        // displayPanel
        displayPanel = new JPanel();
        displayPanel.setSize(DISPLAY_PANEL_WIDTH, DISPLAY_PANEL_HEIGHT);
        displayPanel.setBackground(Color.black);
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.X_AXIS));
        displayPanel.setOpaque(true);
        contentPane.add(displayPanel);

        // Create a JPanel for the JScrollPane
        scrollPanePanel = new JPanel();
        scrollPanePanel.setBorder(BorderFactory.createTitledBorder("Students (click to select)"));
        // Create the JList with the items
        studentList = new JList(); // TODO
        // Create the JScrollPane with the list inside
        aJScrollPane = new JScrollPane(studentList);
        aJScrollPane.setPreferredSize(new Dimension(FRAME_WIDTH/2, 200));
        // Add to scrollPanePanel
        scrollPanePanel.add(aJScrollPane);
        // Add to displayPanel
        displayPanel.add(scrollPanePanel);

        // displayStudentTextPane
        displayStudentTextPane = new JTextPane();
        displayStudentTextPane.setBorder(BorderFactory.createTitledBorder("Selected Student"));
        displayStudentTextPane.setText("Select a student.");
        displayStudentTextPane.setFont(new Font("Monospaced", Font.PLAIN, 24));
        displayStudentTextPane.setBounds(0, 0, 100, 100);
        displayStudentTextPane.setPreferredSize(new Dimension(FRAME_WIDTH/2, 40));
        displayStudentTextPane.setEditable(false);
        displayPanel.add(displayStudentTextPane);

        // addStudentPanel
        addStudentPanel = new JPanel();
        addStudentPanel.setSize(ADD_STUDENT_PANEL_WIDTH, ADD_STUDENT_PANEL_HEIGHT);
        addStudentPanel.setBackground(Color.black);
        addStudentPanel.setLayout(new BoxLayout(addStudentPanel, BoxLayout.Y_AXIS));
        addStudentPanel.setOpaque(true);
        contentPane.add(addStudentPanel);
        addStudentButton = new JButton("Add Student");
        addStudentPanel.add(addStudentButton);

        // updateEmailPanel
        updateEmailPanel = new JPanel();
        updateEmailPanel.setSize(UPDATE_EMAIL_PANEL_WIDTH, UPDATE_EMAIL_PANEL_HEIGHT);
        updateEmailPanel.setBackground(Color.black);
        updateEmailPanel.setLayout(new BoxLayout(updateEmailPanel, BoxLayout.Y_AXIS));
        updateEmailPanel.setOpaque(true);
        contentPane.add(updateEmailPanel);
        updateEmailButton = new JButton("Update e-mail");
        updateEmailPanel.add(updateEmailButton);

        // deleteStudentPanel
        deleteStudentPanel = new JPanel();
        deleteStudentPanel.setSize(DELETE_STUDENT_PANEL_WIDTH, DELETE_STUDENT_PANEL_HEIGHT);
        deleteStudentPanel.setBackground(Color.black);
        deleteStudentPanel.setLayout(new BoxLayout(deleteStudentPanel, BoxLayout.Y_AXIS));
        deleteStudentPanel.setOpaque(true);
        contentPane.add(deleteStudentPanel);
        deleteStudentButton = new JButton("Delete Student");
        deleteStudentPanel.add(deleteStudentButton);


        /* Other Stuff */

        // Finally, pack and show the frame
        this.pack();
        this.setVisible(true);

    }

    /**************************************************************************
     * METHODS
     */

}
