package balancedbinarysearchtreeproblem;

public class BinarySearchTreeNode {

	public Integer data;
	public int length;
	public BinarySearchTreeNode leftNode;
	public BinarySearchTreeNode rightNode;

	public BinarySearchTreeNode(int data) {

		this.data = data;
	}

	public BinarySearchTreeNode(int data, int length) {

		this.data = data;
		this.length = length;
	}
}
