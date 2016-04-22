package tetris;

import java.awt.Point;

public class OTet extends Tetronimo {

	protected static final Point[][] COORDS = { {new Point(1,0), new Point (1,1), new Point(2,0), new Point(2,1)}};
	protected static final int COLOR = 2;
	
	public OTet(int[][] grid){
		super(grid, COORDS, COLOR);
	}
}
