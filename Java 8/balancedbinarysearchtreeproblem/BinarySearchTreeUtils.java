package balancedbinarysearchtreeproblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTreeUtils {

	public static BinarySearchTreeNode createBalancedBSTNode(int n) {

		List<Integer> elements = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			elements.add(i + 1);
		}
		Collections.shuffle(elements);
		return auxBalancedBST(elements, 0, elements.size());
	}

	public static BinarySearchTreeNode auxBalancedBST(List<Integer> elements, int left, int right) {
		if (left > right) {
			return null;
		}
		int mid = (left + right) / 2;
		BinarySearchTreeNode bstNode = new BinarySearchTreeNode(mid);
		bstNode.leftNode = auxBalancedBST(elements, left, mid - 1);
		bstNode.rightNode = auxBalancedBST(elements, mid + 1, right);

		return bstNode;
	}

	public static void displayTree(BinarySearchTreeNode root) {
		auxDisplay(root, 0, "Root");
	}

	private static void auxDisplay(BinarySearchTreeNode root, int nspaces, String type) {
		if (root == null)
			return;
		for (int i = 0; i < nspaces; ++i)
			System.out.print(' ');
		System.out.println(root.data + "(" + type + "," + root.length + ")");
		auxDisplay(root.leftNode, nspaces + 4, "L");
		auxDisplay(root.rightNode, nspaces + 4, "R");
	}

	public static void main(String[] args) {
		displayTree(createBalancedBSTNode(5));
	}
}
