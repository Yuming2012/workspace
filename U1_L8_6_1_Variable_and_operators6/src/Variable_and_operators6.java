
public class Variable_and_operators6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		1- Open the Math class from the Modle and write a program using the following variables in order to perform the following tasks:

		    int i = 7
		    int j = -9
		    double x = 72.3
		    double y = 0.34 
*/

	    int i = 7;
	    int j = -9;
	    double x = 72.3;
	    double y = 0.34 ;

	    System.out.println("int i = " + i + "; j = " + j);
	    System.out.println("double x = " + x + "; y = " + y);
	    System.out.println("\n");

	    // The absolute value of I, j, x, and y
	    System.out.println("The absolute value of " + i + " = " + Math.abs(i));
	    System.out.println("The absolute value of " + j + " = " + Math.abs(j));
	    System.out.println("The absolute value of " + x + " = " + Math.abs(x));
	    System.out.println("The absolute value of " + y + " = " + Math.abs(y));
	    System.out.println("\n");

	    // Use floor to round down round to round up x and y. Change X to 72.6 to see if the round up works
	    System.out.println("Use floor to round down " + x + ": " + Math.floor(x));
	    System.out.println("Use floor to round down " + y + ": " + Math.floor(y));
	    System.out.println("Use round to round up " + x + ": " + Math.round(x) + "; round up " + ((Math.round(x) >= x) ? "works!" : "does not work!"));
	    System.out.println("Use round to round up " + y + ": " + Math.round(y) + "; round up " + ((Math.round(y) >= y) ? "works!" : "does not work!"));
	    
	    double z = 72.6;
	    System.out.println("double z = " + z);
	    System.out.println("Use round to round up " + z + ": " + Math.round(z) + "; round up " + ((Math.round(z) >= z) ? "works!" : "does not work!"));
	    System.out.println("Use ceil to round up " + z + ": " + Math.ceil(z) + "; round up " + ((Math.round(z) >= z) ? "works!" : "does not work!"));
	    System.out.println("Use floor to round down " + z + ": " + Math.floor(z) + "; round down " + ((Math.round(z) <= z) ? "works!" : "does not work!"));
	    System.out.println("\n");

	    //The "ceiling" of I, j, x, and y
	    System.out.println("The ceiling of " + i + " = " + Math.ceil(i));
	    System.out.println("The ceiling of " + j + " = " + Math.ceil(j));
	    System.out.println("The ceiling of " + x + " = " + Math.ceil(x));
	    System.out.println("The ceiling of " + y + " = " + Math.ceil(y));
	    System.out.println("\n");

	    //The "floor" of I, j, x, and y
	    System.out.println("The floor of " + i + " = " + Math.floor(i));
	    System.out.println("The floor of " + j + " = " + Math.floor(j));
	    System.out.println("The floor of " + x + " = " + Math.floor(x));
	    System.out.println("The floor of " + y + " = " + Math.floor(y));
	    System.out.println("\n");

	    //Comparison operators min and max function by comparing I to j, x to y, I to x, y to j
	    System.out.println("The min of (" + i + "," + j + ") = " + Math.min(i, j));
	    System.out.println("The max of (" + i + "," + j + ") = " + Math.max(i, j));
	    
	    System.out.println("The min of (" + x + "," + y + ") = " + Math.min(x, y));
	    System.out.println("The max of (" + x + "," + y + ") = " + Math.max(x, y));

	    System.out.println("The min of (" + i + "," + x + ") = " + Math.min(i, x));
	    System.out.println("The max of (" + i + "," + x + ") = " + Math.max(i, x));

	    System.out.println("The min of (" + y + "," + j + ") = " + Math.min(y, j));
	    System.out.println("The max of (" + y + "," + j + ") = " + Math.max(y, j));
	    System.out.println("\n");

	    // How to show the value of π
		final double PI = 3.1415926535;
	    System.out.println("PI = " + PI);
	    System.out.println("\n");
		
	    //		Cosine and Sine function: angle = 45.0 
		final double angle = 45.0;
	    System.out.println("Cosine(" + angle + ") = " + Math.cos(angle/180.0*PI));
	    System.out.println("Sine(" + angle + ") = " + Math.sin(angle/180.0*PI));
	    System.out.println("\n");

	    //		Inverse cos, sin and tan of value = 0.707
	    final double value = 0.707;
	    System.out.println("Inverse cos(" + value + ") = " + 180.0/PI*Math.acos(value));
	    System.out.println("Inverse sin(" + value + ") = " + 180.0/PI*Math.asin(value));
	    System.out.println("Inverse tan(" + value + ") = " + 180.0/PI*Math.atan(value));
	    System.out.println("\n");
	    
//		Exponent 2 to the power of 5
	    System.out.println("Exponent 2 to the power of 5 = " + Math.pow(2, 5));

	    //		Square root of 10
	    System.out.println("Square root of 10 = " + Math.sqrt(10));

	    //		Generate a random number between 0 and 10
	    System.out.println("Generate a random number between (0, 10): " + Math.round((Math.random()*10.0)));

	    //		Generate a random number between 0 and 100
	    System.out.println("Generate a random number between (0, 100): " + Math.round((Math.random()*100.0)));


	}

}
