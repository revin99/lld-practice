package chess.entity;

import chess.strategy.PlayerStrategy;

public class Player {

    private String name;
    private boolean isWhite;
    private PlayerStrategy playerStrategy;

    public Player(String name, boolean isWhite, PlayerStrategy playerStrategy) {
        this.name = name;
        this.isWhite = isWhite;
        this.playerStrategy=playerStrategy;
    }

    // Ask the strategy to make a move
    public Move makeMove(Board board) {
        return playerStrategy.makeMove(this, board);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public PlayerStrategy getPlayerStrategy() {
        return playerStrategy;
    }

    public void setPlayerStrategy(PlayerStrategy playerStrategy) {
        this.playerStrategy = playerStrategy;
    }
}
