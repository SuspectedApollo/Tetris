package tetris;

import java.util.Scanner;

public class TetrisTester {

	public static void main(String[] args){
		System.out.println("THIS SHOULD PRINT");
		Scanner scan = new Scanner(System.in);
		
		int[][] grid = new int[10][22];
		
		printGrid(grid);
		
		Tetronimo tet;
		boolean out = false;
		while(true){
			out = false;
			switch((int)((Math.random() * 7) + 1)){
				case 1:
					tet = new ITet(grid);
					break;
				case 2:
					tet = new OTet(grid);
					break;
				case 3:
					tet = new TTet(grid);
					break;
				case 4:
					tet = new STet(grid);
					break;
				case 5:
					tet = new ZTet(grid);
					break;
				case 6:
					tet = new LTet(grid);
					break;
				default:
					tet = new JTet(grid);
					break;
			}
			while(!out){
				switch(scan.next()){
					case "l":
					case "L":
						tet.moveLeft();
						break;
					case "r":
					case "R":
						tet.moveRight();
						break;
					case "d":
					case "D":
						tet.moveDown();
						break;
					case "h":
					case "H":
						tet.drop();
						break;
					case "u":
					case "U":
						tet.rotate();
						break;
					case "k":
					case "K":
						out = true;
						break;
				}
				printGrid(grid);
			}
			printGrid(grid);
		}
	}
	
	private static void printGrid(int[][] grid){
		for(int i = grid[0].length - 1; i >= 0; i--){
			for(int j = 0; j < grid.length; j++){
				System.out.print(grid[j][i]);
			}
			System.out.println();
		}
	}
}
