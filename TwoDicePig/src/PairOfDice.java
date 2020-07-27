import java.util.Random;

public class PairOfDice {
private int die1, die2;
	
	public void roll() {
		Random rand = new Random(); //random class
		//roll the dice
		die1 = rand.nextInt(6) + 1;
		die2 = rand.nextInt(6) + 1;
	}

	public int getDie1() {
		return die1;
	}

	public void setDie1(int die1) {
		this.die1 = die1;
	}

	public int getDie2() {
		return die2;
	}

	public void setDie2(int die2) {
		this.die2 = die2;
	}
}
