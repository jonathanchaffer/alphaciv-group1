package alphaciv.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestAlphaWinningStrategy {

	AlphaWinningStrategy winningStrategy; 
	
	@Before
	public void setUp() {
		winningStrategy = new AlphaWinningStrategy();
	}
	
	@Test
	public void testNullWinner() {
		City [][] cities = new City [][] {{new CityImpl(Player.RED), new CityImpl(Player.BLUE)}};
		assertNull(winningStrategy.getWinner(100, cities));
	}
	@Test
	public void testRedWinner() {
		City [][] cities = new City [][] {{new CityImpl(Player.RED), new CityImpl(Player.BLUE)}};
		assertEquals(Player.RED, winningStrategy.getWinner(-3000, cities));
	}
}
