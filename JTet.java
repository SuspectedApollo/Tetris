package tetris;

import java.awt.Point;

public class JTet extends Tetromino {

	protected Point[][] COORDS = {{new Point(0,2), new Point (0,1), new Point(1,1), new Point(2,1)},
								  {new Point(2,2), new Point (1,2), new Point(1,1), new Point(1,0)},
							      {new Point(2,0), new Point (2,1), new Point(1,1), new Point(0,1)},
								  {new Point(0,0), new Point (1,0), new Point(1,1), new Point(1,2)}};
	protected final int COLOR = 6;

	
	public JTet(int[][] grid){
		super(grid, COORDS, COLOR);
	}
}
