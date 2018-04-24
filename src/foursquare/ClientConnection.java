/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foursquare;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Darwin
 */
public class ClientConnection 
{
    Socket clientConn;
    ObjectInputStream OIS;
    ObjectOutputStream OOS;
    
    final int portNumber = 16000;
   
    boolean tconn = true;
    
    
    public ClientConnection() throws IOException
    {
        
        
        clientConn = new Socket("127.0.0.1", portNumber);
        System.out.println("clientConn = " + clientConn);
        try
        {
        if(tconn == true)
        {
            System.out.println("We are making progress " + clientConn.toString());
        }
        OIS = new ObjectInputStream(clientConn.getInputStream());
            System.out.println("OIS = " + OIS);
            
        OOS = new ObjectOutputStream(clientConn.getOutputStream());
            System.out.println("OOS = " + OOS);

        String word = "made it";
        OOS.writeObject(word);
            System.out.println("we wrote");
        OOS.flush();
            System.out.println("then we flushed");
        
        }catch(IOException ioexception)
                {
                    System.out.println("Failed with ioexception - " + ioexception.getLocalizedMessage());
                }
        
    }
    
    
    public static void main(String[] args) throws IOException 
    {
         
        ClientConnection myC1 = new ClientConnection();
        System.out.println("OOS = " + myC1.OOS.toString());
       
    }
}
