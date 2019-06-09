import java.util.*;

/* Grid is represented by a matrix: 1 == cell blocked
									0 == cell free
*/
public class Sol{
	private ArrayList<Point> path;
	private	int endRowI;
	private int endColI;
	private int pathPos;

	public void printGrid(int[][] grid){
		for (int i = 0; i < grid.length; i++){
			for (int j = 0; j < grid[0].length; j++){
				System.out.print(grid[i][j] + " ");	
			}
			System.out.println();
		}
	}

	public void printPath(ArrayList<Point> path){
		Point p = path.get(pathPos - 1);
		System.out.println(p.rowI + " " + p.colI);	
		if ((p.rowI != endRowI) || (p.colI != endColI)){
			System.out.print("\n Couldn't find a path to destination: ");
		}else{
			System.out.print("\n Solution path:");
		}

		for (Point x : path){
			System.out.print(x);
		}
	}
	
	
	private void findPath(int[][] grid, int rowI, int colI){
		pathPos++;

		if ((rowI == endRowI) &&
			(colI == endColI)){ //arrived at Destination
			return ;
		}

		//right
		if ((colI + 1 <= endColI) && (grid[rowI][colI + 1] == 0)){
			Point p = new Point(rowI, colI + 1);
			path.set(pathPos, p);
			findPath(grid, rowI, colI+1);
		}

		//down
		if ((rowI + 1 <= endRowI) && (grid[rowI+1][colI] == 0)){
			Point p = new Point(rowI + 1, colI);
			path.set(pathPos, p);
		   	findPath(grid, rowI+1, colI);
		}else{
			pathPos--;
		}
	}

	public ArrayList<Point> findPath(int[][] grid){
			endRowI = grid.length-1;
			endColI = grid[0].length - 1;

			//create an ArrayList so big that it can store the longest path possible;
			int arrSize = grid.length + grid[0].length - 1;
			Point non = new Point(-1, -1);
			Point arr[] = new Point[arrSize];
			Arrays.fill(arr, non);
			path = new ArrayList<>(Arrays.asList(arr));
			path.set(0, new Point(0,0));

			pathPos = 0;
			findPath(grid, 0, 0);

			printGrid(grid);
			printPath(path);

		return path;
	}

	public static void main(String[] args){
		int[][] grid = {{0, 0, 1}, {0, 1, 0}, {0, 0, 0}};

		new Sol().findPath(grid);
	}

	
	private class Point{
		int rowI, colI;

		public Point (int rowI, int colI){
			this.rowI = rowI;
			this.colI = colI;
		}

		@Override
		public String toString(){
			return "(" + rowI + "," + colI + ") ";
		}
	}
}

