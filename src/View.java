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
     * CONSTANTS
     */

    /* Dimensions */

    // Frame
    public static final int FRAME_WIDTH = 800;
    public static final int FRAME_HEIGHT= 400;

    // Panels
    public static final int TOP_PANEL_WIDTH = FRAME_WIDTH;
    public static final int TOP_PANEL_HEIGHT = 200;

    public static final int BOTTOM_PANEL_WIDTH = FRAME_WIDTH;
    public static final int BOTTOM_PANEL_HEIGHT = 200;

    public static final int BUTTON_PANEL_WIDTH = BOTTOM_PANEL_WIDTH/2;
    public static final int BUTTON_PANEL_HEIGHT = 200;

    // Dialogs
    public static final int DIALOG_WIDTH = 400;
    public static final int DIALOG_HEIGHT= 400;


    /**************************************************************************
     * INSTANCE VARIABLES
     */

    /* Model */

    private Model model;

    /* GUI Components */

    // JPanels
    JPanel topPanel;
    JPanel bottomPanel;
    JPanel buttonPanel;
    
    // JButtons
    JButton oneButton;
    JButton twoButton;
    
    // JDialogs
    JDialog helloDialog;
    
    // JLabels

    // JTextPanes
    JTextPane aJTextPane;


    /**************************************************************************
     * CONSTRUCTORS
     */


    /**
     * Default constructor for View. 
     *
     * @param model The model for this MVC pattern.
     *
     * @author Michael De Santis
     * @version 20231118
     */
    public View(Model model) {
        
        /* Fields */
        this.model = model;

        /* GUI Components */

        // Frame
        this.setTitle("Midterm!");
        this.setMinimumSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        // Content Pane
        Container contentPane = this.getContentPane();
        contentPane.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        // Opening JDialog
        helloDialog = new JDialog(this, "Hello!", true);
        helloDialog.setSize(DIALOG_WIDTH, DIALOG_HEIGHT);
        JLabel helloLabel = new JLabel("Welcome to the program! Please click OK to continue.");
        JButton helloOkButton = new JButton("OK");
        helloDialog.setBackground(Color.black);
        helloDialog.setForeground(Color.yellow);
        helloDialog.setLayout(new GridLayout(2, 1));
        helloDialog.add(helloLabel);
        helloDialog.add(helloOkButton);
        // Add the listeners inline, since we want this up before Controller
        helloOkButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                /* Model actions, if required */
                // N/A

                /* View actions, if required */

                helloDialog.dispose();
            }
        });
        // Modal, therefore blocking once visible
        helloDialog.setVisible(true);
        // Proceed once disposed of!

        // Top Panel
        topPanel = new JPanel();
        topPanel.setSize(TOP_PANEL_WIDTH, TOP_PANEL_HEIGHT);
        topPanel.setBackground(Color.black);
        topPanel.setBorder(new LineBorder(Color.BLACK, 10, false));
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setOpaque(true);
        contentPane.add(topPanel);

        // JTextPane for Top Panel
        aJTextPane = new JTextPane(); 
        aJTextPane.setText("TEXT PANE!");
        aJTextPane.setEditable(false);
        aJTextPane.setFont(new Font("Monospaced", Font.PLAIN, 72));
        topPanel.add(aJTextPane);

        // Bottom Panel
        bottomPanel = new JPanel();
        bottomPanel.setSize(BOTTOM_PANEL_WIDTH, BOTTOM_PANEL_HEIGHT);
        bottomPanel.setBackground(Color.black);
        bottomPanel.setBorder(new LineBorder(Color.BLACK, 10, false));
        bottomPanel.setLayout(new GridLayout(1, 2));
        bottomPanel.setOpaque(true);
        contentPane.add(bottomPanel);

        // Button Panel
        buttonPanel = new JPanel();
        buttonPanel.setSize(BUTTON_PANEL_WIDTH, BUTTON_PANEL_HEIGHT);
        buttonPanel.setBackground(Color.yellow);
        buttonPanel.setBorder(new LineBorder(Color.BLACK, 10, false));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setOpaque(true);
        bottomPanel.add(buttonPanel);

        // Some Buttons
        oneButton = new JButton("oneButton");
        buttonPanel.add(oneButton);        
        twoButton = new JButton("twoButton");
        buttonPanel.add(twoButton);        

        /* Other Stuff */

        // Finally, pack and show the frame
        this.pack();
        this.setVisible(true);

    }

    /**************************************************************************
     * METHODS
     */

}
