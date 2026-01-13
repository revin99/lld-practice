package snake_and_food;

import snake_and_food.entities.Pair;

public class HumanStrategy implements PlayerStrategy{
    @Override
    public Pair getNextPosition(Pair currentPosition, String direction) {
        int row = currentPosition.getRow();
        int col = currentPosition.getCol();
        switch (direction) {
            case "R":
                return new Pair(row, col + 1);
            case "U":
                return new Pair(row - 1, col);
            case "D":
                return new Pair(row + 1, col);
            case "L":
                return new Pair(row, col - 1);
            default:
                return currentPosition;
        }
    }
}
