import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {

	public static MorseCodeTree tree;

	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		tree = new MorseCodeTree();
		String result = "";

		if(!codeFile.exists()) 
			throw new FileNotFoundException();
		
		Scanner reader = new Scanner(codeFile);
		
		while(reader.hasNextLine()) {
			String line = reader.nextLine();
			String[] codes = line.split(" ");
			
			for(String c : codes) {
				c.trim();
				if(c.equals("/")) {
					result += " ";
					continue;
				}
				
				result += tree.fetch(c);
			}
		}
		
		reader.close();
		return result;
	}

	public static String convertToEnglish(String code) {
		tree = new MorseCodeTree();
		String result = "";

		String[] codes = code.split(" ");
		
		for(String c : codes) {
			c.trim();
			if(c.equals("/")) {
				result += " ";
				continue;
			}
			
			result += tree.fetch(c);
		}
		
		System.out.println(result);
		return result;
	}

	public static String printTree() {
		tree = new MorseCodeTree();
		String result = "";
		ArrayList<String> treeList = tree.toArrayList();
		for (String letter : treeList) {
			result += letter + " ";
		}

		return result;

	}

}
