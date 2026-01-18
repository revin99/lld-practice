package chess;

import chess.entity.Board;
import chess.entity.Cell;
import chess.entity.Move;
import chess.factory.Piece;
import chess.state.GameState;

public class Game {
    public static Game instance;
    private Board board;
    private boolean gameOver = false;
    private GameState gameState;

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    private Game(Board board){
        this.board=board;
    }

    public static Game getInstance(Board board){
        if(instance==null){
            instance=new Game(board);
        }
        return instance;
    }

    public void start(){
        System.out.println("Game started!!");
    }

    public Board getBoard(){
        return board;
    }

    public void performMove(Move move) {
        Cell from = move.getStartCell();
        Cell to = move.getEndCell();
        Piece piece = from.getPiece();

        if(piece == null) {
            System.out.println("No piece at start cell!");
            return;
        }

        // Move validation
        if(!piece.canMove(board, from, to)) {
            System.out.println("Invalid move for this piece!");
            return;
        }

        // Capture logic
        if(to.getPiece() != null) {
            to.getPiece().setKilled(true);
            System.out.println(to.getPiece().getClass().getSimpleName() + " captured!");
        }

        // Move piece
        to.setPiece(piece);
        from.setPiece(null);


        // Optional: check for check/checkmate
        // TODO: isKingInCheck(), isCheckMate()
    }

    public boolean isOver() {
        return gameOver;
    }

    // For later: method to end game
    public void endGame() {
        gameOver = true;
    }


}
