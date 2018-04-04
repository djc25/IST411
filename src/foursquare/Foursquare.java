/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foursquare;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jason
 */
public class Foursquare {
    
    public Foursquare()
    {
        JFrame jfClientMain = new JFrame("Project 4Square (CLIENT)");
        JPanel jpClientLogIn = new JPanel();
        JPanel jpClientLobby = new JPanel();
        JPanel jpClientMatch = new JPanel();
        JFrame jfServerMain = new JFrame("Project 4Square (SERVER)");
        CardLayout cl = new CardLayout();
        
        Container cClient = jfClientMain.getContentPane();
        cClient.setLayout(cl);
//         System.out.println("Content pane layout class - " + cClient.getLayout().getClass().getName() );
      //  jfClientMain.setLayout(new CardLayout());
      //    System.out.println("Frame layout class - " + jfClientMain.getLayout().getClass().getName());
        jfClientMain.setSize(960, 540);
        jpClientLogIn.setSize(200, 100);
        jpClientLogIn.setBackground(Color.RED);
        jpClientLobby.setSize(200, 100);
        jpClientLobby.setBackground(Color.YELLOW);
        jpClientMatch.setSize(200, 100);
        jpClientMatch.setBackground(Color.BLUE);
        jfClientMain.add(jpClientLogIn);
        jfClientMain.add(jpClientLobby);
        jfClientMain.add(jpClientMatch);
        
        jfClientMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfClientMain.setVisible(true);
//        cl.show(jfClientMain, jpClientLobby.toString() );
        cl.next(cClient);
        cl.next(cClient);
      
      //CardLayout myCL = (CardLayout)jfClientMain.getLayout();
      //myCL.next(jfClientMain);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        jfClientLobby jfl = new jfClientLobby();
//        jfl.setVisible(true);

        Foursquare fs = new Foursquare();
    }
    
}
