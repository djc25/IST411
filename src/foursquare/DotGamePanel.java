
package foursquare;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
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
    ArrayList<Dots> myDots = new ArrayList();
    ArrayList<Lines> myLines = new ArrayList();
    @Override
    public void paintComponent(Graphics g){
        for(int i = 0; i< myDots.size(); i++)
        {
            myDots.get(i).createDot(g);
            
        }
        for(int i = 0; i< myLines.size(); i++)
        {
            myLines.get(i).drawLines(g);
            
        }
    }
    
    public DotGamePanel() {
        initComponents();
        Handlerclass mouseHandler = new Handlerclass();
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
       
        /* for loop to create grid of dots*/
        for(int i = 100; i < 600; i = i+100)
        {
            for(int j = 100; j < 600; j = j+100)
            {
                Dots myDot = new Dots(i,j);
                myDots.add(myDot);
               // System.out.println(i + " " +j);
            }
        }
        
        
        System.out.println(sqrt(myDots.size()));
        /* Below are two for loops to create the board of lines
            the first for loop creates vertical lines while the second creates
            Horizontal lines
        */
        for (int i = 0; i< sqrt(myDots.size()); i++)
        {
            for (int j = 0; j<sqrt(myDots.size())-1; j++)
            {
                int index = (int) (j + i*sqrt(myDots.size()));
                System.out.println(index);
                Lines myLine = new Lines(myDots.get(index), myDots.get(index +1));
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
        
        
        
        
    }
    private class Handlerclass implements MouseListener, MouseMotionListener
    {
        public void mouseClicked(MouseEvent event){
            System.out.println(String.format("Clicked at %d,%d", event.getX() , event.getY() ));
            /*if (myLines.get(0).getxStart()==myLines.get(0).getxEnd())
                {
                   if((event.getX()< myLines.get(1).getxStart() + 20)&&(event.getX()> myLines.get(0).getxStart() - 20)
                           && (event.getY()> (myLines.get(0).getyStart()))
                           && (event.getY()< (myLines.get(0).getyEnd()))
                           /*&&(event.getY()> (myLines.get(i).getyEnd()-20))
                           &&(event.getY()< (myLines.get(i).getyEnd()+20)))
                       counter++;
                       
                       myLines.get(0).setMyColor(Color.yellow);
                       
                   repaint();
                }*/
            //myLines.get(5).setMyColor(Color.yellow);
            //repaint();
            for(int i = 0; i <myLines.size(); i++)
            {
                if (myLines.get(i).getxStart()==myLines.get(i).getxEnd())
                {
                    if((event.getX()< myLines.get(i).getxStart() + 20)&&(event.getX()> myLines.get(i).getxStart() - 20)
                           && (event.getY()> (myLines.get(i).getyStart()))
                           && (event.getY()< (myLines.get(i).getyEnd())))
                    {       
                            if(counter%2 == 0)
                            {
                                myLines.get(i).setMyColor(Color.red);
                            }
                            else
                            {
                                myLines.get(i).setMyColor(Color.blue);
                            }
                            repaint();
                            counter++;
                    }
                }
                
                else if(myLines.get(i).getyStart()==myLines.get(i).getyEnd())
                {
                    if((event.getY()< myLines.get(i).getyStart() + 20)&&(event.getY()> myLines.get(i).getyStart() - 20)
                           && (event.getX()> (myLines.get(i).getxStart()))
                           && (event.getX()< (myLines.get(i).getxEnd())))
                    {
                       if(counter%2 == 0)
                            {
                                myLines.get(i).setMyColor(Color.red);
                            }
                            else
                            {
                                myLines.get(i).setMyColor(Color.blue);
                            }
                            repaint();
                            counter++;
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
