package snake_and_ladder.models;

public class Snake {

    private Position head;
    private Position tail;

    public Snake(Position head, Position tail)
    {
        this.head=head;
        this.tail=tail;
    }

    public Position getHead() {
        return head;
    }
    public Position getTail(){
        return tail;
    }
}
