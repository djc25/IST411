
package foursquare;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DRACOX, JSS5783
 * 
 * 
 * ----------[CHANGELOG]----------
 * 2018/05/01 -     Match complete check updates in paintComponent(Graphics g), but the code to complete the match is now in mouseClicked(MouseEvent event). -JSS5783
 * 
 * 2018/05/01 -     Added scoring, updated colors, and added match complete check. -JSS5783
 * 
 * 2018/05/01 -     Updated game logic to taking extra turns if box is closed. -DQH5300
 * 
 * 2018/04/30 -     Added setMatch(Match inMatch), getMatch(), and match1, though they still need to be fully implemented. -JSS5783
 * 
 */
public class DotGamePanel extends javax.swing.JPanel
{

    /**
     * Creates new form DotGamePanel
     */
    int counter = 0;
    int sqrtOfList;
    boolean player;
    Color currColor;
    ArrayList<Dots> myDots = new ArrayList();
    ArrayList<Lines> myLines = new ArrayList();
    ArrayList<Boxes> myBoxes = new ArrayList();
    Match match1;
    boolean bIsMatchComplete = false;
    
    
    @Override
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        bIsMatchComplete = true;    //testing for false
        
//        match1.setPlayer1Score(0);
//        match1.setPlayer2Score(0);
        for(int i = 0; i< myLines.size(); i++)
        {
            
            myLines.get(i).drawLines(g);
            
        }
        for(int i = 0; i<myBoxes.size();i++)
        {
            myBoxes.get(i).isClosed();
            if(myBoxes.get(i).getClosed() == true && myBoxes.get(i).getMyColor() == null)
            {
                if ((match1.getWhoseTurn() == Match.PLAYER_2_TURN) )    //increment player 1's points (already switched to player 2's turn here)
                {
                    match1.setPlayer1Score(match1.getPlayer1Score() + 1);
                    match1.setWhoseTurn(Match.PLAYER_1_TURN);
                }
                else
                {
                    match1.setPlayer2Score(match1.getPlayer2Score() + 1);   //increment player 2's points (already switched to player 1's turn here)
                    match1.setWhoseTurn(Match.PLAYER_2_TURN);
                }
//                if (myBoxes.get(i).getMyColor() == PVar.PLAYER_1_COLOR )
//                {
//                    match1.setPlayer1Score(match1.getPlayer1Score() + 1);
//                }
//                else if (myBoxes.get(i).getMyColor() == PVar.PLAYER_2_COLOR)
//                {
//                    match1.setPlayer2Score(match1.getPlayer2Score() + 1);
//                }
            }
            else if (myBoxes.get(i).getClosed() == false && myBoxes.get(i).getMyColor() == null)
            {
                bIsMatchComplete = false;   //at least one empty box
            }
            if(myBoxes.get(i).getClosed() == true)
            {
                myBoxes.get(i).setMyColor(currColor);
//                if (currColor == PVar.PLAYER_1_COLOR)   //count boxes of each color (each player)
//                {
//                    match1.setPlayer1Score(match1.getPlayer1Score() + 1);
//                }
//                else if (currColor == PVar.PLAYER_2_COLOR)
//                {
//                    match1.setPlayer2Score(match1.getPlayer2Score() + 1);
//                }
                myBoxes.get(i).drawBox(g);
                
//                if ((match1.getWhoseTurn() == Match.PLAYER_1_TURN) )    //made box; increment current player's score
//                {
//                    match1.setPlayer1Score(match1.getPlayer1Score() + 1);
//                    jfClient.updateLabels();
//                }
//                else
//                {
//                    match1.setPlayer2Score(match1.getPlayer2Score() + 1);
//                    jfClient.updateLabels();
//                    
//                }
//                repaint();
                
            }
            
            
            
        }
        
        for(int i = 0; i< myDots.size(); i++)
        {
            myDots.get(i).createDot(g);
            
        }
        
        jfClient.updateLabels();    //then update score
//        if (bIsMatchComplete == true)
//        {
//            if (match1.getPlayer1Score() > match1.getPlayer2Score() )
//            {
//                JOptionPane.showMessageDialog(null, "Player 1 wins!");
//            }
//            else if (match1.getPlayer1Score() < match1.getPlayer2Score() )
//            {
//                JOptionPane.showMessageDialog(null, "Player 2 wins!");
//            }
//            else if (match1.getPlayer1Score() == match1.getPlayer2Score() )
//            {
//                JOptionPane.showMessageDialog(null, "Neither player wins. It's a draw!");
//            }
//            jfClient.nextCard();
            
            
//            //TODO: from Queries test
//            // Get connection from SQLiteConnection
//            try
//            {
//        Connection connect;
//        SQLiteConnection sc;
//        sc = new SQLiteConnection();
//        connect = sc.getConnection();
//        
//        // Initialize output
//        ResultSet top10;
//        ResultSet personalRank;
//        int rankLabel;
//
//        // Get queries from connection
//        Queries q;
//        q = new Queries(connect);
//        //q.setEntryInfo("Jackie",45);
//        //q.updateEntryInfo(20);
//        
//        //rankLabel = q.getLastEntryRank();
//        rankLabel = 6; // testing purposes
//        personalRank = q.getLastEntryInfo(rankLabel);
//        
//        top10 = q.getTopTen();
//    
//        // Temporary JFrame, Panel object
//        jpScoreboard panel = new jpScoreboard(top10, personalRank, rankLabel);
//        //jpScoreboard panel = new jpScoreboard();
//
//        JFrame frame = new JFrame();
//        frame.add(panel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setBounds(500, 250, 960, 600);
//        frame.setVisible(true);
//        
//            } catch (SQLException ex) {
//                Logger.getLogger(DotGamePanel.class.getName()).log(Level.SEVERE, null, ex);
//            }
//                    
//        }
    }
    
    public DotGamePanel() {
        initComponents();
        match1 = new Match("Player 1", "Player 2");   //TODO; using as placeholder names
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
//            System.out.println(String.format("Clicked at %d,%d", event.getX() , event.getY() ));

        if (bIsMatchComplete == true)   //have to click once with complete game board to get it to register
        {
            if (match1.getPlayer1Score() > match1.getPlayer2Score() )
            {
                JOptionPane.showMessageDialog(null, "Player 1 wins!");
            }
            else if (match1.getPlayer1Score() < match1.getPlayer2Score() )
            {
                JOptionPane.showMessageDialog(null, "Player 2 wins!");
            }
            else if (match1.getPlayer1Score() == match1.getPlayer2Score() )
            {
                JOptionPane.showMessageDialog(null, "Neither player wins. It's a draw!");
            }
            jfClient.nextCard();
        }
        else
        {
            
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
                            if (match1.getWhoseTurn() == Match.PLAYER_1_TURN )
                            {
                                currColor = PVar.PLAYER_1_COLOR;
                                myLines.get(i).setMyColor(currColor);
//                                try
//                                {
//                                    jfClient.client.sendData(match1);
//                                }
//                                catch (IOException ioe)
//                                {
//                                    System.err.println(ioe.toString() );
//                                }
                                //System.out.println(myLines.get(i).getMyColor());
                            }
                            else
                            {
                                currColor = PVar.PLAYER_2_COLOR;
                                myLines.get(i).setMyColor(currColor);
//                                try
//                                {
//                                    jfClient.client.sendData(match1);
//                                }
//                                catch (IOException ioe)
//                                {
//                                    System.err.println(ioe.toString() );
//                                }
                                //System.out.println(myLines.get(i).getMyColor());
                            }
                            repaint();
                            System.out.println(colorChange(myLines.get(i), prevLine));
                            
                            if(colorChange(myLines.get(i), prevLine))   //if color changed (i.e., turn succeeded), set to other player's turn
                            {
                                if ((match1.getWhoseTurn() == Match.PLAYER_2_TURN) )
                                {
                                    match1.setWhoseTurn(Match.PLAYER_1_TURN);
                                    jfClient.client.sendData(match1);
                                }
                                else
                                {
                                    match1.setWhoseTurn(Match.PLAYER_2_TURN);
                                    jfClient.client.sendData(match1);
                                }
                            }
                    }
                }
                
                else if(myLines.get(i).getyStart()==myLines.get(i).getyEnd())
                {
                    if((event.getY()< myLines.get(i).getyStart() + 20)&&(event.getY()> myLines.get(i).getyStart() - 20)
                           && (event.getX()> (myLines.get(i).getxStart()))
                           && (event.getX()< (myLines.get(i).getxEnd())))
                    {
                            if (match1.getWhoseTurn() == Match.PLAYER_1_TURN )
                            {
                                currColor = PVar.PLAYER_1_COLOR;
                                myLines.get(i).setMyColor(currColor);
                                //System.out.println(myLines.get(i).getMyColor());
                            }
                            else
                            {
                                currColor = PVar.PLAYER_2_COLOR;
                                myLines.get(i).setMyColor(currColor);
                                //System.out.println(myLines.get(i).getMyColor());
                            }
                       
                            repaint();
                            System.out.println(colorChange(myLines.get(i), prevLine));
                            if(colorChange(myLines.get(i), prevLine))
                            {
                                if ((match1.getWhoseTurn() == Match.PLAYER_2_TURN) )
                                {
                                    match1.setWhoseTurn(Match.PLAYER_1_TURN);
                                }
                                else
                                {
                                    match1.setWhoseTurn(Match.PLAYER_2_TURN);
                                }
                            }
                            
                    }
                       
                   
                }
            }
            }
        }
        public void mousePressed(MouseEvent event){
//            System.out.println("mouse pressed");
        }
        public void mouseReleased(MouseEvent event){
//            System.out.println("Mouse Released");
        }
        public void mouseEntered(MouseEvent event){
//            System.out.println("Mouse Entered");
        }
        public void mouseExited(MouseEvent event){
//            System.out.println("Mouse Exited");
        }
        public void mouseDragged(MouseEvent event){
//            System.out.println("Mouse Dragged");
        }
        public void mouseMoved(MouseEvent event){
            //System.out.println("Mouse Moved");
        }
        
        
        
    }
    
    
    
    /**
     * Updates local Match object with passed Match object, and then (due to being a GUI) updates the visuals using the new information.
     * @param inMatch 
     */
    public void setMatch(Match inMatch)
    {
        match1 = inMatch;
        repaint();
    }   //END setMatch(Match inMatch)
    
    
    /**
     * Returns local Match object.
     * @return 
     */
    public Match getMatch()
    {
        return match1;
    }   //END getMatch()
    

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
