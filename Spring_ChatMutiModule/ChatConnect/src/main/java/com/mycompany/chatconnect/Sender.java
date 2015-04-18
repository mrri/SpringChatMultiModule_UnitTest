/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.chatconnect;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import javax.swing.DefaultListModel;

/**
 *
 * @author Quoc Huy Ngo
 */
public class Sender {

    int port;
    String ip;
    DefaultListModel modelMessage;
    public void setPort(int port) {
        this.port = port;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    
    public void setModel(DefaultListModel modelMessage){
        this.modelMessage = modelMessage;
    }
    public void connetClient(Message message) throws IOException, SQLException {
        Socket clientSocket = new Socket(ip, port);
        ObjectOutputStream objectMessage = new ObjectOutputStream(clientSocket.getOutputStream());
        //Message message = new Message(tbUserName.getText(), to , tbMessage.getText());
        objectMessage.writeObject(message);
        //ClientChat.connectDB.insertDB(ClientChat.message);
        modelMessage.addElement(message.getFrom().toUpperCase() + " :" + message.getMessage());
    }
}
