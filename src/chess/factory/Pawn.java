package chess.factory;

import chess.entity.Cell;

public class Pawn extends Piece{
    public Pawn(boolean isWhitePiece, boolean isKilled) {
        super(isWhitePiece, isKilled);
    }

    @Override
    public boolean validMove(Cell from, Cell to) {

        int x2 = to.getRow(); int y2 = to.getCol();
        int x1 = from.getRow(); int y1 = from.getCol();

        if(x2!=x1+1) return false; //has to be just one row ahead
        if(Math.abs(y2-y1)>1) return false; //difference is col cannot be more than 1

        return true;
    }
}
