import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * 
Exercise 2: (Advanced Bonus)							[8]
Write the following procedures for an array that has 3 rows and 4 columns:
o	the method should fill the array by rows. Input can be from the keyboard or from a text file (the user should enter the filename).
o	the method should display the array on the screen as it was entered (rows across and columns down).
o	the method should display the array where the columns appear across the screen and the rows down the screen. This is called the transpose of an array.
	e.g.         Original order	    Transposed order
3    4    5    3			3   1    5
1    2    3    8			4   2    6
5    6    7    9			5   3    7
							3    8   9
o	the method should display the sum of each column at the end of each column and the sum of each row at the end of each row.
 * @author User
 *
 */
public class ReadArrayFromFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int ROW = 3, COL = 4;
		int [][] num = new int[ROW+1][COL+1]; // the extra elements are for sum
		
// o	the method should fill the array by rows. Input can be from the keyboard or from a text file (the user should enter the filename).
		Scanner myfile = null;
		try {
			myfile = new Scanner(new FileReader("C:/Users/User/data.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

        int row = 0;
        int col = 0;
        try {
			while (myfile.hasNext()) {          // Read file content using a while loop
				for(col=0; col<COL; col++)
					num[row][col] = myfile.nextInt();
				row++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        myfile.close(); // close the file
        System.out.println("Rows: " + row);
        System.out.println("");

//o	the method should display the array on the screen as it was entered (rows across and columns down).
        System.out.println("Order 1: rows across the screen and columns down the screen");
        for(row=0; row<ROW; row++) {
        	num[row][COL] = 0;
        	for(col=0; col<COL; col++) {
        		num[row][COL] = num[row][COL] + num[row][col];  
        		System.out.print(num[row][col] + "\t");
        	}
    		System.out.print("\n");
        }
		System.out.print("\n");
		
//o	the method should display the array where the columns appear across the screen and the rows down the screen. This is called the transpose of an array.
        System.out.println("Order 2: columns across the screen and the rows down the screen");
    	for(col=0; col<COL; col++) {
        	num[ROW][col] = 0;
    		for(row=0; row<ROW; row++) {
        		num[ROW][col] = num[ROW][col] + num[row][col];  
        		System.out.print(num[row][col] + "\t");
        	}
    		System.out.print("\n");
        }
		System.out.print("\n");
	
//o	the method should display the sum of each column at the end of each column and the sum of each row at the end of each row.
		System.out.println("Display the array with Sum of row and sum of column\n");
		System.out.println("1\t2\t3\t4\tSum");
		System.out.println("--\t--\t--\t--\t--");
		for(row=0; row<ROW; row++) {
			for(col=0; col<(COL+1); col++) {
        		System.out.print(num[row][col] + "\t");
			}
    		System.out.print("\n");
		}

		System.out.println("--\t--\t--\t--\t--");
		row = ROW;
		num[ROW][COL] = 0;
		for(col=0; col<COL; col++) {
			num[ROW][COL] = num[ROW][COL] + num[row][col]; 
    		System.out.print(num[row][col] + "\t");
		}
		System.out.print(num[ROW][COL]);
		System.out.print("\n");
	
	}

	
}
