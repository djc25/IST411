/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foursquare;

import java.awt.CardLayout;
import java.awt.Container;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author JSS5783
 
 (Client)
 Client program. Player logs in (jpLogIn), then waits for match-making (jpLobby), plays a match (jpMatch), and views their current rank in the scoreboard (jpScoreboard).
 Player returns to jpLobby after being disconnected on during a match, or after a match is fully concluded (win, lose, or draw, all go to the scoreboard).
 
 ----------[CHANGELOG]----------
 * 2018/04/30 -     Added updateGame(Match inMatch). -JSS5783
 * 
 * 2018/04/29 -     Added getCurrentScreen() and associated constants. Updated bare integers to their constant versions. -JSS5783
 * 
 * 2018/04/28 -     Added ClientConnection client.
 *                  Added disconnect() and associated code to formWindowClosing. -JSS5783
 * 
 * 2018/04/18 -     Added comments.
 *                  formWindowClosing now closes without confirmation dialog if on the login screen for a smoother experience. -JSS5783
 * 
 * 2018/04/16 -     Adjusted background color.  -JSS5783
 * 
 * 2018/04/15 -     Continued working on formWindowClosing method. -JSS5783
 * 
 * 2018/04/11 -     Added jScoreboard1. -JSS5783
 * 
 * 2018/04/10 -     GUI built in GUI builder now, with custom components manually added since the drag-and-drop into the GUI builder doesn't work.
 *                  Renamed variables to use clearer names:
 *                      jfClientLobby -> jfClient
 *                      jpli -> jpLogin1
 *                      jpl -> jpLobby1
 *                      jpm -> jpMatch1
 *                  Added comments. -JSS5783
 * 
 * 2018/03/25 -     Created. -JSS5783
 */
public class jfClient extends javax.swing.JFrame {
    
    //declaration
    private static jpLogIn jpLogin1;
    private static jpLobby jpLobby1;
    private static jpMatch jpMatch1;
    private static jpScoreboard jpScoreboard1;
    private static CardLayout cl;
    private static Container cClient;
    private static int intCurrentScreen = 0;
    static final int LOGIN = 0;
    static final int LOBBY = 1;
    static final int MATCH = 2;
    static final int SCOREBOARD = 3;
    public static ClientConnection client;     //public for now

    /**
     * Creates new form ClientLobby
     */
    public jfClient()
    {
        initComponents();
        
        //initialization
        jpLogin1 = new jpLogIn();
        jpMatch1  = new jpMatch();
        jpLobby1  = new jpLobby();
        jpScoreboard1 = new jpScoreboard();
        cl  = new CardLayout();
        cClient = new Container();
        
        //set layout to CardLayout
        cClient = this.getContentPane();
        cClient.setLayout(cl);
        
        //registration
        this.add(jpLogin1);
        this.add(jpLobby1);
        this.add(jpMatch1);
        this.add(jpScoreboard1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Project 4Square (CLIENT)");
        setBackground(PVar.BACKGROUND_COLOR);
        setMinimumSize(new java.awt.Dimension(960, 540));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Intercepts when the user closes the application (e.g., clicking on the "X" in the upper-right - or upper-left, if on iOS - corner of the window).
     * Behavior varies depending on current screen:
     *      Login: Asks if the user wants to quit, the same as the Exit button.
     *      Lobby: Warns the user that they will be disconnected from the server. Otherwise is the same as Login.
     *      Match: Warns the user that they will be disconnected from the server and that if they want to play again, they will need to log in again (this is to prevent selective win-farming). Otherwise is the same as Login.
     *      Scoreboard: Same as Lobby.
     * @param evt 
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
//        Object[] options = {"Yes", "No"};
//        UIManager.put("Button.defaultButtonFollowsFocus", Boolean.TRUE);
//
//        int intResult = JOptionPane.showOptionDialog(this, "Are you sure you want to exit?", "Exit Application", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[1]);
        int intResult = JOptionPane.NO_OPTION;  //default is "no"
        
        switch (intCurrentScreen)
        {
            case LOGIN:     //Login screen
//                intResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit Application", JOptionPane.YES_NO_OPTION);
                //auto-confirm, as there's no user data to lose
                intResult = JOptionPane.YES_OPTION;
                break;
            case LOBBY:     //Lobby screen
                intResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to disconnect and exit?\nYour session will be closed and you will no longer be able to update that session's score.", "Exit Application", JOptionPane.YES_NO_OPTION);
                
                break;
            case MATCH:     //Match screen
                intResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to forfeit and exit?\nYour session will be closed and you will no longer be able to update that session's score.", "Exit Application", JOptionPane.YES_NO_OPTION);
                
                break;
            case SCOREBOARD:     //Scoreboard screen
                intResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to disconnect and exit?\nYour session will be closed and you will no longer be able to update that session's score.", "Exit Application", JOptionPane.YES_NO_OPTION);
                
                break;
            default:
                if (PVar.DEBUG_MODE == true)
                {
                    System.out.println("[DEBUG] Error: Unhandled screen. Please report to the repository on Github.");
                }
                
        }
        
        if (intResult == JOptionPane.YES_OPTION)
        {
            if (intCurrentScreen > LOBBY)   //if not at the lobby (i.e., if connected to the server)
            try
            {
                client.disconnect();
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            catch (IOException ioe)
            {
                JOptionPane.showMessageDialog(this, ioe.toString(), "Error", JOptionPane.ERROR_MESSAGE);    //TODO: not sure what would trigger an error here, so just pop the stack-trace... maybe better to dump to console then
            }
            catch (Exception ex)
            {
                System.err.println(ex.toString() );
            }
        }
        else
        {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
        
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jfClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfClient().setVisible(true);
            }
        });
    }
    
    
    /**
     * Changes to the next panel. Tracks which card is active.
     * Panel order: Login -> lobby -> match -> scoreboard -> login.
     * NOTE: This lists card order, not game order.
     */
    public static void nextCard()
    {
        cl.next(cClient);
        
        if (intCurrentScreen == SCOREBOARD)  //overflow from end of "card deck" to beginning
        {
            intCurrentScreen = LOGIN;
        }
        else
        {
            intCurrentScreen++;
        }
    }   //END nextCard()
    
    
    
    /**
     * Changes to the previous panel. Tracks which card is active.
     * Panel order: Scoreboard -> match -> lobby -> login -> match.
     * NOTE: This lists card order, not game order.
     */
    public static void previousCard()
    {
        cl.previous(cClient);
        
        if (intCurrentScreen == LOGIN)  //overflow from beginning of "card deck" to end
        {
            intCurrentScreen = SCOREBOARD;
        }
        else
        {
            intCurrentScreen--;
        }
    }   //END previousCard()
    
    
    
        
    
    /**
     * Returns the current screen as an integer.
     * @return 
     */
    public static int getCurrentScreen()
    {
        return intCurrentScreen;
    }   //END getCurrentScreen()
    
    
    
    
    
    /**
     * Updates dotGamePanel1 with the passed Match.
     * @param inMatch
     */
    public static void updateGame(Match inMatch)
    {
        jpMatch1.getDotGamePanel().setMatch(inMatch);
    }   //END updateGame(Match inMatch)
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
