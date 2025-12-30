package snake_and_ladder;

import snake_and_ladder.models.*;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Game {

    private Board board;
    private List<Player> playerList;
    private Dice dice;
    Scanner sc = new Scanner(System.in);

    public Game(Board board, List<Player> playerList){
        this.board=board;
        this.playerList=playerList;
        dice = new Dice();
    }

    public String playGame()
    {
        int winner = -1;
        int numberOfPlayers = this.playerList.size();
        int turn=0;
        while (winner==-1)
        {
            turn%=numberOfPlayers;

            Player player = playerList.get(turn);
            Position playerOldPosition = player.getPlayerPosition();
            System.out.println("Turn of " + player.getName() + " at position " + playerOldPosition.getPos());

            System.out.println("Enter 1 to roll dice or 2 to exit game");
            int choice = sc.nextInt();
            if(choice==2) {winner=-2; break;}

            int value = dice.rollDice();
            System.out.println("Dice value is " + value);

            player.setPlayerPosition(new Position(playerOldPosition.getPos()+value));
            System.out.println("New position is " + player.getPlayerPosition().getPos());
            System.out.println("Checking for Snake and Ladder");

            Snake snake = board.checkSnake(player.getPlayerPosition());
            Ladder ladder = board.checkLadder(player.getPlayerPosition());

            if(snake!=null){
                System.out.println("Snake found with head: " + snake.getHead().getPos() + " and tail: " + snake.getTail().getPos());
                player.setPlayerPosition(snake.getTail());
                System.out.println("New position is " + player.getPlayerPosition().getPos());
            }else if(ladder!=null)
            {
                System.out.println("Ladder found with start: " + ladder.getStart().getPos() + " and end: " + ladder.getEnd().getPos());
                player.setPlayerPosition(ladder.getEnd());
                System.out.println("New position is " + player.getPlayerPosition().getPos());
            }else {
                System.out.println("No snake or ladder found");
            }

            if(player.getPlayerPosition().getPos()>=board.getSize()){
                winner = turn;
            }

            turn++;
        }

        if(winner==-2) return "Game was interrupted";

        Player playerWinner = playerList.get(winner);

        return "Winner is player " + playerWinner.getName();

    }

}
