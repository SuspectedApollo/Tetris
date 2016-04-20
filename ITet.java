package tetris;

import java.awt.Point;

public class ITet extends Tetronimo {

	protected final Point[][] COORDS  = { {new Point(0,2), new Point (1,2), new Point(2,2), new Point(3,2)},
										  {new Point(2,3), new Point (2,2), new Point(2,1), new Point(2,0)},
										  {new Point(3,1), new Point (2,1), new Point(1,1), new Point(0,1)},
										  {new Point(1,0), new Point (1,1), new Point(1,2), new Point(1,3)}};
								
	public ITet(int[][] grid){
		super(grid);
		home.setLocation(3, 18);	//Due to its size, I Tetronimo must have home start one lower
	}
}
