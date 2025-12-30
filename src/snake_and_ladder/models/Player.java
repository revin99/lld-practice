package snake_and_ladder.models;

public class Player {


    private String name;
    private Position playerPosition;

    public Player(String name, Position playerPosition){
        this.name=name;
        this.playerPosition=playerPosition;
    }

    public String getName()
    {
        return this.name;
    }
    public Position getPlayerPosition(){
        return this.playerPosition;
    }

    public void setPlayerPosition(Position playerPosition) {
        this.playerPosition = playerPosition;
    }
}
