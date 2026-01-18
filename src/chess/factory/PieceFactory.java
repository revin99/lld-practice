package chess.factory;

public class PieceFactory {

    public Piece getPiece(String name, boolean isWhitePiece)
    {
        switch (name){
            case "King":
                return new King(isWhitePiece,false);
            case "Queen":
                return new Queen(isWhitePiece,false);
            case "Knight":
                return new Knight(isWhitePiece,false);
            case "Rook":
                return new Rook(isWhitePiece,false);
            case "Bishop":
                return new Bishop(isWhitePiece,false);
            case "Pawn":
                return new Pawn(isWhitePiece,false);
            default:
                throw new IllegalArgumentException("Illegal chess move name");
        }
    }
}
