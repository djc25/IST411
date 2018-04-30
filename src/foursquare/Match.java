/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package foursquare;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author jss5783
 * 
 * For now, keep both client and server match code together.
 *
 * ----------CHANGELOG----------
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
    private final static int PLAYER_1_TURN = 1;
    private final static int PLAYER_2_TURN = 2;
    
    private String strPlayer1Username;
    private String strPlayer2Username;
    private int intPlayer1ID;
    private int intPlayer2ID;
    private int intPlayer1Score;
    private int intPlayer2Score;
    private int intWhoseTurn;
    private boolean bHasExtraTurn;
    private boolean bAlreadyObtainedExtraTurn;
    
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
        }
        else
        {
            strPlayer1Username = strUsername2;
            intPlayer1ID = intUserID2;
            strPlayer2Username = strUsername1;
            intPlayer2ID = intUserID1;
        }
        
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
        }
        else
        {
            strPlayer1Username = strUsername2;
            strPlayer2Username = strUsername1;
        }
        
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
     * @return strPlayer2Username
     */
    public String getPlayer2Username() 
    {
        return strPlayer2Username;
    }

    /**
     * @param strInPlayer2Username
     */
    public void setPlayer2Username(String strInPlayer2Username)
    {
        strPlayer2Username = strInPlayer2Username;
    }

    
    
    /**
     * @return intPlayer1ID
     */
    public int getPlayer1ID()
    {
        return intPlayer1ID;
    }

    /**
     * @param intInPlayer1ID
     */
    public void setPlayer1ID(int intInPlayer1ID)
    {
        intPlayer1ID = intInPlayer1ID;
    }

    
    
    /**
     * @return intPlayer2ID
     */
    public int getPlayer2ID()
    {
        return intPlayer2ID;
    }

    /**
     * @param intInPlayer2ID
     */
    public void setPlayer2ID(int intInPlayer2ID)
    {
        intPlayer2ID = intInPlayer2ID;
    }

    
    
    /**
     * @return the intPlayer1Score
     */
    public int getPlayer1Score()
    {
        return intPlayer1Score;
    }

    /**
     * @param intInPlayer1Score
     */
    public void setPlayer1Score(int intInPlayer1Score)
    {
        intPlayer1Score = intInPlayer1Score;
    }

    
    
    /**
     * @return intPlayer2Score
     */
    public int getPlayer2Score()
    {
        return intPlayer2Score;
    }

    /**
     * @param intInPlayer2Score
     */
    public void setIntPlayer2Score(int intInPlayer2Score)
    {
        intPlayer2Score = intInPlayer2Score;
    }

    
    
    /**
     * @return intWhoseTurn
     */
    public int getWhoseTurn()
    {
        return intWhoseTurn;
    }

    /**
     * @param intInWhoseTurn
     */
    public void setWhoseTurn(int intInWhoseTurn)
    {
        intWhoseTurn = intInWhoseTurn;
    }

    
    
    /**
     * @return bHasExtraTurn
     */
    public boolean getHasExtraTurn()
    {
        return bHasExtraTurn;
    }

    /**
     * @param bInHasExtraTurn
     */
    public void setHasExtraTurn(boolean bInHasExtraTurn)
    {
        bHasExtraTurn = bInHasExtraTurn;
    }

    
    
    /**
     * @return bAlreadyObtainedExtraTurn
     */
    public boolean getAlreadyObtainedExtraTurn()
    {
        return bAlreadyObtainedExtraTurn;
    }

    /**
     * @param bInAlreadyObtainedExtraTurn
     */
    public void setAlreadyObtainedExtraTurn(boolean bInAlreadyObtainedExtraTurn)
    {
        bAlreadyObtainedExtraTurn = bInAlreadyObtainedExtraTurn;
    }

}   //END Match