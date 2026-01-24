package tic_tac_toe_v2_guided.state;

import tic_tac_toe_v2_guided.Game;
import tic_tac_toe_v2_guided.enums.GameStatus;
import tic_tac_toe_v2_guided.enums.Symbol;
import tic_tac_toe_v2_guided.exceptions.InvalidMoveException;
import tic_tac_toe_v2_guided.models.Board;
import tic_tac_toe_v2_guided.models.Player;

public class InProgressState implements GameState{

    @Override
    public void handleMove(Game game, Player player,int row, int col) {
        Board board = game.getBoard();
        int size = board.getSize();

        game.getBoard().placeSymbol(player.getSymbol(),row,col);

        if(game.checkWinner(player)){
            game.setWinningPlayer(player);
            game.setGameState(new WinnerState());
            game.setGameStatus((player.getSymbol() == Symbol.X ? GameStatus.X_WINNER : GameStatus.O_WINNER));
        }else if(!game.getBoard().movesLeft()){
            System.out.println("Game is draw");
            game.setGameState(new DrawState());
        }else{
            game.switchPlayer();
        }

    }
}
