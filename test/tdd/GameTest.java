package tdd;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

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
	
	@Test
	void iter5Test() {
		game.roll(7);
		game.roll(3);
		game.roll(4);
		plusieursRolls(17, 0);
		assertEquals(18, game.score());
	}
	
	@Test
	void iter6Test() {
		game.roll(10);
		game.roll(3);
		game.roll(4);
		plusieursRolls(16, 0);
		assertEquals(24, game.score());
	}
	
	@Test
	void iter7Test() {
		int[] tabRoll = {1, 2, 10, 0, 10, 4, 2, 0, 10, 6, 2, 0, 10, 6, 4, 8, 2, 2, 7};
		for (int i = 0; i < tabRoll.length; i++) {
			game.roll(tabRoll[i]);
		}
		assertEquals(122, game.score());
	}
}
