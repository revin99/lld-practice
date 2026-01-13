package snake_and_food.entities;

public class FoodFactory {

    private FoodItem foodItem;

    public FoodItem createFood(Pair position, String type)
    {
        if(type.equals("bonus")){
            return new BonusFood(position.getRow(),position.getCol());
        }
        return new NormalFood(position.getRow(), position.getCol());
    }
}
