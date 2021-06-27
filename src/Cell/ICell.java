package Cell;

import Actor.*;

public interface ICell {


    public boolean getHasEgg();
    public boolean getHasLava();
    public boolean getHasMeteor();
    public boolean getHasFort();


    public void setHasEgg(boolean value);
    public void setHasLava(boolean value);
    public void setHasMeteor(boolean value);
    public void setHasFort(boolean value);

    public ISurprise getSurprise();
    public void setSurprise(ISurprise surprise);

    public IActor getDino();
    public void setDino(IActor dino);

    public IVolcano getVolcano();
    public  void setVolcano(IVolcano v);


    public void connectSurprise(ISurprise value);
    public void connectVolcano(IVolcano value);

}