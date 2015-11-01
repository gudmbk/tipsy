package com.company.GUI;

import com.company.Domain.AI;
import com.company.Domain.Player;
import com.company.Logic.Game;
import com.company.Logic.InvalidMoveException;
import com.company.Logic.State;

import java.util.Scanner;

/**
 * Created by Gudmundur Bjarni Kristinsson on 31-Oct-15.
 * gudmundurk14@ru.is
 * kt: 110384-3279
 */
public class Console implements GUI{
    @Override
    public void run() {
        welcome();
        boolean quit = false;
        while(!quit) {
            Game game = setUp();
            if(game != null){
                while(game.getGameState() == State.RUNNING) {
                    drawBoard(game.getGameBoard());
                    if(game.getCurrentPlayer().getIsHuman())
                        getPlayerMove(game);
                    else
                        game.computerMove();
                }
                announceWinner(game.getWinner());
            }
            quit = playAgain();
        }
    }

    private void getPlayerMove(Game game) {
        boolean valid;
        do {
            valid = true;
            Scanner in = new Scanner(System.in);
            System.out.println("Choose cell. In the format x y");
            int x = in.nextInt();
            int y = in.nextInt();
            try {
                game.makeMove(x, y);
            }catch (InvalidMoveException e) {
                valid = false;
                System.out.println("Cell is already taken or invalid. Try again...");
            }
        }while(!valid);
    }

    private void drawBoard(char[][] board) {
        StringBuilder string = new StringBuilder();
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                string.append("[" + board[x][y] + "]");
            }
            string.append("\n");
        }
        System.out.print(string);
    }

    private void announceWinner(Player winner) {
        if(winner == null)
            System.out.println("The game ended with a tie");

        if(winner.getIsHuman())
            System.out.println("Congratulations " + winner.getName() + " you won!");
        else
            System.out.println("The computer wins!");
    }

    private boolean playAgain() {
        Scanner in = new Scanner(System.in);
        System.out.println("Do you want to play another game (y for yes or any other to quit");
        String cont = in.nextLine();
        return cont != "y\n";
    }

    private Game setUp() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 1 to play against the Computer");
        System.out.println("Enter 2 to play against another player");
        Game game = null;
        int type = in.nextInt();
        in.nextLine();
        switch (type) {
            case 1:
                System.out.print("Please enter your name: ");
                String name = in.nextLine();
                Player p = new Player();
                p.setName(name);
                System.out.println("Do you want to play as Crosses? (y for yes or any other to play as Noughts)");
                String choice = in.nextLine();
                if(choice.equals("y"))
                    game = new Game(p, new AI());
                else
                    game = new Game(new AI(), p);
                break;
            case 2:
                System.out.println("Player 1 plays as Crosses and player 2 as Noughts");
                System.out.print("Please enter player 1's name: ");
                String player1 = in.nextLine();
                Player p1 = new Player();
                p1.setName(player1);
                System.out.print("Please enter player 2's name: ");
                String player2 = in.nextLine();
                Player p2 = new Player();
                p2.setName(player2);
                game = new Game(p1, p2);
                break;
            default:
                break;
        }
        return game;
    }

    private void welcome() {
        System.out.println("Welcome to Tic Tac Toe");
        System.out.println();
    }
}
