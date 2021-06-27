package Cell;

public class StarPowerUp extends Surprise{

    public StarPowerUp(){
        super((50));
    }

    public int pointsToAdd(){
        return super.getValue();
    }
}
