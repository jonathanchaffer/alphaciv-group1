package alphaciv.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestBetaCiv {
	private Game game;

	@Before
	public void setUp() {
		game = new GameImpl(GameVersion.betaCiv);
	}

	@Test
	public void worldAgesCorrectly() {
		assertEquals(-4000, game.getAge());
		playRounds(39);
		assertEquals(-100, game.getAge());
		playRounds(1);
		assertEquals(-1, game.getAge());
		playRounds(1);
		assertEquals(1, game.getAge());
		playRounds(1);
		assertEquals(50, game.getAge());
		playRounds(34);
		assertEquals(1750, game.getAge());
		playRounds(6);
		assertEquals(1900, game.getAge());
		playRounds(14);
		assertEquals(1970, game.getAge());
		playRounds(1);
		assertEquals(1971, game.getAge());
		playRounds(1);
		assertEquals(1972, game.getAge());
	}

	private void playRounds(int rounds) {
		for (int i = 0; i < rounds; i++) {
			// call endOfTurn twice to play one round, since there are two players
			game.endOfTurn();
			game.endOfTurn();
		}
	}

}
