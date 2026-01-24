package tic_tac_toe_v2_guided.strategy;

import tic_tac_toe_v2_guided.models.Board;
import tic_tac_toe_v2_guided.models.Player;

public interface WinningStrategy {

    public boolean checkWinner(Board board, Player player);
}
