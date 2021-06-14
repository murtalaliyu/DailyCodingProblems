
public class Dropbox {

	public static void main(String[] args) {
		int[][] liveCoordinates = new int[][] {{1,2}, {3,4}, {5,6}};
		populateGrid(liveCoordinates);
		printGrid();
		gameOfLife(5);
		printGrid();
	}
	
	/*
	 * This problem was asked by Dropbox.

		Conway's Game of Life takes place on an infinite two-dimensional board of square cells. 
		Each cell is either dead or alive, and at each tick, the following rules apply:
		
		Any live cell with less than two live neighbours dies.
			Any live cell with two or three live neighbours remains living.
			Any live cell with more than three live neighbours dies.
			Any dead cell with exactly three live neighbours becomes a live cell.
		
		A cell neighbours another cell if it is horizontally, vertically, or diagonally adjacent.
		
		Implement Conway's Game of Life. It should be able to be initialized with a starting list of live cell 
		coordinates and the number of steps it should run for. Once initialized, it should print out the 
		board state at each step. Since it's an infinite board, print out only the relevant coordinates, 
		i.e. from the top-leftmost live cell to bottom-rightmost live cell.
		
		You can represent a live cell with an asterisk (*) and a dead cell with a dot (.).{MEDIUM}
	 */
	static int x_axis = 10, y_axis = 10;
	static char[][] grid = new char[x_axis][y_axis];
	public static void gameOfLife(int steps) {
		int[] aliveAndDead;		// 0 = alive, 1 = dead
		int count = 0;
		while (count < steps) {
			for (int i = 0; i < x_axis; i++) {
				for (int j = 0; j < y_axis; j++) {
					aliveAndDead = getNeighbors(i,j);
					setRules(aliveAndDead,i,j);
				}
			}
			printGrid();
		}
	}
	public static void setRules(int[] aliveAndDead, int i, int j) {
		
		// Any live cell with less than two live neighbours dies.
		if ((grid[i][j] == '*') && aliveAndDead[0] < 2) {		
			grid[i][j] = '.';
			return;
		}
		// Any live cell with two or three live neighbours remains living.
		if ((grid[i][j] == '*') && (aliveAndDead[0] == 2 || aliveAndDead[0] == 3)) {
			return;
		}
		// Any live cell with more than three live neighbours dies.
		if ((grid[i][j] == '*') && aliveAndDead[0] > 3) {
			grid[i][j] = '.';
			return;
		}
		// Any dead cell with exactly three live neighbours becomes a live cell.
		if ((grid[i][j] == '.') && aliveAndDead[0] == 3) {
			grid[i][j] = '*';
			return;
		}
	}
	public static int[] getNeighbors(int row, int col) {
		
		// these arrays are used to get row and column numbers of 8 neighbors of a given cell.
				int rowNum[] = new int[] {-1, -1, -1, 0, 0, 1, 1, 1};
				int colNum[] = new int[] {-1, 0, 1, -1, 1, -1, 0, 1};
		
	}
	public static void populateGrid(int[][] liveCoordinates) {
		// populate live cells
		for (int[] x : liveCoordinates) {
			grid[x[0]][x[1]] = '*';
		}
		// populate dead cells
		for (int i = 0; i < x_axis; i++) {
			for (int j = 0; j < y_axis; j++) {
				if (grid[i][j] != '*') {
					grid[i][j] = '.';
				}
			}
		}
	}
	public static void printGrid() {
		for (int i = 0; i < x_axis; i++) {
			for (int j = 0; j < y_axis; j++) {
				System.out.print(grid[i][j] + "  ");
			}
			System.out.println();
		}
	}
}
