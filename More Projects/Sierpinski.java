

 
 public class Sierpinski {

    // Height of an equilateral triangle whose sides are of the specified length. 
    public static double height(double length) {

    double height = length*(Math.sqrt(3)/2);
    
    return height;
    }

    // Draws a filled equilateral triangle whose bottom vertex is (x, y) 
    // of the specified side length. 
    public static void filledTriangle(double x, double y, double length) {

    double[] xArray = {x - height(length)/Math.sqrt(3), x, x+height(length)/Math.sqrt(3)};
    double[] yArray = {y + height(length), y, y + height(length)};

    
    StdDraw.filledPolygon(xArray , yArray);

    }

    // Draws a Sierpinski triangle of order n, such that the largest filled 
    // triangle has bottom vertex (x, y) and sides of the specified length. 
    public static void sierpinski(int n, double x, double y, double length) {

    if(n>0){
        
        filledTriangle(x,y,length);
        
        //triangle up
        sierpinski(n-1, x, y+height(length), length/2.0);

        //triangle left
        sierpinski(n-1, x-length/2.0, y, length/2.0);

        //triangle right
        sierpinski(n-1, (x+ (length/2.0)), y, length/2.0);
      
    }
    }

    // Takes an integer command-line argument n; 
    // draws the outline of an equilateral triangle (pointed upwards) of length 1; 
    // whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0); and 
    // draws a Sierpinski triangle of order n that fits snugly inside the outline. 
    public static void main(String[] args) {

   
    int n = Integer.parseInt(args[0]);
    
    double [] originalX = {0,0.5,1};
    double [] originalY = {0,Math.sqrt(3)/2,0};

    double x = 0.5;
    double y = 0;
    double length = 0.5;

    StdDraw.polygon(originalX, originalY);

    sierpinski (n, x, y, length);
    }
}

