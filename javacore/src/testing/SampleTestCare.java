package testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class SampleTestCare {
	Arithmetic am = new Arithmetic();

	@Test
	public void testAddPositive() {
		assertEquals(8,am.add(5,3));
	}
	@Test
	public void testAddNegative() {
		assertNotEquals(8,am.add(5,3));
	}
}
