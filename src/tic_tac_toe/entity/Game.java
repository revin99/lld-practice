package tic_tac_toe.entity;

import tic_tac_toe.constants.PieceEnum;

import java.util.Scanner;

public class Game {

    Scanner sc = new Scanner(System.in);
    private Board board;
    private Player player1,player2;

    public Game(int boardSize){

        this.board = new Board(boardSize);

        System.out.println("Enter Player 1 Name: ");
        String name1 = sc.nextLine();
        System.out.println("Player 1 piece enter X or O:");
        String p1 = sc.nextLine();

        System.out.println("Enter Player 2 Name: ");
        String name2 = sc.nextLine();

        PlayingPiece piece1 = new PlayingPiece();
        PlayingPiece piece2 = new PlayingPiece();

        if(p1.equals("X")){
            piece1.setPieceEnum(PieceEnum.X);
            piece2.setPieceEnum(PieceEnum.O);
        }else{
            piece1.setPieceEnum(PieceEnum.O);
            piece2.setPieceEnum(PieceEnum.X);
        }


        this.player1 = new Player(name1,piece1);
        this.player2 = new Player(name2,piece2);

        System.out.println("Player 1 details: Name: " + player1.getName() + " Piece: " + player1.getplayingPiece().getpieceEnum());
        System.out.println("Player 2 details: Name: " + player2.getName() + " Piece: " +player2.getplayingPiece().getpieceEnum());
    }

    public void printBoard(){
        this.board.printBoard();
    }

    public void playGame(){

        Integer winner = 0;
        Integer i=0;
        while (winner==0)
        {
            if(i%2==0){
                //Player 1 turn
                System.out.println("Player turn: " + this.player1.getName());
                System.out.println("Choose x,y to place your symbol");
                Integer xcord = sc.nextInt();
                Integer ycord = sc.nextInt();
                board.setPiece(xcord,ycord,this.player1.getplayingPiece());

            }else {
                //Player 2 Turn
                System.out.println("Player turn: " + this.player2.getName());
                System.out.println("Choose x,y to place your symbol");
                Integer xcord = sc.nextInt();
                Integer ycord = sc.nextInt();
                board.setPiece(xcord,ycord,this.player2.getplayingPiece());

            }
            winner = board.checkWinner();
            i++;
        }

        if(winner==1){
            System.out.println(this.player1.getName() + " has Won");
        }else if(winner==2){
            System.out.println(this.player2.getName() + " has Won");
        }else{
            System.out.println("Game has Tied");
        }

    }
}
