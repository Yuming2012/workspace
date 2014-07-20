
public class RockPaperScissors {
	enum enResult {
		YOU_WIN,
		YOU_LOSE,
		WE_EVEN
	};
	
	static public String names[] = {"Rock", "Paper", "Scissors"};

	int youPick;
	int computerPick;
	enResult result = enResult.WE_EVEN;
	
	//1: "Rock", 2: "Paper", 3: "Scissors"
	RockPaperScissors(int pick) {
		youPick = pick;
		computerPick = GenerateRandomNumber(3);
		switch(youPick) {
		case 1:
			if(computerPick == 2) {
				result = enResult.YOU_LOSE;
			} else if(computerPick == 3) {
				result = enResult.YOU_WIN;
			} else {
				result = enResult.WE_EVEN;				
			}
			break;
			
		case 2:
			if(computerPick == 1) {
				result = enResult.YOU_WIN;
			} else if(computerPick == 3) {
				result = enResult.YOU_LOSE;
			} else {
				result = enResult.WE_EVEN;				
			}
			break;
			
		case 3:
			if(computerPick == 1) {
				result = enResult.YOU_LOSE;
			} else if(computerPick == 2) {
				result = enResult.YOU_WIN;
			} else {
				result = enResult.WE_EVEN;				
			}
			break;
			
		default:
			result = enResult.WE_EVEN;
		}
	}
	

	public String getResult() {
		String theResult;
		String statement = "You picked \"" + names[youPick-1] + "\"; I picked \"" + names[computerPick-1] + "\"";
		
		switch(result) {
			case YOU_WIN:
				theResult = "You win! ";
				break;
			case YOU_LOSE:
				theResult = "You lose! ";
				break;
			case WE_EVEN:
				theResult = "We even! ";
				break;
			default:
				theResult = "We even! ";
		}
		return theResult + statement;
	}
	
	public int GenerateRandomNumber (int a) {
		int num = (int) Math.ceil((Math.random()*a));
		return num;
	}
}


