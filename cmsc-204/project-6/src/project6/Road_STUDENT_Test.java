package project6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*** Roads class STUDENT test file
 * 
 * @author Joseph Smith
 *
 */
class Road_STUDENT_Test {

	private Road[] roads;
	private Town[] towns;

	@BeforeEach
	void setUp() throws Exception {

		towns = new Town[10];
		roads = new Road[5];

		for (int i = 0; i < towns.length; i++) {

			towns[i] = new Town("Town_" + i);

		}

		for (int i = 0; i < roads.length; i++) {

			roads[i] = new Road(towns[i], (i > 1) ? towns[i * 2] : towns[i + 1], i * 2 % roads.length, "Road_" + i);

		}

	}

	@AfterEach
	void tearDown() throws Exception {

		towns = null;
		roads = null;

	}

	@Test
	void testGetName() {

		assertEquals("Road_3", roads[3].getName());
		assertFalse("Road_2".equals(roads[0].getName()));

	}

	@Test
	void testContainsTown() {

		assertTrue(roads[0].contains(towns[0]));
		assertTrue(roads[1].contains(towns[2]));
		assertTrue(roads[4].contains(towns[8]));
		

	}

	@Test
	void testCompareTo() {

		assertEquals(0, roads[0].compareTo(roads[0]));

		roads[1] = roads[2];
		assertEquals(0, roads[1].compareTo(roads[2]));

	}

	@Test
	void testEquals() {

		assertTrue(roads[0].equals(roads[0]));
		assertFalse(roads[1].equals(roads[2]));

		roads[4] = roads[3];
		assertTrue(roads[4].equals(roads[3]));

	}

}
