
public class TreeNode<T> {

	private TreeNode<T> left;
	private TreeNode<T> right;
	
	private T data;
	
	public TreeNode(T data) {
		this.setData(data);
		setRight(null);
		setLeft(null);
	}
	
	public TreeNode(TreeNode<T> node) {
		this.setLeft(node.getLeft());
		this.setRight(node.getRight());
		this.setData(node.getData());
	}

	/**
	 * @return the left
	 */
	public TreeNode<T> getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public TreeNode<T> getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(TreeNode<T> right) {
		this.right = right;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}
	
	
	
}
