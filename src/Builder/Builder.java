package Builder;

import Actor.*;
import Board.*;
import Cell.*;
import ControlP.*;

import java.util.Random;

public class Builder implements IBuilder{

    public void newBoard(IControl control){
        IBoard b = new Board();

        int dinoNumber = 0;
        int volcanoNumber = 0;
        for(int i = 0; i < 13; i++){
            for (int j = 0; j< 13; j++){

                switch (i){


                    case 0:
                    case 12:
                        //adds forts to board
                        if(j == 0 || j == 12){
                            b.connect('F', true, i, j);
                        }
                        break;

                    case 5:
                    case 7:
                        //adds eggs to boards
                        if(j == 1|| j == 11){
                            b.connect('E', true, i, j);
                        }
                        //adds dinos
                        else if (j == 5|| j == 7){

                            Actor dino = new Actor();
                            dino.setInitialI(i);
                            dino.setInitialJ(j);
                            dino.setEggPos();
                            dino.setFortPos();
                            b.connect(dino, i, j);
                            control.connect(dinoNumber, dino);
                            dinoNumber++;
                        }
                        //adds surprises
                        else if (j== 3 || j == 9){
                            ISurprise s = createSurprise();
                            b.connect(s, i, j);
                        }
                        break;

                    case 3:
                    case 9:
                        //adds Volcanoes
                        if(j == 3 || j == 9){
                            IVolcano v  = new Volcano(i, j);
                            v.connect(b);
                            b.connect(v, i, j);
                            control.connect(volcanoNumber, v);
                            volcanoNumber++;
                        }
                        //adds surprises
                        else if(j==6){
                            ISurprise s = createSurprise();
                            b.connect(s, i, j);

                        }
                        break;


                    case 1:
                    case 11:
                        //adds surprises
                        if(j == 4 || j == 8){
                            ISurprise s = createSurprise();
                            b.connect(s, i, j);
                        }
                        break;
                    case 2:
                    case 10:
                        //adds surprises
                        if(j == 1|| j == 11){
                            ISurprise s = createSurprise();
                            b.connect(s, i, j);
                        }
                        break;
                }
            }
        }
        control.connect(b);
    }

    public Surprise createSurprise(){
        //generates random number
        Random rand = new Random(); //instance of random class
        int upperbound = 4;
        //generate random values from 0-3
        int int_random = rand.nextInt(upperbound);

        Surprise s = null;
        switch (int_random){

            case 0:
                s = new Food();
                break;
            case 1:
                s = new Rock();
                break;
            case 2:
                s = new StarPowerUp();
                break;
            case 3:
                s = new Meteor();
                break;
        }

        return s;
    }

}
