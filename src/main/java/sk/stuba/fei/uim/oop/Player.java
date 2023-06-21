package sk.stuba.fei.uim.oop;

import java.util.Random;

public class Player {
    private int x;
    private int y;

    public Player (int ranX, int ranY)  //int ranX, int ranY
    {
        //Random gen = new Random();

        //int ranX = gen.nextInt(4)+1;
        //int ranY = gen.nextInt(4)+1;
        this.x=ranX;
        this.y=ranY;
    }

    public void setX(int x) {
        this.x = x;
    }
    public int getX(){
        return x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getY()
    {
        return y;
    }
}
