package project6;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*** TownGraphManager class STUDENT test file
 * 
 * @author Joseph Smith
 *
 */
class TownGraphManager_STUDENT_Test {
	
	private TownGraphManager townGraph;
	
	@BeforeEach
	void setUp() throws Exception {
		
		townGraph = new TownGraphManager();
		
		for(int i = 0; i <= 5; i++) 
			townGraph.addTown("Town_"+i);
		
		townGraph.addRoad("Town_1", "Town_2", 10, "Road_1");
		townGraph.addRoad("Town_1", "Town_3", 15, "Road_2");
		townGraph.addRoad("Town_2", "Town_4", 8, "Road_3");
		townGraph.addRoad("Town_4", "Town_1", 2, "Road_4");
		townGraph.addRoad("Town_5", "Town_3", 22, "Road_5");
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
		townGraph = null;
		
	}

	@Test
	void testAddRoad() {
		
		assertFalse(townGraph.containsRoadConnection("Town_5", "Town_1"));
		townGraph.addRoad("Town_1", "Town_5", 2, "Road_6");
		assertTrue(townGraph.containsRoadConnection("Town_5", "Town_1"));
		
	}
	
	@Test
	void testGetRoad() {
		
		assertEquals("Road_3", townGraph.getRoad("Town_2", "Town_4"));
		
	}
	
	@Test
	void testAddTown() {
		
		assertFalse(townGraph.containsTown("Town_6"));
		townGraph.addTown("Town_6");
		assertTrue(townGraph.containsTown("Town_6"));
		
	}
	
	@Test
	void testGetTown() {
		
		Town town = new Town("Town_6");
		townGraph.addTown("Town_6");
		assertEquals(town, townGraph.getTown("Town_6"));
		
	}
	
	@Test
	void testDeleteRoadConnection() {
		
		assertTrue(townGraph.containsRoadConnection("Town_5", "Town_3"));
		townGraph.deleteRoadConnection("Town_5", "Town_3", "Road_5");
		assertFalse(townGraph.containsRoadConnection("Town_5", "Town_3"));
		
	}
	
	@Test
	void testDeleteTown() {
		
		assertTrue(townGraph.containsTown("Town_2"));
		townGraph.deleteTown("Town_2");
		assertFalse(townGraph.containsTown("Town_2"));
		
	}
	
	@Test
	void testGetPath() {
		
		assertEquals("[Town_1 via Road_2 to Town_3 15 mi , Town_3 via Road_5 to Town_5 22 mi ]", townGraph.getPath("Town_1", "Town_5").toString());
	
	}
	
	@Test
	void testPopulateTownGraph() {
		
		File file = new File("src/testTown.txt");
		townGraph = new TownGraphManager();
		
		try {
			townGraph.populateTownGraph(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals("Road_1", townGraph.getRoad("Town_1", "Town_2"));
		assertEquals("Road_2", townGraph.getRoad("Town_4", "Town_2"));
		assertEquals("Road_3", townGraph.getRoad("Town_3", "Town_1"));
		
	}

}
