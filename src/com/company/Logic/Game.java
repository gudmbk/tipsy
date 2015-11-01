package com.company.Logic;

import com.company.Domain.GameBoard;
import com.company.Domain.Player;

public class Game {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private GameBoard gameBoard;
    private State state;
    private Player winner;

    public Game(Player player1, Player player2) {
        gameBoard = new GameBoard();
        state = State.RUNNING;
        winner = null;
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = player1;
    }

    public State getGameState() {
        return state;
    }

    private boolean checkWin(int x, int y) {
        char currentMark = getMark();
        if(gameBoard.getCell(x, 0) == currentMark && gameBoard.getCell(x, 1) == currentMark && gameBoard.getCell(x, 2) == currentMark)
            return true;
        if(gameBoard.getCell(0, y) == currentMark && gameBoard.getCell(1, y) == currentMark && gameBoard.getCell(2, y) == currentMark)
            return true;
        if(gameBoard.getCell(0, 0) == currentMark && gameBoard.getCell(1, 1) == currentMark && gameBoard.getCell(2, 2) == currentMark)
            return true;
        if(gameBoard.getCell(2, 0) == currentMark && gameBoard.getCell(1, 1) == currentMark && gameBoard.getCell(0, 2) == currentMark)
            return true;

        return false;
    }

    public void makeMove(int x, int y) throws InvalidMoveException {
        if(validMove(x, y)) {
            gameBoard.makeMove(x, y, getMark());
            if(checkWin(x, y)) {
                state = State.WINNER;
                winner = currentPlayer;
                return;
            } else if(gameBoard.isBoardFull()) {
                state = State.TIE;
                return;
            }
            switchCurrentPlayer();
        } else {
            throw new InvalidMoveException();
        }
    }

    private void switchCurrentPlayer() {
        if(currentPlayer == player1)
            currentPlayer = player2;
        else
            currentPlayer = player1;
    }

    private char getMark() {
        return currentPlayer == player1 ? 'X' : 'O';
    }

    private boolean validMove(int x, int y) {
        if(x > 2 || y > 2)
            return false;
        if(x < 0 || y < 0)
            return false;
        if(!gameBoard.isCellEmpty(x, y))
            return false;

        return true;
    }

    public Player getWinner() {
        return winner;
    }

    public char[][] getGameBoard() {
        return gameBoard.getBoard();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void computerMove() {
        Player ai = getCurrentPlayer();
        boolean valid;
        do {
            valid = true;
            int []arr = ai.generateMove();
            try {
                makeMove(arr[0], arr[1]);
            }catch (InvalidMoveException e) {
                valid = false;
            }
        }while(!valid);

    }
}
