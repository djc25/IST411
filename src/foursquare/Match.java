/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package foursquare;

import java.util.Random;

/**
 *
 * @author jss5783
 * 
 * For now, keep both client and server match code together.
 *
 * ----------CHANGELOG----------
 * 2018/04/18 -     Created. -JSS5783
 *
 */
public class Match
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
        
    }   //END Match()

}   //END Match
