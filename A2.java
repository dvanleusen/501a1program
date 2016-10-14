import java.util.Scanner;

/**
* Assignment 2
* @author Daniel Van Leusen
* Student id: 10064708
* E-mail: danvanleusen@yahoo.co.uk
* @version Feb 23, 2015
* <p>
* This is a game of Pig, which is a simple two-player dice game and the first player to reach 100
* or more points wins. This program does the following:
* 1. reads the value of seed as a command line argument and use it to create a Dice project; if the
* user does not provide any value, a default value of 1234 will be used
* 2. allows user to choose between interactive and automated modes; interactive mode allows human to
* choose to roll or to hold; automated mode allows player to enter a hold base, whenever it is the
* human's turn, the program keeps rolling until it has accumulated a score that is bigger or equal to
* the base for the round, or until a 1 is rolled
* 3. when it is the computer's turn, it plays according to the following rules: if either player's
* score is over 71, computer will keep rolling until winning or rolling a 1; otherwise, set the hold
* base for this turn to base = 21 + round((computerScore - humanScore)/8) and keep rolling until either
* 1 is rolled, or hold base for the turn is achieved
* 4. Whenever a 1 is rolled, any accumulated score for that turn does not count, and the other player
* starts to roll.
* <p>
* This game checks any illegal input and either prompts user to re-enter or exits the program. This game
* also is designed to be computer vs. human , and human vs. human matches are not supported yet. 
*/

public class A2 {

	//initializes and declares constants that will be used to check seed
	public static final int ASCII_ZERO = 48;
	public static final int ASCII_NINE = 57;

	public static void main(String[] args) {
		// integer variable seed is declared and initialized to 0
		int seed = 0;

		// checks if user enters an invalid command line argument that contains characters other than integers
		// if there is any illegal character, an error message will display and the program will be terminated
		for (int lngArgsLength = 0; lngArgsLength < args.length; lngArgsLength++) {
			int argLength = args[lngArgsLength].length();
			for (int index = 0; index < argLength; index++) {
				int asciiDig = (int) args[0].charAt(index);
				if ((asciiDig < ASCII_ZERO) || (asciiDig > ASCII_NINE)) {
					System.out.println("The seed argument has to be an integer number.");
					System.exit(0);	
				}
			}
		}

		// if user does not enter any command line argument, seed value is defaulted to be 1234
		if (args.length == 0) {
			seed = 1234;
		}

		// if user enters a valid command line argument, the entered value will be the new seed value
		else if (args.length == 1) {
			seed = Integer.parseInt(args[0]);
			System.out.println("Using the seed "+args[0]+".");
		}

		// if user enters more than one argument, an error message will display and the program will exit
		else {
			System.out.println("Usage: java Game <seed>");
			System.exit(0);
		}

		// initializes an object of class HumanPlayer, and declares it to be null because there are two
		// modes for the human player
		//HumanPlayer humanPlayer = null;

		// asks user if the human player should run in automated or interactive mode
		// initializes local variable humanPlayer based on the user input
		char mode = ' ';
		Scanner keyboard = new Scanner (System.in);
		
		while (mode!='i' && mode!='a') {
			System.out.println("\nYou can play this game in interactive or automated mode. \nEnter 'i' for interactive or 'a' for automated mode:");
			mode = keyboard.next().charAt(0);
		}
		int base = -1; 
		if (mode != 'i') {
			System.out.print("Enter an integer value for the base: ");
			base = keyboard.nextInt();
		}

		// starts the game
		System.out.println("Game Started . . .");
		Controller controller = new Controller(0, base, mode, seed);
		controller.start();
	}

}
