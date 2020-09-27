package alphaciv.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestBetaWinningStrategy {
	
	BetaWinningStrategy winningStrategy; 
	
	@Before
	public void setUp() {
		winningStrategy = new BetaWinningStrategy();
	}
	
	@Test
	public void testNullWinner() {
		City [][] cities = new City [][] {{new CityImpl(Player.RED), new CityImpl(Player.BLUE)}};
		assertNull(winningStrategy.getWinner(100, cities));
	}
	@Test
	public void testRedWinner() {
		City [][] cities = new City [][] {{new CityImpl(Player.RED), new CityImpl(Player.RED)}};
		assertEquals(Player.RED, winningStrategy.getWinner(100, cities));
	}
}
