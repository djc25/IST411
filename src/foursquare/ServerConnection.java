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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Darwin
 */
public class ServerConnection 
{
    
    Socket connection;
    ServerSocket server;
    public static void main(String[] args) throws IOException 
    {
        int svrQ = 10;
       
        
       
        Scanner in = new Scanner(System.in);
        //ObjectInputStream cin = new ObjectInputStream(connection.getInputStream);
     
           
       // Socket connection = server.accept();
        System.out.println("Server is running");
        
        
        
    }
    
    public void runServer()
    {
        int svrQ = 10;
        try
        {
            ServerSocket server = new ServerSocket(60000, svrQ); //ServerSocket Creation
            
            while(true)
            {
                try
                {
                    listenForConnection();
                }
                catch(EOFException eofExeption)
                {
                    System.out.println("\nServer connection ended");
                            
                }
                finally
                {
                    endServerConnection();
                    
                }
            }
        }catch(IOException ioException)
        {
            ioException.printStackTrace();
        }
        
        
    } // starts connection
    
    public void endServerConnection()
    {
        
    } //ends connection 
    
    public void listenForConnection()
    {
        System.out.println("Waiting for connection\n ");
        connection = server.accept();
    }
    
    public void getStreams() throws IOException
    {
        ObjectOutputStream outStream = new ObjectOutputStream(connection.getOutputStream());
        outStream.flush();
        
        ObjectInputStream inputStream = new ObjectInputStream(connection.getInputStream());
        //System.out.println("Got here");
    } //end of getStream method 
    
    public void processConnection()
    {
        
    }
    
    
}
