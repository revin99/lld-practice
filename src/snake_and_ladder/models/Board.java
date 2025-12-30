package snake_and_ladder.models;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private int size;
    private List<Snake> snakeList;
    private List<Ladder> ladderList;

    public Board(int size)
    {
        this.size=size;

        snakeList = new ArrayList<>();
        ladderList = new ArrayList<>();
        //make 5 snakes and add
        snakeList.add(new Snake(new Position(7),new Position(2)));
        snakeList.add(new Snake(new Position(11),new Position(8)));
        snakeList.add(new Snake(new Position(27),new Position(20)));
        snakeList.add(new Snake(new Position(36),new Position(23)));
        snakeList.add(new Snake(new Position(48),new Position(10)));

        //create 5 ladders and add
        ladderList.add(new Ladder(new Position(5),new Position(10)));
        ladderList.add(new Ladder(new Position(12),new Position(21)));
        ladderList.add(new Ladder(new Position(15),new Position(18)));
        ladderList.add(new Ladder(new Position(25),new Position(32)));
        ladderList.add(new Ladder(new Position(19),new Position(43)));

    }

    public int getSize(){
        return size;
    }

    public Snake checkSnake(Position position)
    {
        for (Snake item:snakeList)
        {
            if(item.getHead().getPos()==position.getPos()) return item;
        }
        return null;
    }

    public Ladder checkLadder(Position position){
        for(Ladder item:ladderList)
        {
            if(item.getStart().getPos()==position.getPos()) return item;
        }

        return null;
    }
}
