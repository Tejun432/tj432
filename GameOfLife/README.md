
# Conway's Game of Life

This project implements **Conway's Game of Life** using Java. It includes various methods to simulate and progress the game’s board through its generations, following the rules of the game. The game evolves a grid of cells, where each cell can either be **alive** or **dead**, based on the number of neighbors surrounding it.

## Game Rules:
- **Alive cells** with 0-1 neighbors **die** (loneliness).
- **Alive cells** with 4 or more neighbors **die** (overpopulation).
- **Alive cells** with 2-3 neighbors **survive**.
- **Dead cells** with exactly 3 neighbors **become alive** (reproduction).

### Methods:
- **`getGrid()`**: Returns the current grid.
- **`getTotalAliveCells()`**: Returns the total number of alive cells.
- **`getCellState(int row, int col)`**: Returns the state of a specific cell.
- **`isAlive()`**: Checks if there are any alive cells in the grid.
- **`numOfAliveNeighbors(int row, int col)`**: Returns the number of alive neighbors for a cell.
- **`computeNewGrid()`**: Computes the grid for the next generation.
- **`nextGeneration()`**: Evolves the grid by one generation.
- **`nextGeneration(int n)`**: Evolves the grid by `n` generations.
- **`numOfCommunities()`**: Returns the number of separate cell communities (feature to be implemented).



## Features:
- **Initial Grid Setup**: You can initialize the grid either with a predefined setup or by loading it from an input file.
- **Neighbor Counting**: Each cell can have up to 8 neighbors. The game calculates the number of alive neighbors for each cell.
- **Generation Evolution**: The grid evolves based on the rules, and you can iterate multiple generations.
- **Community Detection** (To be implemented): This feature will calculate the number of distinct communities (groups of connected cells) in the grid.


### Example Input File Format:

5 5
false true false false false
true false true false false
false true true true false
false false false true true
false false false false false


