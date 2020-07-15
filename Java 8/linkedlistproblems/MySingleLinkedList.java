package com.suresh.java891011features;

public class MySingleLinkedList {

	private Node headNode;
	private Node tailNode;

	public MySingleLinkedList() {

	}

	public void addElement(int number) {

		Node newNode = new Node(number);
		// If list is empty, both head and tail will point to new node
		if (headNode == null) {
			headNode = newNode;
			tailNode = newNode;
		} else {
			// newNode will be added after tail such that tail's next will point to newNode
			tailNode.nextNode = newNode;
			// newNode will become new tail of the list
			tailNode = newNode;
		}
	}

	public void display() {

		Node currentNode = headNode;

		if (currentNode == null) {
			System.out.println("List is empty.....");
		} else {
			while (currentNode != null) {
				System.out.print(currentNode.data + " -> ");
				currentNode = currentNode.nextNode;
			}
		}
	}

	public static void main(String[] args) {

		MySingleLinkedList sList = new MySingleLinkedList();
		sList.addElement(1);
		sList.addElement(2);
		sList.addElement(3);
		sList.addElement(4);
		sList.addElement(2);

		// Displays the nodes present in the list
		sList.display();
	}

	private class Node {

		private int data;
		private Node nextNode;

		public Node(int data) {

			this.data = data;
			this.nextNode = null;
		}
	}
}
