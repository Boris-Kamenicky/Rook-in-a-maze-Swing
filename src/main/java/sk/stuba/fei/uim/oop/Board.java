package sk.stuba.fei.uim.oop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Board {
    private int size;
    private Tile[][] board;
    private int ranX2;
    private int ranY2;

    public Board(int size) {
        this.size=size;
        this.board = new Tile[size][size];
        fillBoard();
    }

    private void fillBoard() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                this.board[i][j] = new Tile();

        Random rand = new Random();
        // r for row、c for column
        // Generate random r
        int r = rand.nextInt(size);
        while (r % 2 == 0) {
            r = rand.nextInt(size);
        }
        // Generate random c
        int c = rand.nextInt(size);
        while (c % 2 == 0) {
            c = rand.nextInt(size);
        }
        board[r][c].setValue(0);
        recursion(r, c);

        Random gen = new Random();
        int ranX=0;
        int ranY=0;
        do {
            ranX = gen.nextInt(4)+10;
            ranY = gen.nextInt(4)+10;
        }while (board[ranX][ranY].getValue()==1);
        board[ranX][ranY].setValue(2); //finish

        ranX2 = gen.nextInt(4)+1;
        ranY2 = gen.nextInt(4)+1;
        board[ranX2][ranY2].setValue(3); //start

    }

    public Integer[] generateRandomDirections() {
        ArrayList<Integer> randoms = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++)
            randoms.add(i + 1);
        Collections.shuffle(randoms);
        return randoms.toArray(new Integer[4]);
    }

    public void recursion(int r, int c) {
        // 4 random directions
        Integer[] randDirs = generateRandomDirections();
        // Examine each direction
        for (int i = 0; i < randDirs.length; i++) {

            switch(randDirs[i]){
                case 1: // Up
                    //　Whether 2 cells up is out or not
                    if (r - 2 <= 0)
                        continue;
                    if (board[r - 2][c].getValue()!=0 ) {
                        board[r-2][c].setValue(0);
                        board[r-1][c].setValue(0);
                        recursion(r - 2, c);
                    }
                    break;
                case 2: // Right
                    // Whether 2 cells to the right is out or not
                    if (c + 2 >= size - 1)
                        continue;
                    if (board[r][c + 2].getValue() !=0) {
                        board[r][c + 2].setValue(0);
                        board[r][c + 1].setValue(0);
                        recursion(r, c + 2);
                    }
                    break;
                case 3: // Down
                    // Whether 2 cells down is out or not
                    if (r + 2 >= size - 1)
                        continue;
                    if (board[r + 2][c].getValue()!= 0) {
                        board[r+2][c].setValue(0);
                        board[r+1][c].setValue(0);
                        recursion(r + 2, c);
                    }
                    break;
                case 4: // Left
                    // Whether 2 cells to the left is out or not
                    if (c - 2 <= 0)
                        continue;
                    if (board[r][c - 2].getValue() != 0) {
                        board[r][c - 2].setValue(0);
                        board[r][c - 1].setValue(0);
                        recursion(r, c - 2);
                    }
                    break;
            }
        }

    }

    public Tile getTile(int x, int y) {
        return this.board[x][y];
    }

    public int getStartX() {
        return this.ranX2;
    }
    public int getStartY() {
        return this.ranY2;
    }
}
