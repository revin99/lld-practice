package chess.strategy;

import chess.entity.Board;
import chess.entity.Move;
import chess.entity.Player;

public interface PlayerStrategy {

    Move makeMove(Player player,Board board);
}
