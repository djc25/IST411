
package foursquare;

import java.awt.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DRACOX
 */
public class Lines {
    
    private int xStart;
    private int yStart;
    private int xEnd;
    private int yEnd;
    private Color myColor = Color.BLACK;
    private boolean isConnected = false;
    
    public Lines (Dots dot1, Dots dot2)
    {
        xStart = dot1.getIntX_coord();
        yStart = dot1.getIntY_coord();
        xEnd = dot2.getIntX_coord();
        yEnd = dot2.getIntY_coord();
        
    }
    public void drawLines (Graphics g)
    {
        g.setColor(myColor);
        g.drawLine(xStart, yStart, xEnd, yEnd);
    }
    
}
