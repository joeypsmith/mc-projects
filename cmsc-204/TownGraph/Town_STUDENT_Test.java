package smithJoseph_Project6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Town_STUDENT_Test {

	Town town1, town2, town3;
	
	@BeforeEach
	void setUp() throws Exception {
		town1 = new Town("Town1");
		town2 = new Town("Town2");
		town3 = new Town("Town2");
		
		town1.setDistance(0);
		town2.setDistance(2);
		town3.setDistance(2);
	}

	@AfterEach
	void tearDown() throws Exception {
		town1 = town2 = town3 = null;
	}

	@Test
	void testCompareTo() {
		assertEquals(-1, town1.compareTo(town2));
		assertEquals(0, town2.compareTo(town3));
	}
	
	@Test
	void testEquals() {
		assertTrue(town2.equals(town3));
		assertFalse(town1.equals(town2));
	}
	
	@Test
	void testToString() {
		assertEquals("Town1", town1.toString());
		assertEquals("Town2", town3.toString());
	}

}
