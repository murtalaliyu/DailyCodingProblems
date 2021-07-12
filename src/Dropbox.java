import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dropbox {

	public static void main(String[] args) {
		/*
		 * int[][] liveCoordinates = new int[][] {{1, 1}, {1, 2}, {2, 3}};
		 * populateGrid(liveCoordinates); System.out.println("Starting grid:");
		 * printGrid(); gameOfLife(1);
		 */
		
		String[] arr = {"chair", "height", "racket", "touch", "tunic"};
		canFormACircle(arr);
	}
	
	/*
	 * This problem was asked by Dropbox.
		Given a list of words, determine whether the words can be chained to form a circle. 
		A word X can be placed in front of another word Y in a circle if the last character of X is 
		same as the first character of Y.
		For example, the words ['chair', 'height', 'racket', touch', 'tunic'] can form 
		the following circle: chair --> racket --> touch --> height --> tunic --> chair. (medium)
	 */
	public static boolean canFormACircle(String[] words) {
		Arrays.sort(words);
		
		
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
		COMPLETE (changing state on the fly. need to introduce new grid for state preservation). time=O(row*col), space=O(1)
	 */
	static int x_axis = 4, y_axis = 5;
	static char[][] grid = new char[x_axis][y_axis];
	public static void gameOfLife(int steps) {
		int alive = 0;
		int count = 0;
		
		// these arrays are used to get row and column numbers of 8 neighbors of a given cell.
		int rowNum[] = new int[] {-1, -1, -1, 0, 0, 1, 1, 1};
		int colNum[] = new int[] {-1, 0, 1, -1, 1, -1, 0, 1};
		
		while (count < steps) {
			for (int i = 0; i < x_axis; i++) {
				for (int j = 0; j < y_axis; j++) {
					
					for (int k = 0; k < 8; k++) {
						alive += getNeighbors(i+rowNum[k], j+colNum[k]);
					}
					setRules(alive,i,j);
					alive = 0;
				}
			}
			count++;
			printGrid();
		}
	}
	public static int getNeighbors(int row, int col) {
		if ((row < 0 || row >= x_axis || col < 0 || col >= y_axis)) {
			return 0;
		} 
		if ((grid[row][col] == '.')) {
			return 0;
		}
		return 1;
	}
	public static void setRules(int alive, int i, int j) {
		// Any live cell with less than two live neighbours dies.
		if ((grid[i][j] == '*') && alive < 2) {		
			grid[i][j] = '.';
			return;
		}
		// Any live cell with two or three live neighbours remains living.
		if ((grid[i][j] == '*') && (alive == 2 || alive == 3)) {
			return;
		}
		// Any live cell with more than three live neighbours dies.
		if ((grid[i][j] == '*') && alive > 3) {
			grid[i][j] = '.';
			return;
		}
		// Any dead cell with exactly three live neighbours becomes a live cell.
		if ((grid[i][j] == '.') && alive == 3) {
			grid[i][j] = '*';
			return;
		}
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
		System.out.println("-----------------------------------------------");
	}
}
