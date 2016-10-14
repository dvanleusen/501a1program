
/**
* The ComputerPlayer class implements the gaming strategy of the computer player.
* <p>
* It has a single constructor.
* The computer player works similar to the automated human player 
* but it determines the base value for Hold on its own.
* <p>
* @author Daniel Van Leusen
* @version Feb 23, 2015
*/

public class ComputerPlayer {
	
	private int computerScore = 0;

	/**
	 * Constructor for creating a computer player.
	 */
	public ComputerPlayer() {
		computerScore = 0;
	}

	/**
	 * An acceesor to access the computer score
	 *
	 * @return	returns the current computer score	
	 */
	public int getComputerScore(){
		return computerScore;
	}

	/**
	 * A mutator to set new computer score
	 *
	 */
	public void setComputerScore(int newComputerScore){
		computerScore = newComputerScore;
	}

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
		if (humanScore >= 71 || computerScore >= 71)
		{
			compDecision = 'r';
		}
		// otherwise it will determine the base value and roll until it is achieved
		else
		{
			int baseComputer = (int) 21+ Math.round((computerScore - humanScore)/8);
			if (points < baseComputer)
			{
				compDecision = 'r';
			}
			else
			{
				compDecision = 'h';
			}
		}
		return compDecision;
	}
}
