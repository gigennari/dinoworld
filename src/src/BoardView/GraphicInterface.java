package BoardView;

import Actor.IActor;
import Board.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;


public class GraphicInterface implements IGraphicInterface {

    public IBoard b;
    public IActor[] dinos;
    public JFrame f;
    Container content;
    MenuBar menuBar;
    BoardView bview;
    DinoInfo dinfo;
    JPanel panel1, panel2, toolBarNextPlayer, nextPlayerPanel;

    public GraphicInterface(){
        this.b = null;
        this.f = new JFrame("DinoWorld");
        //Size the frame
        f.setLayout(new BorderLayout());
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.content = f.getContentPane( );
        content.setSize(1300, 1300);
        this.menuBar = new MenuBar();
        this.bview = null;
    }

    public void printGame(){
        //Create components and put them in the frame -> contentPane

        //menubar and next player panel
        toolBarNextPlayer = getToolBarNextPlayer(0);
        content.add(toolBarNextPlayer, BorderLayout.EAST);

        //make space for board
        content.add(Box.createRigidArea(new Dimension(5,0)));

        //dinos
        dinfo = new DinoInfo(dinos);
        panel1 = dinfo.getPanel();
        content.add(panel1, BorderLayout.WEST);

        //board
        bview = new BoardView(b, dinos);
        panel2 = bview.getPanel();
        content.add(panel2, BorderLayout.CENTER);

        //Show it
        f.setVisible(true);

        //Close JFrame
        f.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
    }



    public JPanel getToolBarNextPlayer(int next){

        JPanel Panel = new JPanel();
        Panel.setLayout(new BoxLayout(Panel, BoxLayout.PAGE_AXIS));

        menuBar.createToolBar();
        JToolBar toolBar = menuBar.getToolBar();
        toolBar.setSize(100, 80);

        nextPlayerPanel = updateNextPlayer(0);

        Panel.add(toolBar);
        Panel.add(nextPlayerPanel);

        return Panel;
    }

    public JPanel updateNextPlayer(int next){

        Path currentPath = Paths.get(System.getProperty("user.dir"));
        Path filePath = Paths.get(currentPath.toString(), "src","BoardView", "Icons");

        nextPlayerPanel = new JPanel();
        nextPlayerPanel.setLayout(new BorderLayout());
        nextPlayerPanel.setSize(100, 10);

        Box box =  new Box(BoxLayout.Y_AXIS);
        box.setSize(100, 20);

        JLabel text = new JLabel("Next Player");
        JLabel icon = new JLabel();
        switch (next){
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

        text.setAlignmentX(Component.CENTER_ALIGNMENT);
        icon.setAlignmentX(Component.CENTER_ALIGNMENT);

        box.add(Box.createRigidArea(new Dimension(15, 50)));
        box.add(text);
        box.add(Box.createRigidArea(new Dimension(15, 50)));
        box.add(icon);

        nextPlayerPanel.add(box, BorderLayout.CENTER);

        return  nextPlayerPanel;
    }

    public void updateBoardView(int next){

        toolBarNextPlayer.remove(nextPlayerPanel);
        nextPlayerPanel = updateNextPlayer(next);
        toolBarNextPlayer.add(nextPlayerPanel);

        content.remove(panel2);
        bview = new BoardView(b, dinos);
        panel2 = bview.getPanel();
        content.add(panel2,  BorderLayout.CENTER);

        content.remove(panel1);
        dinfo = new DinoInfo(dinos);
        panel1 = dinfo.getPanel();
        content.add(panel1,  BorderLayout.WEST);




        content.revalidate();
        content.repaint();


    }

    public void connect(IBoard b){
        this.b = b;
    }

    public void connect(IActor [] dinos) {this.dinos = dinos;}

    public JFrame getF(){
        return f;
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }

    public void setMenuBar(MenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public BoardView getBoardView(){
        return bview;
    }

}
