package tdd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {
	Game game;
	
	@BeforeEach
	void setUp() throws Exception {
		game = new Game();
	}
	
	private void plusieursRolls(int nbRoll, int valueRoll) {
		for (int i = 0; i < nbRoll; i++) {
			game.roll(valueRoll);
		}
	}

	@Test
	void iter1Test() {
		assertEquals(0, game.score());
	}
	
	@Test
	void iter2Test() {
		plusieursRolls(20, 0);
		assertEquals(0, game.score());
	}
	
	@Test
	void iter3Test() {
		plusieursRolls(20, 1);
		assertEquals(20, game.score());
	}
	
	@Test
	void iter4Test() {
		plusieursRolls(10, 1);
		plusieursRolls(10, 2);
		assertEquals(30, game.score());
	}
}
