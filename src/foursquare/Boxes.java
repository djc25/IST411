package foursquare;


import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Sets and gets in creating and checking for boxes using lines.
 * @author DRACOX
 * 
 * ----------CHANGELOG----------
 * 2018/04/25 -     Continued adding comments to comply with coding conventions. -JSS5783
 * 
 * 2018/04/23 -     Started renaming variables and adding comments to comply with coding conventions. -JSS5783
 */
public class Boxes
{
    /*
        A Box knows the status (true [checked] /false [unchecked]) of its own four sides (left, right, up, and down).
        It also knows which lines it's connected to (Lines) and their relative positions (left, right, up, and down).
        Finally, it knows whether or not it's closed (i.e., all four sides are closed).
    */
    
    //declaration
    private boolean bTopSide;
    private boolean bBottomSide;
    private boolean bLeftSide;
    private boolean bRightSide;
    private boolean bIsClosed;
    private Lines lineTop;
    private Lines lineBottom;
    private Lines lineLeft;
    private Lines lineRight;
    private Color myColor;
    
    
    /**
     * Default Box constructor.
     * 
     * Lines are not initialized and thus not registered.
     */
    public Boxes()
    {
        //initialization
        bTopSide = bBottomSide = bLeftSide = bRightSide = false;
        bIsClosed = false;
    }   //END Boxes()

    /**
     * Returns true if the Box's top side is checked, and false if not.
     * @return bTopSide
     */
    public boolean isTop()
    {
        return bTopSide;
    }   //END isTop()

    /**
     * Sets the Box's top side to checked if true, and unchecked if false.
     * @param bInTopLine
     */
    public void setTop(boolean bInTopLine)
    {
        bTopSide = bInTopLine;
    }   //END setTop(boolean bInTopLine)

    /**
     * Returns true if the Box's bottom side is checked, and false if not.
     * @return bBottomSide
     */
    public boolean isBot()
    {
        return bBottomSide;
    }   //END isBot()

    /**
     * Sets the Box's bottom side to checked if true, and unchecked if false.
     * @param bInBottomLine
     */
    public void setBot(boolean bInBottomLine)
    {
        bBottomSide = bInBottomLine;
    }   //END setBot(boolean bInBottomLine)

    /**
     * Returns true if the Box's left side is checked, and false if not.
     * @return bLeftSide
     */
    public boolean isLeft()
    {
        return bLeftSide;
    }   //END isLeft()

    /**
     * Sets the Box's left side to checked if true, and unchecked if false.
     * @param bInLeftLine
     */
    public void setLeft(boolean bInLeftLine) 
    {
        bLeftSide = bInLeftLine;
    }   //END setLeft(boolean bInLeftLine)

    /**
     * Returns true if the Box's right side is checked, and false if not.
     * @return bRightSide
     */
    public boolean isRight()
    {
        return bRightSide;
    }   //END isRight()

    /**
     * Sets the Box's right side to checked if true, and unchecked if false.
     * @param bInRightLine
     */
    public void setRight(boolean bInRightLine)
    {
        bRightSide = bInRightLine;
    }   //END setRight(boolean bInRightLine)
    
    /**
     * Gets the game grid Line that is stored as the Box's top line.
     * @return lineTop
     */
    public Lines getTopLine()
    {
        return lineTop;
    }   //END getTopLine()

    /**
     * Sets the Box's top line to the Line passed from the game grid.
     * @param lineInTop - the Line that the Box's top line should be set to.
     */
    public void setTopLine(Lines lineInTop)
    {
        lineTop = lineInTop;
    }   //END setTopLine(Lines lineInTop)

    /**
     * Gets the game grid Line that is stored as the Box's bottom line.
     * @return lineBottom
     */
    public Lines getBotLine()
    {
        return lineBottom;
    }   //END getBotLine()

    /**
     * Sets the Box's bottom line to the Line passed from the game grid.
     * @param lineInBottom - the Line that the Box's bottom line should be set to.
     */
    public void setBotLine(Lines lineInBottom) 
    {
        lineBottom = lineInBottom;
    }   //END setBotLine(Lines lineInBottom)

    /**
     * Gets the game grid Line that is stored as the Box's left line.
     * @return lineLeft
     */
    public Lines getLeftLine()
    {
        return lineLeft;
    }   //END getLeftLine()

    /**
     * Sets the Box's left line to the Line passed from the game grid.
     * @param lineInLeft - the Line that the Box's left line should be set to.
     */
    public void setLeftLine(Lines lineInLeft)
    {
        lineLeft = lineInLeft;
    }   //END setLeftLine(Lines lineInLeft)

    /**
     * Gets the game grid Line that is stored as the Box's right line.
     * @return lineRight
     */
    public Lines getRightLine()
    {
        return lineRight;
    }   //END getRightLine()

    /**
     * @param lineInRight - the Line that the Box's right line should be set to.
     */
    public void setRightLine(Lines lineInRight) {
        lineRight = lineInRight;
    }   //END setRightLine
    
    /**
     * Returns true if the Box is closed, and false if it is not.
     * @return bIsClosed
     */
    public boolean getClosed()
    {
        return bIsClosed;
    }   //END getClosed()
    
    /**
     * Checks if the Box is closed.
     * If closed, then the box graphic is filled in.
     * Sets bIsClosed to true if the Box is closed, and false if it is not.
     * TODO: Should probably be split into setClosed and drawClosed methods or something to cut down on unnecessary redraws. 
     */
    public void isClosed()
    {
        if(lineTop.isIsConnected() && lineBottom.isIsConnected() && lineLeft.isIsConnected() && lineRight.isIsConnected() )   //if all lines are checked
        {
            bIsClosed = true;
        } // if
        else
        {
            bIsClosed = false;
        } // else
    }   //END isClosed
    
    /**
     * changes the color of this particular box in preparation for it to filled
     * @param thisColor 
     */
    public void setMyColor(Color thisColor)
    {
        if(myColor ==null)
        {
            myColor = thisColor;
        } // if
    }   //END setMyColor
    
    /**
     * Gets the color of the box and then returns that color
     * @return 
     */
    public Color getMyColor ()
    {
        return myColor;
    }   //END getMyColor
    /**
     * Fills a box using graphics, and sets the color to that of the player
     * @param g 
     */
    public void drawBox(Graphics g)
    {
        g.setColor(myColor);
        g.fillRect(lineTop.getxStart(), lineTop.getyStart(), 100, 100);
    }   //END drawBox
    
}   // end of class Boxes
