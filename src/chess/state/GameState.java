package chess.state;

import chess.Game;
import chess.entity.Move;

public interface GameState {

    void makeMove(Game game, Move move);
    String getStateName();

}
