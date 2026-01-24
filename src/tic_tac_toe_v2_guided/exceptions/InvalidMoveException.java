package tic_tac_toe_v2_guided.exceptions;

public class InvalidMoveException extends RuntimeException{
    public InvalidMoveException(String message) {
        super(message);
    }
}
