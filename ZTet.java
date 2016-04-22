package tetris;

import java.awt.Point;

public class ZTet extends Tetronimo{
	
	protected static final Point[][] COORDS = { {new Point(0,2), new Point (1,2), new Point(1,1), new Point(2,1)},
								   {new Point(2,2), new Point (2,1), new Point(1,1), new Point(1,0)},
							       {new Point(0,1), new Point (1,1), new Point(1,0), new Point(2,0)},
								   {new Point(0,0), new Point (0,1), new Point(1,1), new Point(1,2)}}; 
			
	protected static final int COLOR = 5;
	
	public ZTet(int[][] grid){
		super(grid,COORDS,COLOR);
	}
}
