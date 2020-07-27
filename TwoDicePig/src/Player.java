
public class Player {
	//Player class should have a name instance variable and a score instance variable. 
		private String name;
		private int score;
		
		public Player(String playerName, int myScore) { //constructor
			name = playerName;
			score = myScore;
		}
		public String toString() {
			return name + ":    Score: " + score;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getScore() {
			return score;
		}
		public void setScore(int score) {
			this.score = score;
		}
}
