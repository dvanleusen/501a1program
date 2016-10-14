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

public class HumanPlayer extends Player  {

	public Score humanScore;


	/**
	 * Constructor for creating an interactive human player.
	 */
	public HumanPlayer(int base, char mode) {
		humanScore = new Score();
		baseHuman = base;
		if (mode == 'i') {
			humanScore.setScore(0);
		}

		else {
			baseHuman = base;
		}
	}
	

}
