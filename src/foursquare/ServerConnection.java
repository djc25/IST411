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
import javax.swing.JTextArea;
import static jdk.nashorn.tools.ShellFunctions.input;

/**
 *
 * @author Darwin, JSS5783
 * 
 * ----------[CHANGELOG]----------
 * 2018/04/30 -     Server works. Just need to finish passing Match object back and forth and transmit win codes/etc. -JSS5783
 * 
 * 2018/04/29 -     Major changes:
 *                      Added codes.
 *                      Added client-server code modified from already-modified code from Deitel's Cryptography assignment.
 *                      Renamed serverConnection() to runServer() for greater readability. -JSS5783
 */
public class ServerConnection 
{
    
    static final String RECEIVE_CODE = "SERVER_CODE_READY_TO_RECEIVE";
    static final String SUCCESS_CODE = "SERVER_CODE_SUCCESS";   //used as a positive acknowledgment code
    final static String DISCONNECT_CODE = "SERVER_CODE_INITIATE_DISCONNECT";
    final static String MATCH_WON_CODE = "SERVER_CODE_MATCH_WON_SCORE=";
    final static String MATCH_LOST_CODE = "SERVER_CODE_MATCH_LOST_SCORE=";
    final static String MATCH_DRAW_CODE = "SERVER_CODE_MATCH_DRAW_SCORE=";
    
//    Socket connection;
    ClientThread client1;       //hard-coding two clients for now
    ClientThread client2;
    Match match;                //hard-coding this as well
    ServerSocket server;
    int counter = 1;
    final int maxClients = 2;
    final int portNumber = 16000;
    
    ObjectInputStream OIS;
    ObjectOutputStream OOS;
    
    boolean test = true; 
    
    boolean bClient1Exists = false;
    boolean bClient2Exists = false;
   
    
    
//    
    public void runServer() throws ClassNotFoundException
    {
        System.out.println("[DEBUG] Reached runServer() ");
        
        try
        {
            server = new ServerSocket(portNumber, maxClients); //ServerSocket Creation
            
            while (true) //Condition for server to listen, get info., process info. or close connection
            {
                try
                {
//                    System.out.println("[DEBUG] Waiting for connection . . .");
                    
                   if (client1 == null)    //if client1 isn't occupied  TODO: when client closes, does this work?
                    {
                        System.out.println("[DEBUG] Connecting as Client1 . . .");
                        client1 = new ClientThread(server.accept(), 1);     //just hard-code client number for now, in case it needs to be referenced
                        bClient1Exists = true;
                        client1.start();
                    }
                    else if (client2 == null)    //if client2 isn't occupied
                    {
                        System.out.println("[DEBUG] Connecting as Client2 . . .");
                        client2 = new ClientThread(server.accept(), 2);     //just hard-code client number for now, in case it needs to be referenced
                        bClient2Exists = true;
                        client2.start();
                    }
                   else     //TODO: just here to see if I can see anything else while this isn't spamming for new connections; leaving this here will result in connections after the first two failing to connect if one leaves
                    {
//                        if (client1.getStatus() == jfClient.LOBBY & client2.getStatus() == jfClient.LOBBY)
//                        {
//                            System.out.println("[DEBUG] 2 clients in lobby. Ready to pair!");
//                            //TODO: somehow get server to blast both clients with MATCH MADE in a cleaner way
//                            match = new Match(client1.getUsername(), client2.getUsername() );    //TODO: should use primary IDs, but usernames will do for now... use unique usernames when testing
//                            System.out.println("[DEBUG] match.getWhoseTurn()=" + match.getWhoseTurn() );
////                                    client1.sendData(ServerConnection.MATCH_MADE);
//                            client1.sendData(match);
//                            client2.sendData(match);
//                        }
//                        break;
                    }
//                    listenForConnection();
//                    getStreams();
//                    setupConnection();
//                    processConnection();
                }
                catch(EOFException eofExeption)
                {
                    System.out.println("\nServer connection ended");
                            
                }
//                finally
//                {
//                    endServerConnection();
//                    ++counter;
//                } 
            } // Try block 
        }
        catch(IOException ioException)
        {
            ioException.printStackTrace();
        }
        
        
    } // Starts connection method
    
//    public void endServerConnection() throws IOException 
//    {
//          
//        
//        OIS.close();
//        OOS.close();
//        connection.close();
//    } //ends connection to the server 
    
    
    
//    /**
//     * Listen for a client to make a connection, then connects it to the first empty server-side socket it has.
//     * @throws IOException 
//     */
//    public void setupConnection() throws IOException
//    {
//        if (client1.isClosed() == true)    //if client1 isn't occupied
//        {
//            client1 = server.accept();
//            
//            ObjectOutputStream OOS = new ObjectOutputStream(client1.getOutputStream() );
//            OOS.flush();
//            ObjectInputStream OIS = new ObjectInputStream(client1.getInputStream() );
//        }
//        else if (client2.isClosed() == true)    //if client2 isn't occupied
//        {
//            client2 = server.accept();
//            
//            ObjectOutputStream OOS = new ObjectOutputStream(client2.getOutputStream() );
//            OOS.flush();
//            ObjectInputStream OIS = new ObjectInputStream(client2.getInputStream() );
//            
//        }
//    }
    

//    public void listenForConnection() throws IOException
//    {
//        System.out.println("Waiting for connection\n ");
//        connection = server.accept();
//        
//    }
    
    
    
//    public void getStreams() throws IOException
//    {
//        ObjectOutputStream OOS = new ObjectOutputStream(connection.getOutputStream());
//        OOS.flush();
//        
//        ObjectInputStream OIS = new ObjectInputStream(connection.getInputStream());
//        System.out.println("OIS = " + OIS);
//        //System.out.println("Got here");
//    } //end of getStream method 
    
//    public void processConnection() throws IOException, ClassNotFoundException 
//    {
//       if(test == true)
//       {
//           System.out.println("Made it to processConnection");  
//       }
//       String temp = (String) OIS.readObject();
//        System.out.println("temp = " + temp);
////        do 
////        {
////            System.out.println("send info");
////            
////        }while(!message.equals("Terminate"));
//    }
    
    
    
    /**
     * From Deitel's code, modified by JSS5783 for the Cryptography assignment, and then modified further.
     */
    // private inner class ClientThread
    // manages each Client as a thread
    private class ClientThread extends Thread
    {
        private int intClientNumber;
        private Socket connection;
        private ObjectOutputStream output;
        private ObjectInputStream input;
        private String strUsername;
        private boolean bInLobby;
        int intStatus = 0;
        
        final static int LOBBY = 1;
        final static int MATCH = 2;
        final static int SCOREBOARD = 3;

        /**
         * Constructor.
         * @param socket - server-side client socket
         * @param intInClientNumber - which number connection the thread is
         */
        public ClientThread(Socket socket, int intInClientNumber)
        {
            System.out.println("[DEBUG] ClientThread(Socket socket, int intInClientNumber)");
           intClientNumber = intInClientNumber;
           connection = socket;
           
           
           // obtain streams from Socket
           try {
                output = new ObjectOutputStream( connection.getOutputStream() );
                output.flush();

                input = new ObjectInputStream( connection.getInputStream() );
//                sendData(ServerConnection.RECEIVE_CODE);    //ask for username

                System.out.println( "\nConnection " + intClientNumber + " received from: " + connection.getInetAddress().getHostName() );
           }

            // process problems with IO
            catch ( IOException ioException ) {
                 ioException.printStackTrace();
            }
    }

        
        
        /**
         * Send Object to client.
         * @param obj - Object to send
         */
        public void sendData(Object obj)
        {
            // send object to client
            System.out.println("[DEBUG] Reached sendData(Object obj)");
            System.out.println("[DEBUG] obj.getClass()=" + obj.getClass() );
        
            try
            {
                output.writeObject(obj);
                output.flush();
            }

            // process problems sending object
            catch ( IOException ioException ) {
                ioException.printStackTrace();
            }
         
        }   //END sendData(Object obj)
        
        
        
        /**
         * Sets the client's username.
         * @param strInUsername 
         */
        public void setUsername(String strInUsername)
        {
            strUsername = strInUsername;
        }   //END setUsername(String strInUsername)
        
        
        /**
         * Gets the client's username.
         * @return 
         */
        public String getUsername()
        {
            return strUsername;
        }   //END getUsername()
        
        
        
         /**
         * Sets the client's status.
         * @param strInUsername 
         */
        public void setStatus(int intInStatus)
        {
            intStatus = intInStatus;
        }   //END setStatus(int intInStatus)
        
        
        /**
         * Gets the client's status.
         * @return 
         */
        public int getStatus()
        {
            return intStatus;
        }   //END getStatus()
        

        
        
        // control thread's execution
        public void run()
        {
            System.out.println("[DEBUG] Reached run() for client " + intClientNumber);
            Object objInput = new Object();
            String strCode = "";

           try  //process connection
           {

                do  //read message from client
                    
                {

                    try
                    {
                        objInput = input.readObject();  //DO NOT TOUCH - must declare object OUTSIDE for some reason for ServerConnection only
                        
                        //TODO: handle specific codes and such
                        if (objInput.getClass().getSimpleName() instanceof String)
                        {
                            strCode = (String) input.readObject();
                            System.out.println( "\nCLIENT CONNECTION " + intClientNumber + " sent \"" + strCode + "\".");
                            
                            
                            if (strCode.contains(ClientConnection.USERNAME_CODE) == true)   //set username
                            {
                                strUsername = strCode.replace(ClientConnection.USERNAME_CODE, "");
                                System.out.println("[DEBUG] strUsername=" + strUsername);
                            }
                            if (strCode.contains(ClientConnection.LOBBY_CODE) == true)
                            {
                                setStatus(LOBBY);
//                                if (client1.getStatus() == LOBBY & client2.getStatus() == LOBBY)
                                if (bClient1Exists == true && bClient2Exists == true)
                                {
                                    System.out.println("[DEBUG] 2 clients in lobby. Ready to pair!");
                                    //TODO: somehow get server to blast both clients with MATCH MADE in a cleaner way
                                    match = new Match(client1.getUsername(), client2.getUsername() );    //TODO: should use primary IDs, but usernames will do for now... use unique usernames when testing
                                    System.out.println("[DEBUG] match.getWhoseTurn()=" + match.getWhoseTurn() );
//                                    client1.sendData(ServerConnection.MATCH_MADE);
                                    client1.sendData(match);
                                    client2.sendData(match);
                                }
                            }
                            else if (strCode.contains(ClientConnection.MATCH_CODE) == true)
                            {
                                setStatus(MATCH);
                            }
                            else if (strCode.contains(ClientConnection.MATCH_FINISHED_CODE) == true) //if match is concluded (sending client finished)
                            {
                                //TODO: derive scores
                                //determine winner (or if both came to a draw and... let's say both lost
                                //add winner's and loser's scores to database
                                
                                //TODO: notify clients who won and who lost (or both "lost", in the case of a draw)
                                
                                
                            }
                            else if (strCode.contains(ClientConnection.SCOREBOARD_CODE) == true)
                            {
                                setStatus(SCOREBOARD);
                            }
                        }
                        else if (objInput.getClass() == Match.class)    //testing for whether or not obj is a Match - can't seem to test as objInput.getClass().getSimpleName() instanceof Match for some reason
                        {
                            match = (Match) objInput;
                            
                            //send to the other client
                            if (intClientNumber == 1)
                            {
                                client2.sendData(match); 
                            }
                            else
                            {
                                client1.sendData(match);
                            }
                            System.out.println( "\nCLIENT CONNECTION " + intClientNumber + " sent a Match object.");
                        }
                        
                    }   //handle input stream

                    // process problems reading from client
                    catch ( ClassNotFoundException classNotFoundException )
                    {
                        System.out.println( "\n[ERROR] Unknown object type received." );
                    }

                } while (strCode.equals(ClientConnection.DISCONNECT_CODE) == false);

                sendData(ServerConnection.SUCCESS_CODE);    //send acknowledgment
                System.out.println( "\nCLIENT CONNECTION " + intClientNumber + " terminated its connection." );
           }
           // process problems with I/O
           catch ( IOException ioException )
           {
                System.out.println("\nCLIENT CONNECTION " + intClientNumber + " unexpectedly terminated its connection.\n"   + ioException.toString() );
           }

           // close streams and socket
            finally
           {
                try
                {
                    output.close();
                    input.close();
                    connection.close();
                }

                // process problems with I/O
                catch ( IOException ioException )
                {
                    ioException.printStackTrace();
                }

//                clients.remove( this );
                //TODO: not sure if any extra cleanup is needed due to not being in a Vector
            }

        }  // end method run

   }  // end class ClientThread
    
    
   
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
        System.out.println("[ServerConnection] Server started.");
        SC.runServer();
        
        
    }
}
