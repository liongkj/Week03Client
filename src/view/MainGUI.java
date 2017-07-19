/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MainController;
import java.awt.Button;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author lecturer
 */
public class MainGUI extends JFrame {
    private StudentGUI g1;
    private Button b1, b2, b3;
    

    public Button getB1() {
        return b1;
    }

    public StudentGUI getG1() {
        return g1;
    }

    public Button getB2() {
        return b2;
    }

    public Button getB3() {
        return b3;
    }
    public MainGUI(){
        b1 = new Button("Student");
        b2 = new Button("Register");
        b3 = new Button("Exit");
        b1.addActionListener(new MainController(this));
        b2.addActionListener(new MainController(this));
        b3.addActionListener(new MainController(this));
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(b3);
        setLocation(300,200);
        setSize(150,100);
        g1 = new StudentGUI();
        g1.setGUI(this);
        setVisible(true);
    }    
}
