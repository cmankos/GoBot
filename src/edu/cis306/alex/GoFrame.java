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
        this.setSize(900, 900); // Set the size of the window to square

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setTitle(JFRAME_TITLE);
        this.setLayout(new BorderLayout());


        // Add in the drawing panel
        GoPanel goPanel = new GoPanel(9);
        goPanel.setBackground(Color.decode("#276314"));
        this.add(goPanel);
        drawGraphics = goPanel.getGraphics();
    }

}
