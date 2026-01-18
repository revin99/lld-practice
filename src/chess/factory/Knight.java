package chess.factory;

import chess.entity.Cell;

public class Knight extends Piece{
    public Knight(boolean isWhitePiece, boolean isKilled) {
        super(isWhitePiece, isKilled);
    }

    @Override
    public boolean validMove(Cell from, Cell to) {
        int x2 = to.getRow(); int y2 = to.getCol();
        int x1 = from.getRow(); int y1 = from.getCol();

        //diff in col is 2 and diff in row is 1
        int rowdiff = Math.abs(x2-x1);
        int coldiff = Math.abs(y2-y1);

        if(rowdiff==2 && coldiff==1) return true;
        if(rowdiff==1 && coldiff==2) return true;

        return false;
    }
}
