package Cell;

public class Surprise implements ISurprise{
    int value;

    public Surprise(int value){
        this.value = value;
    }

    public int pointsToAdd(){
        return 0;
    }

    public int getValue(){
        return value;
    }

    public void connect(ISurprise surprise){

    }
}
