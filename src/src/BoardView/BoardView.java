package BoardView;

import Actor.IActor;
import Board.IBoard;
import Cell.ICell;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BoardView {
    protected IBoard b;
    protected IActor[] dinos;
    protected JPanel Panel;
    protected JLabel[][] matrix = new JLabel[13][13];

    protected ImageIcon dino1, dino2, dino3, dino4, dino1egg, dino2egg, dino3egg,dino4egg, surprise, lava, volcano, castle, egg, meteor;

    public BoardView(IBoard b, IActor[] dinos) {

        this.b = b;
        this.dinos = dinos;

        Panel = new JPanel();
        Panel.setLayout(new GridLayout(13,13));
        Panel.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));

        Path currentPath = Paths.get(System.getProperty("user.dir"));
        Path filePath = Paths.get(currentPath.toString(), "src","BoardView", "Icons");


         dino1 = new ImageIcon(filePath.toString() +"/dino1mini.png");
         dino2 = new ImageIcon(filePath.toString() +"/dino2mini.png");
         dino3 = new ImageIcon(filePath.toString() +"/dino3mini.png");
         dino4 = new ImageIcon(filePath.toString() +"/dino4mini.png");
         dino1egg = new ImageIcon(filePath.toString() +"/dino1egg.png");
         dino2egg = new ImageIcon(filePath.toString() +"/dino2egg.png");
         dino3egg = new ImageIcon(filePath.toString() +"/dino3egg.png");
         dino4egg = new ImageIcon(filePath.toString() +"/dino4egg.png");
         surprise = new ImageIcon(filePath.toString() +"/surprise.png");
         lava = new ImageIcon(filePath.toString() +"/lava.png");
         volcano = new ImageIcon(filePath.toString() +"/volcano.png");
         castle = new ImageIcon(filePath.toString() +"/castle.png");
         egg = new ImageIcon(filePath.toString() +"/eggmini.png");
         meteor = new ImageIcon(filePath.toString() +"/meteor.png");

        ICell[][] board = b.getCellsSpace();

        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {

                if(board[i][j].getDino() != null){
                    IActor dino = board[i][j].getDino();

                    if(dino.getInitialI() == 5 && dino.getInitialJ() == 5){
                        if(dino.getI() == dino.getEggX() && dino.getJ() == dino.getEggY() && board[i][j].getHasEgg()){
                            matrix[i][j] = new JLabel(dino1egg, JLabel.CENTER);
                        }else{
                            matrix[i][j] = new JLabel(dino1, JLabel.CENTER);
                        }

                    }
                    else if(dino.getInitialI() == 5  && dino.getInitialJ() == 7){
                        if(dino.getI() == dino.getEggX() && dino.getJ() == dino.getEggY() && board[i][j].getHasEgg()){
                            matrix[i][j] = new JLabel(dino2egg, JLabel.CENTER);
                        }
                        else{
                            matrix[i][j] = new JLabel(dino2, JLabel.CENTER);
                        }

                    }
                    else if(dino.getInitialI() == 7  && dino.getInitialJ() == 5){
                        if(dino.getI() == dino.getEggX() && dino.getJ() == dino.getEggY() && board[i][j].getHasEgg()){
                            matrix[i][j] = new JLabel(dino3egg, JLabel.CENTER);
                        }
                        else{
                            matrix[i][j] = new JLabel(dino3, JLabel.CENTER);
                        }

                    }
                    else if(dino.getInitialI() == 7 && dino.getInitialJ() == 7){
                        if(dino.getI() == dino.getEggX() && dino.getJ() == dino.getEggY() && board[i][j].getHasEgg()){
                            matrix[i][j] = new JLabel(dino4egg, JLabel.CENTER);
                        }
                        else{
                            matrix[i][j] = new JLabel(dino4, JLabel.CENTER);
                        }
                    }
                }

                else if (board[i][j].getHasFort()) {
                    matrix[i][j] = new JLabel(castle, JLabel.CENTER);
                    if(i == 0 && j == 0){
                        float[] hsb = Color.RGBtoHSB(219, 59, 70, null);
                        matrix[i][j].setBackground(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
                    }
                    else if(i == 0  && j == 12){
                        float[] hsb = Color.RGBtoHSB(132, 100, 59, null);
                        matrix[i][j].setBackground(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
                    }
                    else if(i == 12  && j == 0){
                        float[] hsb = Color.RGBtoHSB(250, 164, 49, null);
                        matrix[i][j].setBackground(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
                    }
                    else if(i == 12 && j == 12){
                        float[] hsb = Color.RGBtoHSB(44, 183, 151, null);
                        matrix[i][j].setBackground(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
                    }

                    matrix[i][j].setOpaque(true);

                }

                else if (board[i][j].getHasLava()) {
                    matrix[i][j] = new JLabel(lava, JLabel.CENTER);
                }

                else if (board[i][j].getSurprise() != null) {
                    matrix[i][j] = new JLabel(surprise, JLabel.CENTER);
                }

                else if(board[i][j].getHasMeteor()){
                    matrix[i][j] = new JLabel(meteor, JLabel.CENTER);
                }

                else if (board[i][j].getHasEgg()) {
                    matrix[i][j] = new JLabel(egg, JLabel.CENTER);
                    if(i == 5 && j == 1){

                        float[] hsb = Color.RGBtoHSB(219, 59, 70, null);
                        matrix[i][j].setBackground(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));

                    }
                    else if(i == 5  && j == 11){
                        float[] hsb = Color.RGBtoHSB(132, 100, 59, null);
                        matrix[i][j].setBackground(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
                    }
                    else if(i == 7  && j == 1){
                        float[] hsb = Color.RGBtoHSB(250, 164, 49, null);
                        matrix[i][j].setBackground(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
                    }
                    else if(i == 7 && j == 11){
                        float[] hsb = Color.RGBtoHSB(44, 183, 151, null);
                        matrix[i][j].setBackground(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
                    }

                    matrix[i][j].setOpaque(true);

                }

                else if (board[i][j].getVolcano() != null) {
                    matrix[i][j] = new JLabel(volcano, JLabel.CENTER);
                }


                else{
                    matrix[i][j] = new JLabel();

                }

                matrix[i][j].setBorder(BorderFactory.createMatteBorder(1,
                        1,
                        1,
                        1,
                        Color.BLACK));
                Panel.add(matrix[i][j]);
                }
            }
    }


    public JPanel getPanel(){
        return Panel;
    }


}
