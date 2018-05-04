/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foursquare;

import javax.swing.JFrame;

/**
 * Alternative main class for running jfClient.
 * @author Jason
 *
 ************************** MODIFICATION LOG ********************************
 * 4/30/2018 - Centered program window and got rid of original dark-gray color
 * 
 ****************************************************************************
 */
public class Launch 
{
    public static void main(String[] args) 
    {
        JFrame frame = new jfClient();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        
    } // main
    
} // Launch
