package com.example.LLD.UseCases.LLDUSECASES.TICTACTOE;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Board {
    private char[][] board;
    int rows;
    int columns;
    Board(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        board = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = '-'; // Empty cells
            }
        }
    }
    public boolean makeMove(int row, int col, char symbol) {
        if (row >= 0 && row < rows && col >= 0 && col < columns && board[row][col] == '-') {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }

    public void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean checkWin(char symbol) {
        // Check rows
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < columns; j++) {
            if (board[0][j] == symbol && board[1][j] == symbol && board[2][j] == symbol) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true;
        }

        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }


}
