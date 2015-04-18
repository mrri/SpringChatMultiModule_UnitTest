
package com.mycompany.chatconnect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

public class Receiver extends Thread{
    int port;
    ServerSocket socketServer;
    Socket socketReceiver;
    //String message = "";
    Message message;
    DefaultListModel modelMessage;
    public void setPort(int port) {
        this.port = port;
    }
    
    public void setModel(DefaultListModel modelMessage){
        this.modelMessage = modelMessage;
    }
    public void connection() throws IOException, SQLException, ClassNotFoundException{
        socketServer = new ServerSocket(port);
        while(true){
            socketReceiver = socketServer.accept();
            ObjectInputStream objectMessage = new ObjectInputStream(socketReceiver.getInputStream());
            message = (Message) objectMessage.readObject();
            //ClientChat.to = message.getFrom();
            if(message.getMessage().equals("EXIT"))
                break;
            else
                modelMessage.addElement(message.getFrom().toUpperCase() + " :" + message.getMessage());
                //ClientChat.modelMessage.addElement(message.getFrom().toUpperCase() + " :" + message.getMessage());
        }
        socketServer.close();
        System.out.println("Disconnect");
    }
    public void run(){
         try {
             connection();
         } catch (IOException ex) {
             Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Receiver.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
