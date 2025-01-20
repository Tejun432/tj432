# More Projects
These are some of my other projects that demonstrate various skills in Java programming, including vehicle cost analysis, geometric transformations, weather simulations, and more.

## 1. LeasingCost.java
The `LeasingCost` Java program calculates the total cost, fuel cost, and CO2 emissions for gas and electric vehicles based on descriptions provided in a file. It processes the data to create `Vehicle` objects and performs various computations.

#### Key Methods:
- `createAllVehicles`: Reads a file and returns an array of `Vehicle` objects.
- `computeCO2`: Calculates CO2 emissions based on vehicle usage, mileage, and fuel type.
- `computeFuelCost`: Computes the fuel cost over the lease period.
- `createVehicle`: Parses vehicle descriptions to create a `Vehicle` object.
- `computeCO2EmissionsAndCost`: Computes and updates CO2 emissions, fuel cost, and total lease cost for all vehicles.


## 2. PolygonTransform.java
The `PolygonTransform` Java program allows for basic geometric transformations on a polygon defined by arrays of x and y coordinates. It supports scaling, translation, and rotation of the polygon, and visualizes the transformations using `StdDraw`.

#### Key Methods:
- `copy`: Creates and returns a copy of the input array.
- `scale`: Scales the polygon by a factor `alpha`.
- `translate`: Translates the polygon by `dx` and `dy` in the x and y directions.
- `rotate`: Rotates the polygon by an angle `theta` (in degrees).
- `main`: Demonstrates scaling, translating, and rotating a polygon using `StdDraw`.


## 3. RURottenTomatoes.java
The `RURottenTomatoes` Java program processes a 2D grid of integers representing rotten tomatoes in a row-column format. It computes the column with the highest total number of rotten tomatoes and outputs its index.

#### Key Logic:
- The program reads row and column sizes from command-line arguments and fills a 2D array with values representing rotten tomatoes.
- It calculates the sum of tomatoes in each column.
- It identifies the column with the maximum sum, and in case of ties, it returns the column with the smallest index.

#### Key Components:
- **Input parsing**: Reads grid dimensions and values from `args`.
- **Column sum calculation**: Sums the values of each column to determine which one has the most rotten tomatoes.
- **Tie-breaking logic**: If multiple columns have the same sum, the smallest index is chosen.


## 4. Sierpinski.java
The `Sierpinski` Java program draws a Sierpinski triangle of a given order `n` within an equilateral triangle. It uses recursive calls to draw smaller filled equilateral triangles, creating the fractal pattern.

#### Key Methods:
- **`height(double length)`**: Computes the height of an equilateral triangle given its side length using the formula \( \text{height} = \frac{\text{length} \times \sqrt{3}}{2} \).
- **`filledTriangle(double x, double y, double length)`**: Draws a filled equilateral triangle with a specified bottom vertex `(x, y)` and side length.
- **`sierpinski(int n, double x, double y, double length)`**: Recursively draws a Sierpinski triangle of order `n` at the specified position `(x, y)` with the given side length.
- **`main(String[] args)`**: Reads the order `n` from command-line arguments, draws the outer triangle, and invokes the recursive function to create the Sierpinski triangle.

#### Example Execution:
- Input: `java Sierpinski 3`
- The program will draw a Sierpinski triangle of order 3 inside an equilateral triangle with side length 1.


## 5. WeatherGenerator.java
The `WeatherGenerator` program simulates weather forecasts based on transition probabilities for wet and dry days at specific locations. It uses historical data to predict the weather for a given month at a location based on its latitude and longitude.

#### Key Methods:
- **`populateArrays(double[][] drywet, double[][] wetwet)`**: Reads and populates 2D arrays from `drywet.txt` and `wetwet.txt` files containing transition probabilities for wet and dry days.
- **`populateLocationProbabilities(double[] drywetProbability, double[] wetwetProbability, double longitude, double latitude, double[][] drywet, double[][] wetwet)`**: Extracts the transition probabilities for a specific location based on latitude and longitude.
- **`forecastGenerator(double drywetProbability, double wetwetProbability, int numberOfDays)`**: Generates a forecast for a month based on the provided probabilities of wet and dry days.
- **`oneMonthForecast(int numberOfLocations, int month, double longitude, double latitude)`**: Integrates the previous methods to generate a complete forecast for a specified month, location, and transition probabilities.
- **`lengthOfLongestSpell(int[] forecast, int mode)`**: Finds the longest consecutive period of wet or dry days in the forecast.
- **`bestWeekToTravel(int[] forecast)`**: Finds the best 7-day period with the most dry days, ideal for travel.

#### Execution:
To generate a weather forecast:
```bash
java WeatherGenerator -97.58 26.02 3
```
The output includes the number of dry and wet spells, as well as the best week to travel based on the forecast.
