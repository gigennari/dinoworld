package ControlP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.lang.*;

public class TextFieldEvent {

    public JFrame window;
    public JPanel panel;
    public JTextField d0, d1, d2, d3;
    public JButton button;
    public String[] names;
    public boolean filled;


    public TextFieldEvent(){
        window = new JFrame("Welcome to Dino World");
        panel = new JPanel();
        button = new JButton("OK");
        names = new String[4];
        filled = false;

        //Size the frame
        window.setLayout(new BorderLayout());
        window.setSize(500, 500);


        //Size the panel
        panel.setSize(300, 300);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        Container content = window.getContentPane( );
        content.setLayout(new BorderLayout());

        JLabel text = new JLabel("Please insert players names: ");

         d0 = new JTextField("", 15);
         d1 = new JTextField("", 15);
         d2 = new JTextField("", 15);
         d3 = new JTextField("", 15);

        String defaultValue = "Dino 1";
        d0.setText(defaultValue);
        d0.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (d0.getText().equals(defaultValue)) {
                    d0.setText("");
                }
                super.focusGained(e);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (d0.getText().equals("")) {
                    d0.setText(defaultValue);
                }
                super.focusLost(e);
            }
        });

        String defaultValue2 = "Dino 2";
        d1.setText(defaultValue2);
        d1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (d1.getText().equals(defaultValue2)) {
                    d1.setText("");
                }
                super.focusGained(e);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (d1.getText().equals("")) {
                    d1.setText(defaultValue2);
                }
                super.focusLost(e);
            }
        });

        String defaultValue3 = "Dino 3";
        d2.setText(defaultValue3);
        d2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (d2.getText().equals(defaultValue3)) {
                    d2.setText("");
                }
                super.focusGained(e);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (d2.getText().equals("")) {
                    d2.setText(defaultValue3);
                }
                super.focusLost(e);
            }
        });

        String defaultValue4 = "Dino 4";
        d3.setText(defaultValue4);
        d3.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (d3.getText().equals(defaultValue4)) {
                    d3.setText("");
                }
                super.focusGained(e);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (d3.getText().equals("")) {
                    d3.setText(defaultValue4);
                }
                super.focusLost(e);
            }
        });

        panel.add(text, BorderLayout.NORTH);
        panel.add(d0);
        panel.add(d1);
        panel.add(d2);
        panel.add(d3);
        panel.add(button, BorderLayout.PAGE_END);
        content.add(panel, BorderLayout.CENTER);


        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public String[] getDinoNames() {

        window.setVisible(true);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                names[0] = d0.getText();
                names[1] = d1.getText();
                names[2] = d2.getText();
                names[3] = d3.getText();

                filled = true;
                window.setVisible(false);

            }
        });

        return names;
    }

}
