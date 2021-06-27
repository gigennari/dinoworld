package ControlP;

import Actor.*;
import Board.*;
import BoardView.*;
import Builder.*;
import Cell.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;

import ControlP.TextFieldEvent;

import javax.swing.*;


public class Control implements IControl {

    public IBoard b;
    private IActor[] dinos = new Actor[4];
    private IVolcano[] volcanoes = new Volcano[4];
    private int roundNumber, winnersNum;
    public IGraphicInterface graphicInterface;
    public int dinoPos;
    public static int command, click, previousClick;


    public Control(){
        this.roundNumber = 1;
        this.winnersNum = 0;
        this.graphicInterface = new GraphicInterface();
        command = 0;
        click = -1;
        previousClick = -1;
        this.dinoPos = 0;
    }

    public void executeGame(String[] names) {

        //create board and actors
        IBuilder builder = new Builder();
        builder.newBoard(this);


        graphicInterface.connect(b);

        //get dino names
        for (int z = 0; z < 4; z++) {
            if (names[z].equals("")){
                dinos[z].setName("Dino" + (z+1));
            }
            dinos[z].setName(names[z]);
            System.out.println(dinos[z].getName());
        }

        //print game
        graphicInterface.connect(dinos);
        graphicInterface.connect(b);
        graphicInterface.printGame();

        //buttonUpperLeft - 7, buttonUp - 8, buttonUpperRight - 9, buttonLeft - 4, buttonEgg - 5, buttonRight - 6, buttonLowerLeft - 1, buttonDown - 2, buttonLowerRight - 3;
        graphicInterface.getMenuBar().buttonUpperLeft.addActionListener(actionEvent -> {
            command = 7;
            click++;
        });

        graphicInterface.getMenuBar().buttonUp.addActionListener(actionEvent -> {
            command = 8;
            click++;
        });


        graphicInterface.getMenuBar().buttonUpperRight.addActionListener(actionEvent -> {
            command = 9;
            click++;
        });


        graphicInterface.getMenuBar().buttonLeft.addActionListener(actionEvent -> {
            command = 4;
            click++;
        });

        graphicInterface.getMenuBar().buttonEgg.addActionListener(actionEvent -> {
            command = 5;
            click++;
        });

        graphicInterface.getMenuBar().buttonRight.addActionListener(actionEvent -> {
            command = 6;
            click++;

        });

        graphicInterface.getMenuBar().buttonLowerLeft.addActionListener(actionEvent -> {
            command = 1;
            click++;
        });

        graphicInterface.getMenuBar().buttonDown.addActionListener(actionEvent -> {
            command = 2;
            click++;
        });

        graphicInterface.getMenuBar().buttonLowerRight.addActionListener(actionEvent -> {
            command = 3;
            click++;

        });

        while (atLeastOneAlive()) {
            System.out.println();
            if (click == previousClick + 1) {

                dinoPos = click % 4;

                if (dinos[dinoPos].getIsAlive(b)) {
                    System.out.println("dino " + dinoPos + "vivo ");
                    if (command != 0) {
                        makeMove(command, dinoPos);
                        command = 0;
                    }
                }
                else {
                    click++;
                }
                previousClick++;

                if (dinoPos == 3) {
                    b.insertLavas(volcanoes);

                    graphicInterface.updateBoardView(next(dinoPos));
                    roundNumber++;
                    if(winnersNum != 0){
                        //one or more have reached the fort
                        //decide who wins
                        int winner = whoWins(winnersNum);
                        System.out.println(dinos[winner].getName() + "has won the game");
                        printEndMessage(winner);
                        break;
                    }
                }
            }
        }
        if (!atLeastOneAlive()){
            printEndMessage(-1);
        }
    }

    public void printSurprise(ISurprise s){
        JFrame surprisePopUp = new JFrame();
        surprisePopUp.setLayout(new BorderLayout());
        surprisePopUp.setSize(350, 150);

        JPanel panel = new JPanel();
        panel.setSize(350, 150);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel message1 = new JLabel();
        JLabel message2 = new JLabel();
        JLabel icon = new JLabel();

        icon = new JLabel();
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        Path filePath = Paths.get(currentPath.toString(), "src","BoardView", "Icons");

        if (s instanceof Meteor){
            message1 = new JLabel("A meteor was about to strike you.");
            message2 = new JLabel("Go back to the start. (-20)");
            icon = new JLabel(new ImageIcon(filePath.toString() + "/meteor.png"));
        }
        else if(s instanceof Food){
            message1 = new JLabel("Yay!");
            message2 =  new JLabel("You found food! (+10)");
            icon = new JLabel(new ImageIcon(filePath.toString() + "/food.png"));
        }
        else if(s instanceof StarPowerUp){
            message1 = new JLabel("Your Star PowerUp is on!");
            message2 = new JLabel("Now you can walk on lava! (But just once) (+50)");
            icon = new JLabel(new ImageIcon(filePath.toString() + "/staron.png"));

        } else if (s instanceof Rock) {
            message1 = new JLabel("Watch out!");
            message2 =  new JLabel("You stepped on a rock! (-10)");
            icon = new JLabel(new ImageIcon(filePath.toString() + "/rock.png"));
        }

        panel.add(message1, BorderLayout.CENTER);
        panel.add(message2, BorderLayout.CENTER);
        panel.add(icon, BorderLayout.CENTER);

        Container content = surprisePopUp.getContentPane( );
        content.add(panel, BorderLayout.CENTER);
        surprisePopUp.setVisible(true);

    }

    public void printEndMessage(int winner){
        JFrame winnerPopUP = new JFrame();
        winnerPopUP.setLayout(new BorderLayout());
        winnerPopUP.setSize(450, 350);

        JPanel panel = new JPanel();
        panel.setSize(450, 350);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));


        JLabel message = new JLabel();
        JLabel icon = new JLabel();
        if(winner != -1){
             message = new JLabel(dinos[winner].getName() + " has won the game!");
             icon = new JLabel();

            Path currentPath = Paths.get(System.getProperty("user.dir"));
            Path filePath = Paths.get(currentPath.toString(), "src","BoardView", "Icons");
            switch (winner){
                case 0:
                    icon = new JLabel(new ImageIcon(filePath.toString() +"/dino1.png"));
                    break;
                case 1:
                    icon = new JLabel(new ImageIcon(filePath.toString() +"/dino2.png"));
                    break;
                case 2:
                    icon = new JLabel(new ImageIcon(filePath.toString() +"/dino3.png"));;
                    break;
                case 3:
                    icon = new JLabel(new ImageIcon(filePath.toString() +"/dino4.png"));;
                    break;
            }
            panel.add(message, BorderLayout.CENTER);
            panel.add(icon, BorderLayout.CENTER);

        }
        else{
            message = new JLabel("No dino has won this round :(");
            panel.add(message, BorderLayout.CENTER);
        }


        Container content = winnerPopUP.getContentPane( );
        content.add(panel, BorderLayout.CENTER);
        winnerPopUP.setVisible(true);
        graphicInterface.getF().setVisible(false);
        winnerPopUP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public  int next(int dinoPos){
        int next;

        if(dinoPos != 3){
            next = dinoPos + 1;
        }
        else{
            next = 0;
        }
        while(!dinos[next].getIsAlive(b)){
            if(next != 3){
                next = next + 1;
            }
            else{
                next = 0;
            }
        }
        return next;
    }
    public int whoWins(int winnersNum){
        //check if more than one dino has reached its fort
        if(winnersNum > 1){
            //decide who wins based on the score
            int first = -1;
            for(int i = 0; i < 4; i++){
                if(dinos[i].getHasWon()){
                    if(first != -1){
                        if(dinos[i].getScore() > dinos[first].getScore()){
                            first = i;
                        }
                    }
                    else{
                        first = i;
                    }
                }
            }
            return first;
        }
        else if (winnersNum == 1) {
            for(int i = 0; i < 4; i++){
                if(dinos[i].getHasWon()){
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean atLeastOneAlive(){
        if(dinos[0].getIsAlive(b) || dinos[1].getIsAlive(b) || dinos[2].getIsAlive(b) || dinos[3].getIsAlive(b)){
            return true;
        }
        return false;
    }

    public void makeMove(int command, int i){

        int destinyX = 0, destinyY = 0;

        //up
        if (command == 8) {
            destinyX = dinos[i].getI() - 1;
            destinyY = dinos[i].getJ();
        }

        //right
        if (command == 6) {
            destinyX = dinos[i].getI();
            destinyY = dinos[i].getJ() + 1;
        }

        //left
        if (command == 4) {
            destinyX = dinos[i].getI();
            destinyY = dinos[i].getJ() - 1;
        }

        //down
        if (command == 2) {
            destinyX = dinos[i].getI() + 1;
            destinyY = dinos[i].getJ();
        }

        //upper-right corner
        if (command == 9) {
            destinyX = dinos[i].getI() - 1;
            destinyY = dinos[i].getJ() + 1;
        }

        //upper-left corner
        if (command == 7) {
            destinyX = dinos[i].getI() - 1;
            destinyY = dinos[i].getJ() - 1;
        }

        //lower-right corner
        if (command == 3) {
            destinyX = dinos[i].getI() + 1;
            destinyY = dinos[i].getJ() + 1;
        }

        //lower-left corner
        if (command == 1) {
            destinyX = dinos[i].getI() + 1;
            destinyY = dinos[i].getJ() - 1;
        }

        int pointstoadd = 0;

        //hatch egg
        boolean capturedEgg = false;
        if (command == 5) {
            capturedEgg = b.captureEgg(dinos[i]);
            if (capturedEgg) {
                destinyX = dinos[i].getEggX();
                destinyY = dinos[i].getEggY();
                if(roundNumber < 10){
                    pointstoadd = 100 - ((roundNumber - 1) * 10);
                }
            }
        }

        boolean surpriseUsed = false;
        //solicitate move to board (the board validates it and updates dino info)
        if (command != 5) {

            surpriseUsed = b.verifySurprise(destinyX, destinyY);
            if(surpriseUsed){
                ICell[][] cells = b.getCellsSpace();
                pointstoadd = cells[destinyX][destinyY].getSurprise().pointsToAdd();
                printSurprise(cells[destinyX][destinyY].getSurprise());
            }

            b.move(dinos[i], destinyX, destinyY);
            //verify if there's a surprise


        }

        //update board (remove visited surprises and captured eggs)

        dinos[i].updateScore(pointstoadd);
        b.updateBoard(capturedEgg, surpriseUsed, destinyX, destinyY);
        if (dinos[i].getHasWon()) {
            winnersNum++;
        }

        graphicInterface.updateBoardView(next(dinoPos));
        //print game no console



    }
    @Override
    public void connect(IBoard b) {
        this.b = b;
    }

    public void connect(int idx, IActor actor) {
        dinos[idx] = actor;
    }

    public void connect(int idx, IVolcano v){
        volcanoes[idx] = v;
    }
    public IActor[] getDinos(){
            return dinos;
    }

    public IGraphicInterface getGraphicInterface( ){
        return graphicInterface;
    }


}


