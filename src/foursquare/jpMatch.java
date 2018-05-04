/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foursquare;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * (Client) Consolidates all game layout.
 * @author JSS5783
 * 
 * ----------[CHANGELOG]----------
 * 2018/05/01 -     Added updateLabels().   -JSS5783
 * 
 * 2018/04/30 -     Added getDotGamePanel() and comments.   -JSS5783
 * 
 * 2018/04/18 -     Hide jbtnDebugGoToScoreboard if DEBUG_MODE not enabled.
 *                  Renamed jbtnDebugGoToMatch to jbtnDebugGoToScoreboard.
 *                  Commented out random code for adding hand-coded components. -JSS5783
 * 
 * 2018/04/16 -     Adjusted background color. -JSS5783
 * 
 * 2018/04/10 -     Added DotGamePanel. -JSS5783
 *                          (BUG) Doesn't show right now for some reason, even using the working code from Client.java.
 * 
 * 2018/03/25 -     Created. -JSS5783
 */
public class jpMatch extends javax.swing.JPanel {

//    private DotGamePanel grid;
    /**
     * Default constructor for jpMatch.
     */
    public jpMatch()
    {
        initComponents();
        if (PVar.DEBUG_MODE == false)
        {
            jbtnDebugGoToScoreboard.setVisible(false);
        } // if
        
//        grid = new DotGamePanel();
////        jpGrid = grid;
//        this.add(grid);

//copied from Client.java to try to get DotGamePanel to show.
//TODO: get it working
//JPanel jpPlayer1 = new JPanel();
//                JLabel jlblPlayer1Name = new JLabel("[PLAYER_1_NAME]");
//                JLabel jlblPlayer1Score = new JLabel("[PLAYER_1_SCORE]");
//                jpPlayer1.setBackground(PVar.PLAYER_1_COLOR);
//                jpPlayer1.add(jlblPlayer1Name);
//                jpPlayer1.add(jlblPlayer1Score);
//            DotGamePanel pnlGrid = new DotGamePanel();
//            JPanel jpPlayer2 = new JPanel();
//                JLabel jlblPlayer2Name = new JLabel("[PLAYER_2_NAME]");
//                JLabel jlblPlayer2Score = new JLabel("[PLAYER_2_SCORE]");
//                jpPlayer2.setBackground(PVar.PLAYER_2_COLOR);
//                jpPlayer2.add(jlblPlayer2Name);
//                jpPlayer2.add(jlblPlayer2Score);
//            this.add(jpPlayer1);
//            this.add(pnlGrid);
//            this.add(jpPlayer2);
    }   //END jpMatch()

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPlayer1 = new javax.swing.JPanel();
        jlblPlayer1Username = new javax.swing.JLabel();
        jlblPlayer1Score = new javax.swing.JLabel();
        jpPlayer2 = new javax.swing.JPanel();
        jlblPlayer2Username = new javax.swing.JLabel();
        jlblPlayer2Score = new javax.swing.JLabel();
        jpGrid = new javax.swing.JPanel();
        jbtnDebugGoToScoreboard = new javax.swing.JButton();
        dotGamePanel1 = new foursquare.DotGamePanel();

        setBackground(PVar.BACKGROUND_COLOR);
        setMaximumSize(new java.awt.Dimension(960, 540));
        setMinimumSize(new java.awt.Dimension(960, 540));

        jpPlayer1.setBackground(new java.awt.Color(204, 255, 255));

        jlblPlayer1Username.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlblPlayer1Username.setText("[P1_NAME]");

        jlblPlayer1Score.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlblPlayer1Score.setText("[P1_SCORE]");

        javax.swing.GroupLayout jpPlayer1Layout = new javax.swing.GroupLayout(jpPlayer1);
        jpPlayer1.setLayout(jpPlayer1Layout);
        jpPlayer1Layout.setHorizontalGroup(
            jpPlayer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPlayer1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jpPlayer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblPlayer1Score)
                    .addComponent(jlblPlayer1Username))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jpPlayer1Layout.setVerticalGroup(
            jpPlayer1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPlayer1Layout.createSequentialGroup()
                .addContainerGap(244, Short.MAX_VALUE)
                .addComponent(jlblPlayer1Username)
                .addGap(26, 26, 26)
                .addComponent(jlblPlayer1Score)
                .addContainerGap(212, Short.MAX_VALUE))
        );

        jpPlayer2.setBackground(new java.awt.Color(255, 204, 102));

        jlblPlayer2Username.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlblPlayer2Username.setText("[P2_NAME]");

        jlblPlayer2Score.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jlblPlayer2Score.setText("[P1_SCORE]");

        javax.swing.GroupLayout jpPlayer2Layout = new javax.swing.GroupLayout(jpPlayer2);
        jpPlayer2.setLayout(jpPlayer2Layout);
        jpPlayer2Layout.setHorizontalGroup(
            jpPlayer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPlayer2Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jpPlayer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlblPlayer2Username)
                    .addComponent(jlblPlayer2Score))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jpPlayer2Layout.setVerticalGroup(
            jpPlayer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPlayer2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlblPlayer2Username)
                .addGap(30, 30, 30)
                .addComponent(jlblPlayer2Score)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpGrid.setBackground(PVar.BACKGROUND_COLOR);

        jbtnDebugGoToScoreboard.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnDebugGoToScoreboard.setText("[DEBUG] Go to Scoreboard screen");
        jbtnDebugGoToScoreboard.setMaximumSize(new java.awt.Dimension(250, 35));
        jbtnDebugGoToScoreboard.setMinimumSize(new java.awt.Dimension(250, 35));
        jbtnDebugGoToScoreboard.setPreferredSize(new java.awt.Dimension(250, 35));
        jbtnDebugGoToScoreboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDebugGoToScoreboardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dotGamePanel1Layout = new javax.swing.GroupLayout(dotGamePanel1);
        dotGamePanel1.setLayout(dotGamePanel1Layout);
        dotGamePanel1Layout.setHorizontalGroup(
            dotGamePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
        );
        dotGamePanel1Layout.setVerticalGroup(
            dotGamePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpGridLayout = new javax.swing.GroupLayout(jpGrid);
        jpGrid.setLayout(jpGridLayout);
        jpGridLayout.setHorizontalGroup(
            jpGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGridLayout.createSequentialGroup()
                .addContainerGap(135, Short.MAX_VALUE)
                .addGroup(jpGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpGridLayout.createSequentialGroup()
                        .addComponent(jbtnDebugGoToScoreboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(193, 193, 193))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpGridLayout.createSequentialGroup()
                        .addComponent(dotGamePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118))))
        );
        jpGridLayout.setVerticalGroup(
            jpGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpGridLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(dotGamePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34)
                .addComponent(jbtnDebugGoToScoreboard, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpPlayer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpPlayer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPlayer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpPlayer2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * (DEBUG] Go to scoreboard screen.
     * @param evt 
     */
    private void jbtnDebugGoToScoreboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDebugGoToScoreboardActionPerformed
        jfClient.nextCard();
    }//GEN-LAST:event_jbtnDebugGoToScoreboardActionPerformed

    
    
    
    /**
     * Returns dotGamePanel1.
     * 
     * @return 
     */
    public DotGamePanel getDotGamePanel()
    {
        return dotGamePanel1;
    }   //END getDotGamePanel()
    
    
    
    /**
     * Updates the player username and score labels.
     */
    public void updateLabels()
    {
        jlblPlayer1Username.setText(dotGamePanel1.match1.getPlayer1Username() );
        jlblPlayer1Score.setText(Integer.toString( dotGamePanel1.match1.getPlayer1Score() ) );
        
        jlblPlayer2Username.setText(dotGamePanel1.match1.getPlayer2Username() );
        jlblPlayer2Score.setText(Integer.toString( dotGamePanel1.match1.getPlayer2Score() ) );
    }   //END updateLabels()
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private foursquare.DotGamePanel dotGamePanel1;
    private javax.swing.JButton jbtnDebugGoToScoreboard;
    private javax.swing.JLabel jlblPlayer1Score;
    private javax.swing.JLabel jlblPlayer1Username;
    private javax.swing.JLabel jlblPlayer2Score;
    private javax.swing.JLabel jlblPlayer2Username;
    private javax.swing.JPanel jpGrid;
    private javax.swing.JPanel jpPlayer1;
    private javax.swing.JPanel jpPlayer2;
    // End of variables declaration//GEN-END:variables
} // jpMatch
