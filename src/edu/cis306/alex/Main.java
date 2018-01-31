package edu.cis306.alex;

public class Main {

    private static Board board;

    public static void main(String[] args) {
        board = new Board(9, 0, 0);
        GoFrame goFrame = new GoFrame(board);
        goFrame.setVisible(true);
    }
}
