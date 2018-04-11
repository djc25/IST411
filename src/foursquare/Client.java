/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foursquare;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jason, JSS5783
 * 
 * ----------[CHANGELOG]----------
 * 2018/04/10 -     (Class DEPRECATED) GUI built in GUI builder now.
 *                  Moved public variables to PVar. -JSS5783
 * 
 * 2018/04/09 -     Added basic components to GUI cards.
 *                  Renamed from Foursquare.java to Client.java to make its purpose clearer. -JSS5783
 * 
 * 2018/04/04 -     Beginning of hand-coded GUI, since teacher and I can't get the GUI-builder-built one working. -JSS5783
 */
public class Client {
    
    public Client()
    {    
        
        JFrame jfClientMain = new JFrame("Project 4Square (CLIENT)");
        JPanel jpClientLogIn = new JPanel();
        jpClientLogIn.setLayout(new BoxLayout(jpClientLogIn, BoxLayout.Y_AXIS) );
            //declaration/initialization
            JLabel jlblTitle = new JLabel("Project 4Square");
            jlblTitle.setFont(new Font("Tahoma", Font.PLAIN, 36));
            JLabel jlblUsername = new JLabel("Username: ");
            JTextField jtxtfUsername = new JTextField(12);      //number of characters
            JButton jbtnLogIn = new JButton("Log In");
            JButton jbtnExit = new JButton("Exit");
            jtxtfUsername.setMinimumSize(new Dimension(200, 20) );      //TODO: get textfield size working
            jtxtfUsername.setSize(new Dimension(200, 15) );
            jtxtfUsername.setMaximumSize(new Dimension(200, 20) );
 //          jtxtfUsername.setText("          ");
            
            //registration
            jpClientLogIn.add(jlblTitle);
            jpClientLogIn.add(jlblUsername);
            jpClientLogIn.add(jtxtfUsername);
            jpClientLogIn.add(jbtnLogIn);
            jpClientLogIn.add(jbtnExit);
            //TODO: events get registered here
        
        JPanel jpClientLobby = new JPanel();
            //declaration/initialization
            JLabel jlblConnectionMessage = new JLabel("Searching for other person to match you against...");
            JButton jbtnDisconnect = new JButton("Disconnect from Server");
            
            //registration
            jpClientLobby.add(jlblConnectionMessage);
            jpClientLobby.add(jbtnDisconnect);
        
        JPanel jpClientMatch = new JPanel();
            JPanel jpPlayer1 = new JPanel();
                JLabel jlblPlayer1Name = new JLabel("[PLAYER_1_NAME]");
                JLabel jlblPlayer1Score = new JLabel("[PLAYER_1_SCORE]");
                jpPlayer1.setBackground(PVar.PLAYER_1_COLOR);
                jpPlayer1.add(jlblPlayer1Name);
                jpPlayer1.add(jlblPlayer1Score);
            DotGamePanel pnlGrid = new DotGamePanel();  //TODO: get this working. Can't get it to find the GUI.
            JPanel jpPlayer2 = new JPanel();
                JLabel jlblPlayer2Name = new JLabel("[PLAYER_2_NAME]");
                JLabel jlblPlayer2Score = new JLabel("[PLAYER_2_SCORE]");
                jpPlayer2.setBackground(PVar.PLAYER_2_COLOR);
                jpPlayer2.add(jlblPlayer2Name);
                jpPlayer2.add(jlblPlayer2Score);
            jpClientMatch.add(jpPlayer1);
            jpClientMatch.add(pnlGrid);
            jpClientMatch.add(jpPlayer2);
        
        JFrame jfServerMain = new JFrame("Project 4Square (SERVER)");
        CardLayout cl = new CardLayout();
        
        Container cClient = jfClientMain.getContentPane();
        cClient.setLayout(cl);
//         System.out.println("Content pane layout class - " + cClient.getLayout().getClass().getName() );
      //  jfClientMain.setLayout(new CardLayout());
      //    System.out.println("Frame layout class - " + jfClientMain.getLayout().getClass().getName());
        jfClientMain.setSize(960, 540);
        jpClientLogIn.setSize(200, 100);
//        jpClientLogIn.setBackground(Color.RED);     //For testing which panel is showing
        jpClientLobby.setSize(200, 100);
//        jpClientLobby.setBackground(Color.YELLOW);  //For testing which panel is showing
        jpClientMatch.setSize(200, 100);
//        jpClientMatch.setBackground(Color.BLUE);    //For testing which panel is showing
//        jfClientMain.add(jpClientLogIn);
        jfClientMain.add(jpClientLobby);
            jpLogIn jpli = new jpLogIn();
            jfClientMain.add(jpli);
        jfClientMain.add(jpClientLobby);
        jfClientMain.add(jpClientMatch);
        jfClientMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfClientMain.setVisible(true);
//        jtxtfUsername.setText("");
//        cl.show(jfClientMain, jpClientLobby.toString() );
//        cl.next(cClient);
//        cl.next(cClient);
      
      //CardLayout myCL = (CardLayout)jfClientMain.getLayout();
      //myCL.next(jfClientMain);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        jfClientLobby jfl = new jfClientLobby();
//        jfl.setVisible(true);

        Client fs = new Client();
    }
    
}
