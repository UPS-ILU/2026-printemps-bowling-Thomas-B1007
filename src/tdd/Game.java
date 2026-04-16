package tdd;

public class Game {
	private int score = 0;
	private int scoreTour = 0;
	private int nbBonusSpare = 0;
	private int tour = 1;
	private int[] tableauStrike = {0,0,0};
	
	private int calculerBonusSpare(int nbQuilles) {
		if (nbBonusSpare > 0) {
			nbBonusSpare--;
			return nbQuilles;
		}
		return 0;
	}
	
	private int calculerBonusStrike(int nbQuilles) {
		int bonus = 0;
		for (int i = 0; i < 3; i++) {
			if (tableauStrike[i] > 0) {
				bonus = bonus + nbQuilles;
				tableauStrike[i]--;
			}
		}
		return bonus;
	}
	
	private void ajouterStrike() {
		int i = 0;
		while (tableauStrike[i] > 0) i++;
		tableauStrike[i] = 2;
	}
	
	public void roll(int nbQuilles) {
		score = score + nbQuilles + calculerBonusStrike(nbQuilles) + calculerBonusSpare(nbQuilles);
		scoreTour = scoreTour + nbQuilles;
		if (tour%2 == 1) {
			if (scoreTour == 10) {
				ajouterStrike();
				tour++;
				scoreTour = 0;
			}
		} else {
			if (scoreTour == 10) {
				nbBonusSpare++;
			}
			scoreTour = 0;
		}
		tour++;
		System.out.println("score : " + score);
	}

//	public void roll(int nbQuilles) {
//		score = score + nbQuilles;
//		scoreTour = scoreTour + nbQuilles;
//		if (nbBonusSpare > 0) {
//			score = score + nbQuilles;
//			nbBonusSpare--;
//		}
//		if (nbBonusStrike > 0) {
//			score = score + nbQuilles;
//			nbBonusStrike--;
//		}
//		if (scoreTour == 10) {
//			if (debutTour) {
//				nbBonusStrike = nbBonusStrike + 2;
//				debutTour = false;
//			} else {
//				nbBonusSpare++;
//			}
//		}
//		if (!debutTour) {
//			scoreTour = 0;
//		}
//		debutTour = !debutTour;
//	}
	
	public int score() {
		System.out.println("-------");
		return score;
	}
}
