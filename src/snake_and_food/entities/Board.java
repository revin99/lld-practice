package snake_and_food.entities;

public class Board {

    private static Board instance;
    private int width;
    private int height;

    private Board(int width,int height){
        this.width=width;
        this.height=height;
    }

    public static Board getInstance(int width, int height){
        if(instance==null){
            instance = new Board(width,height);
        }
        return instance;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
