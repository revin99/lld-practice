package tic_tac_toe_v2_guided.state;

import tic_tac_toe_v2_guided.Game;
import tic_tac_toe_v2_guided.enums.Symbol;
import tic_tac_toe_v2_guided.models.Player;

public class DrawState implements GameState{
    @Override
    public void handleMove(Game game, Player player, int row, int col) {
        System.out.println("Game has already been drawn");
    }
}
