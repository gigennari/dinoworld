package BoardView;

import Actor.IActor;

import javax.swing.*;
import java.awt.*;
import java.lang.Object;
import java.nio.file.*;

public class DinoInfo {

    JPanel Panel;


    public DinoInfo(IActor[] dinos){

        Panel = new JPanel();
        Panel.setLayout(new BoxLayout(Panel, BoxLayout.Y_AXIS));

        String activated = new String();

        Path currentPath = Paths.get(System.getProperty("user.dir"));
        Path filePath = Paths.get(currentPath.toString(), "src","BoardView", "Icons");



        JPanel d1 = new JPanel();
        d1.setLayout(new BoxLayout(d1, BoxLayout.Y_AXIS));

        JLabel i1 = new JLabel(new ImageIcon(filePath.toString() +"/dino1.png"));
        JLabel name = new JLabel(dinos[0].getName());
        JLabel score = new JLabel("Score: " + dinos[0].getScore());
        JLabel powerUp1;
        JLabel egg1;

        if(dinos[0].getStarPowerUpOn()){
            powerUp1 = new JLabel(new ImageIcon(filePath.toString() +"/staron.png"));
        }
        else{
            powerUp1 = new JLabel(new ImageIcon(filePath.toString() +"/star.png"));
        }

        if(dinos[0].getHasEgg()){
            egg1 = new JLabel(new ImageIcon(filePath.toString() +"/eggon.png"));
        }
        else{
            egg1 = new JLabel(new ImageIcon(filePath.toString() +"/eggoff.png"));
        }

        JPanel images1 = new JPanel();
        images1.setLayout(new BoxLayout(images1, BoxLayout.X_AXIS));

        images1.add(powerUp1, BorderLayout.WEST);
        images1.add(egg1,BorderLayout.CENTER);

        d1.add(name, BorderLayout.NORTH);
        d1.add(score, BorderLayout.CENTER);
        d1.add(i1, BorderLayout.SOUTH);
        d1.add(images1, BorderLayout.SOUTH);



        JPanel d2 = new JPanel();
        d2.setLayout(new BoxLayout(d2, BoxLayout.Y_AXIS));
        JLabel i2 = new JLabel(new ImageIcon(filePath.toString() +"/dino2.png"));
        JLabel n2 = new JLabel(dinos[1].getName());
        JLabel s2 = new JLabel("Score: " + dinos[1].getScore());
        JLabel powerUp2;
        JLabel egg2;

        if(dinos[1].getStarPowerUpOn()){
            powerUp2 = new JLabel(new ImageIcon(filePath.toString() +"/staron.png"));
        }
        else{
            powerUp2 = new JLabel(new ImageIcon(filePath.toString() +"/star.png"));
        }


        if(dinos[1].getHasEgg()){
            egg2 = new JLabel(new ImageIcon(filePath.toString() +"/eggon.png"));
        }
        else{
            egg2 = new JLabel(new ImageIcon(filePath.toString() +"/eggoff.png"));
        }

        JPanel images2 = new JPanel();
        images2.setLayout(new BoxLayout(images2, BoxLayout.X_AXIS));

        images2.add(powerUp2, BorderLayout.WEST);
        images2.add(egg2,BorderLayout.CENTER);

        d2.add(n2, BorderLayout.NORTH);
        d2.add(s2, BorderLayout.CENTER);
        d2.add(i2, BorderLayout.SOUTH);
        d2.add(images2,BorderLayout.SOUTH);



        JPanel d3 = new JPanel();
        d3.setLayout(new BoxLayout(d3, BoxLayout.Y_AXIS));
        JLabel i3 = new JLabel(new ImageIcon(filePath.toString() + "/dino3.png"));
        JLabel n3 = new JLabel(dinos[2].getName());
        JLabel s3 = new JLabel("Score: " + dinos[2].getScore());
        JLabel powerUp3;
        JLabel egg3;

        if(dinos[2].getStarPowerUpOn()){
            powerUp3 = new JLabel(new ImageIcon(filePath.toString() +"/staron.png"));
        }
        else{
            powerUp3 = new JLabel(new ImageIcon(filePath.toString() +"/star.png"));
        }


        if(dinos[2].getHasEgg()){
            egg3 = new JLabel(new ImageIcon(filePath.toString() +"/eggon.png"));
        }
        else{
            egg3 = new JLabel(new ImageIcon(filePath.toString() +"/eggoff.png"));
        }

        JPanel images3 = new JPanel();
        images3.setLayout(new BoxLayout(images3, BoxLayout.X_AXIS));

        images3.add(powerUp3, BorderLayout.WEST);
        images3.add(egg3,BorderLayout.CENTER);

        d3.add(n3, BorderLayout.NORTH);
        d3.add(s3, BorderLayout.CENTER);
        d3.add(i3, BorderLayout.SOUTH);
        d3.add(images3, BorderLayout.SOUTH);





        JPanel d4 = new JPanel();
        d4.setLayout(new BoxLayout(d4, BoxLayout.Y_AXIS));
        JLabel i4 = new JLabel(new ImageIcon(filePath.toString() +"/dino4.png"));
        JLabel n4 = new JLabel(dinos[3].getName());
        JLabel s4 = new JLabel("Score: " + dinos[3].getScore());
        JLabel powerUp4;
        JLabel egg4;

        if(dinos[3].getStarPowerUpOn()){
            powerUp4 = new JLabel(new ImageIcon(filePath.toString() +"/staron.png"));
        }
        else{
            powerUp4 = new JLabel(new ImageIcon(filePath.toString() +"/star.png"));
        }

        if(dinos[3].getHasEgg()){
            egg4 = new JLabel(new ImageIcon(filePath.toString() +"/eggon.png"));
        }
        else{
            egg4 = new JLabel(new ImageIcon(filePath.toString() +"/eggoff.png"));
        }

        JPanel images4 = new JPanel();
        images4.setLayout(new BoxLayout(images4, BoxLayout.X_AXIS));

        images4.add(powerUp4, BorderLayout.WEST);
        images4.add(egg4,BorderLayout.CENTER);

        d4.add(n4, BorderLayout.NORTH);
        d4.add(s4, BorderLayout.CENTER);
        d4.add(i4, BorderLayout.SOUTH);
        d4.add(images4, BorderLayout.SOUTH);

        Panel.add(d1);
        Panel.add(new JSeparator());
        Panel.add(d2);
        Panel.add(new JSeparator());
        Panel.add(d3);
        Panel.add(new JSeparator());
        Panel.add(d4);

    }

    public JPanel getPanel(){
        return Panel;
    }

}
