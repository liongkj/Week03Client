/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.StudentGUI;
import week03client.Week03Client;

/**
 *
 * @author kj
 */
public class StudentController implements ActionListener {
    private StudentGUI page;
    
    
    public StudentController(StudentGUI x){
        this.page = x;
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == page.getB1()){
            Week03Client.serverOut.println("D");
            String input = JOptionPane.showInputDialog("Enter Amount:");
            Week03Client.serverOut.println(input);
        }
        else if(e.getSource() == page.getB2()){
            Week03Client.serverOut.println("W");
            String input = JOptionPane.showInputDialog("Enter Amount:");
            Week03Client.serverOut.println(input);
        }
        else if(e.getSource() == page.getB3()){
            
        }
        else if(e.getSource() == page.getB4()){
            page.getMainGUI().setVisible(true);
            page.setVisible(false);
        }
    }
}
