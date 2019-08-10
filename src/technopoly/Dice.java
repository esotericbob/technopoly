package technopoly;

import java.util.Random;
/**
 * Group 4 Technolpoly Sci-fi Conglomerate edition
 * @author Andy McCollum, Neil Gray, Jay hanna, Jonathan Smyth
 * @version 1.0.0
 * 
 */
public class Dice {
	public int rollDice() {
		Random r = new Random();
		int faceValue = r.nextInt(6) + 1;
		return faceValue;
	}
}
