package tic_tac_toe.entity;

import tic_tac_toe.constants.PieceEnum;

public class PlayingPiece {
    private PieceEnum pieceEnum;
    public PlayingPiece(PieceEnum pieceEnum)
    {
        this.pieceEnum = pieceEnum;
    }

    public PlayingPiece(){
        this.pieceEnum = PieceEnum.X;
    }

    public void setPieceEnum(PieceEnum pieceEnum){
        this.pieceEnum = pieceEnum;
    }

    public String getpieceEnum()
    {
        if(this.pieceEnum.equals(PieceEnum.X)) return "X";
        return "O";
    }
}
