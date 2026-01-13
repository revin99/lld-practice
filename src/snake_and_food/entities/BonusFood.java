package snake_and_food.entities;

public class BonusFood extends FoodItem{

    public BonusFood(int row, int col) {
        super(row, col);
        this.setPoints(2);
    }
}
