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
    JLabel addStudentLabel;

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
    JTextPane addFirstNameTextPane;
    JTextPane addLastNameTextPane;
    JTextPane addEmailTextPane;
    JTextPane addEnrollmentDateTextPane;
    JTextPane displayStudentTextPane;
    JTextPane updateEmailTextPane;
    JTextPane deleteStudentTextPane;

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
        addStudentPanel.setLayout(new BoxLayout(addStudentPanel, BoxLayout.X_AXIS));
        addStudentPanel.setOpaque(true);
        contentPane.add(addStudentPanel);
        // Create text entry boxes for required adds
        // FirstName
        addFirstNameTextPane = new JTextPane();
        addFirstNameTextPane.setBorder(BorderFactory.createTitledBorder("First Name"));
        addFirstNameTextPane.setText("First Name");
        addFirstNameTextPane.setBounds(0, 0, 100, 100);
        addFirstNameTextPane.setPreferredSize(new Dimension(FRAME_WIDTH/5, 40));
        addFirstNameTextPane.setEditable(true);
        addStudentPanel.add(addFirstNameTextPane);
        // LastName
        addLastNameTextPane = new JTextPane();
        addLastNameTextPane.setBorder(BorderFactory.createTitledBorder("Last Name"));
        addLastNameTextPane.setText("Last Name");
        addLastNameTextPane.setBounds(0, 0, 100, 100);
        addLastNameTextPane.setPreferredSize(new Dimension(FRAME_WIDTH/5, 40));
        addLastNameTextPane.setEditable(true);
        addStudentPanel.add(addLastNameTextPane);
        // Email
        addEmailTextPane = new JTextPane();
        addEmailTextPane.setBorder(BorderFactory.createTitledBorder("e-mail"));
        addEmailTextPane.setText("e-mail");
        addEmailTextPane.setBounds(0, 0, 100, 100);
        addEmailTextPane.setPreferredSize(new Dimension(FRAME_WIDTH/5, 40));
        addEmailTextPane.setEditable(true);
        addStudentPanel.add(addEmailTextPane);
        // EnrollmentDate
        addEnrollmentDateTextPane = new JTextPane();
        addEnrollmentDateTextPane.setBorder(BorderFactory.createTitledBorder("Enrollment Date"));
        addEnrollmentDateTextPane.setText("YYYY-MM-DD");
        addEnrollmentDateTextPane.setBounds(0, 0, 100, 100);
        addEnrollmentDateTextPane.setPreferredSize(new Dimension(FRAME_WIDTH/5, 40));
        addEnrollmentDateTextPane.setEditable(true);
        addStudentPanel.add(addEnrollmentDateTextPane);
        // addStudentButton
        addStudentButton = new JButton("Add Student");
        addStudentPanel.add(addStudentButton);

        // updateEmailPanel
        updateEmailPanel = new JPanel();
        updateEmailPanel.setSize(UPDATE_EMAIL_PANEL_WIDTH, UPDATE_EMAIL_PANEL_HEIGHT);
        updateEmailPanel.setLayout(new BoxLayout(updateEmailPanel, BoxLayout.X_AXIS));
        updateEmailPanel.setOpaque(true);
        contentPane.add(updateEmailPanel);
        // Create text entry boxes for required adds
        updateEmailTextPane = new JTextPane();
        updateEmailTextPane.setBorder(BorderFactory.createTitledBorder("e-mail"));
        updateEmailTextPane.setText("e-mail");
        updateEmailTextPane.setBounds(0, 0, 100, 100);
        updateEmailTextPane.setPreferredSize(new Dimension(FRAME_WIDTH/5, 40));
        updateEmailTextPane.setEditable(true);
        updateEmailPanel.add(updateEmailTextPane);
        // Button
        updateEmailButton = new JButton("Update e-mail");
        updateEmailPanel.add(updateEmailButton);

        // deleteStudentPanel
        deleteStudentPanel = new JPanel();
        deleteStudentPanel.setSize(DELETE_STUDENT_PANEL_WIDTH, DELETE_STUDENT_PANEL_HEIGHT);
        deleteStudentPanel.setLayout(new BoxLayout(deleteStudentPanel, BoxLayout.X_AXIS));
        deleteStudentPanel.setOpaque(true);
        contentPane.add(deleteStudentPanel);
        // Create text entry boxes for required fields
        deleteStudentTextPane = new JTextPane();
        deleteStudentTextPane.setBorder(BorderFactory.createTitledBorder("Student ID"));
        deleteStudentTextPane.setText("Student ID");
        deleteStudentTextPane.setBounds(0, 0, 100, 100);
        deleteStudentTextPane.setPreferredSize(new Dimension(FRAME_WIDTH/5, 40));
        deleteStudentTextPane.setEditable(true);
        deleteStudentPanel.add(deleteStudentTextPane);
        // Button
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
