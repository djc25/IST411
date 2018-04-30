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
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Darwin
 * 
 * ----------[CHANGELOG]----------
 * 2018/04/30 -     Client works. Just need to finish passing Match object back and forth and transmit win codes/etc. -JSS5783
 * 
 * 2018/04/29 -     Made asynchronous LocalThread class. -JSS5783
 * 
 * 2018/04/29 -     Major changes:
 *                      Added codes.
 *                      Added client-server code modified from already-modified code from Deitel's Cryptography assignment. -JSS5783
 * 
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
    LocalThread thread;
    
    //client codes for sending key words to the server
    //general format for commands is "CLIENT_CODE_" + command phrase
    //general format for passing parameters is "CLIENT_CODE_PASS_" + variable (not actual name in code) + "="
    final static String CONNECT_CODE = "CLIENT_CODE_INITIATE_CONNECT";
    final static String DISCONNECT_CODE = "CLIENT_CODE_INITIATE_DISCONNECT";    //something verbose that won't be sent accidentally (can't be sent as a username, even, just in case)
    final static String USERNAME_CODE = "CLIENT_CODE_PASS_USERNAME=";           //if we aren't passing entire "Player" objects or something, we'll need codes for passing information
    final static String ACKNOWLEDGMENT_CODE = "CLIENT_CODE_ACKNOWLEDGMENT";     //neutral acknowledgment, like "okay (will wait)"
    final static String LOBBY_CODE = "CLIENT_CODE_ENTERED_LOBBY";
    final static String MATCH_CODE = "CLIENT_CODE_ENTERED_MATCH";
    final static String MATCH_FINISHED_CODE = "CLIENT_CODE_MATCH_FINISHED_SCORE=";        //just derive the other client's score for now from (maximum number of squares on grid - sending client's score)
    final static String SCOREBOARD_CODE = "CLIENT_CODE_ENTERED_SCOREBOARD";
    
    
    
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
        strUsername = strInUsername;
//        connect();
        thread = new LocalThread();
        thread.start();
    }   //END ClientConnection()
    
    
    /**
     * Wrapper class for LocalThread.
     * @throws IOException 
     */
    public void disconnect() throws IOException
    {
        System.out.println("[DEBUG] Reached disconnect()");
        thread.disconnect();
        System.out.println("[DEBUG] Disconnected.");
    }
    
    
private class LocalThread extends Thread
   {
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
//            if (tconn == true)
//            {
//                System.out.println("We are making progress " + clientConn.toString() );
//            }
            
            OIS = new ObjectInputStream(clientConn.getInputStream() );
//                System.out.println("OIS = " + OIS);

            OOS = new ObjectOutputStream(clientConn.getOutputStream() );
//                System.out.println("OOS = " + OOS);




//                // set up output stream for objects
//                OOS = new ObjectOutputStream( clientConn.getOutputStream() );
//
//                // flush output buffer to send header information
//                OOS.flush();
//
//                // set up input stream for objects
//                OIS = new ObjectInputStream( clientConn.getInputStream() );

//            sendData(ClientConnection.CONNECT_CODE);    //request to be connected to the server
            //TODO: wait for acknowledgment from the server
            sendData(ClientConnection.USERNAME_CODE + strUsername);
            //TODO: wait for the server to report that the client-server connection is complete
//            run();

        }
        catch(IOException ioexception)
        {
            System.out.println("Failed with ioexception - " + ioexception.getLocalizedMessage());
        }
    }   //END connect()
    
    
    

    // connect to server, get streams, process connection
    /**
     * From Deitel's code, modified by JSS5783 for the Cryptography assignment, and then modified further.
     */
      public void run()
      {
            try
            {
                connect();
                System.out.println("[DEBUG] Reached ClientConnection.run()");

//                System.out.println( "Connected to server");

//                bIsConnected = true;  //connection is good, so set connected status to true

//                // set up output stream for objects
//                output = new ObjectOutputStream( client.getOutputStream() );
//
//                // flush output buffer to send header information
//                output.flush();
//
//                // set up input stream for objects
//                input = new ObjectInputStream( client.getInputStream() );

//                System.out.println("\nGot I/O streams\n");
//                sendData(ClientConnection.USERNAME_CODE + strUsername);


//                Object objInput = new Object();
                String strCode = "";
                sendData(ClientConnection.LOBBY_CODE);  //entering lobby
//                jfClient guiClient = new jfClient();
//                guiClient.setVisible(true);
                
                // process messages sent from server
                do
                {

                    // read message and display it
                    try
                    {
                        Object objInput = OIS.readObject();     //DO NOT TOUCH - must declare object INSIDE for some reason for ClientConnection only
                        System.out.println("[DEBUG] objInput.getClass=" + objInput.getClass() + " == match.class=" + Match.class + "?");
                        if (objInput.getClass() == Match.class)
                        {
                            //TODO: store in Match object(s)
                            if (jfClient.getCurrentScreen() == jfClient.LOBBY)
                            {
                                sendData(ClientConnection.MATCH_CODE);
                                jfClient.nextCard();
                            }
                            System.out.println( "\nSERVER sent a Match object.");
                        }
                        else if (objInput.getClass().getSimpleName() instanceof String)    //TODO: handle specific codes and such
                        {
                            strCode = (String) OIS.readObject();
                            if (strCode.contains(ServerConnection.MATCH_LOST_CODE) )
                            {
                                //TODO: display lose pop-up
                                sendData(ClientConnection.SCOREBOARD_CODE);
                                jfClient.nextCard();
                            }
                            else if (strCode.contains(ServerConnection.MATCH_WON_CODE) )
                            {
                                //TODO: display win pop-up
                                sendData(ClientConnection.SCOREBOARD_CODE);
                                jfClient.nextCard();
                            }
                            else if (strCode.contains(ServerConnection.MATCH_DRAW_CODE) )
                            {
                                //TODO: display draw pop-up
                                sendData(ClientConnection.SCOREBOARD_CODE);
                                jfClient.nextCard();
                            }
                            System.out.println( "\nSERVER sent \"" + strCode + "\".");
                        }
                        
                        
                        
                    }

                    // catch problems reading from server
                    catch ( ClassNotFoundException classNotFoundException ) {
                        System.out.println( "\n[ERROR] Unknown object type received." );
                   }

                }  while (strCode.equals(ServerConnection.DISCONNECT_CODE) == false);

                System.out.println( "\nSERVER has shut down.\n" );

                disconnect();

                System.out.println( "Client connection to the server has been terminated." );
           }   //END try
            catch (UnknownHostException uhe)    //if the given IP address for the server doesn't work
            {
                JOptionPane.showMessageDialog(null, "Could not find the server.\nIs the IP address for the server correctly formatted and accurate?", "Invalid Server Address", JOptionPane.ERROR_MESSAGE);
//                System.err.println(uhe.toString() );
            }
            catch (ConnectException ce) //if the server isn't running when the client tries to connect
            {
                JOptionPane.showMessageDialog(null, "Connection refused.\nIs the server running and accepting connections?", "Invalid Server Address", JOptionPane.ERROR_MESSAGE);
//                System.err.println(ce.toString() );
            }
//           catch(ClassNotFoundException cnf)
//           {
//                System.err.println(cnf.toString() );
//           }

           catch ( EOFException eofException ) {
              System.err.println( "Server terminated connection" );
           }

           // process problems communicating with server
           catch ( IOException ioException ) {           
               ioException.printStackTrace();
           }
           catch (NullPointerException npe)
           {
               System.err.println(npe.toString() );
           }
           catch (Exception ex)
           {
               System.err.println(ex.toString() );
               ex.printStackTrace();
           }

         // server closed connection


      }     //END runClient()
    
    
    
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
         // close streams and socket
        OOS.close();
        OIS.close();
        clientConn.close();
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
            System.out.println("Reached sendData(Object obj)");
            System.out.println("[DEBUG] obj.getClass()=" + obj.getClass() );
//            if (obj.getClass().getSimpleName() instanceof String) //seems to throw errors if not actually a String
//            {
//                System.out.println( "(String) obj=" + (String) obj);
//            }
        }
        
        OOS.writeObject(obj);
        OOS.flush();
    }   //END sendData(Object obj)
}   //END LocalThread
        
    
    
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