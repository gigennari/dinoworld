package Cell;

public class Food extends Surprise{

    public Food(){
        super(-10);
    }

    public int pointsToAdd(){
        return super.getValue();
    }
}
