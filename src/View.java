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
    JPanel updateStudentEmailPanel;
    JPanel updateStudentIdPanel;
    JPanel deleteStudentPanel;
    JPanel getAllStudentsPanel;
    JPanel scrollPanePanel;

    /* JLists */
    JList studentList;

    /* JScrollPanes */
    JScrollPane aJScrollPane;

    /* JButtons */
    JButton addStudentButton;
    JButton updateStudentEmailButton;
    JButton deleteStudentButton;
    JButton getAllStudentsButton;

    /* JTextPanes */
    JTextPane addFirstNameTextPane;
    JTextPane addLastNameTextPane;
    JTextPane addEmailTextPane;
    JTextPane addEnrollmentDateTextPane;
    JTextPane displayStudentTextPane;
    JTextPane updateStudentIdTextPane;
    JTextPane updateStudentEmailTextPane;
    JTextPane deleteStudentTextPane;
    JTextPane studentsTextPane;

    /**************************************************************************
     * CONSTANTS
     */

    /* Dimensions */

    // Frame
    public static final int FRAME_WIDTH = 800;
    public static final int FRAME_HEIGHT= 400;

    // DisplayPanel
    public static final int DISPLAY_PANEL_WIDTH = FRAME_WIDTH;
    public static final int DISPLAY_PANEL_HEIGHT = FRAME_HEIGHT;

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

        // displayStudentTextPane
        displayStudentTextPane = new JTextPane();
        displayStudentTextPane.setBorder(BorderFactory.createTitledBorder("students"));
        displayStudentTextPane.setText("students...");
        //displayStudentTextPane.setFont(new Font("Monospaced", Font.PLAIN, 12));
        displayStudentTextPane.setBounds(0, 0, 100, 100);
        displayStudentTextPane.setPreferredSize(new Dimension(DISPLAY_PANEL_WIDTH, DISPLAY_PANEL_HEIGHT));
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

        // updateStudentEmailPanel
        updateStudentEmailPanel = new JPanel();
        updateStudentEmailPanel.setSize(UPDATE_EMAIL_PANEL_WIDTH, UPDATE_EMAIL_PANEL_HEIGHT);
        updateStudentEmailPanel.setLayout(new BoxLayout(updateStudentEmailPanel, BoxLayout.X_AXIS));
        updateStudentEmailPanel.setOpaque(true);
        contentPane.add(updateStudentEmailPanel);
        // Create text entry boxes for required updates
        // student_id
        updateStudentIdTextPane = new JTextPane();
        updateStudentIdTextPane.setBorder(BorderFactory.createTitledBorder("Student ID"));
        updateStudentIdTextPane.setText("ID");
        updateStudentIdTextPane.setBounds(0, 0, 100, 100);
        updateStudentIdTextPane.setPreferredSize(new Dimension(FRAME_WIDTH/5, 40));
        updateStudentIdTextPane.setEditable(true);
        updateStudentEmailPanel.add(updateStudentIdTextPane);
        // email
        updateStudentEmailTextPane = new JTextPane();
        updateStudentEmailTextPane.setBorder(BorderFactory.createTitledBorder("New e-mail"));
        updateStudentEmailTextPane.setText("e-mail");
        updateStudentEmailTextPane.setBounds(0, 0, 100, 100);
        updateStudentEmailTextPane.setPreferredSize(new Dimension(FRAME_WIDTH/5, 40));
        updateStudentEmailTextPane.setEditable(true);
        updateStudentEmailPanel.add(updateStudentEmailTextPane);
        // Button
        updateStudentEmailButton = new JButton("Update e-mail");
        updateStudentEmailPanel.add(updateStudentEmailButton);

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


        // getAllStudentsPanel
        getAllStudentsPanel = new JPanel();
        getAllStudentsPanel.setSize(DELETE_STUDENT_PANEL_WIDTH, DELETE_STUDENT_PANEL_HEIGHT);
        getAllStudentsPanel.setLayout(new BoxLayout(getAllStudentsPanel, BoxLayout.X_AXIS));
        getAllStudentsPanel.setOpaque(true);
        contentPane.add(getAllStudentsPanel);
        // Button
        getAllStudentsButton = new JButton("Get All Students");
        getAllStudentsPanel.add(getAllStudentsButton);


        /* Other Stuff */

        // Finally, pack and show the frame
        this.pack();
        this.setVisible(true);

    }

    /**************************************************************************
     * METHODS
     */

    public void refreshStudentsDisplay(ArrayList<String> arr) {

        // String to write to display
        String studentsList = "";

        // Lazy check
        if (arr == null) {
            return;
        }
        
        // String, splits on newline
        for (String s : arr) {
            studentsList += s;
            studentsList += "\n";
        }

        // Write the text in the display
        displayStudentTextPane.setText(studentsList);

        return; 
    }

}
