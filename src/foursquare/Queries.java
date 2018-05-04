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
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 * SQLite queries for use with jpScoreboard.
 * @author Jason
 * 
 ************************** MODIFICATION LOG ********************************
 * 4/13/18- Created Class and supporting PreparedStatements and Methods 
 * 4/16/18-Added more PreparedStatements 
 * 4/18/18- Added getAllEntry PreparedStatement and supporting Method
 * 4/25/18- Added getTopTenEntry PreparedStatement and supporting Method
 * 4/30/18- Resolved SQL Errors and updated getEntry and supporting getLastEntryInfo
 *          Made some changes in wording for readability
 *
 ****************************************************************************
 */
public class Queries {

    /**
     * Temporary main, will need to integrate into main program.
     * Will run jpScoreboard with supporting functionality remotely from main
     * program.
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException 
    {
        // Get connection from SQLiteConnection
        Connection connect;
        SQLiteConnection sc = new SQLiteConnection();
        connect = sc.getConnection();
        
        // Initialize output
        ResultSet top10;
        ResultSet personalRank;
        int rankLabel;

        // Get queries from connection
        Queries q = new Queries(connect);
        q.setEntryInfo("Jackie",45);
        q.updateEntryInfo(20);
        
        rankLabel = q.getLastEntryRank();
        //rankLabel = 6; // testing purposes
        personalRank = q.getLastEntryInfo(rankLabel);
        
        top10 = q.getTopTen();
    
        // Temporary JFrame, Panel object
        //jpScoreboard panel = new jpScoreboard(top10, personalRank, rankLabel);
        jpScoreboard panel = new jpScoreboard();
        panel.populateTopTen(top10);
        panel.populatePersonal(personalRank);
        panel.setRankLabel(rankLabel);
        

        JFrame frame = new JFrame();
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 250, 960, 600);
        frame.setVisible(true);

    } // main

    private final Connection connect;
    private final Date datex;
    private ResultSet result;
    private ResultSet keyID;
    
    private final PreparedStatement newEntry;
    private final PreparedStatement updateEntry;
    private final PreparedStatement getEntry;
    private final PreparedStatement getTopTenEntry;
    private final PreparedStatement getAllEntry;
    
    /**
     * Establishes connection with SQLite database and sets PreparedStatements.
     * @param connectIn Connection connectIn will be inherited by Class connect variable
     * @throws SQLException
     */
    public Queries(Connection connectIn) throws SQLException
    {
        // Make connection via SQLiteConnection
        connect = connectIn;
        
        // Initialize new Date object
        datex = new Date(Calendar.getInstance().getTime().getTime());
        
/////////////////////////PREPARED_STATEMENTS////////////////////////////////////
        //create new entry row after first game ends in a session
        newEntry = connect.prepareStatement(
                "INSERT INTO RANK(strUserName, intScore, intGameWon, timex) "
                + "VALUES( ?, ?, ?, ?)");
        
        //update entry row in the current session based on keyID by adding
        updateEntry = connect.prepareStatement(
                "UPDATE Rank\n"
                + "SET intScore = (intScore + ?), intGameWon = (intGameWon + 1) \n"
                + "WHERE intID = ?");
        
        //get information on entry row and the rows above and below based on rank
        getEntry = connect.prepareStatement(
                "SELECT strUserName, intScore, intGameWon, timex\n"
                + "FROM Rank\n"
                + "ORDER BY intScore desc\n"
                + "LIMIT 3 OFFSET (?-2);");
        
        //get top ten entries ordered from high to lowest score
        getTopTenEntry = connect.prepareStatement(
                "SELECT strUserName as Username, intScore as Score, "
                + "intGameWon as Win, timex as Date\n"
                + "FROM Rank\n"
                + "ORDER BY intScore desc\n"
                + "LIMIT 0,10;");
        
        //get all entries ordered from high to lowest score
        getAllEntry = connect.prepareStatement(
                "SELECT *\n"
                + "FROM Rank\n"
                + "ORDER BY intScore desc;");

    } // constructor

    /**
     * Creates new entry row after first game ends in a session.
     * @param NameIn String NameIn will be set within setString parameter for
     * use in newEntry query
     * 
     * @param ScoreIn int ScoreIN will be set within setInt parameter for use in
     * newEntry query
     */
    public void setEntryInfo(String NameIn, int ScoreIn) 
    {
        try 
        {
            newEntry.setString(1, NameIn);
            newEntry.setInt(2, ScoreIn);
            newEntry.setInt(3, 1);
            newEntry.setString(4, datex.toString());
            newEntry.executeUpdate();
            
            // get get last auto-increment number
            keyID = newEntry.getGeneratedKeys();
            System.out.println("KeyID = " + keyID.getString(1));
        } // try
        catch (SQLException ex) 
        {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        } // catch     
    
    } // setEntryInfo

    /**
     * Update entry row in the current session based on keyID by adding to 
     * previous score in session.
     * @param ScoreIn int ScoreIn will be set within setInt parameter for use in
     * updateEntry query
     */
    public void updateEntryInfo(int ScoreIn) 
    {
        try 
        {
            updateEntry.setInt(1, ScoreIn);
            updateEntry.setInt(2, keyID.getInt(1));
            updateEntry.executeUpdate();
        } // try
        catch (SQLException ex) 
        {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        } // catch     
    
    } // updateEntryInfo
    
    /**
     * Returns information on entry row and the rows above and below based on rank
     * @param intRank int intRank will be set within setInt to be used in getEntry
     * query. Obtained from getLastEntryRank result.
     * @return result 
     */
    public ResultSet getLastEntryInfo(int intRank) 
    {
        try 
        {
            getEntry.setInt(1, intRank);
            result = getEntry.executeQuery();
        } // try
        catch (SQLException ex) 
        {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        } // catch  
        
        return result;
    } // getLastEntryInfo
    
    /**
     * Returns the rank of the player based on row index after rows have been sorted
     * from highest score to lowest score.
     * @return intRowCount
     */
    public int getLastEntryRank() 
    {
        int intRowCount = -1;
        boolean bFoundTarget = false;
    
        try 
        {
            result = getAllEntry.executeQuery();
            if (result != null) 
            {
                intRowCount = 1;
                while (result.next() && (bFoundTarget == false)) 
                {
                    if (result.getString("intID").equalsIgnoreCase(keyID.getString(1))) 
                    {
                        bFoundTarget = true;
                    } // if intID equals the last auto-generated id
                    else 
                    {
                        intRowCount++;
                    } // else
                } // while
            } // if RS is not null
        } // try
        catch (SQLException ex) 
        {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        } // catch
    
        if (bFoundTarget == false) 
        {
            intRowCount = -1;
        } // if keyID was not found -1 is returned instead

        return intRowCount;
    } // getLastEntryRank

    /**
     * Returns top ten entries ordered from high to lowest score.
     * @return result
     */
    public ResultSet getTopTen() 
    {
        try 
        {
            result = getTopTenEntry.executeQuery();
        } // try
        catch (SQLException ex) 
        {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        } // catch

        return result;
    } // getTopTen
    
} // end of class Queries
