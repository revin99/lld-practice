package chess.entity;

import chess.factory.Piece;
import chess.factory.PieceFactory;

public class Board {

    private Cell [][] cells;
    private PieceFactory pieceFactory;

    public Board(){
        this.cells = new Cell[8][8];

        for(int r=0;r<8;r++){
            for(int c=0;c<8;c++){
                cells[r][c] = new Cell(r,c);
            }
        }
        this.pieceFactory = new PieceFactory();

        initialisePieces();
    }

    void initialisePieces(){
        // White pieces

        cells[0][0].setPiece(pieceFactory.getPiece("Rook", true));
        cells[0][1].setPiece(pieceFactory.getPiece("Knight", true));
        cells[0][2].setPiece(pieceFactory.getPiece("Bishop", true));
        cells[0][3].setPiece(pieceFactory.getPiece("Queen", true));
        cells[0][4].setPiece(pieceFactory.getPiece("King", true));
        cells[0][5].setPiece(pieceFactory.getPiece("Bishop", true));
        cells[0][6].setPiece(pieceFactory.getPiece("Knight", true));
        cells[0][7].setPiece(pieceFactory.getPiece("Rook", true));

        for (int c = 0; c < 8; c++) {
            cells[1][c].setPiece(pieceFactory.getPiece("Pawn", true));
        }

        // Black pieces
        cells[7][0].setPiece(pieceFactory.getPiece("Rook", false));
        cells[7][1].setPiece(pieceFactory.getPiece("Knight", false));
        cells[7][2].setPiece(pieceFactory.getPiece("Bishop", false));
        cells[7][3].setPiece(pieceFactory.getPiece("Queen", false));
        cells[7][4].setPiece(pieceFactory.getPiece("King", false));
        cells[7][5].setPiece(pieceFactory.getPiece("Bishop", false));
        cells[7][6].setPiece(pieceFactory.getPiece("Knight", false));
        cells[7][7].setPiece(pieceFactory.getPiece("Rook", false));
        for (int c = 0; c < 8; c++) {
            cells[6][c].setPiece(pieceFactory.getPiece("Pawn", false));
        }
    }

    public Cell getCellFromChessNotation(String pos) {
        pos = pos.toLowerCase();
        int col = pos.charAt(0) - 'a';  // a-h -> 0-7
        int row = Integer.parseInt(pos.charAt(1) + "") - 1; // 1-8 -> 0-7
        return cells[row][col];
    }


    public void printBoard() {
        System.out.println("  a b c d e f g h");
        for (int r = 7; r >= 0; r--) { // print row 8 -> 1
            System.out.print((r+1) + " ");
            for (int c = 0; c < 8; c++) {
                Piece piece = cells[r][c].getPiece();
                if(piece == null) {
                    System.out.print(". ");
                } else {
                    // Simple notation: uppercase for white, lowercase for black
                    char symbol = getPieceSymbol(piece);
                    System.out.print(symbol + " ");
                }
                }
            System.out.println();
        }
    }

    private char getPieceSymbol(Piece piece) {
        String name = piece.getClass().getSimpleName(); // King, Queen, etc.
        char symbol;
        switch(name) {
                case "King": symbol = 'K'; break;
                case "Queen": symbol = 'Q'; break;
                case "Rook": symbol = 'R'; break;
                case "Bishop": symbol = 'B'; break;
                case "Knight": symbol = 'N'; break;
                case "Pawn": symbol = 'P'; break;
                default: symbol = '?';
            }

            if(!piece.isWhitePiece()) symbol = Character.toLowerCase(symbol);
            return symbol;
    }
}

