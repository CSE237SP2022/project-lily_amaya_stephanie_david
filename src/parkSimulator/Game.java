package parkSimulator;

public class Game {
	public String team;
	private String gameMessage;

	
	public Game(String name) {
		team = name;
		gameMessage = "";
	}
	
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

	public int randomScore() {
		int Points;
		Points = (int) (Math.random() * 100);
		return Points;
	}
}

