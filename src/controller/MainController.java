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
import java.util.List;
import javax.swing.JOptionPane;
import model.Student;
import view.MainGUI;

/**
 *
 * @author lecturer
 */
public class MainController implements ActionListener{
    private MainGUI page;
    private List<Student> data;

    public MainController(MainGUI x) {
        this.page = x;
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==page.getB1()){
            String input = JOptionPane.showInputDialog("Enter your username:");
            Student s = null;
            for(int i=0; i<data.size(); i++){
                if(input.equals(((Student)(data.get(i))).getName())){
                    s = (Student)(data.get(i));
                    break;
                }
            }
            if(s != null){
                if(s.Login()){
                    page.getG1().setVisible(true);
                    page.getG1().setStudent(s);
                    page.setVisible(false);    
                } else{
                    JOptionPane.showMessageDialog(page.getB1(),"Wrong password!");
                }
            } else{
                JOptionPane.showMessageDialog(page.getB1(),"Wrong username!");
            }            
        } else if(e.getSource()==page.getB2()){
            String a = JOptionPane.showInputDialog("Enter student name:");
            char b = JOptionPane.showInputDialog("Enter student gender:").charAt(0);
            int c = Integer.parseInt(JOptionPane.showInputDialog("Enter student pin:"));
            double d = Double.parseDouble(JOptionPane.showInputDialog("Enter student balance:"));
            Student s = new Student(a,b,c,d);  
            data.add(s);
        } else if(e.getSource()==page.getB3()){
            Student s;
            try{
                Iterator student = data.iterator();
                while(student.hasNext()){
                    s = (Student)student.next();
                    System.out.println(s.getName()+"\t"+s.getPin()+"\t"+"\t"+s.getBalance());
                }
                ObjectOutputStream objectOutputFile = new ObjectOutputStream(new FileOutputStream("Student.dat"));
                objectOutputFile.writeObject(data);
                objectOutputFile.close();
            } catch(IOException ex){
                System.out.println("Output error!");
            }            
            System.exit(0);
        }        
    }
    
}
