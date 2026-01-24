package tic_tac_toe_v2_guided.strategy;

import tic_tac_toe_v2_guided.models.Board;
import tic_tac_toe_v2_guided.models.Player;

public class DiagonalWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Player player) {
        int size = board.getSize();
        boolean ans = true;
        for (int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++){
                if(board.getCell(i,j).getSymbol()!=player.getSymbol()) {
                    ans = false; break;
                }
            }
            if(!ans) break;
        }

        if(ans) return true;

        ans=true;
        for(int i=size-1;i>=0;i--)
        {
            for(int j=0;j<size;j++)
            {
                if(board.getCell(i,j).getSymbol()!=player.getSymbol()){
                    ans=false; break;
                }
            }
            if(!ans) break;
        }
        return ans;
    }
}
