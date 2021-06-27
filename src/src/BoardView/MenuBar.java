package BoardView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MenuBar  {

    private JToolBar toolBar;
    public JButton buttonUpperLeft, buttonUp, buttonUpperRight, buttonLeft, buttonEgg, buttonRight, buttonLowerLeft, buttonDown, buttonLowerRight;
    private int num;

    public MenuBar(){
        toolBar = new JToolBar();
        this.num = 0;
    }

    public void createToolBar(){

        Path currentPath = Paths.get(System.getProperty("user.dir"));
        Path filePath = Paths.get(currentPath.toString(), "src","BoardView", "Icons");
        System.out.println(filePath.toString());

        toolBar.setLayout(new GridLayout(3,3));
        toolBar.setSize(100, 100);
        ImageIcon upperLeft = new ImageIcon(filePath.toString() +"/upperleft.png");
        buttonUpperLeft = new JButton(upperLeft);


        toolBar.add(buttonUpperLeft);

        ImageIcon up = new ImageIcon(filePath.toString() + "/up.png");
        buttonUp = new JButton(up);
        toolBar.add(buttonUp);

        ImageIcon upperRight = new ImageIcon(filePath.toString() + "/upperright.png");
        buttonUpperRight = new JButton(upperRight);
        toolBar.add(buttonUpperRight);

        ImageIcon left = new ImageIcon(filePath.toString() + "/left.png");
        buttonLeft = new JButton(left);
        toolBar.add(buttonLeft);

        ImageIcon egg = new ImageIcon(filePath.toString() + "/egg.png");
        buttonEgg = new JButton(egg);
        toolBar.add(buttonEgg);

        ImageIcon right = new ImageIcon(filePath.toString() + "/right.png");
        buttonRight = new JButton(right);
        toolBar.add(buttonRight);

        ImageIcon lowerLeft = new ImageIcon(filePath.toString() + "/lowerleft.png");
        buttonLowerLeft = new JButton(lowerLeft);
        toolBar.add(buttonLowerLeft);

        ImageIcon down = new ImageIcon(filePath.toString() + "/down.png");
        buttonDown = new JButton(down);
        toolBar.add(buttonDown);

        ImageIcon lowerRight = new ImageIcon(filePath.toString() + "/lowerright.png");
        buttonLowerRight = new JButton(lowerRight);
        toolBar.add(buttonLowerRight);

    }

    public int getNum() {
        return num;
    }

    public JToolBar getToolBar() {
        return toolBar;
    }

    public void setToolBar(JToolBar toolBar) {
        this.toolBar = toolBar;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
