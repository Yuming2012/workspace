import java.util.Scanner;

// class to calculate a leap year
public class LeapYear {

	// given a year the function determines if it is a leap year  
	public static boolean isLeapYear(int year) {
		if(isDivisible(year, 400))
			return true;
		
		if(isDivisible(year, 100))
			return false;
		
		if(isDivisible(year, 4))
			return true;

		return false;
	}

	// given a year the function determines the next leap year  
	public static int nextLeapYear(int year) {
		// if year is a leap year then return itself
		if(isLeapYear(year))
			return year;

		// if it is not a leap year, will increase until it becomes a leap year
		int leapYear = year + 1;
		while(!isLeapYear(leapYear)) {
			leapYear++;
		}
		
		return leapYear;
	}

	// Helper function, given a divided number and a dividing number return if the divided is divisible  
	public static boolean isDivisible(int devided, int by) {
		if((devided/by)*by == devided)
			return true;
		else
			return false;
	}
	
	// Java runnable entry
	public static void main(String[] args) {

		Scanner input = new Scanner( System.in );
		System.out.println("Input a year: ");
		int year = 0;

		try {
			year = Integer.parseInt(input.next());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Please input a valid integer as year. " + e.toString());
			System.exit(0);
		}

		boolean is = isLeapYear(year);
		
		System.out.println("Year " + year + " is " + (is ? "" : "not ") + "a leap year.");
		
		// If the input year is not a leap year, then print the next leap year
		if(!is)
			System.out.println("The next leap year is " + nextLeapYear(year));
		
		input.close();
	}

}
