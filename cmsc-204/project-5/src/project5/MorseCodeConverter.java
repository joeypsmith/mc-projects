package project5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {

	public static MorseCodeTree tree = new MorseCodeTree();

	public static String convertToEnglish(String code) {

		String result = "";

		// Split the code into separate words
		// Separated by '/' delimiter
		String[] words = code.split("/");

		for (int i = 0; i < words.length; i++) {

			// Split the code words into letters
			// Separated by ' ' delimiter
			String[] letters = words[i].split(" ");

			for (int j = 0; j < letters.length; j++) {

				// Check to make sure code isn't blank
				if (!letters[j].isBlank())
					result += tree.fetch(letters[j]);

			}

			result += " ";

		}

		return result.trim();

	}

	public static String convertToEnglish(File file) throws FileNotFoundException {

		String result = "";
		Scanner scanner = new Scanner(file);

		// Scan each line of the file
		while (scanner.hasNextLine()) {

			// Convert code line to english
			String code = scanner.nextLine();
			result += convertToEnglish(code) + " ";

		}

		scanner.close();
		return result.trim();

	}

	public static String printTree() {

		String treeString = "";
		ArrayList<String> list = tree.toArrayList();

		for (String letter : list) {

			treeString += letter + " ";

		}

		// Cut off hanging comma and return tree
		return treeString.trim();

	}

}
