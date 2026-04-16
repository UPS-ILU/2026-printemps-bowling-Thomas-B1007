package tdd;

public class Game {
	private int score = 0;
	private boolean debutTour = true;
	private int scoreTour = 0;
	private int nbBonusSpare = 0;
	private int nbBonusStrike = 0;

	public void roll(int nbQuilles) {
		score = score + nbQuilles;
		scoreTour = scoreTour + nbQuilles;
		if (nbBonusSpare > 0) {
			score = score + nbQuilles;
			nbBonusSpare--;
		}
		if (nbBonusStrike > 0) {
			score = score + nbQuilles;
			nbBonusStrike--;
		}
		if (scoreTour == 10) {
			if (debutTour) {
				nbBonusStrike = nbBonusStrike + 2;
				debutTour = false;
			} else {
				nbBonusSpare++;
			}
		}
		if (!debutTour) {
			scoreTour = 0;
		}
		debutTour = !debutTour;
	}
	
	public int score() {
		return score;
	}
}
