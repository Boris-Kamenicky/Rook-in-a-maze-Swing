package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButton extends JButton implements ActionListener {

    private Player player;
    private Board maze;
    private int isReset;
    public MyButton(String label, Player player, Board maze)
    {
        super(label);
        this.player=player;
        this.maze=maze;
        this.isReset=0;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        this.setFocusable(false);
        if (getActionCommand().equals("↓"))
        {
            if(maze.getTile(player.getY()+1,player.getX()).getValue()!=1)
                player.setY(player.getY()+1);
        }
        if(getActionCommand().equals("→"))
        {
            if(maze.getTile( player.getY(),player.getX()+1).getValue()!=1)
                player.setX(player.getX()+1);
        }
        if(getActionCommand().equals("←"))
        {
            if(maze.getTile(player.getY(),player.getX()-1).getValue()!=1)
                player.setX(player.getX()-1);
        }
        if(getActionCommand().equals("↑"))
        {
            if(maze.getTile(player.getY()-1,player.getX()).getValue()!=1)
                player.setY(player.getY()-1);
        }
        if(getActionCommand().equals("Reset"))
        {
            setIsReset(1);
        }

    }

    public void change(Player player, Board board)
    {
        this.player=player;
        this.maze=board;

    }

    public int getIsReset()
    {
        return isReset;
    }

    public void setIsReset (int isReset)
    {
        this.isReset=isReset;
    }
}
