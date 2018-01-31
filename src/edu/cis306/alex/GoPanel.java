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
    private int gridSize;
    Board goBoard;
    private Dimension componentDimension;

    GoPanel(int p_gridSize, Board goBoard) {
        gridSize = p_gridSize;
        this.goBoard = goBoard;
        addMouseListener();
    }

    private void addMouseListener() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                int xDraw = 0;
                int yDraw = 0;
                double xRatio = (double) componentDimension.width / (double) (gridSize + 1);
                double yRatio = (double) componentDimension.height / (double) (gridSize + 1);
                boolean isValidX = false;
                boolean isValidY = false;
                double xOffset = (1.0 / 3.0) * xRatio;
                double yOffset = (1.0 / 3.0) * yRatio;
                for (int i = 1; i <= gridSize; i++) {
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
                if (isValidX && isValidY && goBoard.checkValididty(xDraw, yDraw));
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        componentDimension = this.getSize();
        for(int i = 1; i <= gridSize; i++) {
            g2.drawLine(0, i * (componentDimension.height / (gridSize + 1)), componentDimension.width,
                    i * (componentDimension.height / (gridSize + 1)));
            g2.drawLine(i* (componentDimension.width / (gridSize + 1)), 0 ,
                    i* (componentDimension.width / (gridSize + 1)), componentDimension.height);

        }
    }


}
