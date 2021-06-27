package Cell;

import Actor.*;

public class Cell implements ICell {

    private boolean hasEgg, hasLava, hasMeteor, hasFort;
    private IVolcano volcano;
    private ISurprise s;
    private IActor dino;

    public Cell(){
        this.hasEgg = false;
        this.hasLava = false;
        this.hasMeteor = false;
        this.hasFort = false;

        this.dino = null;
        this.s = null;
        this.volcano = null;
    }

    public boolean getHasEgg(){
        return this.hasEgg;
    }

    public boolean getHasLava(){
        return this.hasLava;
    }

    public boolean getHasMeteor(){
        return this.hasMeteor;
    }

    public boolean getHasFort(){
        return this.hasFort;
    }

    public void setSurprise(ISurprise surprise){
        this.s = surprise;
    }

    public  void setVolcano(IVolcano v){
        this.volcano = v;
    }


    public void setHasEgg(boolean value){
        this.hasEgg = value;

    }

    public void setHasLava(boolean value){
        this.hasLava = value;
    }

    public void setHasMeteor(boolean value){
        this.hasMeteor = value;
    }

    public void setHasFort(boolean value){
        this.hasFort = value;
    }



    public IVolcano getVolcano(){
        return this.volcano;
    }
    public IActor getDino(){
        return this.dino;
    }

    public ISurprise getSurprise(){ return this.s; }


    public void setDino(IActor value){
        this.dino = value;
    }

    public void connectSurprise(ISurprise value){this.s = value; }

    public void connectVolcano(IVolcano value){
        this.volcano = value;
    }



}
