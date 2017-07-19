/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.StudentController;
import java.awt.Button;
import java.awt.FlowLayout;
import javax.swing.JFrame;

/**
 *
 * @author lecturer
 */
public class StudentGUI extends JFrame {
    private MainGUI x;
    private Button b1,b2,b3,b4;
    
    public void setGUI(MainGUI m){
        x = m;
    }
    
    public MainGUI getMainGUI(){
        return x;
    }
    
    public Button getB1(){
        return b1;
    }

    public Button getB2(){
        return b2;
    }
    
    public Button getB3(){
        return b3;
    }
    public Button getB4(){
        return b4;
    }
    
    public StudentGUI(){
        b1 = new Button("Deposit");
        b2 = new Button("Withdraw");
        b3 = new Button("Update");
        b4 = new Button("Exit");
        
        b1.addActionListener(new StudentController(this));
        b2.addActionListener(new StudentController(this));
        b3.addActionListener(new StudentController(this));
        b4.addActionListener(new StudentController(this));
        
        setLayout(new FlowLayout());
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        setLocation(300,200);
        setSize(300,200);
        setVisible(false);
    }
}
    
