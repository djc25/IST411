/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foursquare;

/**
 *
 * @author JSS5783
 * 
 * (Client) Login screen.
 * 
 * ---CHANGELOG---
 * 2018/03/25 -     Created. -JSS5783
 */
public class jpLogIn extends javax.swing.JPanel {

    /**
     * Creates new form jpLogIn
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
        jtxtUsername = new javax.swing.JTextField();
        jlblTitle = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(960, 540));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(960, 540));

        jbtnLogIn.setText("Log In");
        jbtnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLogInActionPerformed(evt);
            }
        });

        lblUsername.setText("Username:");

        jbtnExit.setText("Exit");

        jlblTitle.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jlblTitle.setText("4Square");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(402, 402, 402)
                        .addComponent(jlblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(442, 442, 442)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtnLogIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(319, 319, 319)
                        .addComponent(lblUsername)
                        .addGap(18, 18, 18)
                        .addComponent(jtxtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(380, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jlblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(jtxtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addComponent(jbtnLogIn)
                .addGap(18, 18, 18)
                .addComponent(jbtnExit)
                .addGap(84, 84, 84))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLogInActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnLogInActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnExit;
    private javax.swing.JButton jbtnLogIn;
    private javax.swing.JLabel jlblTitle;
    private javax.swing.JTextField jtxtUsername;
    private javax.swing.JLabel lblUsername;
    // End of variables declaration//GEN-END:variables
}
