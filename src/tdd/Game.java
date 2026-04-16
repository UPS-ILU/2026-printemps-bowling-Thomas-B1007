package tdd;

public class Game {
	private int score = 0;
	private boolean debutTour = true;
	private int scoreTour = 0;
	private int nbBonus = 0;

	public void roll(int nbQuilles) {
		score = score + nbQuilles;
		if (nbBonus > 0) {
			score = score + nbQuilles;
			nbBonus--;
		}
		scoreTour = scoreTour + nbQuilles;
		if (!debutTour) {
			nbBonus = nbBonus + scoreTour/10;
			scoreTour = 0;
		}
		debutTour = !debutTour;
	}
	
	public int score() {
		return score;
	}
}
