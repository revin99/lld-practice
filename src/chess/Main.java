package chess;

import chess.entity.Board;
import chess.entity.Move;
import chess.entity.Player;
import chess.strategy.HumanStrategy;

public class Main {

    public static void main(String [] args){

        // 1️⃣ Initialize Board
        Board board = new Board(); // assume this sets up all pieces in starting positions

        // 2️⃣ Initialize Players
        Player whitePlayer = new Player("Alice", true, new HumanStrategy());
        Player blackPlayer = new Player("Bob", false, new HumanStrategy());

        // 3️⃣ Initialize Game (Singleton)
        Game game = Game.getInstance(board);

        // 4️⃣ Print initial board
        System.out.println("Initial Board:");
        board.printBoard();

        // 5️⃣ Game Loop
        while(!game.isOver()) {
            Player currentPlayer;
            if(game.getGameState().getStateName().contains("White")) {
                currentPlayer = whitePlayer;
            } else {
                currentPlayer = blackPlayer;
            }

            // Ask current player for a move
            Move move = currentPlayer.makeMove(board);

            if(move != null) {
                // Delegate move to Game (State will enforce turn)
                game.performMove(move);

                // Print updated board
                board.printBoard();
            }
        }

        System.out.println("Game Over!");
    }
}
