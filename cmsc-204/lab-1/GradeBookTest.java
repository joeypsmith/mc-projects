import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {

	GradeBook gb1, gb2;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		gb1 = new GradeBook(5);
		gb2 = new GradeBook(5);
		
		gb1.addScore(39.40);
		gb1.addScore(86.20);
		
		gb2.addScore(56.70);
		gb2.addScore(96.50);
		gb2.addScore(76.40);
	}

	@AfterEach
	void tearDown() throws Exception {
		gb1 = gb2 = null;
	}

	@Test
	void testAddScore() {
		gb1.addScore(45);
		assertTrue(gb1.toString().equals("39.4 86.2 45.0"));
		assertEquals(gb1.getScoreSize(), 3);
		
		gb2.addScore(24.9);
		assertTrue(gb2.toString().equals("56.7 96.5 76.4 24.9"));
		assertEquals(gb2.getScoreSize(), 4);
	}

	@Test
	void testSum() {
		assertEquals(gb1.sum(), 125.6);
		assertEquals(gb2.sum(), 229.6);
	}

	@Test
	void testMinimum() {
		assertEquals(gb1.minimum(), 39.4);
		assertEquals(gb2.minimum(), 56.7);
	}

	@Test
	void testFinalScore() {
		assertEquals(gb1.finalScore(), 86.2);
		assertEquals(gb2.finalScore(), 172.9);
	}

}
