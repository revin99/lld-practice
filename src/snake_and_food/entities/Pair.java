package snake_and_food.entities;

public class Pair {

    int row;
    int col;

    public int getRow() {
        return row;
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

    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
