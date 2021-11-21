import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

	private TreeNode<String> root;

	public MorseCodeTree() {
		buildTree();
	}

	@Override
	public TreeNode<String> getRoot() {
		return root;
	}

	@Override
	public void setRoot(TreeNode<String> newNode) {
		this.root = newNode;
	}

	@Override
	public LinkedConverterTreeInterface<String> insert(String code, String result) {

		addNode(getRoot(), code, result);

		return this;
	}

	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		
		char c = ' ';

		if(code != null && code.length() > 0) {
			c = code.charAt(0);
		}
		
		// Checking for code length
		// When code length is 1, this is the last traversal before the letter node is placed
		// On the correct child. '.' is the left child and '-' is the right.
		if (code.length() == 1) {

			TreeNode<String> node = new TreeNode<>(letter);

			switch (c) {
			case '.':
				// Place node at left child of current root
				root.setLeft(node);
				break;
			case '-':
				// Place node at right child of current root
				root.setRight(node);
				break;
			default:
				return;
			}
		} else {

			//StringBuilder has a method that allows for character removal at a given index
			StringBuilder codeBuilder = new StringBuilder(code);
			TreeNode<String> newRoot;

			switch (c) {
			case '.':
				newRoot = root.getLeft();
				break;
			case '-':
				newRoot = root.getRight();
				break;
			default:
				return;
			}

			if(codeBuilder.length() > 0) 
				codeBuilder.deleteCharAt(0);
			String newCode = codeBuilder.toString();

			addNode(newRoot, newCode, letter);

		}

	}

	@Override
	public String fetch(String code) {
		return fetchNode(getRoot(), code);
	}

	@Override
	public String fetchNode(TreeNode<String> root, String code) {

		char c = ' ';
		
		if(code != null && code.length() > 0) {
			c = code.charAt(0);
		}
		
		String letter = "";

		//Similar to addNode recursive method. Instead of creating new nodes, 
		//retrieves the letter String value from the node based on the given code.
		if (code.length() == 1) {

			switch (c) {
			case '.':
	
				if (root.getLeft() == null)
					return letter;

				letter = root.getLeft().getData();
				return letter;
			case '-':
				
				if (root.getRight() == null)
					return letter;

				letter = root.getRight().getData();
				return letter;
			default:
				return null;
			}

		} else {

			//StringBuilder methods should be called before switch statement,
			//due to the method returning a String variable.
			StringBuilder codeBuilder = new StringBuilder(code);
			
			if(codeBuilder.length() > 0)
				codeBuilder.deleteCharAt(0);
			String newCode = codeBuilder.toString();

			switch (c) {
			case '.':
				//Traverse to left child of root
				return fetchNode(root.getLeft(), newCode);

			case '-':
				//Traverse to right child of root
				return fetchNode(root.getRight(), newCode);

			default:
				return null;
			}

		}

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
		root = new TreeNode<>("");
		
		//Builds tree by inserting a node into the correct position by code on the tree
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
		//InOrder traversal recursive method, adds each node to ArrayList of Strings
		if (root != null) {
			LNRoutputTraversal(root.getLeft(), list);

			list.add(root.getData());

			LNRoutputTraversal(root.getRight(), list);
		}
	}

}
