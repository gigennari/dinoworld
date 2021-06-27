package Board;

import Actor.*;
import Cell.*;

public interface IBoard {

    public void move(IActor dino, int destinyX, int destinyY);

    public boolean validatesMove(int destinyX, int destinyY);

    public void insertLavas(IVolcano[] volcanoes);

    public boolean captureEgg(IActor dino);

    public void updateBoard(boolean capturedEgg, boolean surpriseUsed, int destinyX, int destinyY);

    public void connect(char character, boolean value, int i, int j);

    public void connect(IActor actor, int i, int j);

    public void connect(ISurprise surprise, int i, int j);

    public void connect(IVolcano volcano, int i, int j);

    public ICell[][] getCellsSpace();

    public boolean verifySurprise(int destinyX, int destinyY);

}
