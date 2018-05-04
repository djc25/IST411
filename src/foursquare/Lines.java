
package foursquare;

import java.awt.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Create Lines component.
 * @author DRACOX
 */
public class Lines {
    
    private int xStart;
    private int yStart;
    private int xEnd;
    private int yEnd;
    private Color myColor = Color.BLACK;
    private boolean isConnected = false;
    
    /**
     * Constructor That takes two dots and creates a line between them.
     * @param dot1
     * @param dot2 
     */
    public Lines (Dots dot1, Dots dot2)
    {
        xStart = dot1.getIntX_coord();
        yStart = dot1.getIntY_coord();
        xEnd = dot2.getIntX_coord();
        yEnd = dot2.getIntY_coord();
    } // constructor
    
    /**
     * Constructor that takes 4 values. the purpose of this constructor is
     * to take starting point of a line and the end point of a line.
     * @param x1
     * @param y1
     * @param x2
     * @param y2 
     */
    public Lines (int x1, int y1, int x2, int y2)
    {
        xStart = x1;
        yStart = y1;
        xEnd = x2;
        yEnd = y2;
    } // alternative constructor
    
    /**
     * Draws the line using graphics, setting color to the current color of the
     * line object.
     * @param g 
     */
    public void drawLines (Graphics g)
    {
        g.setColor(myColor);
        g.drawLine(getxStart(), getyStart(), getxEnd(), getyEnd());
    } // drawLines

    /**
     * Returns the xStart.
     * @return the xStart
     */
    public int getxStart() {
        return xStart;
    }

    /**
     * @param xStart int xStart to set
     */
    public void setxStart(int xStart) {
        this.xStart = xStart;
    } // setxStart

    /**
     * Returns the yStart.
     * @return the yStart
     */
    public int getyStart() {
        return yStart;
    } // getyStart

    /**
     * @param yStart int yStart to set
     */
    public void setyStart(int yStart) {
        this.yStart = yStart;
    } // setyStart

    /**
     * Returns the xEnd.
     * @return the xEnd
     */
    public int getxEnd() {
        return xEnd;
    } // getxEnd

    /**
     * @param xEnd the xEnd to set
     */
    public void setxEnd(int xEnd) {
        this.xEnd = xEnd;
    } // setxEnd

    /**
     * Returns the yEnd.
     * @return the yEnd
     */
    public int getyEnd() {
        return yEnd;
    } // getyEnd

    /**
     * @param yEnd the yEnd to set
     */
    public void setyEnd(int yEnd) {
        this.yEnd = yEnd;
    } // setyEnd

    /**
     * Returns the myColor.
     * @return the myColor
     */
    public Color getMyColor() {
        return myColor;
    } // getMyColor

    /**
     * @param myColor the myColor to set
     */
    public void setMyColor(Color myColor) {
        if(this.isConnected == false)
        {
            this.myColor = myColor;
        } // if
        this.isConnected = true;
    } // setMyColor

    /**
     * Returns isConnected.
     * @return isConnected
     */
    public boolean isIsConnected() {
        return isConnected;
    } // isIsConnected

    /**
     * @param isConnected the isConnected to set
     */
    public void setIsConnected(boolean isConnected) {
        this.isConnected = isConnected;
    } // setIsConnected
    
} // Lines
