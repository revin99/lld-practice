package tic_tac_toe_v2_guided;

import tic_tac_toe_v2_guided.exceptions.InvalidMoveException;
import tic_tac_toe_v2_guided.models.Board;
import tic_tac_toe_v2_guided.models.Player;
import tic_tac_toe_v2_guided.state.InProgressState;

public class TicTacToeSystem {

    private static TicTacToeSystem instance;
    private Game game;

    private TicTacToeSystem(){}

    public static TicTacToeSystem getInstance(){
        if(instance==null){
            instance = new TicTacToeSystem();
        }
        return instance;
    }

    public Player getCurrentPlayer(){
        return game.getCurrent_player();
    }

    public void createGame(Player player1, Player player2, int size)
    {
        Board board = new Board(size);
        this.game = new Game(board,player1,player2);

        System.out.println("Game started between " + player1.getName() + " and " + player2.getName());
    }

    public void makeMove(Player player, int row, int col)
    {
        if(game==null){
            System.out.println("No game in progress please create a game first");
        }

        try {
            System.out.printf("%s plays at (%d, %d)%n", player.getName(), row, col);
            game.makeMove(player, row, col);
            printBoard();
            System.out.println("Game Status: " + game.getGameStatus());

            if (game.getWinningPlayer() != null) {
                System.out.println("Winner: " + game.getWinningPlayer().getName());
            }
        } catch (InvalidMoveException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void printBoard(){
        this.game.getBoard().printBoard();
    }


}
