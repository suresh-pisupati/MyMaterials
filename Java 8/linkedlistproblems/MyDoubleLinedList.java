package linkedlistproblems;

/**
 * Class Node, which is an inner class, needs to be created which contains<br>
 * <li>data, an integer parameter to store the actual data</li>
 * <li>previousNode, a link to point to previous node</li>
 * <li>nextNode, a link to point to the next node</li>
 */
class InternalNode {

    public int data;
    public InternalNode previousNode;
    public InternalNode nextNode;

    public InternalNode(int data) {

	this.data = data;
    }
}

/**
 * Class which creates custom double linked list
 * 
 * @author pksuresh
 *
 */
public class MyDoubleLinedList {

    private InternalNode headNode, tailNode;

    public MyDoubleLinedList() {

    }

    /**
     * The method to add the given number as the last node
     * 
     * @param number
     */
    public void addLast(int number) {

	InternalNode newNode = new InternalNode(number);
	if (headNode == null) {
	    headNode = tailNode = newNode;
	} else {
	    // establish a link to the newNode using the tailNode.nextNode as
	    // nextNode is the pointer
	    tailNode.nextNode = newNode;
	    // New node's previous node needs to pointed to the tailNode
	    newNode.previousNode = tailNode;
	    // tailNode should be pointed to the new node
	    tailNode = newNode;
	    // tailNode.nextNode should be null
	    tailNode.nextNode = null;
	}
    }

    /**
     * The method to add the number as the first node
     * 
     * @param number
     */
    public void addFirst(int number) {
	InternalNode newNode = new InternalNode(number);
	if (headNode == null) {
	    headNode = tailNode = newNode;
	} else {
	    // headNode is the first element. Its previousNode is null as of
	    // now. We need to point previousNode to the newNode.
	    headNode.previousNode = newNode;
	    // newNode next should be pointed to headNode. As of now headNode
	    // has previous data only
	    newNode.nextNode = headNode;
	    // Now the headNode should be pointed to newNode.
	    headNode = newNode;
	    // Now the newNode is the headNode, its previousNode should be
	    // pointed to null
	    newNode.previousNode = null;

	}
    }

    public void delete(int element) {

	InternalNode requiredNode = getNodeOfElement(element);
	requiredNode.previousNode.nextNode = requiredNode.nextNode;
	requiredNode.nextNode.previousNode = requiredNode.previousNode;
	requiredNode = null;
    }

    private InternalNode getNodeOfElement(int element) {

	InternalNode currentNode = headNode;
	while (currentNode != null) {
	    if (currentNode.data == element) {
		return currentNode;
	    }
	    currentNode = currentNode.nextNode;
	}
	return null;
    }

    /**
     * The method to display the custom double linked list
     */
    public void display() {
	InternalNode currentNode = headNode;
	if (headNode == null) {
	    System.out.println("List is empty");
	} else {
	    while (currentNode != null) {
		System.out.print(currentNode.data + " ");
		currentNode = currentNode.nextNode;
	    }
	    System.out.println();
	}
    }

    public static void main(String[] args) {

	MyDoubleLinedList dList = new MyDoubleLinedList();
	dList.addLast(1);
	dList.addLast(2);
	dList.addLast(3);
	dList.addLast(4);
	dList.addLast(5);

	dList.display();// displays: 1 2 3 4 5
	dList.addFirst(6);
	dList.display();// displays: 6 1 2 3 4 5
	dList.delete(4);
	dList.display();
    }

}
