package conwaygame;
import java.util.ArrayList;
/**
 * Conway's Game of Life Class holds various methods that will
 * progress the state of the game's board through it's many iterations/generations.
 *
 * Rules 
 * Alive cells with 0-1 neighbors die of loneliness.
 * Alive cells with >=4 neighbors die of overpopulation.
 * Alive cells with 2-3 neighbors survive.
 * Dead cells with exactly 3 neighbors become alive by reproduction.
//teju
 * @author Seth Kelley 
 * @author Maxwell Goldberg
 */
public class GameOfLife {

    // Instance variables
    private static final boolean ALIVE = true;
    private static final boolean  DEAD = false;

    private boolean[][] grid;    // The board has the current generation of cells
    private int totalAliveCells; // Total number of alive cells in the grid (board)

    /**
    * Default Constructor which creates a small 5x5 grid with five alive cells.
    * This variation does not exceed bounds and dies off after four iterations.
    */
    public GameOfLife() {
        grid = new boolean[5][5];
        totalAliveCells = 5;
        grid[1][1] = ALIVE;
        grid[1][3] = ALIVE;
        grid[2][2] = ALIVE;
        grid[3][2] = ALIVE;
        grid[3][3] = ALIVE;
    }

    /**
    * Constructor used that will take in values to create a grid with a given number
    * of alive cells
    * @param file is the input file with the initial game pattern formatted as follows:
    * An integer representing the number of grid rows, say r
    * An integer representing the number of grid columns, say c
    * Number of r lines, each containing c true or false values (true denotes an ALIVE cell)
    */
    public GameOfLife (String file) {

        // WRITE YOUR CODE HERE
        StdIn.setFile(file);
        int r = StdIn.readInt();
        int c = StdIn.readInt();
        
        grid = new boolean[r][c];
        totalAliveCells = 0;
        for (int i = 0; i < r; i++) {
        	for (int j = 0; j < c; j++) {
        		boolean b = StdIn.readBoolean();
        		if (b == true) {
        			grid[i][j] = ALIVE;
        			totalAliveCells += 1;
        		}
        	}
        }
        // DELETE
        StdOut.println("ROWS: " + r);
        StdOut.println("COLS: " + c);
        StdOut.println("Cells: " + totalAliveCells);
    }

    /**
     * Returns grid
     * @return boolean[][] for current grid
     */
    public boolean[][] getGrid () {
        return grid;
    }
    
    /**
     * Returns totalAliveCells
     * @return int for total number of alive cells in grid
     */
    public int getTotalAliveCells () {
        return totalAliveCells;
    }

    /**
     * Returns the status of the cell at (row,col): ALIVE or DEAD
     * @param row row position of the cell
     * @param col column position of the cell
     * @return true or false value "ALIVE" or "DEAD" (state of the cell)
     */
    public boolean getCellState (int row, int col) {

        // WRITE YOUR CODE HERE
        boolean cellState = true;
    	if (grid[row][col] == ALIVE) cellState = true;
    	if (grid[row][col] == DEAD) cellState = false;
        return cellState;
         // update this line, provided so that code compiles
    }

    /**
     * Returns true if there are any alive cells in the grid
     * @return true if there is at least one cell alive, otherwise returns false
     */
    public boolean isAlive () {

        // WRITE YOUR CODE HERE
        boolean isAlive = true;
    	if (totalAliveCells != 0) isAlive = true;
    	if (totalAliveCells == 0) isAlive = false;
        return isAlive; // update this line, provided so that code compiles
    }

    /**
     * Determines the number of alive cells around a given cell.
     * Each cell has 8 neighbor cells which are the cells that are 
     * horizontally, vertically, or diagonally adjacent.
     * 
     * @param col column position of the cell
     * @param row row position of the cell
     * @return neighboringCells, the number of alive cells (at most 8).
     */
    public int numOfAliveNeighbors (int row, int col) {

        
    	int height = grid.length;
    	int width = grid[0].length;
    	int numOfAliveNeighbors = 0;
    	int ni = 0;
    	int nj = 0;
    	
    	for (int i = row-1; i <= row+1; i++) {
    		for (int j = col-1; j <= col+1; j++) {
    			ni = i;
    			nj = j;
    			if (i == -1) ni = height-1;
    			if (i == height) ni = 0;
    			if (j == -1) nj = width-1;
    			if (j == width) nj = 0;
    			if (i != row || j != col) {
    				// DELETE
    				//StdOut.println(ni+","+nj);
    				if (grid[ni][nj] == ALIVE) numOfAliveNeighbors += 1;
    			}
    		}
    	}
    	// DELETE
    	//StdOut.println("H: " + height);
    	//StdOut.println("W: " + width);
        return numOfAliveNeighbors;
    }

    /**
     * Creates a new grid with the next generation of the current grid using 
     * the rules for Conway's Game of Life.
     * 
     * @return boolean[][] of new grid (this is a new 2D array)
     */
    public boolean[][] computeNewGrid () {

        // WRITE YOUR CODE HERE
        int h = grid.length;
    	int w = grid[0].length;
    	
    	boolean[][] new_grid = new boolean[h][w];
        for (int i = 0; i < h; i++) {
        	for (int j = 0; j < w; j++) {
        		if (grid[i][j] == ALIVE) {
        			// Rule 1
        			if (numOfAliveNeighbors(i,j) <= 1) new_grid[i][j] = DEAD;
        			// Rule 2
        			else if (numOfAliveNeighbors(i,j) >= 4) new_grid[i][j] = DEAD;
        			// Rule 3
        			else new_grid[i][j] = ALIVE;
        		}
        		else {
        			// Rule 4
        			if (numOfAliveNeighbors(i,j) == 3) new_grid[i][j] = ALIVE;
        			else new_grid[i][j] = DEAD;
        		}
        	}
        }
    	
        return new_grid;// update this line, provided so that code compiles
    }

    /**
     * Updates the current grid (the grid instance variable) with the grid denoting
     * the next generation of cells computed by computeNewGrid().
     * 
     * Updates totalAliveCells instance variable
     */
    public void nextGeneration () {

        // WRITE YOUR CODE HERE
        grid = computeNewGrid();
    	
    	int h = grid.length;
    	int w = grid[0].length;
    	totalAliveCells = 0;
        for (int i = 0; i < h; i++) {
        	for (int j = 0; j < w; j++) {
        		if (grid[i][j] == ALIVE) {
        			totalAliveCells += 1;
        		}
        	}
        }
    }

    /**
     * Updates the current grid with the grid computed after multiple (n) generations. 
     * @param n number of iterations that the grid will go through to compute a new grid
     */
    public void nextGeneration (int n) {

        // WRITE YOUR CODE HERE
        for (int i = 0; i < n; i++) {
    		grid = computeNewGrid();    		
    	}
    }

    /**
     * Determines the number of separate cell communities in the grid
     * @return the number of communities in the grid, communities can be formed from edges
     */
    public int numOfCommunities() {

        // WRITE YOUR CODE HERE
        return 0; // update this line, provided so that code compiles
    }
}
