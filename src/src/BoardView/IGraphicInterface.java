package BoardView;

import Actor.IActor;
import Board.IBoard;

import javax.swing.*;

public interface IGraphicInterface {

    public void connect(IBoard b);
    public void connect(IActor[] dinos);
    public JFrame getF();
    public void printGame();


    public MenuBar getMenuBar();

    public void setMenuBar(MenuBar menuBar);

    public BoardView getBoardView();
    public void updateBoardView( int next);
}
