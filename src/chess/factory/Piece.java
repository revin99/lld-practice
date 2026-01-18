package chess.factory;

import chess.entity.Board;
import chess.entity.Cell;

public abstract class Piece {

    private boolean isWhitePiece;
    private boolean isKilled;

    public Piece(boolean isWhitePiece, boolean isKilled) {
        this.isWhitePiece = isWhitePiece;
        this.isKilled = isKilled;
    }

    public boolean isWhitePiece() {
        return isWhitePiece;
    }

    public void setWhitePiece(boolean whitePiece) {
        isWhitePiece = whitePiece;
    }

    public boolean isKilled() {
        return isKilled;
    }

    public void setKilled(boolean killed) {
        isKilled = killed;
    }

    public boolean canMove(Board board,Cell from, Cell to){

        if(to.getPiece()!=null && to.getPiece().isWhitePiece==this.isWhitePiece)
        {
            return false;
        }
        return validMove(from,to);
    }
    public abstract boolean validMove(Cell from,Cell to);
}
