package project6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*** Towns class STUDENT test file
 * 
 * @author Joseph Smith
 *
 */
class Town_STUDENT_Test {

	private Town[] towns;

	@BeforeEach
	void setUp() throws Exception {

		towns = new Town[5];

		for (int i = 0; i < 5; i++) {

			towns[i] = new Town("Town_" + i);

		}

	}

	@AfterEach
	void tearDown() throws Exception {

		towns = null;

	}

	@Test
	void testGetName() {

		for (int i = 0; i < 5; i++) {

			assertEquals("Town_" + i, towns[i].getName());

		}

	}
	
	@Test
	void testCompareTo() {
		
		assertEquals(-1, towns[0].compareTo(towns[1]));
		assertEquals(0, towns[2].compareTo(towns[2]));
		assertEquals(1, towns[4].compareTo(towns[3]));
		
		towns[1] = towns[0];
		assertEquals(0, towns[1].compareTo(towns[0]));
		
	}
	
	@Test
	void testEquals() {
		
		assertTrue(towns[0].equals(towns[0]));
		assertFalse(towns[0].equals(towns[1]));
		
		towns[4] = towns[3];
		assertTrue(towns[4].equals(towns[3]));
		
	}

}
