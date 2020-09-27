package alphaciv.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestBetaAgingStrategy {

	BetaAgingStrategy agingStrategy;
	
	@Before
	public void setUp() {
		agingStrategy = new BetaAgingStrategy();
	}
	
	@Test
	public void testGetNewAge() {
		assertEquals(-1900, agingStrategy.getNewAge(-2000));
		assertEquals(-1, agingStrategy.getNewAge(-100));
		assertEquals(1, agingStrategy.getNewAge(-1));
		assertEquals(50, agingStrategy.getNewAge(1));
		assertEquals(160, agingStrategy.getNewAge(110));
		assertEquals(1825, agingStrategy.getNewAge(1800));
		assertEquals(1965, agingStrategy.getNewAge(1960));
		assertEquals(1971, agingStrategy.getNewAge(1970));
	}
}
