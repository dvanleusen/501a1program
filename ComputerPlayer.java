
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

public class ComputerPlayer extends Player {
	
	public Score computerScore;

	/**
	 * Constructor for creating a computer player.
	 */
	public ComputerPlayer(int cpuScore) {
		computerScore = new Score();
		computerScore.setScore(cpuScore);
	}
}
