# Infinity War 
## Overview
This codebase contains Java programs related to various tasks in a fictional context based on the Marvel Universe. The main purpose of these programs is to handle graph-based problems, read/write files, and perform calculations such as finding flux, connectivity, expected utility (EU) thresholds, and minimum energy costs.

## Files:
1. **ForgeStormBreaker.java**  
   - **Task**: Calculates the total flux Thor has to endure from a 2D array of flux intensity values (Neutron Star data). It reads the data from an input file, calculates the total flux, and writes it to an output file.
   - **Input**: A file with a matrix of flux values.
   - **Output**: A file with the calculated total flux.

2. **PredictThanosSnap.java**  
   - **Task**: Simulates the effect of Thanos' snap by randomly removing half of the vertices in a graph. Then, it checks if the graph remains connected or not after removing the vertices.
   - **Input**: A graph's adjacency matrix and a random seed.
   - **Output**: A boolean (true/false) indicating whether the graph is connected after the removal of vertices.

3. **UseTimeStone.java**  
   - **Task**: Based on a directed graph representing possible timelines, this program counts the total number of possible timelines and those with an expected utility (EU) greater than or equal to a given threshold.
   - **Input**: A graph adjacency matrix and EU values for vertices, along with an EU threshold.
   - **Output**: The total number of timelines and those with EU greater than or equal to the threshold.

4. **LocateTitan.java**  
   - **Task**: Given a graph of generators and their functionality values, it computes the minimum energy cost from Earth (vertex 0) to Titan (vertex n-1) after modifying the edge weights using functionality values.
   - **Input**: A graph with energy costs and functionality values.
   - **Output**: The minimum cost to travel from Earth to Titan.

## Key Concepts:
- **Adjacency Matrix**: A representation of a graph where matrix elements indicate if there is a direct connection (edge) between two vertices (nodes).
- **Graph Algorithms**: Includes graph traversal (DFS) and shortest path algorithms (Dijkstra’s Algorithm).
- **Random Vertex Removal**: Simulating random destruction of parts of a graph and checking connectivity.

## Instructions:
 **Compiling and Running**:
   - Ensure you are in the **../InfinityWar** directory.
   - **Compiling**: `javac -d bin src/avengers/*.java`
   - **Running**: 
     ```bash
     java -cp bin avengers/ForgeStormBreaker forgestormbreaker.in forgestormbreaker.out
     java -cp bin avengers/PredictThanosSnap predictthanossnap.in predictthanossnap.out
     java -cp bin avengers/UseTimeStone usetimestone.in usetimestone.out
     java -cp bin avengers/LocateTitan locatetitan.in locatetitan.out
     ```

---
