package smithJoseph_Project6;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TownGraphManager_STUDENT_Test {

	TownGraphManager map;
	
	@BeforeEach
	void setUp() throws Exception {
		map = new TownGraphManager();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddRoad() {
		assertEquals(null, map.getRoad("Town1", "Town2"));
		assertTrue(map.addRoad("Town1", "Town2", 0, "Road1"));
		assertEquals("Road1", map.getRoad("Town1", "Town2"));
	}
	
	@Test
	void testGetRoad() {
		assertTrue(map.addRoad("Gaithersburg", "Germantown", 5, "355"));
		assertEquals("355", map.getRoad("Gaithersburg", "Germantown"));
	}

	@Test
	void testAddTown() {
		assertTrue(map.addTown("Town1"));
		assertEquals(new Town("Town1"), map.getTown("Town1"));
	}
	
	@Test
	void testAllRoads() {
		map.addRoad("Town1", "Town2", 4, "Road1");
		map.addRoad("Town2", "Town3", 8, "Road2");
		map.addRoad("Town1", "Town3", 3, "Road3");
		ArrayList<String> roads = map.allRoads();
		Collections.sort(roads);
		assertEquals("Road1", roads.get(0));
		assertEquals("Road2", roads.get(1));
		assertEquals("Road3", roads.get(2));
		
	}
	
	@Test
	void testDeleteRoadConnection() {
		map.addRoad("Town1", "Town2", 4, "Road1");
		map.addRoad("Town1", "Town3", 5, "Road2");
		assertTrue(map.containsRoadConnection("Town1", "Town2"));
		assertTrue(map.containsRoadConnection("Town1", "Town3"));
		map.deleteRoadConnection("Town1", "Town2", "Road1");
		assertTrue(map.containsRoadConnection("Town1", "Town3"));
		System.out.println(map.allRoads());
		assertFalse(map.containsRoadConnection("Town1", "Town2"));
		
	}
	
	@Test
	void testDeleteTown() {
		map.addRoad("Town", "Town2", 4, "Road1");
		map.deleteTown("Town");
		assertEquals(null, map.getTown("Town"));
		assertFalse(map.containsRoadConnection("Town", "Town2"));
		
	}
	
	@Test
	void testAllTowns() {
		map.addRoad("Town1", "Town2", 3, "Road1");
		map.addRoad("Town3", "Town4", 2, "Road2");
		ArrayList<String> towns = map.allTowns();
		Collections.sort(towns);
		
		assertEquals("Town1", towns.get(0));
		assertEquals("Town2", towns.get(1));
		assertEquals("Town3", towns.get(2));
		assertEquals("Town4", towns.get(3));
	}
	
	
	@Test
	void testGetPath() {
		map.addRoad("Town1", "Town2", 3, "Road1");
		map.addRoad("Town3", "Town4", 2, "Road2");
		map.addRoad("Town3", "Town1", 1, "Road3");
		map.addRoad("Town4", "Town2", 5, "Road4");
		ArrayList<String> path = map.getPath("Town1", "Town4");
		assertEquals("Town1 via Road3 to Town3 1 mi", path.get(0));
		assertEquals("Town3 via Road2 to Town4 2 mi", path.get(1));
	}
}
