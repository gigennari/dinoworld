package Board;

import Actor.*;
import Cell.*;

public class Board implements IBoard{

    public ICell[][] cellsSpace = new Cell[13][13];

    public Board(){
        for(int i = 0; i < 13; i++){
            for(int j = 0;j < 13;j++){
                cellsSpace[i][j] = new Cell();
            }
        }
    }

    public ICell[][] getCellsSpace(){
        return cellsSpace;
    }

    public boolean validatesMove(int X, int Y){
        //not within cellsSpace limits
        if(X < 0 || X > 12 || Y < 0 || Y > 12){
            // volcano/ other dino/ meteor
            return false;
        }
        else{
            if(cellsSpace[X][Y].getVolcano() != null || cellsSpace[X][Y].getHasMeteor() || cellsSpace[X][Y].getDino() != null){
                return false;
            }
            return true;
        }
    }


    public void move(IActor dino, int destinyX, int destinyY){
        if(validatesMove(destinyX, destinyY)){
            //remove dino from current position
            cellsSpace[dino.getI()][dino.getJ()].setDino(null);

            //update dino pos
            dino.setI(destinyX);
            dino.setJ(destinyY);

            //add dino to destiny
            if(cellsSpace[destinyX][destinyY].getHasLava()){

                //with no powerup, dino dies and is not added to the board again
                if(!dino.getStarPowerUpOn()){
                    //dino dies
                    dino.setIsAlive(false);

                }
                //with powerup, powerup is deactivated and dino is added to the board again
                else if(dino.getStarPowerUpOn()){
                    dino.setStarPowerUpOn(false);
                    cellsSpace[destinyX][destinyY].setDino(dino);
                }
            }
            //if there's no lava, just move the dino
            else{

                cellsSpace[destinyX][destinyY].setDino(dino);

                //if cell has a surprise, open it
                ISurprise s = cellsSpace[destinyX][destinyY].getSurprise();
                if(s != null){
                    if(s instanceof Meteor){
                        cellsSpace[dino.getInitialI()][dino.getInitialJ()].setDino(dino);
                        if(cellsSpace[dino.getInitialI()][dino.getInitialJ()].getHasLava() && !dino.getStarPowerUpOn()){
                            dino.setIsAlive(false);
                        }
                        else{
                            dino.setI(dino.getInitialI());
                            dino.setJ(dino.getInitialJ());
                        }
                        cellsSpace[destinyX][destinyY].setDino(null);
                        cellsSpace[destinyX][destinyY].setHasMeteor(true);

                    }
                    else if (s instanceof StarPowerUp){
                        cellsSpace[destinyX][destinyY].getDino().setStarPowerUpOn(true);
                    }
                }
            }
        }
    }

    public boolean captureEgg(IActor dino){
        //dino is in the egg pos
        if(dino.getI() == dino.getEggX() && dino.getJ() == dino.getEggY()){
            dino.setHasEgg(true);
            return true;
        }
        return false;
    }

    public boolean verifySurprise(int destinyX, int destinyY){
        if(validatesMove(destinyX, destinyY)){
            if (cellsSpace[destinyX][destinyY].getSurprise() != null) {
                return true;
            }
        }
        return false;

    }

    public void insertLavas(IVolcano[] volcanoes){
        for(int i = 0; i < volcanoes.length; i++){
            int[] newPos;
            volcanoes[i].connect(this);
            newPos = volcanoes[i].nextLava(this);

            cellsSpace[newPos[0]][newPos[1]].setHasLava(true);
        }
    }

    public void updateBoard(boolean eggCaptured, boolean surpriseUsed, int X, int Y){
        if(eggCaptured){
            cellsSpace[X][Y].setHasEgg(false);
        }
        else if(surpriseUsed){
            cellsSpace[X][Y].setSurprise(null);
        }
    }

    public void connect(char character, boolean value, int i, int j){
        if (character == 'F'){
            cellsSpace[i][j].setHasFort(value);
        }
        else if(character == 'E'){
            cellsSpace[i][j].setHasEgg(value);
        }
    }

    public void connect(IActor actor, int i, int j){
        cellsSpace[i][j].setDino(actor);
    }

    public void connect(ISurprise surprise, int i, int j){
        cellsSpace[i][j].connectSurprise(surprise);
    }

    public void connect(IVolcano volcano, int i, int j){
        cellsSpace[i][j].connectVolcano(volcano);
    }

}
