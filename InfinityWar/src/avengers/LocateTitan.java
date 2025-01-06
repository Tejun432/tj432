package avengers;
/**
 * 
 * Using the Adjacency Matrix of n vertices and starting from Earth (vertex 0), 
 * modify the edge weights using the functionality values of the vertices that each edge 
 * connects, and then determine the minimum cost to reach Titan (vertex n-1) from Earth (vertex 0).
 * 
 * Steps to implement this class main method:
 * 
 * Step 1:
 * LocateTitanInputFile name is passed through the command line as args[0]
 * Read from LocateTitanInputFile with the format:
 *    1. g (int): number of generators (vertices in the graph)
 *    2. g lines, each with 2 values, (int) generator number, (double) funcionality value
 *    3. g lines, each with g (int) edge values, referring to the energy cost to travel from 
 *       one generator to another 
 * Create an adjacency matrix for g generators.
 * 
 * Populate the adjacency matrix with edge values (the energy cost to travel from one 
 * generator to another).
 * 
 * Step 2:
 * Update the adjacency matrix to change EVERY edge weight (energy cost) by DIVIDING it 
 * by the functionality of BOTH vertices (generators) that the edge points to. Then, 
 * typecast this number to an integer (this is done to avoid precision errors). The result 
 * is an adjacency matrix representing the TOTAL COSTS to travel from one generator to another.
 * 
 * Step 3:
 * LocateTitanOutputFile name is passed through the command line as args[1]
 * Use Dijkstra’s Algorithm to find the path of minimum cost between Earth and Titan. 
 * Output this number into your output file!
 * 
 * Note: use the StdIn/StdOut libraries to read/write from/to file.
 * 
 *   To read from a file use StdIn:
 *     StdIn.setFile(inputfilename);
 *     StdIn.readInt();
 *     StdIn.readDouble();
 * 
 *   To write to a file use StdOut (here, minCost represents the minimum cost to 
 *   travel from Earth to Titan):
 *     StdOut.setFile(outputfilename);
 *     StdOut.print(minCost);
 *  
 * Compiling and executing:
 *    1. Make sure you are in the ../InfinityWar directory
 *    2. javac -d bin src/avengers/*.java
 *    3. java -cp bin avengers/LocateTitan locatetitan.in locatetitan.out
 * 
 * @author Yashas Ravi
 * 
 */

public class LocateTitan {
	
    public static void main (String [] args) {
    	
        if ( args.length < 2 ) {
            StdOut.println("Execute: java LocateTitan <INput file> <OUTput file>");
            return;
        }

        // read file names from command line
        String inputFile = args[0];
        String outputFile = args[1];
        
        // Set the input file.
        StdIn.setFile(inputFile);
        int g = StdIn.readInt();
        double[] functionalities = new double[g];
        for (int i = 0; i < g; i++) {
        	int index = StdIn.readInt();
        	double functionality = StdIn.readDouble();
        	functionalities[index] = functionality;
        }
        int[][] adjacencyMatrix1 = new int[g][g];
        for (int i = 0; i < g; i++) {
        	for (int j = 0; j < g; j++) {
        		adjacencyMatrix1[i][j] = StdIn.readInt();
        	}
        }
        int[][] adjacencyMatrix2 = new int[g][g];
        for (int i = 0; i < g; i++) {
        	for (int j = 0; j < g; j++)
        		adjacencyMatrix2[i][j] = (int) (adjacencyMatrix1[i][j] / (functionalities[i] * functionalities[j]));
        }

        
        // Create an array that keeps track of the MINIMUM cost
        // to reach every vertex FROM vertex 0.
        int[] minCost = new int[g];
        
        // Create an array that keeps track of which nodes are in
        // the path already.
        boolean[] DijkstraSet = new boolean[g];
        
        
        // Set each minCost value to infinity (Integer.MAX_VALUE)
        // except vertex 0 since we are STARTING at node 0.
        for (int v = 0; v < g; v++) {
        	if (v == 0)
        		minCost[v] = 0;
        	else
        		minCost[v] = Integer.MAX_VALUE;
        }
        
        for (int i = 0; i < g - 1; i++) {
        	/* determine the vertex with the MINIMUM cost from vertex 0.
        	   Store this vertex in currentSource. */
        	int currentSource = -1;
        	for (int v = 0; v < g; v++) {
        		if (!DijkstraSet[v] && (currentSource == -1 || minCost[v] < minCost[currentSource]))
        			currentSource = v;
        	}
        	
        	// Add currentSource to DijkstraSet (we are visiting it now)
        	DijkstraSet[currentSource] = true;
        	
        	// Update the distance from 0 to each currentSource's neighbors IF it CAN BE lowered.
        	for (int w = 0; w < g; w++) {
        		if (adjacencyMatrix2[currentSource][w] != 0 && !DijkstraSet[w] && minCost[currentSource] != Integer.MAX_VALUE && minCost[w] > (minCost[currentSource] + adjacencyMatrix2[currentSource][w])) {
        			minCost[w] = minCost[currentSource] + adjacencyMatrix2[currentSource][w];
        		}
        	}
        	
        	// Set the output file.
            StdOut.setFile(outputFile);
            StdOut.print(minCost[g - 1]);
        }
    }
}
