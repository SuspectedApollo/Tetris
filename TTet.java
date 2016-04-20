package tetris;

import java.awt.Point;

public class TTet extends Tetronimo {

	protected final Point[][] COORDS = { {new Point(0,1), new Point (1,1), new Point(1,2), new Point(2,1)},
										 {new Point(1,2), new Point (1,1), new Point(2,1), new Point(1,0)},
										 {new Point(2,1), new Point (1,1), new Point(1,0), new Point(0,1)},
										 {new Point(1,0), new Point (1,1), new Point(0,1), new Point(1,2)}};
	
	protected final int COLOR = 3;
	
	private boolean spinValid;	//Whether or not points can be awarded for a T-Spin
	
	
	public TTet(int[][] grid){
		super(grid);
		
		spinValid = false;
	}
	
	//moves tetromino x blocks right and y blocks up after checking if move is valid
	//Override:Adds assignment to set spinValid to false after a successful move
	protected boolean move(int x, int y){
		if(!checkMove(x,y)){
			return false;
		}else{
			wipe();
			home.move(x, y);
			draw();
			spinValid = false;
			return true;
		}
	}
	
	//rotates the tetronimo 90 degrees
	//Override:Adds assignment to set spinValid to true for a successful rotate
	public boolean rotate(){
		wipe();															//clear current position
		orient = (orient + 1) % COORDS.length;							//advance orientation
		if(!checkMove(0,0)){											//if current position has collisions
			orient = (orient + (COORDS.length - 1)) % COORDS.length;	//move orientation back one
			draw();														//draw old position
			return false;
		}else
			draw();				//draw new position
			spinValid = true; 	//last successful move was a rotate
			return true;
	}
	
	//Returns whether or not points can be awarded for a T-Spin
	//Note:should always return false except for T-Tetromino
	//Override:Can return true in the case that the last successful
	//	move was a rotate and 3 of 4 diagonally adjacent blocks are filled 
	public boolean checkTSpin(){
		if(home.x < 0 || home.x > 8 || home.y < 0 || home.y > 20)	//if the check would be out of bounds
			return false;											//return false
		
		int count = 0;
		
		if(grid[home.x][home.y] != 0)			// 
			count++;							//
		if(grid[home.x + 2][home.y] != 0)		//
			count++;							//
		if(grid[home.x][home.y + 2] != 0)		//Increments count for each diagonally adjacent block that is filled
			count++;							//
		if(grid[home.x + 2][home.y + 2] != 0)	//
			count++;							//
		
		return spinValid && count >= 3;	//rotate was the last move AND three of four diagonally adjacent blocks are filled

	}
}
