package snake_and_food;

import snake_and_food.entities.Pair;

public interface PlayerStrategy {

    Pair getNextPosition(Pair currentPosition, String direction);
}
