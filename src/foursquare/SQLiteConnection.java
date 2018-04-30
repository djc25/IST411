/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package foursquare;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jqj5405
*
*Modified Class Template
 */

/************************MODIFICATION LOG ************************************
4/13/18- Created LeaderBoard.db3 and made connection

*****************************************************************************/

public final class SQLiteConnection 
{    
    private Connection connect;
    
    // IF CONNECTION ISN'T WORKING CHECK IF 
    //sqlite-jdbc-x.xx.x.jar is installed in library
    private String strDBName;
    final String strDBClass = "org.sqlite.JDBC";
    final String strJDBCString = "jdbc:sqlite:";
    
    public SQLiteConnection() throws SQLException
    {
        connectSQLiteDB();
    } // constructor
    
    
/////////////////////////CONNECT TO DATABASE////////////////////////////////////       
    public void connectSQLiteDB() throws SQLException 
    {
        // Get Leaderboard.db3 file location relative to absolute path
        File file = new File("");
        String path = file.getAbsolutePath();
        String dir = ("\\resource\\Leaderboard.db3");    
        strDBName = (path+dir);
        
        try 
        {
            System.out.println("Connecting to: " + strDBName);
            connect = DriverManager.getConnection(strJDBCString + strDBName);
        } // try
        catch (SQLException ex) 
        {
            Logger.getLogger(SQLiteConnection.class.getName()).log(Level.SEVERE, null, ex);
        } // catch
        
        System.out.println("Connected to product:  " + connect.getMetaData().getDatabaseProductName());
    } // connectSQLiteDB
    
/////////////////////////RETRIEVE DATABASE CONNECTION///////////////////////////      
    public Connection getConnection()
    {
        return connect;
    } // getData
    
} // end of class SQLConnection
