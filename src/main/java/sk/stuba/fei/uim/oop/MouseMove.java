package sk.stuba.fei.uim.oop;

import javax.management.loading.PrivateMLet;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseMove extends Canvas implements MouseListener, MouseMotionListener {

    private Player player;
    private Board board;

    public MouseMove(Player player, Board board)
    {
        addMouseListener(this);
        addMouseMotionListener(this);
        this.player=player;
        this.board=board;
    }
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseDragged(MouseEvent e){}

    public void mouseClicked(MouseEvent e)
    {
        if (   (e.getX()>=(player.getX()*25+175-25+player.getX()) && e.getX()<=(player.getX()*25+175+player.getX())) &&
                (e.getY()>=(player.getY()*25+125-25+player.getY()-25) && e.getY()<=(player.getY()*25+125+player.getY())-25))
        {
            if(board.getTile(player.getY()-1,player.getX()).getValue()!=1)
                player.setY(player.getY()-1);
        }

        if (   (e.getX()>=(player.getX()*25+175-25+player.getX()-25) && e.getX()<=(player.getX()*25+175+player.getX())-25) &&
                (e.getY()>=(player.getY()*25+125-25+player.getY()) && e.getY()<=(player.getY()*25+125+player.getY()))) //left
        {
            if(board.getTile(player.getY(),player.getX()-1).getValue()!=1)
                player.setX(player.getX()-1);
        }

        if (   (e.getX()>=(player.getX()*25+175-25+player.getX()+25) && e.getX()<=(player.getX()*25+175+player.getX())+25) &&
                (e.getY()>=(player.getY()*25+125-25+player.getY()) && e.getY()<=(player.getY()*25+125+player.getY())))
        {
            if(board.getTile( player.getY(),player.getX()+1).getValue()!=1)
                player.setX(player.getX()+1);
        }

        if (   (e.getX()>=(player.getX()*25+175-25+player.getX()) && e.getX()<=(player.getX()*25+175+player.getX())) &&
                (e.getY()>=(player.getY()*25+125-25+player.getY()+25) && e.getY()<=(player.getY()*25+125+player.getY())+25))
        {
            if(board.getTile(player.getY()+1,player.getX()).getValue()!=1)
                player.setY(player.getY()+1);
        }

    }
    public void mouseMoved(MouseEvent e)
    {
        //System.out.println(e.getX() + " " + e.getY());
    }

    public void change (Player player, Board board)
    {
        this.player=player;
        this.board=board;
    }
}
