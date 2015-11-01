package com.company.Domain;

public class GameBoard {
    private char board[][];
    private int cellsFull;

    public GameBoard() {
        board = new char[3][3];
        for(char space[] : board) {
            space[0] = ' ';
            space[1] = ' ';
            space[2] = ' ';
        }
        cellsFull = 0;
    }

    public char[][] getBoard() {
        return board;
    }

    public void makeMove(int x, int y, char mark) {
        board[x][y] = mark;
        cellsFull++;
    }

    public char getCell(int x, int y) {
        return board[x][y];
    }

    public boolean isCellEmpty(int x, int y) {
        return board[x][y] == ' ';
    }

    public boolean isBoardFull() {
        return cellsFull >= 9;
    }
}
