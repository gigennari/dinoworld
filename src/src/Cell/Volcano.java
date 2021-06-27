package Cell;

import Board.Board;
import java.util.Random;
import Board.*;

public class Volcano implements IVolcano{
    int volcanoX, volcanoY, lastLavaX, lastLavaY;
    IBoard b;

    public Volcano(int volcanoX, int volcanoY){
        this.volcanoX = volcanoX;
        this.lastLavaX = volcanoX;
        this.volcanoY = volcanoY;
        this.lastLavaY = volcanoY;

    }

    public int[] nextLava(Board b){
        int[] newPos = new int[2];

        boolean valid  = false;
        int i = 0;

        while((valid != true) && i < 9) {

            //generates random number
            Random rand = new Random(); //instance of random class

            int upperbound = 3;
            //generate random values from 0-2
            int rand_i = rand.nextInt(upperbound) - 1;
            int rand_j;
            rand_j = rand.nextInt(upperbound) - 1;

            //new lava has to be moved, [0][0] results in no change to the current position
            if(rand_i == 0 && rand_j == 0){
                int max = 2;
                int r = rand.nextInt(max);
                if (r == 0){
                    rand_j = -1;
                }
                else{
                    rand_j = 1;
                }
            }

            //no lava yet, no dino, not volcano, inside board
            int newX = lastLavaX + rand_i;
            int newY = lastLavaY + rand_j;
            ICell[][] cells = b.getCellsSpace();
            if(newX >= 0 && newX <= 12 && newY >= 0 && newY <= 12 && cells[newX][newY].getHasFort() == false && cells[newX][newY].getHasEgg() == false &&
                    cells[newX][newY].getHasLava() == false && cells[newX][newY].getDino() == null &&
                cells[newX][newY].getVolcano() == null) {
                if(cells[newX][newY].getSurprise() != null){
                    cells[newX][newY].setSurprise(null);
                }

                newPos[0] = newX;
                newPos[1] = newY;
                lastLavaX = newPos[0];
                lastLavaY = newPos[1];
                valid = true;
                return newPos;
            }
            i++;
        }

        newPos[0] = lastLavaX;
        newPos[1] = lastLavaX;

        return newPos;
    }

    public void connect(IBoard board){
        b = board;
    }

}

