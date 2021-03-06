package tetris;

import java.awt.Point;

public class STet extends Tetromino{
	
	protected Point[][] COORDS = { {new Point(0,1), new Point (1,1), new Point(1,2), new Point(2,2)},
								   {new Point(2,0), new Point (2,1), new Point(1,1), new Point(1,2)},
							       {new Point(0,0), new Point (1,0), new Point(1,1), new Point(2,1)},
								   {new Point(1,0), new Point (1,1), new Point(0,1), new Point(0,2)}}; 
			
	protected int COLOR = 4;
	
	public STet(int[][] grid){
		super(grid, COORDS, COLOR);
	}
}
