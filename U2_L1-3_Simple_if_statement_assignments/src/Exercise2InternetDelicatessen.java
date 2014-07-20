import java.util.Scanner;


public class Exercise2InternetDelicatessen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
/*		You have been asked to write a program for the Sam and Ella Delicatessen. The program takes 
		deli orders from the Internet. It asks for the item, its price in cents, and if overnight 
		shipping is wanted. The program writes out the order and the charges. Regular shipping for 
		items under $10 is $2.00; for items $10 or more shipping is $3.00. For overnight delivery add
		$5.00. 
				Enter the item: Tuna Salad
				Enter the price: 450
				Overnight delivery (0==no, 1==yes): 1

				Invoice:
				  Tuna Salad    4.50
				  shipping      7.00
				  total         11.50
*/
		
		Scanner input = new Scanner(System.in);

		// Input item
		System.out.println("Enter the item: ");
		String item = "";
		try {
			item = input.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Invalid input. A string is expected.");
			System.exit(0);
		}
		
		// Input price
		System.out.println("Enter the price (in cents): ");
		double price = 0.0;
		try {
			price = input.nextDouble();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Invalid input. An integer is expected.");
			System.exit(0);
		}
		price = price/100.0;
		
		// Choose overnight deliver or not
		System.out.println("Overnight delivery (0==no, 1==yes): ");
		int overnightDeliver = 0;
		try {
			overnightDeliver = input.nextInt();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Invalid input. An integer is expected.");
			System.exit(0);
		}
		
		// calculate the regular shipping cost
		double shipping;
		if(price < 10.0) {
			shipping = 2.0;
		} else {
			shipping = 3.0;
		}
		
		// Add $5.00 if overnight deliver is choosed
		if(overnightDeliver == 1) {
			shipping = shipping + 5.0;
		}
		
		double total = price + shipping;
		
		// Print the invoice
		System.out.println("Invoice:");
		System.out.println("\t " + item + "\t" + String.format("%.2f", price));
		System.out.println("\t shipping\t" + String.format("%.2f", shipping));
		System.out.println("\t total   \t" + String.format("%.2f", total));
		
	}

}
