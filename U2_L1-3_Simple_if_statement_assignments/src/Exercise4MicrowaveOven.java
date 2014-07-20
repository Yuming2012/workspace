import java.util.Scanner;


public class Exercise4MicrowaveOven {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
/*		A microwave oven manufacturer recommends that when heating two items, add 50% to the heating time, 
		and when heating three items double the heating time. Heating more than three items at once is not 
		recommended. 
		Write a program that asks the user for the number of items and the single-item heating time. The 
		program then writes out the recommended heating time. 
		Hint: do this with four successive single-branch if statements each of which tests for one of the 
		four cases: 1 item, 2 items, 3 items, more than three items. Look at the sports car purchase program
		in the chapter to see how to do this, if you are stuck. 
*/
		Scanner input = new Scanner(System.in);

		// Input the number of items
		System.out.println("Enter the number of items: ");
		int numberOfItems = 0;
		try {
			numberOfItems = input.nextInt();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Invalid input. An integer is expected.");
			System.exit(0);
		}

		if(numberOfItems > 3) {
			System.out.println("Heating more than three items at once is not recommended!");
			System.exit(0);
		}

		// Input the number of items
		System.out.println("Enter the single item heating time: ");
		float singleItemHeatingTime = 0;
		try {
			singleItemHeatingTime = input.nextFloat();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Invalid input. A number is expected.");
			System.exit(0);
		}

		// Calculate and writes out the recommended heating time
		float recommendedHeatingTime = 0;
		if(numberOfItems == 1) {
			recommendedHeatingTime = singleItemHeatingTime;
		} else if(numberOfItems == 2) {
			recommendedHeatingTime = (float) (singleItemHeatingTime + 0.5*singleItemHeatingTime);
		} else if(numberOfItems == 3) {
			recommendedHeatingTime = 2*singleItemHeatingTime;
		}

		System.out.println("The recommended heating time for " + numberOfItems + " item(s) is: " + recommendedHeatingTime);

	}

}
