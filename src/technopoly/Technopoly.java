
package technopoly;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Group 4 Technolpoly Sci-fi Conglomerate edition
 * @author Andy McCollum, Neil Gray, Jay hanna, Jonathan Smyth
 * @version 1.0.0
 * 
 */
public class Technopoly {
	/**
	 * ArrayList containing all <code>Player</code> instances in current game
	 */
	public static ArrayList<Player> players;
	/**
	 * ArrayList containing all <code>Square</code> instances in current game
	 */
	public static ArrayList<Square> board;
	/**
	 * ArrayList containing all <code>Company</code> instances in current game
	 */
	public static ArrayList<Company> allCompanies;

	/**
	 * Static instance of <code>Dice</code> class
	 */
	public static Dice die = new Dice();
	/**
	 * 
	 */
	public static boolean gameOver = false;
	/**
	 * boolean marker to flag end of game
	 */
	public static Scanner in = new Scanner(System.in);

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		welcome();
		setup();

		startGame();
		// askToRoll();
		int playerCounter = 0;
		int turnCounter = 0;
		while (!gameOver) {
			turnCounter++;
			for (Player p : players) {
				takeTurn(p, die, board, turnCounter);
				playerCounter++;
				if (playerCounter > players.size() - 1) {
					playerCounter = 0;
				}
				if (gameOver) {
					break;
				}
			}
			if (gameOver) {
				// System.out.println("GAME OVER MAN!");
				gameOver();
			}
		}
	}

	/**
	 * Setup the Game board and add players
	 * 
	 */
	public static void setup() {
		addSquares();
//		board.toArray();
//		System.out.println(board.toString());
		addPlayers();
//		players.toArray();
//		System.out.println(players.toString());

	}

	/**
	 * Prints a welcome message before the game begins
	 */
	/**
	 * 
	 */
	public static void welcome() {
		System.out.println(

				"                     ___________             .__                                     .__             _________        .__          ___________.__ 				\n"
						+ "                     \\__    ___/____   ____  |  |__    ____    ____  ______    ____  |  |  ___.__.  /   _____/  ____  |__|         \\_   _____/|__|				\n"
						+ "                       |    | _/ __ \\_/ ___\\ |  |  \\  /    \\  /  _ \\ \\____ \\  /  _ \\ |  | <   |  |  \\_____  \\ _/ ___\\ |  |  ______  |    __)  |  |				\n"
						+ "                       |    | \\  ___/\\  \\___ |   Y  \\|   |  \\(  <_> )|  |_> >(  <_> )|  |__\\___  |  /        \\\\  \\___ |  | /_____/  |     \\   |  |				\n"
						+ "                       |____|  \\___  >\\___  >|___|  /|___|  / \\____/ |   __/  \\____/ |____// ____| /_______  / \\___  >|__|          \\___  /   |__|				\n"
						+ "                                   \\/     \\/      \\/      \\/         |__|                  \\/              \\/      \\/                   \\/        			\n"
						+ "             _________                          .__                                            __            ___________    .___.__   __   .__               	\n"
						+ "             \\_   ___ \\   ____    ____    ____  |  |    ____    _____    ____ _______ _____  _/  |_   ____   \\_   _____/  __| _/|__|_/  |_ |__|  ____    ____  \n"
						+ "             /    \\  \\/  /  _ \\  /    \\  / ___\\ |  |   /  _ \\  /     \\ _/ __ \\\\_  __ \\\\__  \\ \\   __\\_/ __ \\   |    __)_  / __ | |  |\\   __\\|  | /  _ \\  /    \\ \n"
						+ "             \\     \\____(  <_> )|   |  \\/ /_/  >|  |__(  <_> )|  Y Y  \\\\  ___/ |  | \\/ / __ \\_|  |  \\  ___/   |        \\/ /_/ | |  | |  |  |  |(  <_> )|   |  \\ \n"
						+ "              \\______  / \\____/ |___|  /\\___  / |____/ \\____/ |__|_|  / \\___  >|__|   (____  /|__|   \\___  > /_______  /\\____ | |__| |__|  |__| \\____/ |___|  /\n"
						+ "                     \\/              \\//_____/                      \\/      \\/             \\/            \\/          \\/      \\/                             \\/ \n");

	}

	/**
	 * creates instances of all squares that comprise the game board
	 */
	public static void addSquares() {
		Company planetExpress = new Company("Planet Express", Field.SPACEEXPLORATION, 50, 30, 90, 270, 550, 0, 6, 100);
		Company weylandYutani = new Company("Weyland-Yutani", Field.SPACEEXPLORATION, 50, 30, 90, 270, 550, 0, 6, 100);
		Company raptureFarms = new Company("Rapture Farms", Field.BIOTECH, 90, 70, 200, 550, 950, 0, 14, 180);
		Company umbrella = new Company("Umbrella", Field.BIOTECH, 90, 70, 200, 550, 950, 0, 14, 180);
		Company inGen = new Company("InGen", Field.BIOTECH, 100, 80, 220, 600, 1000, 0, 16, 200);
		Company ocp = new Company("OCP", Field.ROBOTICS, 130, 110, 330, 800, 1150, 0, 22, 260);
		Company cyberdyne = new Company("Cyberdyne", Field.ROBOTICS, 130, 110, 330, 800, 1150, 0, 22, 260);
		Company tyrell = new Company("Tyrell", Field.ROBOTICS, 140, 120, 360, 850, 1200, 0, 24, 280);
		Company lexCorp = new Company("LexCorp", Field.RANDD, 175, 175, 500, 1100, 1500, 0, 35, 350);
		Company wayneEnterprises = new Company("Wayne Enterprises", Field.RANDD, 200, 200, 600, 1400, 2000, 0, 50, 400);
		Launch launch = new Launch();
		Restaurant restaurant = new Restaurant();

		board = new ArrayList<Square>();

		board.add(0, launch);
		board.add(planetExpress);
		board.add(weylandYutani);
		board.add(raptureFarms);
		board.add(umbrella);
		board.add(inGen);
		board.add(6, restaurant);
		board.add(ocp);
		board.add(cyberdyne);
		board.add(tyrell);
		board.add(wayneEnterprises);
		board.add(lexCorp);

		allCompanies = new ArrayList<Company>();

		allCompanies.add(planetExpress);
		allCompanies.add(weylandYutani);
		allCompanies.add(raptureFarms);
		allCompanies.add(umbrella);
		allCompanies.add(inGen);
		allCompanies.add(ocp);
		allCompanies.add(cyberdyne);
		allCompanies.add(tyrell);
		allCompanies.add(wayneEnterprises);
		allCompanies.add(lexCorp);

	}

	/**
	 * Creates instances of input number of <code>Player</code> class and adds to arraylist <code>players</code>
	 */
	public static void addPlayers() {
		players = new ArrayList<Player>();

		boolean valid = false;
		while (!valid) {
			try {
				System.out.println("How many players? 2-4");
				int numPlayers = in.nextInt();
				if (numPlayers >= 2 && numPlayers <= 4) {
					for (int i = 0; i < numPlayers; i++) {
						Player player = new Player(500, "Player " + String.valueOf(i + 1), 0);
						players.add(player);
						// System.out.println(player.toString());
						valid = true;
					}
				} else {
					System.out.println("Invalid number of players, please enter a value 2-4");
				}
			} catch (InputMismatchException ex) {
				// ex.printStackTrace();
				System.out.println("Invalid input, please enter a value 2-4");
				in.next();
			}

		}
	}

	/**
	 * Prompts user to enter custom gamertag and displays start message
	 */
	public static void startGame() {
		enterPlayerNames(players);
		System.out.println();
		System.out.println("--------------------Let's Play!--------------------");
	}

	/**
	 * Updates Player with new, custom gamertag
	 * 
	 * @param players list of all players
	 */
	public static void enterPlayerNames(ArrayList<Player> players) {
		for (Player p : players) {
			String gamertag = p.getGamertag();
			System.out.println("Enter Gamertag for " + gamertag + ":");
			
		
			gamertag = in.next();
			
			p.setGamertag(gamertag);
			System.out.println("Name changed to " + gamertag);
			System.out.println(p.toString());
		}
	}

	/**complete turn for all players until gameover is true
	 * @param player current player
	 * @param die instance of Dice class
	 * @param board list of all squares
	 * @param turn current turn number value
	 */
	public static void takeTurn(Player player, Dice die, ArrayList<Square> board, int turn) {
		System.out.println();

		String gamertag = player.getGamertag();
		System.out.println(gamertag + "'s turn");
		int move = 0;

		if (turn == 1) {
			// get value from roll of die
			move = askToRoll();
		} else if (turn == 3) {
			player.setCredits(-100);
		} else {
			hireProcess(player);
			move = askToRoll();
		}
		// if player does not quit continue with turn
		if (move > 0) {
			movePlayer(player, move);
			if (player.isBankrupt()) {
				gameOver = true;
			}
			System.out.println("END OF TURN");
			System.out.println("---------------------------");
			System.out.println();
		}
	}

	/**ask player to roll die
	 * @return face value of dice roll
	 */
	public static int askToRoll() {
		boolean rolled = false;
		int returnVal = -1;
		while (!rolled) {
			System.out.println("Would you like to roll? Y/N");
			String input = in.next();
			input = input.substring(0, 1).toUpperCase();
			System.out.println();
			switch (input) {
			case "Y":
				System.out.println("Rolling die");

				int roll1, roll2, rollTotal;
				roll1 = die.rollDice();
				roll2 = die.rollDice();
				rollTotal = roll1 + roll2;

				System.out.println("You rolled " + roll1 + " and " + roll2);
				System.out.println("Moving " + rollTotal + " spaces");
				rolled = true;
				returnVal = rollTotal;
				break;
			case "N":
				System.out.println("Quit game? Y/N");
				input = in.next();
				input = input.substring(0, 1).toUpperCase();

				switch (input) {
				case "Y":
					System.out.println("Quitting game...");
					gameOver = true;
					rolled = true;
					break;
				case "N":
					System.out.println("continuing game...");
					break;
				default:
					System.out.println("Invalid input, please try again");
					break;
				}
				break;
			default:
				System.out.println("Invalid input, please try again");
				break;
			}
		}
		return returnVal;
	}

	/**ask player if they wish to hire VP or CEO for company in owned field
	 * @param player current player
	 */
	public static void hireProcess(Player player) {
		int count = 0;
		if (checkOwnsField(player, Field.SPACEEXPLORATION) || checkOwnsField(player, Field.BIOTECH)
				|| checkOwnsField(player, Field.ROBOTICS) || checkOwnsField(player, Field.RANDD)) {
			if (askToHire(player)) {
				Company[] hire = new Company[10];

				System.out.println("Where would you like to hire for?");

				if (checkOwnsField(player, Field.SPACEEXPLORATION)) {
					System.out.println("Space Exploration:");
					for (Company company : allCompanies) {

						if (company.getField() == Field.SPACEEXPLORATION) {
							count++;
							
							System.out.println(count + ". " + company.getName());
							hire[count] = company;
						}
					}
					System.out.println();
				}
				if (checkOwnsField(player, Field.ROBOTICS)) {
					System.out.println("Robotics");
					for (Company company : allCompanies) {

						if (company.getField() == Field.ROBOTICS) {
							count++;
							
							System.out.println(count + ". " + company.getName());
							hire[count] = company;

						}
					}
					System.out.println();
				}
				if (checkOwnsField(player, Field.BIOTECH)) {
					System.out.println("Biotech");
					for (Company company : allCompanies) {

						if (company.getField() == Field.BIOTECH) {
							count++;
							
							System.out.println(count + ". " + company.getName());
							hire[count] = company;

						}
					}
					System.out.println();
				}
				if (checkOwnsField(player, Field.RANDD)) {
					System.out.println("Research and Development");
					for (Company company : allCompanies) {
						if (company.getField() == Field.RANDD) {
							count++;
						
							System.out.println(count + ". " + company.getName());
							hire[count] = company;

						}
					}
					System.out.println();
				}
				System.out.println("0. Cancel");

				boolean valid = false;
				do {
					try {
						int input = in.nextInt();
						if (input > 0 && input <= 9 && hire[input] != null) {
							Company upgradeCompany = hire[input];
							String upgradeCompanyName = upgradeCompany.getName();
							int upgadeVPHireCost = upgradeCompany.getHireVPCost();

							switch (upgradeCompany.getNumVPs()) {
							case 0:
								System.out.println("VP Price: " + upgradeCompany.getHireVPCost() + " credits");
								System.out.println("How many VP's will you be hiring?\n" + "0 - None\n"
										+ "1 - One VPs\n" + "2 - Two VPs\n" + "3 - Three VPs\n" + "4 - Hire CEO");
								input = in.nextInt();
								if (input >= 0 && input <= 4) {
									break;
								} else {
									System.out.println("invalid input, please select a number 0-4");
									valid = false;
									break;
								}

							case 1:
								System.out.println("VP Price: " + upgradeCompany.getHireVPCost() + " credits");
								System.out.println("How many VP's will you be hiring?\n" + "0 - None\n"
										+ "1 - Two VPs\n" + "2 - Three VPs\n" + "3 - Hire CEO");
								input = in.nextInt();
								if (input >= 0 && input <= 3) {
									break;
								} else {
									System.out.println("invalid input, please select a number 0-3");
									valid = false;
									break;
								}
							case 2:
								System.out.println("VP Price: " + upgradeCompany.getHireVPCost() + " credits");
								System.out.println("How many VP's will you be hiring?\n" + "0 - None\n"
										+ "1 - Three VPs\n" + "2 - Hire CEO");
								input = in.nextInt();
								if (input >= 0 && input <= 2) {
									break;
								} else {
									System.out.println("invalid input, please select a number 0-2");
									valid = false;
									break;
								}
							case 3:
								System.out.println("VP Price: " + upgradeCompany.getHireVPCost() + " credits");
								System.out
										.println("How many VP's will you be hiring?\n" + "0 - None\n" + "1 - Hire CEO");
								input = in.nextInt();
								if (input >= 0 && input <= 1) {
									break;
								} else {
									System.out.println("invalid input, please select a number 0-1");
									valid = false;
									break;
								}
							default:
								valid = false;
								break;
							}
							int totalRecruitmentCost = (upgadeVPHireCost * input);
							if (totalRecruitmentCost > player.getCredits()) {
								System.out.println("insufficient credits to recruit staff");
								valid = false;
								break;
							}
							if (upgradeCompany.getNumVPs() < 4) {
								upgradeCompany.setNumVPs(upgradeCompany.getNumVPs() + input);
								System.out.println(upgradeCompanyName + "upper management team upgraded to "
										+ upgradeCompany.getNumVPs() + " member(s)");
							} else {
								System.out.println("Company already has CEO");
							}
							break;
						}

						if (input == 0) {
							System.out.println("Cancelling interviews");
							break;
						}
					} catch (InputMismatchException ex) {
						System.out.println("Invalid input, please try again");
						valid = false;
					}
				} while (!valid);
			}
		}
	}

	/**check if the current player owns all companies in a field
	 * @param p current player
	 * @param f list of fields
	 * @return true if player owns all companies in any given field
	 */
	public static boolean checkOwnsField(Player p, Field f) {

		for (Company c : allCompanies) {
			if (c.getField() == f && c.getOwner() != p) {
				return false;
			}
		}
		return true;
	}

	/**ask player if the wish to hire VPs/CEO
	 * @param player current player
	 * @return true if player wishes to hire staff
	 */
	public static boolean askToHire(Player player) {
		int spaceExCount = 0;
		int biotechCount = 0;
		int roboticsCount = 0;
		int rAndDCount = 0;

		ArrayList<Company> companies = player.getCompanies();

		if (companies.size() > 1) {
			for (Company company : companies) {
				Field field = company.getField();
				switch (field) {
				case SPACEEXPLORATION:
					spaceExCount++;
					break;
				case BIOTECH:
					biotechCount++;
					break;
				case ROBOTICS:
					roboticsCount++;
					break;
				case RANDD:
					rAndDCount++;
					break;
				default:
					System.out.println("");
				}
			}
			if (spaceExCount == 2 || biotechCount == 3 || roboticsCount == 3 || rAndDCount == 2) {
				System.out.println("Would you like to hire new upper management? Y/N");
				String input = in.next();
				input = input.substring(0, 1).toUpperCase();

				switch (input) {
				case "Y":
					return true;
				case "N":
					return false;
				default:
					System.out.println("invalid input, please try again");
					break;
				}
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**Display GAME OVER message
	 * 
	 */
	public static void gameOver() {
		System.out.println(

				"       ________    _____      _____   ___________   ________ ____   _________________________      _____      _____    _______  ._.	\n"
						+ "      /  _____/   /  _  \\    /     \\  \\_   _____/   \\_____  \\\\   \\ /   /\\_   _____/\\______   \\    /     \\    /  _  \\   \\      \\ | |	\n"
						+ "     /   \\  ___  /  /_\\  \\  /  \\ /  \\  |    __)_     /   |   \\\\   Y   /  |    __)_  |       _/   /  \\ /  \\  /  /_\\  \\  /   |   \\| |	\n"
						+ "     \\    \\_\\  \\/    |    \\/    Y    \\ |        \\   /    |    \\\\     /   |        \\ |    |   \\  /    Y    \\/    |    \\/    |    \\\\|	\n"
						+ "      \\______  /\\____|__  /\\____|__  //_______  /   \\_______  / \\___/   /_______  / |____|_  /  \\____|__  /\\____|__  /\\____|__  /__	\n"
						+ "             \\/         \\/         \\/         \\/            \\/                  \\/         \\/           \\/         \\/         \\/ \\/	\n");

	}

	/**move player to new position on board
	 * @param player current player
	 * @param move number of squares to move
	 */
	public static void movePlayer(Player player, int move) {
		// get player current position and add roll of die
		int newSpaceIndex = player.getPosition() + move;
		String gamertag = player.getGamertag();
		// if players new position exceeds the array of squares, return to 0 index and
		// add remainder
		// add credits for passing launch
		// else update position
		if (newSpaceIndex > 11) {
			player.setPosition(newSpaceIndex - 12);
			Launch.launchAction(player);
		} else {
			player.setPosition(newSpaceIndex);
		}

		if (player.getPosition() == 0) {
			Square newPosition = board.get(player.getPosition());
			System.out.println(gamertag + " new position " + newPosition.getName());
		} else if (player.getPosition() == 6) {
			Restaurant.restaurantAction();
		} else {
			Company newPosition = (Company) board.get(player.getPosition());
			System.out.println("____________________");
			System.out.println("Land on " + newPosition.getName());
			if (newPosition.isAvailable()) { 
				System.out.println("Purchase Price: " + newPosition.getPrice() + " credits");
				System.out.println("Current Balance: " + player.getCredits() + " credits");
				System.out.println();
			}

			if (newPosition.getOwner() != null && newPosition.getOwner() != player) {
				Player owner = newPosition.getOwner();
				int numVP = newPosition.getNumVPs();

				int rentCharge = 0;

				switch (numVP) {
				case 0:
					rentCharge = newPosition.getRent();
					break;
				case 1:
					rentCharge = newPosition.getRent1VP();
					break;
				case 2:
					rentCharge = newPosition.getRent2VP();
					break;
				case 3:
					rentCharge = newPosition.getRent3VP();
					break;
				case 4:
					rentCharge = newPosition.getRentCEO();
					break;
				default:
					System.out.println("oops...something went wrong");
					break;
				}

				System.out.println(owner.getGamertag() + " demands you pay " + rentCharge + " credits!");
				System.out.println(rentCharge + " credits will be deducted from your account");
				player.setCredits(player.getCredits() - rentCharge);
				owner.setCredits(owner.getCredits() + rentCharge);

				player.showBalance();
				owner.showBalance();

			} else {
				boolean valid = false;
				Player owner = newPosition.getOwner();

				if (owner != player) {
					do {
						System.out.println("What would you like to do now? ...\n" + "1. Buy company\n" + "2. End turn");
						try {
							int input = in.nextInt();
							int playerBalance = player.getCredits();
							int companyPrice = newPosition.getPrice();

							// take user input
							switch (input) {
							// if sufficient funds, buy property
							case 1:

								if (playerBalance > companyPrice) {
									System.out.println("You now own controlling stock of " + newPosition.getName());
									newPosition.setOwner(player);
									newPosition.setAvailable(false);
									player.setOwnsCompany(newPosition);

									System.out.println("Your account has been debited " + companyPrice + " credits");
									player.setCredits(player.getCredits() - companyPrice);
									System.out.println("New Balance: " + player.getCredits() + " credits");

									valid = true;
									break;
								} else {
									System.out.println("Insufficient funds to purchase " + newPosition.getName());
									break;
								}
								// end turn
							case 2:
								System.out.println("Ending turn");
								valid = true;
								break;
							// display error message and loop back
							default:
								System.out.println("Invalid input, please select one of the options 1-2");
								valid = false;
								break;
							}
						} catch (InputMismatchException e) {
							System.out.println("Invalid input, please select one of the options 1-2");
							valid = false;
							in.next();
						}
					} while (!valid);
				}
			}
		}

	}
}
