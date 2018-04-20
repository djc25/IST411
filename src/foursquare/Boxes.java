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
 */
public class Boxes {
    
    private boolean top;
    private boolean bot;
    private boolean left;
    private boolean right;
    private boolean closeMe = false;
    private Lines topLine;
    private Lines botLine;
    private Lines leftLine;
    private Lines rightLine;
    
    public Boxes()
    {
        top = bot = left = right = false;
    }

    /**
     * @return the top
     */
    public boolean isTop() {
        return top;
    }

    /**
     * @param top the top to set
     */
    public void setTop(boolean top) {
        this.top = top;
    }

    /**
     * @return the bot
     */
    public boolean isBot() {
        return bot;
    }

    /**
     * @param bot the bot to set
     */
    public void setBot(boolean bot) {
        this.bot = bot;
    }

    /**
     * @return the left
     */
    public boolean isLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(boolean left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public boolean isRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(boolean right) {
        this.right = right;
    }

    /**
     * @return the topLine
     */
    public Lines getTopLine() {
        return topLine;
    }

    /**
     * @param topLine the topLine to set
     */
    public void setTopLine(Lines topLine) {
        this.topLine = topLine;
    }

    /**
     * @return the botLine
     */
    public Lines getBotLine() {
        return botLine;
    }

    /**
     * @param botLine the botLine to set
     */
    public void setBotLine(Lines botLine) {
        this.botLine = botLine;
    }

    /**
     * @return the leftLine
     */
    public Lines getLeftLine() {
        return leftLine;
    }

    /**
     * @param leftLine the leftLine to set
     */
    public void setLeftLine(Lines leftLine) {
        this.leftLine = leftLine;
    }

    /**
     * @return the rightLine
     */
    public Lines getRightLine() {
        return rightLine;
    }

    /**
     * @param rightLine the rightLine to set
     */
    public void setRightLine(Lines rightLine) {
        this.rightLine = rightLine;
    }
    public boolean getClosed()
    {
        return this.closeMe;
    }
    
    public void isClosed(Graphics g)
    {
        
        if(topLine.isIsConnected()&&botLine.isIsConnected()&&leftLine.isIsConnected()&&rightLine.isIsConnected())
        {
            g.fillRect(topLine.getxStart(), topLine.getyStart(), 100, 100);
            closeMe =true;
            
        }
        else
        {
            closeMe = false;
        }
    }
    
    
}
