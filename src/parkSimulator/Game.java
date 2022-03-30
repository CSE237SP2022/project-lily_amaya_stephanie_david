package parkSimulator;

public class Game {
	public String team;
	private String gameMessage;

	
	/**
	 * Constructor for a Game
	 * @param name The name of the game
	 */
	public Game(String name) {
		team = name;
		gameMessage = "";
	}
	
	/**
	 * Runs simulation of a game
	 */
	public String simulateGame() {
		int teamAPoints = randomScore();
		int teamBPoints = randomScore();
		if(teamAPoints > teamBPoints) {
			gameMessage = team + "Wins!" + "Score: " + teamAPoints + "-" + teamBPoints;
		}
		else if(teamAPoints < teamBPoints){
			gameMessage = team + "Loses!" + "Score: " + teamAPoints + "-" + teamBPoints;

		}
		else {
			gameMessage = "you tied. Score:" + teamAPoints + "-" + teamBPoints;
		}
		 
		return gameMessage;
	}

	/**
	 * Generate a random score
	 * @return a randomly generated integer between 0-99 
	 */
	public int randomScore() {
		int Points;
		Points = (int) (Math.random() * 100);
		return Points;
	}
}

