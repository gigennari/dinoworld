package Cell;

public class Rock extends Surprise{

    public Rock(){
        super(-10);
    }
    public int pointsToAdd(){
        return super.getValue();
    }
}
