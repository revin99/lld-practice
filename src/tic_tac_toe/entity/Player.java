package tic_tac_toe.entity;

import tic_tac_toe.constants.PieceEnum;

public class Player {

    private String name;
    private PlayingPiece playingPiece;


    Player(String name, PlayingPiece playingPiece)
    {
        this.name=name;
        this.playingPiece = playingPiece;
    }

    public String getName(){
        return this.name;
    }

    public PlayingPiece getplayingPiece(){
        return this.playingPiece;
    }
}
