package Actor;

import Board.*;

public class Actor implements IActor {
    private int i,j, initialI, initialJ, eggX, eggY, fortX, fortY, score;
    private boolean hasEgg, starPowerUpOn, isAlive, hasWon;
    private String name;

    public Actor(){
        this.score = 0;
        this.hasEgg = false;
        this.starPowerUpOn = false;
        this.isAlive = true;
        this.hasWon = false;
    }

    public void setI(int value){
        this.i = value;
    }

    public void setJ(int value){
        this.j = value;
    }

    public void setInitialI(int initialI) {
        this.initialI = initialI;
        setI(initialI);
    }

    public void setInitialJ(int initialJ) {
        this.initialJ = initialJ;
        setJ(initialJ);
    }

    public int getInitialI() {
        return initialI;
    }

    public int getInitialJ() {
        return initialJ;
    }

    public int getI(){
        return this.i;
    }

    public int getJ(){
        return this.j;
    }

    public void setEggPos(){
        eggX = i;
        if(j == 5){
            eggY = 1;
        }
        else if ( j == 7){
            eggY = 11;
        }
    }

    public void setFortPos(){
        if(j == 5){
            fortY = 0;
        }
        else if (j == 7){
            fortY = 12;
        }

        if(i == 5){
            fortX = 0;
        }
        else if(i == 7){
            fortX = 12;
        }
    }

    public int getEggX() {
        return eggX;
    }

    public int getEggY() {
        return eggY;
    }

    public int getFortX() {
        return fortX;
    }

    public int getFortY() {
        return fortY;
    }

    public int getScore() {
        return score;
    }

    public boolean getHasEgg(){
        return hasEgg;
    }

    public boolean getIsAlive(IBoard b){
        //check if he can still reach the fort or he is not surrounded by lava
        if(isSurrounded(fortX, fortY, b) && !starPowerUpOn){
            isAlive = false;
            b.getCellsSpace()[i][j].setDino(null);
            return isAlive;
        }
        else if(isSurrounded(i, j, b) && !starPowerUpOn){
            isAlive = false;
            b.getCellsSpace()[i][j].setDino(null);
            return isAlive;
        }
        return isAlive;
    }

    public boolean isSurrounded(int x, int y, IBoard board){
        boolean isSurrounded = true;
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                int posX = x + i;
                int posY = y + j;
                if(i == 0 & j == 0){

                }
                else{
                    if(posX >= 0 && posX <= 12 && posY >= 0 && posY <= 12){
                        if(!(board.getCellsSpace()[posX][posY].getHasLava())){
                            return false;
                        }
                    }
                }


            }
        }
        return isSurrounded;
    }

    public boolean getStarPowerUpOn(){
        return starPowerUpOn;
    }

    public boolean getHasWon(){

        if(i == fortX && j == fortY && hasEgg){
            hasWon = true;
        }

        return hasWon;
    }

    public String getName(){
        return name;
    }

    public void setHasEgg(boolean value){
        this.hasEgg = value;
    }

    public void setIsAlive(boolean value){
        this.isAlive = value;
    }

    public void setStarPowerUpOn(boolean value){
        this.starPowerUpOn = value;
    }

    public void setHasWon(boolean value){
        this.hasWon = value;
    }


    public void updateScore(int value){
        score += value;
    }

    public void setName(String name){
        this.name = name;
    }
}
