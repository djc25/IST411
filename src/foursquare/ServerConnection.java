/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foursquare;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.Scanner;
import static jdk.nashorn.tools.ShellFunctions.input;

/**
 *
 * @author Darwin
 */
public class ServerConnection 
{
    
    Socket connection;
    ServerSocket server;
    int counter = 1;
    final int maxClients = 10;
    final int portNumber = 16000;
    
    ObjectInputStream OIS;
    ObjectOutputStream OOS;
    
    boolean test = true; 
   
    
    
//    
    public void serverConnection() throws ClassNotFoundException
    {
      
        
        try
        {
            server = new ServerSocket(portNumber, maxClients); //ServerSocket Creation
            
            while(true) //Condition for server to listen, get info., process info. or close connection
            {
                try
                {
                    listenForConnection();
                    getStreams();
                    processConnection();
                }
                catch(EOFException eofExeption)
                {
                    System.out.println("\nServer connection ended");
                            
                }
                finally
                {
                    endServerConnection();
                    ++counter;
                } 
            } // Try block 
        }catch(IOException ioException)
        {
            ioException.printStackTrace();
        }
        
        
    } // Starts connection method
    
    public void endServerConnection() throws IOException 
    {
          
        
        OIS.close();
        OOS.close();
        connection.close();
    } //ends connection to the server 
    
    public void listenForConnection() throws IOException
    {
        System.out.println("Waiting for connection\n ");
        connection = server.accept();
        
    }
    
    public void getStreams() throws IOException
    {
        OOS = new ObjectOutputStream(connection.getOutputStream());
        OOS.flush();
        
        OIS = new ObjectInputStream(connection.getInputStream());
        System.out.println("OIS = " + OIS);
        //System.out.println("Got here");
    } //end of getStream method 
    
    public void processConnection() throws IOException, ClassNotFoundException 
    {
       if(test == true)
       {
           System.out.println("Made it to processConnection");  
       }
       String temp = (String) OIS.readObject();
        System.out.println("temp = " + temp);
//        do 
//        {
//            System.out.println("send info");
//            
//        }while(!message.equals("Terminate"));
    }
    
    
   
    public static void main(String[] args) throws IOException, ClassNotFoundException 
    {
//        int svrQ = 10;
//       
//        
//       
//        Scanner in = new Scanner(System.in);
//        ObjectInputStream cin = new ObjectInputStream(connection.getInputStream);
//     
//           
//        Socket connection = server.accept();
//        System.out.println("Server is running");
        ServerConnection SC = new ServerConnection();
        SC.serverConnection();
        
        
    }
}
