package chess.factory;

import chess.entity.Cell;

public class Queen extends Piece{
    public Queen(boolean isWhitePiece, boolean isKilled) {
        super(isWhitePiece, isKilled);
    }

    @Override
    public boolean validMove(Cell from, Cell to) {
        int x2 = to.getRow(); int y2 = to.getCol();
        int x1 = from.getRow(); int y1 = from.getCol();

        return true; //marking all moves as true
    }
}
