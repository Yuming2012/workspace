/**
 * Restaurant user input; 
 * ask user for meal name, meal quantity, and meal price,
 * calculate the total including hst print a restaurant bill
 * 
 * Shuke Wang
 * v1.0
 * oct-13-2013
 * 
 */

  import java.util.Scanner; //Input Class
  import java.io.*; //Runtime errors Class

  import java.text.*; 
  import java.text.NumberFormat; 

  import java.util.Date; // date class
  import java.text.DateFormat;
  import java.text.SimpleDateFormat;
  import java.util.Calendar;

public class RestaurantUserInput {
  public static void main(String[] args) { 
    
    
    //Constants
    final double hstRate = 0.13; //hst rate 
     
    //variables
    double subTotal = 0.0;
    double hstTotal = 0.0;
    double total = 0.0; 
    
    // Restaurant name 
    // welcomes user to restaurant 
    System.out.println("Welcome to ABC restaurant\n");
    
    
    //scanner- calls for user input
    Scanner input = new Scanner(System.in);
    
    // waiter or waitress name
    System.out.println("kjdfhaskjh");
    String waitorName = input.nextLine();

    // prompt the user for the meal name
    System.out.println("Please enter the name of the meal you would like to order: ");
    String mealName = input.nextLine();
    
    // meal quantity
    System.out.println("Please enter the quantity of the meal your ordered as an integer: ");
    int quantity = input.nextInt();
    
    // meal price, 
    System.out.println("Please enter the meal price: ");
    double price = input.nextDouble(); 
     
    //calculate the subtotal and total 
    subTotal = quantity*price;
    hstTotal = subTotal*hstRate;
    total = subTotal + hstTotal;
    
    //output - the final restaurant bill
    System.out.println("\n#############################");
    System.out.println("# Welcome to ABC restaurant #");
    System.out.println("#############################\n");
    
     //date
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    System.out.println(dateFormat.format(date));
    
    //• Water/Waitress name
    System.out.println("\nWaitor or waitresses name:  " + waitorName);
    
    
    System.out.println("----------------------------------------");
    
    // number format currency to 2 decimals 
    NumberFormat nfc = NumberFormat.getCurrencyInstance();
    nfc.setMaximumFractionDigits(2);   
    
    //meal name, price, and quantity 
    System.out.println(mealName + "\t" + nfc.format(price) + "\tX " + quantity);
    
     System.out.println("----------------------------------------");
     
    //subtotal      
    System.out.println ("Subtotal:\t\t" + nfc.format(subTotal));
    
    //HST total
    System.out.println("HST TOTAL(13%):   \t" + nfc.format(hstTotal)); 
    
    System.out.println("========================================");
    
    //total 
    System.out.println("Total: \t          " + nfc.format(total));
   
    
    //payment method 
    System.out.println("\nPayment Method: Cash ");
    
    //a message 
    System.out.println("\nPlease come again! ");
    
  
  
 
  }//end of main
  
}//end of class
