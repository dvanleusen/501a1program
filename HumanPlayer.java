import java.util.Scanner;

/**
* The HumanPlayer class implements the gaming strategy of a human player.
* <p>
* It has two modes of operation: interactive or automated.
* To create an interactive human player, use the no-argument constructor.
* To create an automated human player use the constructor with one parameter.
* In the interactive mode, the user should be prompted to choose between Hold or Roll
* after every roll of the die.
* <p> 
* The method "play" is called by the Controller
* 
* @author Daniel Van Leusen
* @version Feb 23, 2015
*/

public class HumanPlayer {

	private int humanScore = 0;
	private int baseHuman = -1;


	/**
	 * An acceessor to access the human score
	 *
	 * @return	returns the current human score
	 */
	public int getHumanScore()
	{
		return humanScore;
	}

	/**
	 * A mutator to set new human score
	 *
	 */
	public void setHumanScore(int newHumanScore)
	{
		humanScore = newHumanScore;
	}
	
	/**
	 * Constructor for creating an automated human player.
	 * 
	 * @param	base	The value of the base when deciding whether to Roll or Hold.
	 */
	public HumanPlayer(int base)
	{
		baseHuman = base;
	}

	/**
	 * Constructor for creating an interactive human player.
	 */
	public HumanPlayer(int base, char mode) {

		if (mode == 'i') {
			humanScore = 0;
		}

		else {
			baseHuman = base;
		}
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
