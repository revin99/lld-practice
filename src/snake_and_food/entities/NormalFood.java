package snake_and_food.entities;

public class NormalFood extends FoodItem{

    public NormalFood(int row, int column)
    {
        super(row,column);
        this.setPoints(1);
    }
}
