package tic_tac_toe_v2_guided;

import tic_tac_toe_v2_guided.enums.GameStatus;
import tic_tac_toe_v2_guided.models.Board;
import tic_tac_toe_v2_guided.models.Player;
import tic_tac_toe_v2_guided.state.GameState;
import tic_tac_toe_v2_guided.state.InProgressState;
import tic_tac_toe_v2_guided.strategy.ColumnWinningStrategy;
import tic_tac_toe_v2_guided.strategy.DiagonalWinningStrategy;
import tic_tac_toe_v2_guided.strategy.RowWinningStrategy;
import tic_tac_toe_v2_guided.strategy.WinningStrategy;

import java.util.List;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player current_player;

    public Player getCurrent_player() {
        return current_player;
    }

    public void setCurrent_player(Player current_player) {
        this.current_player = current_player;
    }

    private Player winningPlayer;
    private GameState gameState;
    private GameStatus gameStatus;
    private List<WinningStrategy> winningStrategyList;

    public Game(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.current_player=player1;
        this.gameState = new InProgressState();
        this.gameStatus = GameStatus.NOT_STARTED;
        this.winningStrategyList = List.of(new RowWinningStrategy(),
                new ColumnWinningStrategy(),
                new DiagonalWinningStrategy());
    }

    public void makeMove(Player player,int row, int col){
        gameState.handleMove(this,player,row,col);
    }

    public boolean checkWinner(Player player){
        for(WinningStrategy winningStrategy: winningStrategyList)
        {
            if(winningStrategy.checkWinner(board,player)){
                return true;
            }
        }
        return false;
    }

    public void switchPlayer(){
        if(this.current_player==player1) this.current_player=player2;
        else this.current_player=player1;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getWinningPlayer() {
        return winningPlayer;
    }

    public void setWinningPlayer(Player winningPlayer) {
        this.winningPlayer = winningPlayer;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public List<WinningStrategy> getWinningStrategyList() {
        return winningStrategyList;
    }

    public void setWinningStrategyList(List<WinningStrategy> winningStrategyList) {
        this.winningStrategyList = winningStrategyList;
    }
}
