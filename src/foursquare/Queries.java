/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foursquare;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jason
 */

/************************MODIFICATION LOG ************************************
4/13/18- Created Class and supporting PreparedStatements and Methods
4/16/18- Added more PreparedStatements

*****************************************************************************/

public class Queries 
{
    public static void main(String[] args) throws SQLException 
    {
        // Make Connection
        Connection connect;
        SQLiteConnection sc = new SQLiteConnection();
        connect = sc.getConnection();
        
        // Get Queries from Connection
        Queries q = new Queries(connect);
        q.setEntry("Justin", 100);
        //q.updateEntry(2);
        q.getLastEntry();
        //q.getDataDebugging();
        
    } // main
    
    private Connection connect;
    private Statement stment;
    private ResultSet result;
    private ResultSet keyid;
    private Date datex;
    
    
    private final PreparedStatement newEntry;
    private final PreparedStatement updateEntry;
    private final PreparedStatement getEntry;
    
    public Queries(Connection connectIn) throws SQLException
    {
        // Get connection established from SQLiteConnection
        connect = connectIn;
        
        // Initialize new Date object
        datex = new Date(Calendar.getInstance().getTime().getTime());
        
/////////////////////////PREPARED_STATEMENTS////////////////////////////////////
        //create new entry row after first game ends in a session
        newEntry = connect.prepareStatement(
            "INSERT INTO RANK(name, score, timex) " +
            "VALUES( ?, ?, ?)");
        
        //update last entry row in the session
        updateEntry = connect.prepareStatement(
            "UPDATE Rank\n" +
            "SET score = (score + ?) \n" +
            "WHERE playid = ?");
        
        //get last entry row information
        getEntry = connect.prepareStatement(
            "SELECT name, score, timex\n" +
            "FROM Rank\n" +
            "WHERE playid = ?");
        
    } // constructor

    public void setEntry(String NameIn, int ScoreIn)
    {
        try 
        {
            newEntry.setString(1, NameIn);
            newEntry.setInt(2, ScoreIn);
            newEntry.setString(3, datex.toString());
            newEntry.executeUpdate();
            
            // update result variable to get auto-increment number
            keyid = newEntry.getGeneratedKeys();
            //System.out.println(result.getString(1));
        } // try
        catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        } // catch     
    } // setEntry
    
    public void updateEntry(int ScoreIn)
    {
        try 
        {
            updateEntry.setInt(1, ScoreIn);
            updateEntry.setInt(2, keyid.getInt(1));
            updateEntry.executeUpdate();
        } // try
        catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        } // catch     
    } // setEntry
    
    public ResultSet getLastEntry()
    {
        try 
        {
            getEntry.setInt(1, keyid.getInt(1));
            result = getEntry.executeQuery();
        } // try
        catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        } // catch  
        
        return result;
    } // getLastEntry
    
    public void getTopTen()
    {
        
    } // getTopTen
    
    public void getDataDebugging()
    {
        try 
        {
            //PreparedStatement ps = connect.prepareStatement("select * from course");
            //result = ps.executeQuery();
            
            stment = connect.createStatement();
            String query = "select * from rank";
            result = stment.executeQuery(query);

            // output out to output console
            System.out.println("LeaderBoard");
            while (result.next())
            {
                String name = result.getString("name");
                String score = result.getString("score");
                System.out.println("Name:" + name + "\tScore:" + score);
            } // while
        } // try
        catch (SQLException ex) 
        {
            Logger.getLogger(SQLiteConnection.class.getName()).log(Level.SEVERE, null, ex);
        } // catch // catch
    } // getData
}
