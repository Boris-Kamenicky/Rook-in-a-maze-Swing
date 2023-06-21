package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.*;
import java.util.ArrayList;


public class Game {
    private Board board;
    public static final int BoardSize=15;

    public Game() {
        this.board = new Board(BoardSize);
        this.startGame();
    }

    private void startGame()
    {
        int win=0;
        JFrame window = new JFrame();
        window.setSize(700,700);
        window.setVisible(true);
        JPanel menuPanel= new JPanel();
        menuPanel.setLayout(new GridLayout(0,3));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Player player= new Player(board.getStartY(), board.getStartX());   //board.startX(), board.startY()
        while (board.getTile(player.getY(), player.getX()).getValue()==1)
        {
            player= new Player(board.getStartY(), board.getStartX());
        }

        MyButton buttonReset = new MyButton("Reset",player,board);
        menuPanel.add(buttonReset);
        MyButton buttonUp = new MyButton("↑",player,board);
        menuPanel.add(buttonUp);
        JLabel text = new JLabel("   Pocet vyhier: "+ win);
        menuPanel.add(text);
        MyButton buttonLeft = new MyButton("←",player,board);
        menuPanel.add(buttonLeft);
        MyButton buttonDown = new MyButton("↓",player,board);
        menuPanel.add(buttonDown);
        MyButton buttonRight = new MyButton("→",player,board);
        menuPanel.add(buttonRight);


        MouseMove mouse= new MouseMove(player,board);

        DrawBoard panelMaze= new DrawBoard(board,player.getX(),player.getY());
        KeyboardMove panelKeyboard= new KeyboardMove(player,board);
        panelKeyboard.setFocusable(true);   //for working keyboard

        panelMaze.addMouseListener(mouse);
        panelMaze.addMouseMotionListener(mouse);

        window.add(panelKeyboard,BorderLayout.SOUTH);
        window.add(panelMaze,BorderLayout.CENTER);
        window.add(menuPanel,BorderLayout.NORTH);



        while(win!=20)
        {
            if(win>=1 || buttonReset.getIsReset()==1)
            {
                this.board=new Board(BoardSize);
            }
            player= new Player(board.getStartY(), board.getStartX());
            while (board.getTile(player.getY(), player.getX()).getValue()==1)
            {
                player= new Player(board.getStartY(), board.getStartX());
            }

            panelKeyboard.change(player,board);
            mouse.change(player,board);

            buttonReset.setIsReset(0);
            buttonReset.setFocusable(false);
            buttonReset.change(player,board);
            buttonDown.setFocusable(false);
            buttonDown.change(player,board);
            buttonUp.setFocusable(false);
            buttonUp.change(player,board);
            buttonLeft.setFocusable(false);
            buttonLeft.change(player,board);
            buttonRight.setFocusable(false);
            buttonRight.change(player,board);


            text.setText("   Pocet vyhier: "+ win);

            while(true)
            {
                panelMaze.change(player.getX(),player.getY(),board);
                panelMaze.repaint();
                window.repaint();
                if(board.getTile(player.getY(), player.getX()).getValue()==2)
                {
                    win=win+1;
                    break ;
                }
                if (buttonReset.getIsReset()==1)
                {
                    win=0;
                    break;
                }
            }
        }
    }
}
