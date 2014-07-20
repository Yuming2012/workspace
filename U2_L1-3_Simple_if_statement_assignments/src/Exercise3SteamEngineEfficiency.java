import java.util.Scanner;


public class Exercise3SteamEngineEfficiency {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
/*		The maximum possible efficiency of a steam engine depends on the temperature of the steam in the boiler 
		and the temperature of the outside air: 
			efficiency = 1 - Tair / Tsteam
		where Tair is the air temperature and Tsteam is the steam temperature. The temperatures are give in 
		degrees above absolute zero. Normal air temperature is about 300oK. Boiling is 373oK. Write a program 
		that asks the user for the air temperature and the steam temperature and writes out the maximum 
		possible efficiency of a steam engine. However, if the steam temperature is less than 373oK there is 
		no steam, so the efficiency is zero. 
		Use integer or floating point input, but do the calculations in floating point. 
*/
		
		Scanner input = new Scanner(System.in);

		// Input air temperature
		float tAir = 0;
		System.out.println("Enter the air temperature (>0): ");
		try {
			tAir = input.nextFloat();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Invalid input. A number is expected.");
			System.exit(0);
		}
		
		// Input steam temperature
		System.out.println("Enter the steam temperature (>0): ");
		float tSteam = 0;
		try {
			tSteam = input.nextFloat();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("The maximum possible efficiency: ");
			System.exit(0);
		}
		
		float efficiency;
		
		if(tSteam < 373) {
			efficiency = 0;
		} else {
			efficiency = 1 - tAir/tSteam;
		}
		
		// writes out the maximum possible efficiency
		System.out.println("The maximum possible efficiency: " + String.format("%.2f", efficiency));
	}

}
