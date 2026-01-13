package snake_and_food.entities;

abstract class FoodItem {
    private int row;
    private int col;

    private int points;

    public int getRow() {
        return row;
    }

    public FoodItem(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
