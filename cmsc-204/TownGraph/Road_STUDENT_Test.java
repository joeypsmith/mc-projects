package smithJoseph_Project6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Road_STUDENT_Test {

	Road road1;
	Road road2;
	Road road2Clone;
	
	Town t1;
	Town t2;
	Town t3;

	@BeforeEach
	void setUp() throws Exception {

		t1 = new Town("Test Town 1");
		t2 = new Town("Test Town 2");
		t3 = new Town("Test Town 3");

		road1 = new Road(t1, t2, 5, "Test Road 1");
		road2 = new Road(t1, t3, 4, "Test Road 2");
		road2Clone = new Road(t1, t3, 4, "Test Road 2");

	}

	@AfterEach
	void tearDown() throws Exception {
		t1 = t2 = t3 = null;
		road1 = road2 = road2Clone = null;
	}

	@Test
	void testToString() {
		assertEquals("Test Road 1", road1.toString());
		assertEquals("Test Road 2", road2.toString());
	}
	
	@Test
	void testContains() {
		assertTrue(road1.contains(t1));
		assertTrue(road2.contains(t3));
		assertFalse(road1.contains(t3));
	}
	
	@Test
	void testCompareTo() {
		assertEquals(-1, road1.compareTo(road2));
		assertEquals(0, road2.compareTo(road2Clone));
	}
	
	@Test
	void testSourceAndDestination() {
		assertEquals(t1, road1.getSource());
		assertEquals(t3, road2.getDestination());
	}
	
	@Test
	void testDistance() {
		assertEquals(5, road1.getDistance());
		assertEquals(4, road2.getDistance());
	}

}
