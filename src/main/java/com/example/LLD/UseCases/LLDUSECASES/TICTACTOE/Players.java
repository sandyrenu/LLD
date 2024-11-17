package com.example.LLD.UseCases.LLDUSECASES.TICTACTOE;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Players {

    char symbol;

    String player;
    Players(String player, char symbol){
        this.player = player;
        this.symbol = symbol;
    }
}
