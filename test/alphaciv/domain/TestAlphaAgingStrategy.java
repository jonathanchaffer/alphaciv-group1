package alphaciv.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestAlphaAgingStrategy {

	AlphaAgingStrategy agingStrategy;
	
	@Before
	public void setUp() {
		agingStrategy = new AlphaAgingStrategy();
	}
	
	@Test
	public void testGetNewAge() {
		assertEquals(200, agingStrategy.getNewAge(100));
		assertEquals(100, agingStrategy.getNewAge(0));
		assertEquals(50, agingStrategy.getNewAge(-50));
		assertEquals(2754, agingStrategy.getNewAge(2654));
	}

}
