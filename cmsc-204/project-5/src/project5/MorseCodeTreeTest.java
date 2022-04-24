package project5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*** MorseCodeTree Student JUnit test cases
 *
 * @author joeyp
 *
 */
class MorseCodeTreeTest {

	private MorseCodeTree tree;
	
	@BeforeEach
	void setUp() throws Exception {
		
		tree = new MorseCodeTree();
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
		tree = null;
		
	}
	
	@Test
	public void testRoot() {
		
		assertEquals("", tree.getRoot().getData());
		tree.setRoot(new TreeNode<String>("X"));
		assertEquals("X", tree.getRoot().getData());
		
	}
	
	@Test
	public void testFetch() {
		
		assertEquals("r", tree.fetch(".-."));
		assertEquals("c", tree.fetch("-.-."));
		
	}
	
	@Test
	public void testList() {
		
		ArrayList<String> list = tree.toArrayList();
		assertEquals("[h, s, v, i, f, u, e, l, r, a, p, w, j, , b, d, x, n, c, k, y, t, z, g, q, m, o]", list.toString());
		
	}

	

}
