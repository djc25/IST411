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

/**
 *
 * @author Darwin
 * 
 * ----------[CHANGELOG]----------
 * 2018/04/28 -     Added strUsername and client codes (CONNECT_CODE, DISCONNECT_CODE, USERNAME_CODE).
 *                  Added ClientConnection(String strInUsername), connect(), disconnect(), and sendData(Object obj).
 *                  Added comments.
 *                  Moved code from default constructor to connect() for reuse in the other constructor.
 *                  Default constructor now throws IllegalArgumentException.
 *                  Methods now throw more exceptions. -JSS5783
 */
public class ClientConnection 
{
    Socket clientConn;
    ObjectInputStream OIS;
    ObjectOutputStream OOS;
    
    final int portNumber = 16000;
   
    boolean tconn = true;
    
    String strUsername = "";    //TODO: not sure what else the client needs to know
    
    //client codes for sending key words to the server
    //general format for commands is "CLIENT_CODE_" + command phrase
    //general format for passing parameters is "CLIENT_CODE_PASS_" + variable (not actual name in code) + "="
    private final static String CONNECT_CODE = "CLIENT_CODE_INITIATE_CONNECT";
    private final static String DISCONNECT_CODE = "CLIENT_CODE_INITIATE_DISCONNECT";    //something verbose that won't be sent accidentally (can't be sent as a username, even, just in case)
    private final static String USERNAME_CODE = "CLIENT_CODE_PASS_USERNAME=";           //if we aren't passing entire "Player" objects or something, we'll need codes for passing information
    
    
    
    /**
     * Default constructor.
     * 
     * Always throws an IllegalArgumentException, as a username must be provided to connect to the client.
     * 
     * @throws IllegalArgumentException 
     */
    public ClientConnection() throws IllegalArgumentException
    {
        throw new IllegalArgumentException("No username provided.");
    }   //END ClientConnection()
    
    
    
    /**
     * Constructor that takes and sets the client's username.
     * 
     * @param strInUsername
     * @throws java.net.UnknownHostException
     * @throws java.net.ConnectException
     * @throws IOException 
     */
    public ClientConnection(String strInUsername) throws UnknownHostException, ConnectException, IOException
    {
        connect();
        
        strUsername = strInUsername;
    }   //END ClientConnection()
    
    
    
    /**
     * Connects to the server.
     * 
     * TODO: Maybe let the calling class do the cleanup. Then again, might need to finally{} close any loose bits.
     * 
     * @throws java.net.UnknownHostException
     * @throws java.net.ConnectException
     * @throws IOException 
     */
    public void connect() throws UnknownHostException, ConnectException, IOException
    {
        clientConn = new Socket("127.0.0.1", portNumber);
        System.out.println("clientConn = " + clientConn);
        
        try
        {
            if (tconn == true)
            {
                System.out.println("We are making progress " + clientConn.toString() );
            }
            
            OIS = new ObjectInputStream(clientConn.getInputStream() );
                System.out.println("OIS = " + OIS);

            OOS = new ObjectOutputStream(clientConn.getOutputStream() );
                System.out.println("OOS = " + OOS);

            sendData(ClientConnection.CONNECT_CODE);    //request to be connected to the server
            //TODO: wait for acknowledgment from the server
            sendData(ClientConnection.USERNAME_CODE + strUsername);
            //TODO: wait for the server to report that the client-server connection is complete

        }
        catch(IOException ioexception)
        {
            System.out.println("Failed with ioexception - " + ioexception.getLocalizedMessage());
        }
    }   //END connect()
    
    
    
    /**
     * Disconnects client from the server.
     * 
     * Order of operations:
     *      -Client: send disconnect code to the server. Waits for acknowledgment/until timeout (TODO: implement timeout later). 
     *      -Server: sends back acknowledgment prior to closing its side to the connection.
     *      -Client: closes client-side connection.
     * @throws java.io.IOException
     */
    public void disconnect() throws IOException
    {
        sendData(ClientConnection.DISCONNECT_CODE);
        //TODO: disconnect
    }   //END disconnect()
    
    
    
    /**
     * Sends data to the server.
     * @param obj
     * @throws java.io.IOException
     */
    public void sendData(Object obj) throws IOException
    {
        if (PVar.DEBUG_MODE == true)
        {
            System.out.println("Reached " + this.getClass().getSimpleName() );
        }
        
        OOS.writeObject(obj);
        OOS.flush();
    }   //END sendData(Object obj)
        
    
    
    /**
     * Main method for testing the client.
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException 
    {
         
        ClientConnection myC1 = new ClientConnection();
        System.out.println("OOS = " + myC1.OOS.toString());
       
    }   //END main(String[] args)
    
}   //END ClientConnection