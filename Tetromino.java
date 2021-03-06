package tetris;
/**
 * 
 */

/**
 * @author shelt
 *
 */

import java.awt.Point;

public abstract class Tetromino {
	
	protected final Point[][] COORDS;
	protected final int COLOR;
	
	protected Point home;
	protected int[][] grid;
	protected int orient;
	
	protected Tetromino(int[][] grid, Point[][] coords, int color){
		orient = 0;
		home.new Point(3, 19);
		
		this.grid = grid;
		
		this.COORDS = coords;
		this.COLOR = color;
	}
	
	//Moves tetromino 1 left
	public boolean moveLeft(){
		return move(-1, 0);
	}
	
	//Moves tetromino 1 right
	public boolean moveRight(){
		return move(1, 0);
	}
	
	//Moves tetromino 1 down
	public boolean moveDown(){
		return move(0, -1);
	}
	
	//Moves the tetromino as far down as possible
	//Returns the number of rows fallen
	public int drop(){
		int count = 0;
		while(checkMove(0,-(count + 1))){
			count++;
		}
		move(0, -count);
		return count;
	}
	
	//rotates the tetromino 90 degrees
	public boolean rotate(){
		wipe();															//clear current position
		orient = (orient + 1) % COORDS.length;							//advance orientation
		if(!checkMove(0,0)){											//if current position has collisions
			orient = (orient + (COORDS.length - 1)) % COORDS.length;	//move orientation back one
			draw();														//draw old position
			return false;
		}else
			draw();														//draw new position
			return true;
	}
	
	//Clears the piece from the grid and returns the type of block
	public int hold(){
		wipe();
		return COLOR;
	}
	
	//moves tetromino x blocks right and y blocks up after checking if move is valid
	protected boolean move(int x, int y){
		if(!checkMove(x,y)){
			return false;
		}else{
			home.move(home.x + x, home.y + y);
			draw();
			return true;
		}
	}
	
	//checks if there are any collisions for the tetromino moving x squares right and y squares down
	protected boolean checkMove(int x, int y){
		Point[] squares = getAbs();
		wipe()
		for(int i = 0; i < 4; i++){
			if(((int)squares[i].getX() + x) < 0 || (int)squares[i].getX() + x > grid.length			//check that new x coordinate is in grid
				||	((int)squares[i].getY() + y) < 0 || (int)squares[i].getY() + y > grid[0].length	//check that new y coordinate is in grid
				|| 	(grid[(int)squares[i].getX() + x][(int)squares[i].getY() + y]) != 0)//check that new coordinate is empty
				draw();
				return false;
			}
		draw();
		return true;
	}
	
	//Return absolute points for the tetromino's squares
	protected Point[] getAbs(){
			Point[] temp = new Point[4];
			for(int i = 0; i < 4; i++){
				temp[i] = new Point((int)(COORDS[orient][i].getX() + home.getX()), (int)(COORDS[orient][i].getY() + home.getY()));
			}
			return temp;
		}
	
	//Returns whether or not points can be awarded for a T-Spin
	//Note:should always return false except for T-Tetromino
	public boolean checkTSpin(){
		return false;
	}
	
	protected void draw(){
		Point[] squares = getAbs();
		
		for(int i = 0; i < 4; i++){
			grid[(int)squares[i].getX()][(int)squares[i].getY()] = COLOR;
		}
	}
	
	protected void wipe(){
		Point[] squares = getAbs();
		
		for(int i = 0; i < 4; i++){
			grid[(int)squares[i].getX()][(int)squares[i].getY()] = 0;
		}
	}
}

