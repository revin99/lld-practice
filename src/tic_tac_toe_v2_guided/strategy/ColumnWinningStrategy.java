package tic_tac_toe_v2_guided.strategy;

import tic_tac_toe_v2_guided.models.Board;
import tic_tac_toe_v2_guided.models.Player;

public class ColumnWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Player player) {
        int size = board.getSize();

        for(int i=0;i<size;i++)
        {
            boolean ans = true;
            for(int j=0;j<size;j++)
            {
                if(board.getCell(j,i).getSymbol() != player.getSymbol()) {ans=false; break;}
            }
            if(ans) return true;
        }
        return false;
    }
}
