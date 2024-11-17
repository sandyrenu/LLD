package com.example.LLD.UseCases.LLDUSECASES.TICTACTOE;

public class TicTacToe {


    public static  void main(String[] args){
        System.out.println("Starting the ticTac Toe Game");
        TicTacToeService tictacservice = new TicTacToeService();
        tictacservice.startGame();
    }
}
