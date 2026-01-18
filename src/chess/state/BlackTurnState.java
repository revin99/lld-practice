package chess.state;

import chess.Game;
import chess.entity.Move;

public class BlackTurnState implements GameState{
    @Override
    public void makeMove(Game game, Move move) {

        if(move.getStartCell().getPiece().isWhitePiece()) { //if start piece is white then return
            System.out.println("It's Black's turn!");
            return;
        }

        // Delegate actual move to Game
        game.performMove(move);

        // Switch to Black's turn
        game.setGameState(new WhiteTurnState());
    }

    @Override
    public String getStateName() {
        return "White turn state";
    }
}
