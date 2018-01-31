package edu.cis306.alex;

/***************************************
 * Name: Board.java
 * Project: GoBot
 * Purpose: To encapsulate the board class and have it do all
 * the boardy things that boards do
 * Author: Alex
 * Date: 1/29/2018
 * Inputs: None
 * Outputs: None
 ***************************************/
public class Board {
    private int[][] board;
    private int size;
    private int whiteHandicap;
    private int blackHandicap;

    public int getWhiteHandicap() {
        return whiteHandicap;
    }

    public void setWhiteHandicap(int whiteHandicap) {
        this.whiteHandicap = whiteHandicap;
    }

    public int getBlackHandicap() {
        return blackHandicap;
    }

    public void setBlackHandicap(int blackHandicap) {
        this.blackHandicap = blackHandicap;
    }

    public int[][] getBoard() {

        return board;
    }

    public Board(int p_size, int p_whitehandicap, int p_blackhandicap) {
        board = new int[p_size][p_size];
        whiteHandicap = p_whitehandicap;
        blackHandicap = p_blackhandicap;
        board[3][3] = 1;

    }

    /**
     * MOST IMPORTANT
     * @param x
     * @param y
     * @return
     */
    public boolean step(int x, int y) {
        System.out.println("X: " + x + " Y: " + y);
        return true;
    }
}
