package Actor;

import Board.*;

public interface IActor {

    public void setI(int value);

    public void setJ(int value);

    public int getI();

    public int getJ();

    public void setEggPos();

    public void setFortPos();

    public int getEggX();

    public int getEggY();

    public int getFortX();

    public int getFortY();

    public int getScore();

    public boolean getHasEgg();

    public boolean getIsAlive(IBoard b);

    public boolean getStarPowerUpOn();

    public boolean getHasWon();

    public String getName();

    public void setHasEgg(boolean value);

    public void setIsAlive(boolean value);

    public void setStarPowerUpOn(boolean value);

    public void setHasWon(boolean value);

    public void updateScore(int value);

    public void setName(String name);


    public void setInitialI(int initialI);

    public void setInitialJ(int initialJ);

    public int getInitialI();

    public int getInitialJ();

    public boolean isSurrounded(int x, int y, IBoard board);

}
