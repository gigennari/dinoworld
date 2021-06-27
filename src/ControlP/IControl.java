package ControlP;

import Board.*;
import Actor.*;
import BoardView.IGraphicInterface;
import Cell.IVolcano;

public interface IControl {
    public void executeGame(String[] names);

    public void connect(IBoard board);
    public void connect(int idx, IActor actor);
    public void connect(int idx, IVolcano v);
    public boolean atLeastOneAlive();
    public IGraphicInterface getGraphicInterface( );
    public IActor[] getDinos();

}
