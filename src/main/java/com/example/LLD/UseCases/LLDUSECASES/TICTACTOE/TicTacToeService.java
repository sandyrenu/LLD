package com.example.LLD.UseCases.LLDUSECASES.TICTACTOE;

import java.util.Scanner;

import static com.example.LLD.UseCases.LLDUSECASES.TICTACTOE.Symbols.CIRCLE;
import static com.example.LLD.UseCases.LLDUSECASES.TICTACTOE.Symbols.CROSS;

public class TicTacToeService {

    public void startGame(){
        // to start a game you need board and players
        // for every player require a symbol
         Board board = new Board(3,3);
         Players player1 = new Players("renu" ,'o');
         Players player2 = new Players("sandy",'x');
         intializePlaying(board,player1,player2);
    }

    private void intializePlaying(Board board, Players player1, Players player2) {

//          int rows = board.getRows();
//          int columns = board.getColumns();
//
//          for(int i = 0 ; i < rows ;i++) {
//              for(int j = i + 1;j < columns;j++) {
//
//
//              }
//          }
        Scanner scanner = new Scanner(System.in);
        boolean isPlayer1Turn = true;

        while (true) {
            board.printBoard();
            Players currentPlayer = isPlayer1Turn ? player1 : player2;
            System.out.println(currentPlayer.player + "'s turn (" + currentPlayer.getSymbol() + ")");
            System.out.print("Enter row (0-2): ");
            int row = scanner.nextInt();
            System.out.print("Enter column (0-2): ");
            int col = scanner.nextInt();

            if (board.makeMove(row, col, currentPlayer.getSymbol())) {
                // Check for win
                if (board.checkWin(currentPlayer.getSymbol())) {
                    board.printBoard();
                    System.out.println(currentPlayer.getPlayer() + " wins!");
                    break;
                }
                // Check for draw
                if (board.isFull()) {
                    board.printBoard();
                    System.out.println("It's a draw!");
                    break;
                }

                // Switch turn
                isPlayer1Turn = !isPlayer1Turn;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        scanner.close();

    }
}
