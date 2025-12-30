package snake_and_ladder;

import snake_and_ladder.models.Board;
import snake_and_ladder.models.Player;
import snake_and_ladder.models.Position;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("This is the main snake and ladder class");

        Board board = new Board(50);

        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player("P1",new Position(0)));
        playerList.add(new Player("P2",new Position(0)));


        Game game = new Game(board,playerList);

        System.out.println(game.playGame());
    }
}
