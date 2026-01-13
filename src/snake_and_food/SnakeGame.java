package snake_and_food;

import snake_and_food.entities.Board;
import snake_and_food.entities.Pair;

import java.util.Deque;
import java.util.Map;

public class SnakeGame {

    private Board gameBoard;
    Deque<Pair> snake;
    Map<Pair,Boolean> snakeMap;
    int [][] food;
    int foodIndex;
    PlayerStrategy playerStrategy;
    
}
