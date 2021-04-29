package arrayproblems.advancedTopics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import balancedbinarysearchtreeproblem.BinarySearchTreeNode;
import balancedbinarysearchtreeproblem.BinarySearchTreeUtils;

/**
 * Serializing and De-Serializing the given binary tree using <b>Recursion<b>.
 * The order of recursion is "pre-order" which is Root->Left Node->Right Node.
 * 
 */
public class BinaryTreeNodeSerializationDeserialization {

    private static void auxSerializeBinaryTree(BinarySearchTreeNode treeNode, StringBuilder builder) {

	if (treeNode == null) {
	    builder.append("#,");
	    return;
	}
	builder.append(treeNode.data + ",");
	auxSerializeBinaryTree(treeNode.leftNode, builder);
	auxSerializeBinaryTree(treeNode.rightNode, builder);
    }

    /**
     * For serializing, the logic is: <b>Recursive Logic </b> namely <b>pre
     * order</b> <br>
     * The <b>pre-order</b> logic is Root->Left sub tree->Right sub tree If the
     * nodes are null, we use a special character to represent that value # The
     * out put of the serialization is string which represents the elements in
     * the given binary tree where if the nodes are null or empty, # will be
     * value.
     * 
     * Time Complexity is Theta(n)<br>
     * Space Complexity is Theta(n)
     * 
     * @param treeNode
     * @return a string which is serialized form of given Binary Tree
     */
    public static String serializeBinaryTree(BinarySearchTreeNode treeNode) {

	StringBuilder builder = new StringBuilder();
	auxSerializeBinaryTree(treeNode, builder);
	return builder.toString();
    }

    private static BinarySearchTreeNode auxDeSerializeBinaryTree(List<String> strList) {

	/**
	 * Remove the first element from the list. Construct the node with this
	 * element. When a special string encounters, return null which means
	 * there are no child nodes further.
	 */
	String element = strList.remove(0);
	if (element.equals("#")) {
	    return null;
	}
	BinarySearchTreeNode treeNode = new BinarySearchTreeNode(Integer.parseInt(element));
	treeNode.leftNode = auxDeSerializeBinaryTree(strList);
	treeNode.rightNode = auxDeSerializeBinaryTree(strList);

	return treeNode;
    }

    /**
     * For De-Serializing the logic is: <br>
     * Parse the input Serialized string by splitting them using the token which
     * is used to generate while Serialization. Extract the first element each
     * time and form tree node. If any special character is encountered, return
     * null and this means there are no child nodes further.
     * 
     * @param serializedBinaryTree
     * @return binary tree node
     */
    public static BinarySearchTreeNode deSerializeBinaryTree(String serializedBinaryTree) {

	List<String> strList = new ArrayList<>(Arrays.asList(serializedBinaryTree.split(",")));
	return auxDeSerializeBinaryTree(strList);
    }

    public static void main(String[] args) {

	int nNodes = Integer.parseInt(args[0]);
	BinarySearchTreeNode node = BinarySearchTreeUtils.createBalancedBSTNode(nNodes);
	BinarySearchTreeUtils.displayTree(node);
	System.out.println(serializeBinaryTree(node));
	node = deSerializeBinaryTree(serializeBinaryTree(node));
	BinarySearchTreeUtils.displayTree(node);
    }

}
