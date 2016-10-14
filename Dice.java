
import java.util.Random;

/**
 * A simple class to simulate rolling a six-sided die.
 * <p>
 * A seed for the random number generator should be provided
 * when calling the constructor. Internally, class Dice uses
 * the Java class Rnadom.
 * 
 * @author Majid Ghaderi
 * @since Feb 5, 2015
 */
public class Dice {
	private Random random;	// the internal Java Random object
	
	/**
	 * The sole constructor of the class Dice.
	 * 
	 * @param seed 	The seed used to initialize class Random.
	 */
	public Dice(int seed) {
		random = new Random(seed);
	}
	
	/**
	 * It is used to simulate the rolling of a die.
	 * Every time it is called, it return a number from 1 to 6.
	 * 
	 * @return	The number rolled.
	 */
	public int roll() {
		return (random.nextInt(6) + 1);
	}
}
