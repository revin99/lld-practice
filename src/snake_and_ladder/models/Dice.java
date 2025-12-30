package snake_and_ladder.models;

public class Dice {

    int value;
    public Dice(){
        this.value=0;
    }
    public Dice(int value){
        this.value=value;
    }

    public int rollDice(){
        value = (int)(Math.random()*6)+1;
        return value;
    }

    public int getValue(){
        return this.value;
    }
}
