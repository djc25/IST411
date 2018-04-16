/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foursquare;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author JSS5783
 
 (Client) Login screen. Player chooses username (currently a non-unique nickname) before connecting to the server.
 
 ----------[CHANGELOG]----------
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblUsername)
                .addGap(18, 18, 18)
                .addComponent(jtxtfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(196, Short.MAX_VALUE)
                .addComponent(jlblInstructions)
                .addContainerGap(195, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(jlblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(jlblInstructions)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(jtxtfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jbtnLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLogInActionPerformed
        try
        {
            String strUsername = jtxtfUsername.getText().trim();   //removes leading and ending whitespace before processing, at least, but might read as inconsistent to the player
            Pattern patAlphanumeric = Pattern.compile("^[a-zA-Z0-9]*$");    //from stackoverflow.com/questions/5988228
            Matcher mat = patAlphanumeric.matcher(strUsername);
            boolean bIsAlphanumeric = mat.matches();
            
            if (strUsername.isEmpty() == false && strUsername.length() <= 8 && bIsAlphanumeric == true)
            {
                //TODO: make connection to server and pass relevant data (username, IP, anything else needed, like passwords later)
                jfClient.nextCard();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Enter a username 1 to 8 characters in length. Characters must all be alphanumeric (A-Z, 0-9).", "Error", JOptionPane.WARNING_MESSAGE);   //more of a warning, but also user input error
            }
        }
        catch (Exception ex)
        {
            
        }
    }//GEN-LAST:event_jbtnLogInActionPerformed

    /**
     * Asks the user if they want to quit.
     * TODO: Figure out the custom dialog to get the default option to be "no".
     */
    private void jbtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExitActionPerformed

        int intResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
        if (intResult == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }//GEN-LAST:event_jbtnExitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnExit;
    private javax.swing.JButton jbtnLogIn;
    private javax.swing.JLabel jlblInstructions;
    private javax.swing.JLabel jlblTitle;
    private javax.swing.JTextField jtxtfUsername;
    private javax.swing.JLabel lblUsername;
    // End of variables declaration//GEN-END:variables
}
