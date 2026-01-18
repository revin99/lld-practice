package chess.factory;

import chess.entity.Cell;

public class Bishop extends Piece{
    public Bishop(boolean isWhitePiece, boolean isKilled) {
        super(isWhitePiece, isKilled);
    }

    @Override
    public boolean validMove(Cell from, Cell to) {

        int x2 = to.getRow(); int y2 = to.getCol();
        int x1 = from.getRow(); int y1 = from.getCol();

        if(x2-x1 == y2-y1) return true; //slope has to be the same

        return false;
    }
}
