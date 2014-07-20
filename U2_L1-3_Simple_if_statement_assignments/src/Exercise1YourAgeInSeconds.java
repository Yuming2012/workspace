import java.util.Scanner;


public class Exercise1YourAgeInSeconds {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
/*			Write a program that asks for your month birth and the program should return the number of days since January. 
			For example if they enter January number of days is 31 if they enter February the number of days is 31 + 28 etc.
*/
		// Initiate days in each month
		int daysInMonth[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		Scanner input = new Scanner(System.in);

		System.out.println("*********************************************************");
		System.out.println("1 - January; 2 - Febrary; 3 - March; 4 - April; 5 - May; 6 - June");
		System.out.println("7 - July; 8 - August; 9 - September; 10 - October; 11 - November; 12 - December");
		System.out.println("*********************************************************");
		System.out.println("Input your month birth: ");
		
		int month = 0;
		try {
			month = input.nextInt();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Invalid input. Month should be an integer number between (1 ~ 12)");
			System.exit(0);
		}
		
		int days = 0;
		if(month > 0 && month < 13) {
			for(int i = 0; i< month; i++) {
				days = days + daysInMonth[i];
			}
			System.out.println("The number of days: " + days);
		} else {
			System.out.println("Incorrect month: " + month + ". Month should be a number between (1 ~ 12).");
		}
		
		
	}

}
