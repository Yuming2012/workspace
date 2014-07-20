
public class TwoArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
/*
		Arrays Exercise
		Declare two arrays of 20 integers: list1 and list2 
		1.	Fill up array list1 with 20 random integers between 1 and 100.  
		2.	Multiply each element in list1 by its index number and place the value in array list2.  
		3.	Replace the value of the elements in all odd number indexes in list2 with 0.  
		4.	Add list1 and list2 placing the value in list1. 
		5.	Find and print the average of the elements in list1 then list 2.  
		6.	Invert the array list2 placing the values in list1.  
		7.	Input a numeric value to search for in list1, and output the results, with location if found.
*/		
//		Declare two arrays of 20 integers: list1 and list2 
		int[] list1 = new int[20];
		int[] list2 = new int[20];
	
//		1.	Fill up array list1 with 20 random integers between 1 and 100.  
		for(int i = 0; i<20; i++) {
			list1[i] = (int) (Math.random()*100.0 + 1.0);
		}
		
//		2.	Multiply each element in list1 by its index number and place the value in array list2.  
		for(int i = 0; i<20; i++) {
			list2[i] = (i+1)*list1[i];
		}
		
//		3.	Replace the value of the elements in all odd number indexes in list2 with 0.  
		for(int i = 0; i<20; i++) {
			if(((i+1) & 1) == 1) {
				list2[i] = 0;
			}
		}

		System.out.println("Index" + "\tlist1" + "\tlist2");
		System.out.println("-----" + "\t-----" + "\t-----");
		for(int i = 0; i<20; i++) {
			System.out.println((i+1) + "\t" + list1[i] + "\t" + list2[i] );
		}

	}

}
