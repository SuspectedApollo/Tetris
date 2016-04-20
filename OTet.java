package tetris;

import java.awt.Point;

public class OTet extends Tetronimo {

	protected final Point[][] COORDS = { {new Point(1,0), new Point (1,1), new Point(2,0), new Point(2,1)}};
	protected final int COLOR = 2;
	
	public OTet(int[][] grid){
		super(grid);
	}
}
