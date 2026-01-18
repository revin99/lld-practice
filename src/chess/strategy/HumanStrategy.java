package chess.strategy;

import chess.entity.Board;
import chess.entity.Cell;
import chess.entity.Move;
import chess.entity.Player;
import chess.factory.Piece;

import java.util.Scanner;

public class HumanStrategy implements PlayerStrategy{

    private Scanner scanner = new Scanner(System.in);
    @Override
    public Move makeMove(Player player,Board board) {

        System.out.println(player.getName() + "'s turn. Enter your move:");

        // Example input: e2 e4
        String input = scanner.nextLine();
        String[] tokens = input.split(" ");
        if(tokens.length != 2) return null;

        Cell from = board.getCellFromChessNotation(tokens[0]);
        Cell to = board.getCellFromChessNotation(tokens[1]);

        Piece piece = from.getPiece();
        if(piece == null) {
            System.out.println("No piece at from-cell!");
            return null;
        }
        if(!piece.canMove(board, from, to)) {
            System.out.println("Invalid move for this piece!");
            return null;
        }

        return new Move(from, to);
    }
}
