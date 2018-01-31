package edu.cis306.alex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/***************************************
 * Name: GoPanel.java
 * Project: GoBot
 * Purpose: To encapsulate a JPanel and tune it more
 * for use as a panel to draw a goboard on
 * Author: Alex
 * Date: 1/29/2018
 * Inputs: Size of the grid
 * Outputs: A Custom panel with a mouselistener
 ***************************************/
class GoPanel extends JPanel {
    // Instance variables
    private int _gridSize; // Keep track of the size of the board
    private Board _goBoard; // Reference to the board so we can check if we are proposing a valid move and update
    private Dimension componentDimension; // Class level variable for the current dimensions of the panel

    private static final 

    // Constructors

    /**
     * Overloaded constructor that takes in the size and a reference to the board
     * @param p_gridSize - The size of the Go Board, usually 9x9 or 13x13 or 19x19
     * @param p_goBoard - A reference to the _goBoard in the heap
     */
    GoPanel(int p_gridSize, Board p_goBoard) {
        // Set all the instance variables
        _gridSize = p_gridSize;
        this._goBoard = p_goBoard;
        // Add a mouse listener to the panel
        addMouseListener();
    }

    /**
     * A function to add a mouse listener that will call the boards validate move or step function
     * to propose the users move to the Board
     */
    private void addMouseListener() {
        // Add a mouse listener
        addMouseListener(new MouseAdapter() {
            // Add a mouse clicked listener specifically
            @Override
            public void mouseClicked(MouseEvent e) {
                // Get the x and the y in respect to the panel
                int x = e.getX();
                int y = e.getY();
                // Initialize the xDraw and yDraw, these are the column and row that the user clicked
                int xDraw = 0;
                int yDraw = 0;
                // Initalize a ratio for the x and y that is just the (width or height) / gridsize + 1
                double xRatio = (double) componentDimension.width / (double) (_gridSize + 1);
                double yRatio = (double) componentDimension.height / (double) (_gridSize + 1);
                // Booleans for if the x or y is valid as we are only checking in a small area around the intersection
                boolean isValidX = false;
                boolean isValidY = false;
                // The offset we are checking around the intersections
                double xOffset = (1.0 / 3.0) * xRatio;
                double yOffset = (1.0 / 3.0) * yRatio;
                // Check around all of the columns and rows and find if we have a valid click in either
                for (int i = 1; i <= _gridSize && !(isValidX && isValidY); i++) {
                    if ((x >= (i * xRatio) - xOffset) &&
                            (x <= (i * xRatio) + xOffset)) {
                        isValidX = true;
                        xDraw = i;
                    }
                    if ((y >= (i * yRatio) - yOffset) &&
                            (y <= (i * yRatio) + yOffset)) {
                        isValidY = true;
                        yDraw = i;
                    }
                }
                // If x and y are valid pass that off to the board
                if (isValidX && isValidY) {
                    _goBoard.step(xDraw - 1, yDraw - 1);
                    redraw();
                }
            }
        });
    }

    private void redraw() {
        this.invalidate();
    }

    /**
     * Function that overrides the default panel redraw and adds onto it
     * @param g Graphics object
     */
    @Override
    public void paintComponent(Graphics g) {
        // Call the default panel paint
        super.paintComponent(g);
        // Get a 2d graphics object from the 1d one
        Graphics2D g2 = (Graphics2D) g;
        // Set the stroke as bigger
        g2.setStroke(new BasicStroke(3));

        // Get the size of the panel
        componentDimension = this.getSize();
        // Draw the grids in
        for(int i = 1; i <= _gridSize; i++) {
            g2.drawLine(0, i * (componentDimension.height / (_gridSize + 1)), componentDimension.width,
                    i * (componentDimension.height / (_gridSize + 1)));
            g2.drawLine(i* (componentDimension.width / (_gridSize + 1)), 0 ,
                    i* (componentDimension.width / (_gridSize + 1)), componentDimension.height);

        }
        // Get the current board state
        int[][] currentState = _goBoard.getBoard();
        for(int i = 0; i < _gridSize; i++) {
            for(int j = 0; j < _gridSize; j++) {
                boolean doDraw = false;
                if(currentState[i][j] == 1) {
                    doDraw = true;
                }
                else if (currentState[i][j] == 2) {
                    doDraw = true;
                }
                System.out.print(currentState[i][j]);
                if (doDraw) {
                    g2.setColor(Color.WHITE);
                    g2.drawOval((i + 1) * (componentDimension.width / (_gridSize + 1)) - 2,
                            (i + 1) * (componentDimension.height / (_gridSize + 1)) - 2, 4, 4);
                }
            }
            System.out.println();
        }

    }


}
