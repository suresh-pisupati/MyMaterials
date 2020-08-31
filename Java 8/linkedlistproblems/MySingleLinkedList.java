package linkedlistproblems;

import java.util.NoSuchElementException;

/**
 * Implementation of java linked list class with all the major operations like
 * <br>
 * <li>addFirst()</li>
 * <li>addLast()</li>
 * <li>removeFirst()</li>
 * <li>removeLast()</li>
 * <li>indexOf()</li>
 * <li>contains()</li>
 * 
 */
public class MySingleLinkedList {

	private Node first;
	private Node last;

	public MySingleLinkedList() {

	}

	/**
	 * This method will adds the number/element to the last index in the node.
	 * 
	 * @param number
	 */
	public void addLast(int number) {

		Node node = new Node(number);
		// If list is empty, both head and tail will point to new node
		if (isEmpty()) {
			first = last = node;
		} else {
			// newNode will be added after tail such that tail's next will point
			// to newNode
			last.next = node;
			// newNode will become new tail of the list
			last = node;
		}
	}

	/**
	 * This method will adds the number/element to the first index in the node.
	 * 
	 * @param number
	 */
	public void addFirst(int number) {

		Node node = new Node(number);
		// Check if there are any elements in the list. If the list is empty,
		// first and last will point to same node
		if (isEmpty()) {
			first = last = node;
		} else {
			// The new node needs to be pointed to the first node which is the
			// current first node
			node.next = first;
			// Set the first node to this node
			first = node;
		}
	}

	/**
	 * Traverse through the entire list and as soon as we find the required
	 * item/number return it.
	 * 
	 * @param number
	 *            for which the index needs to be find
	 * @return the index of the given number in the list
	 */
	public int indexOf(int number) {

		int index = 0;
		Node current = first;
		while (current != null) {
			if (current.value == number) {
				return index;
			}
			current = current.next;
			index++;
		}
		return -1;
	}

	/**
	 * Determines whether the given element is present in the list or not.
	 * 
	 * @param number,
	 *            to be determined whether it is there in the list or not
	 * 
	 * @return true or false based on the existence
	 */
	public boolean contains(int number) {
		return indexOf(number) != -1;
	}

	/**
	 * Removes the first element from the list
	 */
	public void removeFirst() {

		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		// If the list has only one element, then set first and last to null
		if (first == last) {
			first = last = null;
			return;
		}
		// For example we have list like this
		// [10 -> 20 -> 30]
		// First we need to have the node which points to (20) second node
		Node current = first.next;
		// Now we can remove the link of first
		first.next = null;
		// Finally we need to set the first pointing to the current node which
		// is 20
		first = current;
	}

	/**
	 * This method will remove the element/item from the last index
	 * 
	 * @return
	 */
	public void removeLast() {

		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		// If the list has only one element, then set first and last to null
		if (first == last) {
			first = last = null;
			return;
		}
		// For example we have list like this
		// [10 -> 20 -> 30]
		// First we determine the previous node of the last node
		// In this case it is 20
		Node previousNode = getPreviousNode(last);
		// Now the last is pointing to 30, we should make it to point to 20
		last = previousNode;
		last.next = null;
	}

	/*
	 * To get the previous node of the given node, we need to iterate through
	 * all the nodes starting from the first node. If the next node from the
	 * current node is the required node, then the current node is the previous
	 * node of the given node.
	 */
	private Node getPreviousNode(Node node) {

		Node current = first;
		while (current != null) {
			if (current.next == node) {
				return current;
			}
			current = current.next;
		}
		return null;
	}

	/*
	 * Checks whether first node is null if so the list is said to be empty
	 */
	private boolean isEmpty() {
		return first == null;
	}

	public void display() {

		Node currentNode = first;

		if (currentNode == null) {
			System.out.println("List is empty.....");
		} else {
			while (currentNode != null) {
				System.out.print(currentNode.value + " -> ");
				currentNode = currentNode.next;
			}
		}
	}

	public static void main(String[] args) {

		MySingleLinkedList list = new MySingleLinkedList();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addFirst(5);

		// Displays the nodes present in the list
		list.display();
		list.removeFirst();
		list.display();
	}

	private class Node {

		private int value;
		private Node next;

		public Node(int value) {

			this.value = value;
			this.next = null;
		}
	}
}
