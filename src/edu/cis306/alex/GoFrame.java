package edu.cis306.alex;

import javax.swing.*;
import java.awt.*;

/***************************************
 * Name: GoFrame.java
 * Project: GoBot
 * Purpose: To encapsulate the JFrame and make it useful for our GoBot
 * Author: Alex
 * Date: 1/29/2018
 * Inputs:
 * Outputs:
 ***************************************/
class GoFrame extends JFrame {
    GoFrame(Board board) {
        // Set the window attributes
        this.setSize(900, 900); // Set the size of the window to square

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(true);
        this.setTitle("Go Bot");
        this.setLayout(new BorderLayout());


        // Add in the drawing panel
        GoPanel goPanel = new GoPanel(9, board);
        goPanel.setBackground(Color.decode("#276314"));
        this.add(goPanel);
    }

}
