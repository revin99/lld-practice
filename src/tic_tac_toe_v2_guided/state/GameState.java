package tic_tac_toe_v2_guided.state;

import tic_tac_toe_v2_guided.Game;
import tic_tac_toe_v2_guided.models.Player;

public interface GameState {

    public void handleMove(Game game, Player player, int row, int col);
}
