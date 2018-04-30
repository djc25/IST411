/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foursquare;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author JSS5783
 
 (Client) Login screen. Player chooses username (currently a non-unique nickname) before connecting to the server.
 
 ----------[CHANGELOG]----------
 * 2018/04/29 -     [FIX] Fixed message pop-up errors (JptionPane.ERROR was used instead of JOptionPane.ERROR_MESSAGE). -JSS5783
 * 
 * 2018/04/28 -     Added client connection code to logIn(). -JSS5783
 * 
 * 2018/04/18 -     Split login method into dedicated logIn() method.
 *                  Modified jbtnLogInActionPerformed to use logIn().
 *                  Added jtxtfUsernameKeyPressed for using logIn(). -JSS5783
 * 
 * 2018/04/18 -     Readjusted component positioning, as it didn't want to stick for some reason.
 *                  Removed btnExit's confirmation dialog for smoother operation - it just closes now. -JSS5783
 * 
 * 2018/04/18 -     Readjusted component positioning, as it didn't want to stick for some reason.
 *                  Removed btnExit's confirmation dialog for smoother operation - it just closes now. -JSS5783
 * 
 * 2018/04/16 -     Adjusted background color.
 *                  Adjusted component positioning. -JSS5783
 * 
 * 2018/04/15 -     Checks for valid username. -JSS5783
 * 
 * 2018/04/10 -     Added ActionEvent to btnExit. -JSS5783
 * 
 * 2018/03/25 -     Created. -JSS5783
 */
public class jpLogIn extends javax.swing.JPanel {

    /**
     * Creates new form jpLogin
     */
    public jpLogIn() {
        initComponents();                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtnLogIn = new javax.swing.JButton();
        lblUsername = new javax.swing.JLabel();
        jbtnExit = new javax.swing.JButton();
        jtxtfUsername = new javax.swing.JTextField();
        jlblTitle = new javax.swing.JLabel();
        jlblInstructions = new javax.swing.JLabel();

        setBackground(PVar.BACKGROUND_COLOR);
        setMinimumSize(new java.awt.Dimension(960, 540));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(960, 540));

        jbtnLogIn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnLogIn.setText("Log In");
        jbtnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLogInActionPerformed(evt);
            }
        });

        lblUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUsername.setText("Username:");

        jbtnExit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnExit.setText("Exit");
        jbtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExitActionPerformed(evt);
            }
        });

        jtxtfUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtxtfUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtfUsernameKeyPressed(evt);
            }
        });

        jlblTitle.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jlblTitle.setText("4Square");

        jlblInstructions.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblInstructions.setText("Enter a username 1 to 8 characters in length. Characters must all be alphanumeric (A-Z, 0-9).");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlblTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jlblInstructions)
                        .addContainerGap(196, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(jlblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(jlblInstructions)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsername))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jbtnLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Attempts to log the user in when jbtnLogIn is pressed.
     * @param evt 
     */
    private void jbtnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLogInActionPerformed
        logIn();
    }//GEN-LAST:event_jbtnLogInActionPerformed

    /**
     * Closes the application.
     */
    private void jbtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExitActionPerformed

        //Ask nothing, as there's no user data to lose
//        int intResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
//        if (intResult == JOptionPane.YES_OPTION)
//        {
            System.exit(0);
//        }
    }//GEN-LAST:event_jbtnExitActionPerformed

    /**
     * Attempts to log the user in when the Enter key is pressed in jtxtfUsername.
     * @param evt 
     */
    private void jtxtfUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtfUsernameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)  //if key pressed is Enter
        {
            logIn();
        }
    }//GEN-LAST:event_jtxtfUsernameKeyPressed

    
    /**
     * Log the user into the server if the user has a valid username.
     */
    private void logIn()
    {
        try
        {
            String strUsername = jtxtfUsername.getText().trim();   //removes leading and ending whitespace before processing, at least, but might read as inconsistent to the player
            Pattern patAlphanumeric = Pattern.compile("^[a-zA-Z0-9]*$");    //from stackoverflow.com/questions/5988228
            Matcher mat = patAlphanumeric.matcher(strUsername);
            boolean bIsAlphanumeric = mat.matches();
            
            
            if (strUsername.isEmpty() == false && strUsername.length() <= 8 && bIsAlphanumeric == true) //if valid username
            {
                try
                {
                    jfClient.client = new ClientConnection(strUsername);    //try to connect with the server (passing relevant data like username, password TODO: implement later, etc.)
                    jfClient.client.run();
                    jfClient.nextCard();                                    //then switch to the lobby after connecting
                }
                catch (UnknownHostException uhe)    //if the given IP address for the server doesn't work
                {
                    JOptionPane.showMessageDialog(this, "Could not connect to the server.\nIs the IP address for the server correct?", "Invalid Server Address", JOptionPane.ERROR_MESSAGE);
    //                System.err.println(uhe.toString() );
                }
                catch (ConnectException ce)         //if the server isn't running when the client tries to connect
                {
                    JOptionPane.showMessageDialog(this, "Connection refused.\nIs the server running and accepting connections?", "Invalid Server Address", JOptionPane.ERROR_MESSAGE);
    //                System.err.println(ce.toString() );
                }
                catch (IOException ioe)             //if could not connect to the server for other reasons
                {
                    JOptionPane.showMessageDialog(this, "Could not connect to the server.\n" + ioe.toString(), "Error", JOptionPane.ERROR_MESSAGE);   //more of a warning, but also user input error
                }
                catch (IllegalArgumentException iae)    //if somehow a connection is attempted without a username being passed
                {
                    JOptionPane.showMessageDialog(this, iae.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Enter a username 1 to 8 characters in length. Characters must all be alphanumeric (A-Z, 0-9).", "Error", JOptionPane.WARNING_MESSAGE);   //more of a warning, but also user input error
            }
        }
        catch (Exception ex)
        {
            System.err.println(ex.toString() );
        }
    }   //END logIn()

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnExit;
    private javax.swing.JButton jbtnLogIn;
    private javax.swing.JLabel jlblInstructions;
    private javax.swing.JLabel jlblTitle;
    private javax.swing.JTextField jtxtfUsername;
    private javax.swing.JLabel lblUsername;
    // End of variables declaration//GEN-END:variables
}
