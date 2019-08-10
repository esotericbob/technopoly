package technopoly;
/**
 * Group 4 Technolpoly Sci-fi Conglomerate edition
 * @author Andy McCollum, Neil Gray, Jay hanna, Jonathan Smyth
 * @version 1.0.0
 * 
 */
public class Launch extends Square{
	public static void launchAction(Player player) {
		System.out.println("BLASTOFF ... adding 150 credits");
		player.setCredits(player.getCredits() + 150);
	}

	public Launch() {
		super("LAUNCH", false);
	}
}
