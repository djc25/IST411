/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package foursquare;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Sets and gets of the match's score and player turn information.
 * @author jss5783
 * 
 * For now, keep both client and server match code together.
 *
 * ----------CHANGELOG----------
 * 2018/05/01 -     Fixed setPlayer2Score(int intInPlayer2Score) name.   -JSS5783
 * 
 * 2018/04/29 -     Made Serializable. -JSS5783
 * 
 * 2018/04/29 -     Added Match(String strUsername1, String strUsername2). Doesn't set primary IDs, but getting things working is more important. -JSS5783
 * 
 * 2018/04/25 -     Added getters/setters (auto-generated, and then cleaned up method signatures). -JSS5783
 * 
 * 2018/04/18 -     Created. -JSS5783
 *
 */
public class Match implements Serializable
{
    final static int PLAYER_1_TURN = 1;
    final static int PLAYER_2_TURN = 2;
    
    private String strPlayer1Username;
    private String strPlayer2Username;
    private int intPlayer1ID;
    private int intPlayer2ID;
    private int intPlayer1Score;
    private int intPlayer2Score;
    private int intWhoseTurn;
    private boolean bHasExtraTurn;
    private boolean bAlreadyObtainedExtraTurn;
    ArrayList<Dots> myDots = new ArrayList();
    ArrayList<Lines> myLines = new ArrayList();
    ArrayList<Boxes> myBoxes = new ArrayList();
    
    /**
     * Initializes variables and determines who is player 1 (who always goes first).
     * @param strUsername1
     * @param strUsername2
     * @param intUserID1
     * @param intUserID2 
     */
    public Match(String strUsername1, String strUsername2, int intUserID1, int intUserID2)
    {
        Random rng = new Random();
        if (rng.nextBoolean() == true)  //"approximately equal probability" is good enough for now
        {
            //User 1 goes first
            
            //So set User 1 as Player 1
            strPlayer1Username = strUsername1;
            intPlayer1ID = intUserID1;
            strPlayer2Username = strUsername2;
            intPlayer2ID = intUserID2;
        } // if
        else
        {
            strPlayer1Username = strUsername2;
            intPlayer1ID = intUserID2;
            strPlayer2Username = strUsername1;
            intPlayer2ID = intUserID1;
        } // else
        
        intPlayer1Score = 0;
        intPlayer2Score = 0;
        intWhoseTurn = PLAYER_1_TURN;
        bHasExtraTurn = false;
        bAlreadyObtainedExtraTurn = false;
        
    }   //END Match(String strUsername1, String strUsername2, int intUserID1, int intUserID2)
    
    
    
    /**
     * Initializes variables and determines who is player 1 (who always goes first).
     * @param strUsername1
     * @param strUsername2
     */
    public Match(String strUsername1, String strUsername2)
    {
        Random rng = new Random();
        if (rng.nextBoolean() == true)  //"approximately equal probability" is good enough for now
        {
            //User 1 goes first
            
            //So set User 1 as Player 1
            strPlayer1Username = strUsername1;
            strPlayer2Username = strUsername2;
        } // if
        else
        {
            strPlayer1Username = strUsername2;
            strPlayer2Username = strUsername1;
        } // else
        
        intPlayer1Score = 0;
        intPlayer2Score = 0;
        intWhoseTurn = PLAYER_1_TURN;
        bHasExtraTurn = false;
        bAlreadyObtainedExtraTurn = false;
        
    }   //END Match(String strUsername1, String strUsername2)

    
    
    /**
     * @return strPlayer1Username
     */
    public String getPlayer1Username()
    {
        System.out.println("strPlayer1Username = " + strPlayer1Username);
        return strPlayer1Username;
    }

    /**
     * @param strInPlayer1Username
     */
    public void setPlayer1Username(String strInPlayer1Username)
    {
        strPlayer1Username = strInPlayer1Username;
    }

    
    
    /**
     * Returns Player 2's username.
     * @return strPlayer2Username
     */
    public String getPlayer2Username() 
    {
        return strPlayer2Username;
    }   //END getPlayer2Username

    /**
     * @param strInPlayer2Username
     */
    public void setPlayer2Username(String strInPlayer2Username)
    {
        strPlayer2Username = strInPlayer2Username;
    }   //END setPlayer2Username

   
    
    /**
     * Returns Player 1's ID.
     * @return intPlayer1ID
     */
    public int getPlayer1ID()
    {
        return intPlayer1ID;
    }   //END getPlayer1ID

    /**
     * @param intInPlayer1ID
     */
    public void setPlayer1ID(int intInPlayer1ID)
    {
        intPlayer1ID = intInPlayer1ID;
    }   //END setPlayer1ID

    
    
    /**
     * Returns Player 2's ID.
     * @return intPlayer2ID
     */
    public int getPlayer2ID()
    {
        return intPlayer2ID;
    }   //END getPlayer2ID

    /**
     * @param intInPlayer2ID
     */
    public void setPlayer2ID(int intInPlayer2ID)
    {
        intPlayer2ID = intInPlayer2ID;
    }   //END setPlayer2ID

    
    
    /**
     * Returns Player 1's score.
     * @return the intPlayer1Score
     */
    public int getPlayer1Score()
    {
        return intPlayer1Score;
    }   //END getPlayer1Score

    /**
     * @param intInPlayer1Score
     */
    public void setPlayer1Score(int intInPlayer1Score)
    {
        intPlayer1Score = intInPlayer1Score;
    }   //END setPlayer1Score

    
    
    /**
     * Returns Player 2's score.
     * @return intPlayer2Score
     */
    public int getPlayer2Score()
    {
        return intPlayer2Score;
    }   //END getPlayer2Score

    /**
     * @param intInPlayer2Score
     */
    public void setPlayer2Score(int intInPlayer2Score)
    {
        intPlayer2Score = intInPlayer2Score;
    }   //END setPlayer2Score

    
    
    /**
     * Returns the player of the current turn.
     * @return intWhoseTurn
     */
    public int getWhoseTurn()
    {
        return intWhoseTurn;
    }   //END getWhoseTurn

    /**
     * @param intInWhoseTurn
     */
    public void setWhoseTurn(int intInWhoseTurn)
    {
        intWhoseTurn = intInWhoseTurn;
    }   //END setWHoseTurn

    
    
    /**
     * Returns true/false whether extra turn was made yet.
     * @return bHasExtraTurn
     */
    public boolean getHasExtraTurn()
    {
        return bHasExtraTurn;
    }   //END getHasExtraTurn

    /**
     * @param bInHasExtraTurn
     */
    public void setHasExtraTurn(boolean bInHasExtraTurn)
    {
        bHasExtraTurn = bInHasExtraTurn;
    }   //END setHasExtraTurn

    
    
    /**
     * Returns true/false whether extra turn was already made.
     * @return bAlreadyObtainedExtraTurn
     */
    public boolean getAlreadyObtainedExtraTurn()
    {
        return bAlreadyObtainedExtraTurn;
    }   //END getAlreadyObtainedExtraTurn

    /**
     * @param bInAlreadyObtainedExtraTurn
     */
    public void setAlreadyObtainedExtraTurn(boolean bInAlreadyObtainedExtraTurn)
    {
        bAlreadyObtainedExtraTurn = bInAlreadyObtainedExtraTurn;
    }   //END setAlreadyObtainedExtraTurn

}   //END Match