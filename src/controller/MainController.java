/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import javax.swing.JOptionPane;
import view.MainGUI;
import week03client.Week03Client;


/**
 *
 * @author lecturer
 */
public class MainController implements ActionListener{
    private MainGUI page;

    public MainController(MainGUI x) {
        this.page = x;
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==page.getB1()){
            //send server char 's' 
            Week03Client.serverOut.println("S");
            String input = JOptionPane.showInputDialog("Enter your username:");
            Week03Client.serverOut.println(input);
            input=JOptionPane.showInputDialog("Enter your pin:");
            Week03Client.serverOut.println(input);
            
        } else if(e.getSource()==page.getB2()){
            Week03Client.serverOut.println("C");
            String a = JOptionPane.showInputDialog("Enter student name:");
            Week03Client.serverOut.println(a);
            String b = JOptionPane.showInputDialog("Enter student gender:");
            Week03Client.serverOut.println(b);
            String c = JOptionPane.showInputDialog("Enter student pin:");
            Week03Client.serverOut.println(c);
            String d = JOptionPane.showInputDialog("Enter student balance:");
            Week03Client.serverOut.println(d);
            
        } else if(e.getSource()==page.getB3()){
            Week03Client.serverOut.println("Client is leaving");
            System.exit(0);
        }        
    }
    
}
