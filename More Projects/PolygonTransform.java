

public class PolygonTransform {
	
	public static double[]copy(double[]array) {
		
		double[]newArray = new double[array.length];

		
		for(int i=0; i<array.length;i++) {
			newArray[i] = array[i];
			
		}
		return newArray;
		
		
		
	}
	
	public static void scale(double[]x,double[]y,double alpha) {
		for(int i=0; i<x.length; i++) {
			x[i] *= alpha;
			y[i] *= alpha;
			
		}
	}
	
	public static void translate(double[]x,double[]y,double dx,double dy) {
		for(int i=0; i<x.length; i++) {
			x[i] += dx;
			y[i] += dy;
		}
	}
	
	public static void rotate(double[]x,double[]y,double theta) {
		double rad = Math.toRadians(theta);
		double temp;
		for(int i=0; i<x.length; i++) {
			temp = x[i];			//for storing temporarily the previous value of x before changing so that it can be used in changing y
			x[i] = x[i]*Math.cos(rad)-y[i]*Math.sin(rad);
			y[i] = y[i]*Math.cos(rad)+temp*Math.sin(rad);
			
		}
	}
	
	
	public static void main (String[]args) {		//implementing the test case discripted
		double[]x =  {0,1,1,0};
		double[]y =  {0,0,2,1};
		
	
		
		
		StdDraw.setScale(-5.0,+5.0);
		double alpha = 2.0;
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.polygon(x,y);
		scale(x,y,alpha);
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.polygon(x, y);
		
		
		//translates polygon by (2,1)
		StdDraw.setScale(-5.0, +5.0);
		double dx = 2.0, dy = 1.0;
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.polygon(x,y);
		translate(x,y,dx,dy);
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.polygon(x, y);
		
		
		// rotates polygon 45 degrees
		StdDraw.setScale(-5.0, +5.0);
		double theta = 45.0;
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.polygon(x,y);
		rotate(x,y,theta);
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.polygon(x, y);
		
		///////////////intialise the x and y values smwhere *****////////
		
		
	}	
		
	}