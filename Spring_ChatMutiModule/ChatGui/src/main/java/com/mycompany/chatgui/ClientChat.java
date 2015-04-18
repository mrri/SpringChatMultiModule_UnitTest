package com.mycompany.chatgui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.mycompany.chatconnect.Message;
import com.mycompany.chatconnect.Receiver;
import com.mycompany.chatconnect.Sender;
/*
 * Quoc Huy Ngo
 * Chat Demo Spring
 */
public class ClientChat extends javax.swing.JFrame {

    ServerSocket serverConnection;
    int portDes, portSource; //port gui di, local
    Thread threadReceiver;
    public static String to = "anonymous";
    //public static ConnectDB connectDB;
    public static DefaultListModel modelMessage;
    public static Message message;
    ApplicationContext context;
    public ClientChat() {
        initComponents();
        setGui();
        context = new ClassPathXmlApplicationContext("Spring.xml");
        //connectDB = (ConnectDB) context.getBean("connectDB");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnSend = new javax.swing.JButton();
        tbIp = new javax.swing.JTextField();
        tbPortSource = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tbMessage = new javax.swing.JTextField();
        btnConnect = new javax.swing.JButton();
        tbPortDes = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lbMessage = new javax.swing.JList();
        tbUserName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSend.setText("Send");
        btnSend.setName("btnSend"); // NOI18N
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        tbIp.setText("127.0.0.1");
        tbIp.setName("tblP"); // NOI18N

        tbPortSource.setName("tbPortSource"); // NOI18N

        jLabel1.setText("IP");

        jLabel2.setText("Port Source");

        btnConnect.setText("Connect");
        btnConnect.setName("btnConnect"); // NOI18N
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        tbPortDes.setName("tbPort"); // NOI18N

        jLabel3.setText("Port Des");

        jScrollPane2.setViewportView(lbMessage);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(tbMessage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSend)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tbIp, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tbPortSource, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tbPortDes, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(btnConnect)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbPortSource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConnect)
                    .addComponent(tbIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbPortDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSend)
                    .addComponent(tbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jLabel4.setText("User name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        portSource = Integer.parseInt(tbPortSource.getText());
        Receiver receiver;
        receiver = (Receiver) context.getBean("receiver");//new Receiver(portSource);
        receiver.setPort(portSource);
        receiver.setModel(modelMessage);
        threadReceiver = new Thread(receiver);
        threadReceiver.start();
    }//GEN-LAST:event_btnConnectActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
       message = new Message(tbUserName.getText(), to , tbMessage.getText());
        try {
            portDes = Integer.parseInt(tbPortDes.getText());
            Sender sender;
            sender = (Sender) context.getBean("sender");
            sender.setIp(tbIp.getText());
            sender.setPort(portDes);
            sender.setModel(modelMessage);
            sender.connetClient(message);
            //new Sender(tbIp.getText(), portDes);
            tbMessage.setText(null);
        } catch (IOException ex) {
            Logger.getLogger(ClientChat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClientChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSendActionPerformed

     void setGui(){
        setTitle("Spring Chat Demo");
        modelMessage = new DefaultListModel();
        lbMessage.setModel(modelMessage);
    }        
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientChat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList lbMessage;
    private javax.swing.JTextField tbIp;
    private javax.swing.JTextField tbMessage;
    private javax.swing.JTextField tbPortDes;
    private javax.swing.JTextField tbPortSource;
    private javax.swing.JTextField tbUserName;
    // End of variables declaration//GEN-END:variables
}
