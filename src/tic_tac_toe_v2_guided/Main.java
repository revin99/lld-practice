package tic_tac_toe_v2_guided;

import tic_tac_toe_v2_guided.enums.Symbol;
import tic_tac_toe_v2_guided.models.Player;

import java.util.Scanner;

public class Main {

    public static void main(String [] args)
    {
        TicTacToeSystem system = TicTacToeSystem.getInstance();
        Scanner sc = new Scanner(System.in);

        system.createGame(new Player("alice", Symbol.X),new Player("bob",Symbol.O),3);

        int option = 4;
        while (option!=-3)
        {
            System.out.println("1.Print board\n2.Play turn\n3.Exit game");
            option=sc.nextInt();

            if(option==1){
                system.printBoard();
            }else if(option==2){
                System.out.println("Player turn: " + system.getCurrentPlayer().getName());
                System.out.println("Choose row and col");
                int row = sc.nextInt();
                int col = sc.nextInt();
                system.makeMove(system.getCurrentPlayer(),row,col);
            }else{
                break;
            }
        }
    }
}
