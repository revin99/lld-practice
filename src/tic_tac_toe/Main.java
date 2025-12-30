package tic_tac_toe;

import tic_tac_toe.entity.Game;

public class Main {

    public static void main(String[] args){
        System.out.println("This is main Class of tic tac toe");
        Game game1 = new Game(3);
        game1.printBoard();
        game1.playGame();
    }
}
