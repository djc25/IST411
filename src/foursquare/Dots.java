/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DRACOX
 */
import java.awt.*;
public class Dots {
    
    private static final int DIAMTR = 10;
    private int intX_coord;
    private int intY_coord;
    
    public Dots(int x, int y)
    {
        intX_coord = x;
        intY_coord = y;
        
        
    }
    
    
    public void createDot(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillOval(intX_coord, intY_coord, DIAMTR, DIAMTR);
        
        
    }

    /**
     * @return the myDot
     */

    /**
     * @param myDot the myDot to set
     */
 

    /**
     * @return the intX_coord
     */
    public int getIntX_coord() {
        return intX_coord;
    }

    /**
     * @param intX_coord the intX_coord to set
     */
    public void setIntX_coord(int intX_coord) {
        this.intX_coord = intX_coord;
    }

    /**
     * @return the intY_coord
     */
    public int getIntY_coord() {
        return intY_coord;
    }

    /**
     * @param intY_coord the intY_coord to set
     */
    public void setIntY_coord(int intY_coord) {
        this.intY_coord = intY_coord;
    }
    
    
}
