import java.util.Scanner; // Import the Scanner class

public class TwoDicePig {
	private static Player[] players;

	public static void main(String[] args) {

		Scanner myObj = new Scanner(System.in); // Create a Scanner object
		System.out.println("Enter number of players."); // Ask for number of players

		int playerCount = myObj.nextInt(); // Read user input
		System.out.println("Will now begin the game with " + playerCount + " players!"); // Output user input

		players = new Player[playerCount];// create an instance for Player class

		// create array of objects for players
		for (int i = 0; i < playerCount; i++) {
			// auto-generated player name
			int playerNum = i + 1;
			String generatedName = "Player" + playerNum;
			// pass in player name and starting score for player data
			players[i] = new Player(generatedName, 0);
		}

		boolean winner = false;
		// while no one has a score 100 or greater, loop through players
		while (!winner) {
			for (int i = 0; i < players.length; i++) {
				players[i].setScore(playerTurn(players[i].getName(), i));
				if (players[i].getScore() >= 100) {
					winner = true;
					System.out.println(players[i]);
					System.out.println("Game Over. " + players[i].getName() + " wins!");
					break;
				}
			}
		}
	} // end main method

	// The program should have a function named playerTurn that allows the player to
	// decide when to “hold”. The function must return the score for the player’s
	// turn.
	//
	private static int playerTurn(String name, int idx) {
		int die1, die2, choice, roundScore;
		int totalScore = players[idx].getScore();
		boolean rollAgain = false;
		String endTurnMsg = ("End " + name + " turn.");
		PairOfDice dices = new PairOfDice(); // create instance of the PairOfDice class

		// Each turn, a player repeatedly rolls two dice until a 1 is rolled or the
		// player decides to “hold”:
		do {

			if (!rollAgain) {
				Scanner scan = new Scanner(System.in);
				System.out.println("Turn: " + name);
				System.out.println("Enter (1) to Roll or (2) to Hold");
				choice = scan.nextInt();
			} else {
				choice = 1;
			}

			if (choice == 1) {
				dices.roll();
				die1 = dices.getDie1();
				die2 = dices.getDie2();
				System.out.println("First die value: " + die1);
				System.out.println("Second die value: " + die2);

				if (die1 == 1 && die2 == 1) {
					// If two 1s are rolled, the player’s entire score is lost, and the turn ends.
					totalScore = 0;
					players[idx].setScore(totalScore);
					System.out.println("Shucks, you lost all of your points. Score: " + totalScore + " " + endTurnMsg);
					return totalScore;
				} else if (die1 == 1 || die2 == 1) {
					// If a single 1 is rolled, the player scores nothing and the turn ends.
					System.out.println("Sorry, you scored nothing! Your total score is: " + totalScore);
					System.out.println(endTurnMsg);
					return totalScore;
				}
				if (die1 == die2) {
					// If a double is rolled, the point total is added to the turn total as with any
					// roll but the player is obligated to roll again.
					roundScore = die1 + die2;
					totalScore += roundScore;
					players[idx].setScore(totalScore);
					System.out.println("This round's score: " + roundScore);
					System.out.println("Total Score: " + totalScore);
					System.out.println("Double! Now roll again.");
					rollAgain = true;
				} else {
					// If the player rolls any other number, it is added to their turn total and the
					// player’s turn continues.
					roundScore = die1 + die2;
					totalScore += roundScore;
					players[idx].setScore(totalScore);
					System.out.println("This round's score: " + roundScore);
					System.out.println("Total Score: " + totalScore);
					rollAgain = false;
				}
			} // end if choice 1
				// If a player chooses to “hold”, their turn total is added to their score, and
				// it becomes the next player’s turn.
			if (choice == 2) {
				System.out.println(endTurnMsg);
				return totalScore;
			}
			// The first player to 100 or more points wins.
		} while (players[idx].getScore() < 100);

		return totalScore;

	} // end playerTurn
} // end TwoDicePig class
