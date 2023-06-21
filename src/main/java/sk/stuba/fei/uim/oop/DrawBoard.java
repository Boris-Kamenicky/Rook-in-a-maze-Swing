package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class DrawBoard extends JPanel {
    private Board maze;
    public static final int BoardSize=15;
    private int playerX;
    private int playerY;

    public Dimension getPreferredSize() {
        return new Dimension(400,400);
    }

    public DrawBoard(Board maze,int xP, int yP)
    {
        this.maze=maze;
        this.playerX=xP;
        this.playerY=yP;

    }

    public void paint(Graphics g){
        int j=0,x=150,y=100;
        for (int i = 0; i < BoardSize; i++) {
            if (maze.getTile(i, j).getValue() == 1) {
                g.setColor(Color.BLACK);
                g.fillRect(x, y, 25, 25);
            }
            else if(maze.getTile(i, j).getValue() == 2) {
                g.setColor(Color.RED);
                g.fillRect(x, y, 25, 25);
            }
            else if(maze.getTile(i,j).getValue()==3)
            {
                g.setColor(Color.GREEN);
                g.fillRect(x, y, 25, 25);
            }
            else {
                g.setColor(Color.WHITE);
                g.fillRect(x, y, 25, 25);
            }

            for (j = 0; j < BoardSize; j++) {
                if (maze.getTile(i, j).getValue() == 1) {
                    g.setColor(Color.BLACK);
                    g.fillRect(x, y, 25, 25);
                }
                else if(maze.getTile(i, j).getValue() == 2) {
                    g.setColor(Color.RED);
                    g.fillRect(x, y, 25, 25);
                }
                else if(maze.getTile(i,j).getValue()==3)
                {
                    g.setColor(Color.GREEN);
                    g.fillRect(x, y, 25, 25);
                }
                else {
                    g.setColor(Color.WHITE);
                    g.fillRect(x, y, 25, 25);
                }
                x=x+26; // move square
            }
            x=150;
            y=y+26;
            j = 0;
        }
        g.setColor(Color.YELLOW);  //draw player
        g.fillRect(playerX*26+150, playerY*26+ 100, 25, 25);
    }

    public void change(int playerX , int playerY, Board maze)
    {
        this.playerY=playerY;
        this.playerX=playerX;
        this.maze=maze;
        repaint();
    }

}
