package sk.stuba.fei.uim.oop;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyboardMove extends JPanel implements KeyListener {
    private Player player;
    private Board board;

    public KeyboardMove(Player player, Board board){
        addKeyListener(this);
        this.player=player;
        this.board=board;

    }

    public void keyPressed (KeyEvent e)
    {
        if (e.getKeyCode()==38) //up
        {
            if(board.getTile(player.getY()-1,player.getX()).getValue()!=1)
                player.setY(player.getY()-1);
        }

        if (e.getKeyCode()==37) //left
        {
            if(board.getTile(player.getY(),player.getX()-1).getValue()!=1)
                player.setX(player.getX()-1);
        }

        if (e.getKeyCode()==39)
        {
            if(board.getTile( player.getY(),player.getX()+1).getValue()!=1)
                player.setX(player.getX()+1);
        }

        if (e.getKeyCode()==40)
        {
            if(board.getTile(player.getY()+1,player.getX()).getValue()!=1)
                player.setY(player.getY()+1);
        }

    }
    public void keyReleased (KeyEvent e){}
    public void keyTyped (KeyEvent e){}


    public void change (Player player, Board board)
    {
        this.player=player;
        this.board=board;
    }
}
