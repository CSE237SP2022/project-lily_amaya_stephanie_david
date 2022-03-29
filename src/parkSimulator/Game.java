package parkSimulator;

public class Game {
	public String team;
	private String gameMessage;

	
	public Game(String name) {
		team = name;
		gameMessage = "";
	}
	
	public String simulateGame(String team) {
		int teamAPoints;
		int teamBPoints;
		teamAPoints = (int) (Math.random() * 100);
		teamBPoints = (int) (Math.random() * 100);
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
}

