package chess.state;

import chess.Game;
import chess.entity.Move;

public class WhiteTurnState implements  GameState{
    @Override
    public void makeMove(Game game, Move move) {

        if(!move.getStartCell().getPiece().isWhitePiece()) { //if start piece is black then return
            System.out.println("It's White's turn!");
            return;
        }

        // Delegate actual move to Game
        game.performMove(move);

        // Switch to Black's turn
        game.setGameState(new WhiteTurnState());
    }

    @Override
    public String getStateName() {
        return "White state";
    }
}
