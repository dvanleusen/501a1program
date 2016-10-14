
/**
* The Controller class is in charge of playing the game.
* <p>
* It manages turns between players, keeps track of scores and handles rolling the die. The start() 
* method should be called after initialization to start the game.
* <p>
* @author Daniel Van Leusen
* @version Feb 23, 2015
*/

public class Controller {

	// initializes objects of three different classes that will be used in other methods
	ComputerPlayer controlCpu;
	HumanPlayer controlHuman;
	Dice controlDice;
	boolean blnHumanPlayer = false;
	boolean blnFirstHand = false;
	int intTotalScore = 0;
	int points = 0;
	/**
	 * A constructor for the controller that declares class variables
	 * 
	 * @param	cpuPlayer	The computer player object
	 * @param	userPlayer	The human player object
	 * @param	dice		The die to be used in the game
	 */

	public Controller(ComputerPlayer cpuPlayer, HumanPlayer userPlayer, Dice dice) {
		controlCpu = cpuPlayer;
		controlHuman = userPlayer;
		controlDice = dice;
	}
	
	private void roundControl(){
		// checks if it is the first hand of the round: the first hand does not let player
		// choose to roll or to hold
		if (blnFirstHand || (blnHumanPlayer && controlHuman.human(points) == 'r')|| (!blnHumanPlayer && controlCpu.computer(controlCpu.getComputerScore(), controlHuman.getHumanScore(), points) == 'r'))
		{
			int intCurrentRoll = controlDice.roll();
			points += intCurrentRoll;
			if (blnHumanPlayer)
				System.out.println("     H: dice = " + intCurrentRoll + " points = " + points);
			else 
				System.out.println("     C: dice = " + intCurrentRoll + " points = " + points);
			// if rolls 1, no new score is gained by the player and your opponent starts rolling
			if (intCurrentRoll == 1)
			{
				blnHumanPlayer = !blnHumanPlayer;
				points = 0;
			}

			else
			{
				
				intTotalScore += intCurrentRoll;
			}
		}

		else
		{
			blnHumanPlayer = !blnHumanPlayer;
		}
		blnFirstHand = false;
	}
	
	/**
	 * It is called from the main program to start the game once a Controller object
	 * has been initialized with two players and a die.
	 */
	public void start() {

		// plays the game in a loop
		// after each roll of the die, call the play method
		// of the corresponding player to find out if Roll or Hold
		// the game terminates when a player wins
		// a player wins when its score reaches 100
		// ...
		int totalPoint = 100;
		blnHumanPlayer = true;
		int round = 1;

		// checks if any player's score is over 100
		while (controlCpu.getComputerScore() < totalPoint && controlHuman.getHumanScore() < totalPoint)
		{
			System.out.println("\n[" + round + "]" + "ComputerScore = " + controlCpu.getComputerScore() +
			"  HumanScore = " + controlHuman.getHumanScore());
			points = 0;
			intTotalScore = 0;
			blnFirstHand = true;
			intTotalScore = blnHumanPlayer?controlHuman.getHumanScore():controlCpu.getComputerScore();
			// human player always goes first and checks if it is human's turn
		
			if (blnHumanPlayer)
			{
			// checks again if it is human's turn at each roll, and see if the new score exceeds 100
				while (blnHumanPlayer &&  intTotalScore < totalPoint)
				{
					// checks if it is the first hand of the round: the first hand does not let player
					// choose to roll or to hold
					roundControl();
				}
				// records the new human player score
				controlHuman.setHumanScore(controlHuman.getHumanScore()+points);
			}

			// a similar logic is applied to computer player, please see above comments
			else
			{
				while (!blnHumanPlayer &&  intTotalScore < totalPoint)
				{
					roundControl();
				}
				controlCpu.setComputerScore(controlCpu.getComputerScore()+points);
			}
			// counts number of rounds
			round++;
		}

		// checks if human wins
		if (controlCpu.getComputerScore() <  controlHuman.getHumanScore())
		{
			System.out.println("\nGame is over, human player wins with the score " + controlHuman.getHumanScore() + "!!"); 

		}
		// checks if the game is a draw
		else if(controlCpu.getComputerScore() ==  controlHuman.getHumanScore())
		{
			System.out.println("\nGame is over, it is a draw with a score " + controlHuman.getHumanScore() + "!!"); 
		}
		// checks if computer wins
		else{
			System.out.println("\nGame is over, computer player wins with the score " + controlCpu.getComputerScore() + "!!"); 
		}
	}
}
