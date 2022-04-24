package project5;

import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

	private TreeNode<String> root;

	public MorseCodeTree() {

		root = null;
		buildTree();

	}

	@Override
	public TreeNode<String> getRoot() {
		return root;
	}

	@Override
	public void setRoot(TreeNode<String> newNode) {

		root = new TreeNode<>(newNode);

	}

	@Override
	public LinkedConverterTreeInterface<String> insert(String code, String result) {

		addNode(getRoot(), code, result);
		return this;

	}

	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {

		char current = code.charAt(0);
		code = code.substring(1, code.length());

		// Traverse to next root
		if (code.length() > 0) {

			switch (current) {

			// Traverse Right
			case '-':
				addNode(root.getRight(), code, letter);
				break;

			// Traverse Left
			case '.':
				addNode(root.getLeft(), code, letter);
				break;

			}

			// Add node into tree
		} else {

			TreeNode<String> node = new TreeNode<>(letter);

			switch (current) {

			// Traverse Right
			case '-':
				root.setRight(node);
				break;

			// Traverse Left
			case '.':
				root.setLeft(node);
				break;

			}

		}

	}

	@Override
	public String fetch(String code) {

		return fetchNode(getRoot(), code);

	}

	@Override
	public String fetchNode(TreeNode<String> root, String code) {

		char current = code.charAt(0);
		code = code.substring(1, code.length());

		if (code.length() > 0) {

			switch (current) {

			// Traverse Right
			case '-':

				return fetchNode(root.getRight(), code);

			// Traverse Left
			case '.':

				return fetchNode(root.getLeft(), code);

			}

		} else {

			switch (current) {

			// Traverse Right
			case '-':

				return root.getRight().getData();

			// Traverse Left
			case '.':

				return root.getLeft().getData();

			}

		}
		
		return null;

	}

	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void buildTree() {

		// Set the root to a blank letter
		// Insert each letter with corresponding code in correct order
		setRoot(new TreeNode<>(""));
		insert(".", "e");
		insert("-", "t");
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");

	}

	@Override
	public ArrayList<String> toArrayList() {

		ArrayList<String> list = new ArrayList<>();
		LNRoutputTraversal(getRoot(), list);

		return list;

	}

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {

		if (root == null)
			return;

		// Left, Root, Right
		LNRoutputTraversal(root.getLeft(), list);

		list.add(root.getData());

		LNRoutputTraversal(root.getRight(), list);

	}

}
