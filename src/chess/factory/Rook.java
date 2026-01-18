package chess.factory;

import chess.entity.Cell;

public class Rook extends Piece{
    public Rook(boolean isWhitePiece, boolean isKilled) {
        super(isWhitePiece, isKilled);
    }

    @Override
    public boolean validMove(Cell from, Cell to) {
        int x2 = to.getRow(); int y2 = to.getCol();
        int x1 = from.getRow(); int y1 = from.getCol();

        //if row is not same then col should be same
        if(x2!=x1 && y1==y2) return true;

        //if col is not same then row should be same
        if(y1!=y2 && x1==x2) return true;

        return false;
    }
}
