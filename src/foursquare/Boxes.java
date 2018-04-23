package foursquare;


import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DRACOX
 * 
 * ----------CHANGELOG----------
 * 2018/04/23 -     Started renaming variables and adding comments to comply with coding conventions. -JSS5783
 */



public class Boxes {
    
    /*
        A Box knows the status (true [checked] /false [unchecked]) of its own four sides (left, right, up, and down).
        It also knows which lines it's connected to (Lines) and their relative positions (left, right, up, and down).
        Finally, it knows whether or not it's closed (i.e., all four sides are closed.
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
    }

    
    
    /**
     * @return bTopSide - returns true if the Box's top side is checked, and false if not.
     */
    public boolean isTop() {
        return bTopSide;
    }

    /**
     * @param bInTopLine - sets the Box's top side to checked if true, and unchecked if false.
     */
    public void setTop(boolean bInTopLine) {
        bTopSide = bInTopLine;
    }

    
    
    /**
     * @return bBottomSide - returns true if the Box's bottom side is checked, and false if not.
     */
    public boolean isBot() {
        return bBottomSide;
    }

    /**
     * @param bInBottomLine - sets the Box's bottom side to checked if true, and unchecked if false.
     */
    public void setBot(boolean bInBottomLine) {
        bBottomSide = bInBottomLine;
    }

    
    
    /**
     * @return bLeftSide - returns true if the Box's left side is checked, and false if not.
     */
    public boolean isLeft() {
        return bLeftSide;
    }

    /**
     * @param bInLeftLine - sets the Box's left side to checked if true, and unchecked if false.
     */
    public void setLeft(boolean bInLeftLine) {
        bLeftSide = bInLeftLine;
    }

    
    
    /**
     * @return bRightSide - returns true if the Box's right side is checked, and false if not.
     */
    public boolean isRight() {
        return bRightSide;
    }

    /**
     * @param bInRightLine - sets the Box's right side to checked if true, and unchecked if false.
     */
    public void setRight(boolean bInRightLine) {
        bRightSide = bInRightLine;
    }

    
    
    /**
     * @return the lineTop
     */
    public Lines getTopLine() {
        return lineTop;
    }

    /**
     * @param lineInTop - the Line that the Box's top line should be set to.
     */
    public void setTopLine(Lines lineInTop) {
        lineTop = lineInTop;
    }

    
    
    /**
     * @return the lineBottom
     */
    public Lines getBotLine() {
        return lineBottom;
    }

    /**
     * @param lineInBottom - the Line that the Box's bottom line should be set to.
     */
    public void setBotLine(Lines lineInBottom) {
        lineBottom = lineInBottom;
    }

    
    
    /**
     * @return the lineLeft
     */
    public Lines getLeftLine() {
        return lineLeft;
    }

    /**
     * @param lineInLeft - the Line that the Box's left line should be set to.
     */
    public void setLeftLine(Lines lineInLeft) {
        lineLeft = lineInLeft;
    }

    
    
    /**
     * @return the lineRight
     */
    public Lines getRightLine() {
        return lineRight;
    }

    /**
     * @param lineInRight - the Line that the Box's right line should be set to.
     */
    public void setRightLine(Lines lineInRight) {
        lineRight = lineInRight;
    }
    
    
    
    /**
     * @return bIsClosed - returns true if the Box is closed, and false if it is not.
     */
    public boolean getClosed()
    {
        return bIsClosed;
    }
    
    /**
     * Checks if the Box is closed.
     * If closed, then the box graphic is filled in.
     * Sets bIsClosed to true if the Box is closed, and false if it is not.
     * TODO: Should probably be split into setClosed and drawClosed methods or something to cut down on unnecessary redraws.
     * @param g 
     */
    public void isClosed(Graphics g)
    {
        
        if(lineTop.isIsConnected()&&lineBottom.isIsConnected()&&lineLeft.isIsConnected()&&lineRight.isIsConnected())
        {
            g.fillRect(lineTop.getxStart(), lineTop.getyStart(), 100, 100);
            bIsClosed = true;
            
        }
        else
        {
            bIsClosed = false;
        }
    }
    
    
}
