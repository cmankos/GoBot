package edu.cis306.alex;

import javax.swing.*;
import java.awt.*;

/***************************************
 * Name: GoFrame.java
 * Project: GoBot
 * Purpose: To encapsulate the JFrame and make it useful for our gobot
 * Author: Alex
 * Date: 1/29/2018
 * Inputs:
 * Outputs:
 ***************************************/
public class GoFrame extends JFrame {
    // Final values for the GUI
    private final String JFRAME_TITLE = "Go Bot";
    private final String[] BOARD_SIZES = {"9x9", "13x13", "19x19"};
    private Graphics drawGraphics;


    public GoFrame() {
        // Set the window attributes
        this.setSize(640, 640);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle(JFRAME_TITLE);
        this.setLayout(new BorderLayout());


        // Add in the drawing panel
        JPanel goPanel = new JPanel();
        goPanel.setBackground(Color.WHITE);
        this.add(goPanel);
        drawGraphics = goPanel.getGraphics();

        // Initialize the control panel
        JPanel controlPanel = new JPanel(new GridLayout(1, 3));
        // Add controls to the control panel
        JComboBox sizeComboBox = new JComboBox(BOARD_SIZES);
        controlPanel.add(sizeComboBox);

        JButton restartButton = new JButton("Restart");
        controlPanel.add(restartButton);
        // Add the control panel
        this.add(controlPanel, BorderLayout.SOUTH);




    }

}
