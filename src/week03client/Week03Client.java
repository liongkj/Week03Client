/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week03client;

import com.sun.security.ntlm.Client;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import javax.swing.JOptionPane;
import view.MainGUI;

/**
 *
 * @author kj
 */
public class Week03Client {

    private Socket connection = null;
    private BufferedReader serverIn = null;
    public static PrintStream serverOut = null;  
    private MainGUI x;
    public static void main(String[] args) {
        // TODO code application logic here
        new Week03Client().doConnect();
    }
    private void doConnect() {
        x = new MainGUI();
        try {
            connection = new Socket("127.0.0.1",2000);
            serverIn = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            serverOut = new PrintStream(connection.getOutputStream());
            RemoteReader t = new RemoteReader();
            t.start();
        } catch(Exception e) {
            System.out.println("Unable to connect to server!");
            e.printStackTrace();
        }
    }
    private class RemoteReader {
        private boolean keepListening = true;
        public void start() {
            while(keepListening == true) {
                try {
                    String nextLine = serverIn.readLine();
                    if(nextLine!=null){
                        System.out.println(nextLine);
                        if(nextLine.equals("Welcome!")){
                            x.getG1().setVisible(true);
                            x.setVisible(false);
                        } else if(nextLine.equals("Login Failed!")){
                            JOptionPane.showMessageDialog(null,"Login Failed!");
                        } else if(nextLine.equals("Transaction Successful!")){
                            JOptionPane.showMessageDialog(null,serverIn.readLine());
                        }
                    }
                } catch(Exception e) {
                    keepListening = false;
                    System.out.println("Error while reading from server.");
                    e.printStackTrace();
                }
            }
        }
    } 
    
}
