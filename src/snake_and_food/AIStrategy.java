package snake_and_food;

import snake_and_food.entities.Pair;

public class AIStrategy implements PlayerStrategy{
    @Override
    public Pair getNextPosition(Pair currentPosition, String direction) {
        return currentPosition;
    }
}
