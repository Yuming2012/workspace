import java.util.Scanner;


public class Exercise5FantasyGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
/*		In a new role-playing fantasy game players must design their character by picking a point value for each
		of three characteristics: 
			•	Strength, from 1 to 10 
			•	Health, from 1 to 10 
			•	Luck, from 1 to 10 
		Write a program that asks for a name for the character and asks for the point value of for each of the three
		characteristics. However, the total points must be less than 15. If the total exceeds 15, then 5 points are 
		assigned to each characteristic 
			Welcome to Yertle's Quest
			Enter the name of your character:
			Chortle
			Enter strength (1-10):
			8
			Enter health (1-10):
			4
			Enter luck (1-10):
			6
			You have give your character too many points!  Default values have been assigned:
		Chortle, strength: 5, health: 5, luck: 5
		(This user interface could get much more complicated. You might want to implement some of your own ideas.) 
*/
		
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to Yertle's Quest");

		// Input character name
		System.out.println("Enter the name of your character: ");
		String name = "";
		try {
			name = input.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}

		// Input Strength, from 1 to 10
		System.out.println("Enter strength (1-10): ");
		int strength = 0;
		try {
			strength = input.nextInt();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Invalid input. An integer is expected.");
			System.exit(0);
		}

		// Input Strength, from 1 to 10
		System.out.println("Enter health (1-10): ");
		int health = 0;
		try {
			health = input.nextInt();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Invalid input. An integer is expected.");
			System.exit(0);
		}

		// Input Strength, from 1 to 10
		System.out.println("Enter luck (1-10): ");
		int luck = 0;
		try {
			luck = input.nextInt();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Invalid input. An integer is expected.");
			System.exit(0);
		}
		
		// the total points must be less than 15
		if((strength + health + luck) > 15) {
			System.out.println("You have give your character too many points!  Default values have been assigned:");
			strength = 5;
			health = 5;
			luck = 5;			
		}
		
		System.out.println(name + ", strength: " + strength + ", health: " + health + ", luck: " + luck);

	}

}
