import java.util.Scanner;

public class Player{
	
	public int baseHuman = -1;
	
	/**
	 * The method play() is called by the Controller after each die roll.
	 * The scores do not change in the middle of a turn.
	 * Only at the end of a turn, the Controller updates the scores.
	 *  
	 * @param	computerScore	the computer player score at the beginning of this turn 
	 * @param	humanScore		the human player score at the beginning of this turn
	 * @param	points			the sum of rolls collected so far in this turn
	 * @return	the next move of the player as a character: Roll or Hold	
	 */
	public char computer(int computerScore, int humanScore, int points) {

		char compDecision = ' ';
		// checks if either player's score is over 71, if yes, it will roll
		if (humanScore >= 71 || computerScore >= 71) {
			compDecision = 'r';
		}
		// otherwise it will determine the base value and roll until it is achieved
		else {
			int baseComputer = (int) 21+ Math.round((computerScore - humanScore)/8);
			if (points < baseComputer) {
				compDecision = 'r';
			}
			
			else {
				compDecision = 'h';
			}
		}
		return compDecision;
	}
	

	/**
	 * The method play() is called by the Controller after each die roll.
	 * The scores do not change in the middle of a turn.
	 * Only at the end of a turn, the Controller updates the scores.
	 *  
	 * @param	points			the sum of rolls collected so far in this turn
	 * @return	the next move of the player as a character: Roll or Hold	
	 */
	public char human(int points) {
		char humanDecision = ' ';

		if (baseHuman == -1) {
			Scanner keyboard = new Scanner(System.in);
			// prompts user to choose hold or roll
			while (humanDecision != 'h' && humanDecision != 'r') {
				System.out.print("     H: (r)un or (h)old? ");
				humanDecision = keyboard.next().charAt(0);
			}
		}
		// automated mode: roll until the user entered hold base value is achieved
		else {
			if (points < baseHuman)	{
				humanDecision = 'r';
			}

			else {
				humanDecision = 'h';
			}
		}

		return humanDecision;
	}
}