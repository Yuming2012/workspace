/**
 * @Pop window demo 
 *http://download.oracle.com/javase/1.4.2/docs/api/javax/swing/JOptionPane.html
 *
 * @author Boutanos
 * @version 1.00 2010/11/19
 */

import javax.swing.JOptionPane;

public class PopWindow {

    public static void main(String[] args) {
        String yourName;        // your original name
        int again;
       
        do{
	        
	        // entering the name for user 
	        yourName = JOptionPane.showInputDialog(null, "Enter your full name here please");
	
	        // results shown 
	        JOptionPane.showMessageDialog(null, "Your have entered " + yourName);
	   
	
	        
	        Object[] possibleValues = { "First", "Second", "Third" };
	        Object selectedValue = JOptionPane.showInputDialog(null, 
	                                                           "Choose one", "Input",
	                                                            JOptionPane.INFORMATION_MESSAGE, null,
	                                                            possibleValues, possibleValues[0]);
	                                                            
	        again = JOptionPane.showConfirmDialog(null, "Do you want to play again");
	        //System.out.println(temp);
        }while(again == 0);

    }

}
