
import ControlP.*;

import java.util.ConcurrentModificationException;

public class AppDinoWorld {

    public static void main(String[] args) {

        TextFieldEvent textFieldEvent = new TextFieldEvent();
        while (textFieldEvent.names[0] == null){
            textFieldEvent.getDinoNames();
        }

        String[] names = textFieldEvent.names;

        IControl controller = new Control();
        controller.executeGame(names);
    }
}

