
package foursquare;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;

/**
 * Creates Dots component.
 * @author DRACOX
 * 
 * ----------CHANGELOG----------
 * 2018/04/25 -     Added DOT_COLOR variable.
 *                  Renamed variables and added comments to comply with coding conventions. -JSS5783
 */
public class Dots
{
    private static final int DIAMETER = 10;
    private static final Color DOT_COLOR = Color.BLACK;
    private int intPosX;
    private int intPosY;
    
    /**
     * Dots constructor.
     * Sets x and y coordinates for the upper-left corner of the Dots.
     * 
     * @param intInPosX
     * @param intInPosY
     */
    public Dots(int intInPosX, int intInPosY)
    {
        intPosX = intInPosX;
        intPosY = intInPosY;
    }   //END Dots(int intInPosX, int intInPosY)
    
    /**
     * Draws a dot at the Dots's coordinates.
     * @param g Graphics g used to call Graphics class methods.
     */
    public void createDot(Graphics g)
    {
        g.setColor(DOT_COLOR);
        g.fillOval(intPosX, intPosY, DIAMETER, DIAMETER);
    }   //END createDot(Graphics g)
 
    /**
     * Gets the x coordinate for the center of the Dots.
     * @return intPosX
     */
    public int getIntX_coord()
    {
        return intPosX + (DIAMETER / 2);
    }   //END getIntX_coord()

    /**
     * Sets the x coordinate for the upper-left corner of the Dots.
     * @param intInPosX
     */
    public void setIntX_coord(int intInPosX)
    {
        intPosX = intInPosX;
    }   //END setIntX_coord(int intInPosX)

    /**
     * Gets the y coordinate for the center of the Dots.
     * @return intPosY
     */
    public int getIntY_coord()
    {
        return intPosY + (DIAMETER / 2);
    }   //END getIntY_coord()

    /**
     * Sets the y coordinate for the upper-left corner of the Dots.
     * @param intInPosY
     */
    public void setIntY_coord(int intInPosY)
    {
        intPosY = intInPosY;
    }   //END setIntY_coord(int intInPosY)

}   //END Dots
