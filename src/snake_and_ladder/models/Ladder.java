package snake_and_ladder.models;

public class Ladder {
    private Position start;
    private Position end;

    Ladder(Position start, Position end){
        this.start = start;
        this.end = end;
    }

    public Position getStart(){
        return start;
    }

    public Position getEnd(){
        return end;
    }
}
