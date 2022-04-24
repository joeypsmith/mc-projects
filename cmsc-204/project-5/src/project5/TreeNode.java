package project5;

public class TreeNode<T> {

	private T data;
	private TreeNode<T> left, right;
	
	public TreeNode(T data) {
		
		this.data = data;
		left = right = null;
		
	}
	
	public TreeNode(TreeNode<T> node) {
		
		this.data = node.getData();
		this.left = node.getLeft();
		this.right = node.getRight();
		
	}
	
	public T getData() {
		
		return data;
		
	}
	
	public void setData(T data) {
		
		this.data = data;
		
	}
	
	public TreeNode<T> getLeft() {
		
		return left;
		
	}
	
	public TreeNode<T> getRight() {
		
		return right;
	
	}
	
	public void setLeft(TreeNode<T> node) {
		
		this.left = node;
		
	}
	
	public void setRight(TreeNode<T> node) {
		
		this.right = node;
		
	}
	
}
