
package foursquare;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.ArrayList;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DRACOX
 */
public class DotGamePanel extends javax.swing.JPanel {

    /**
     * Creates new form DotGamePanel
     */
    int counter = 0;
    int sqrtOfList;
    boolean player;
    ArrayList<Dots> myDots = new ArrayList();
    ArrayList<Lines> myLines = new ArrayList();
    ArrayList<Boxes> myBoxes = new ArrayList();
    @Override
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        for(int i = 0; i< myLines.size(); i++)
        {
            myLines.get(i).drawLines(g);
            
        }
        for(int i = 0; i<myBoxes.size();i++)
        {
            myBoxes.get(i).isClosed();
            if(myBoxes.get(i).getClosed() == true)
            {
                myBoxes.get(i).drawBox(g);
            }
            else{
            if(player)
                myBoxes.get(i).setMyColor(Color.RED);
            
            else{
                myBoxes.get(i).setMyColor(Color.BLUE);
            
            }
            //myBoxes.get(i).isClosed();
        }
        }
        for(int i = 0; i< myDots.size(); i++)
        {
            myDots.get(i).createDot(g);
            
        }
    }
    
    public DotGamePanel() {
        initComponents();
        Handlerclass mouseHandler = new Handlerclass();
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
       
        /* for loop to create grid of dots*/
        for(int i = 50; i < 400; i = i+100)
        {
            for(int j = 50; j < 400; j = j+100)
            {
                Dots myDot = new Dots(i,j);
                myDots.add(myDot);
               // System.out.println(i + " " +j);
            }
           
            
        }
         sqrtOfList = (int) sqrt(myDots.size());
       /*VERTICAL LINES*/
        for (int i = 0; i< sqrtOfList; i++)
        {
            for (int j = 0; j<sqrtOfList-1; j++)
            {
                int index = (int) (j + i*sqrtOfList);
                //System.out.println(index);
                Lines myLine = new Lines(myDots.get(index), myDots.get(index +1));
                myLines.add(myLine);
            }
        }
        
        
       
         /*HORIZONTAL LINES*/
        for (int i = 0; i< sqrtOfList; i++)
        {
            for (int j = 0; j<sqrtOfList-1; j++)
            {
                int index1 = (int) (j*sqrtOfList+i);
                int index2 = (int) ((j+1)*sqrtOfList+i);
                //System.out.println(index);
                Lines myLine = new Lines(myDots.get(index1), myDots.get(index2));
                myLines.add(myLine);
            }
        }
        
        for (int i = 0; i< sqrt(myDots.size()); i++)
        {
            for (int j = 0; j<sqrt(myDots.size())-1; j++)
            {
                int index1 = (int) (j*sqrt(myDots.size())+i);
                int index2 = (int) ((j+1)*sqrt(myDots.size())+i);
                //System.out.println(index);
                Lines myLine = new Lines(myDots.get(index1), myDots.get(index2));
                myLines.add(myLine);
            }
        }
        
        /*BOXES*/
        for(int i = 0; i<pow(sqrtOfList-1,2);i++)
        {
            Boxes myBox = new Boxes();
            myBox.setLeftLine(myLines.get(i));
            myBox.setRightLine(myLines.get(i+(sqrtOfList-1)));
            myBoxes.add(myBox);
        }
        for(int i = 0; i<sqrtOfList-1; i++)
        {
            
            for(int j = 0; j<sqrtOfList -1; j++)
            {
               myBoxes.get(i+j*(sqrtOfList-1)).setTopLine(myLines.get(i*(sqrtOfList-1)+j+sqrtOfList*(sqrtOfList-1)));
               myBoxes.get(i+j*(sqrtOfList-1)).setBotLine(myLines.get((i+1)*(sqrtOfList-1)+j+sqrtOfList*(sqrtOfList-1)));
            }
        }
        
        
        
        
    }
    public boolean colorChange (Lines line1, Lines line2)
    {
        return line1.getMyColor() != line2.getMyColor();
    }
    
    private class Handlerclass implements MouseListener, MouseMotionListener
    {
        public void mouseClicked(MouseEvent event){
            System.out.println(String.format("Clicked at %d,%d", event.getX() , event.getY() ));
            
            for(int i = 0; i <myLines.size(); i++)
            {
                Lines prevLine = new Lines(myLines.get(i).getxStart(),myLines.get(i).getyStart(),
                myLines.get(i).getxEnd(),
                myLines.get(i).getyEnd());
                prevLine.setMyColor(myLines.get(i).getMyColor());
                if (myLines.get(i).getxStart()==myLines.get(i).getxEnd())
                {
                    if((event.getX()< myLines.get(i).getxStart() + 20)&&(event.getX()> myLines.get(i).getxStart() - 20)
                           && (event.getY()> (myLines.get(i).getyStart()))
                           && (event.getY()< (myLines.get(i).getyEnd())))
                    {       
                            if(player)
                            {
                                myLines.get(i).setMyColor(Color.red);
                                //System.out.println(myLines.get(i).getMyColor());
                            }
                            else
                            {
                                myLines.get(i).setMyColor(Color.blue);
                                //System.out.println(myLines.get(i).getMyColor());
                            }
                            repaint();
                            System.out.println(colorChange(myLines.get(i), prevLine));
                            if(colorChange(myLines.get(i), prevLine))
                            {
                                player = !player;
                            }
                    }
                }
                
                else if(myLines.get(i).getyStart()==myLines.get(i).getyEnd())
                {
                    if((event.getY()< myLines.get(i).getyStart() + 20)&&(event.getY()> myLines.get(i).getyStart() - 20)
                           && (event.getX()> (myLines.get(i).getxStart()))
                           && (event.getX()< (myLines.get(i).getxEnd())))
                    {
                       if(player)
                            {
                                myLines.get(i).setMyColor(Color.red);
                            }
                            else
                            {
                                myLines.get(i).setMyColor(Color.blue);
                            }
                       
                            repaint();
                            System.out.println(colorChange(myLines.get(i), prevLine));
                            if(colorChange(myLines.get(i), prevLine))
                            {
                                player = !player;
                            }
                            
                    }
                       
                   
                }
            }
        }
        public void mousePressed(MouseEvent event){
            System.out.println("mouse pressed");
        }
        public void mouseReleased(MouseEvent event){
            System.out.println("Mouse Released");
        }
        public void mouseEntered(MouseEvent event){
            System.out.println("Mouse Entered");
        }
        public void mouseExited(MouseEvent event){
            System.out.println("Mouse Exited");
        }
        public void mouseDragged(MouseEvent event){
            System.out.println("Mouse Dragged");
        }
        public void mouseMoved(MouseEvent event){
            //System.out.println("Mouse Moved");
        }
        
        
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
