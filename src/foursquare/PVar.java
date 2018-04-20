/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foursquare;

import java.awt.Color;

/**
 *
 * @author JSS5783
 * 
 * Public variables.
 * 
 * ----------[CHANGELOG]----------
 * 2018/04/18 -     Finalized variables, as they shouldn't be changing in-game.
 *                  Renamed bDebugMode to comply with final variable naming conventions. -JSS5783
 * 
 * 2018/04/16 -     Added BACKGROUND_COLOR. -JSS5783
 * 
 * 2018/04/15 -     Added DEBUG_MODE. -JSS5783
 * 
 * 2018/04/10 -     Created. -JSS5783
 */
public class PVar
{
    public static final boolean DEBUG_MODE = true;
    public static final Color BACKGROUND_COLOR = new Color(245, 245, 245);
    public static final Color PLAYER_1_COLOR = new Color(32, 192, 255);
    public static final Color PLAYER_2_COLOR = new Color(255, 192, 32);
    
}   //END PVar
