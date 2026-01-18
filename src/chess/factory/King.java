package chess.factory;

import chess.entity.Cell;

public class King extends Piece{


    public King(boolean isWhitePiece, boolean isKilled) {
        super(isWhitePiece, isKilled);
    }

    @Override
    public boolean validMove(Cell from, Cell to) {
        //king valid piece move logic

        if(Math.abs(to.getCol()-from.getCol())>1) return false;
        if(Math.abs(to.getRow()-from.getRow())>1) return false;
        if(to.getCol()==from.getRow() && to.getCol()==from.getCol()) return false;

        return true;
    }
}
