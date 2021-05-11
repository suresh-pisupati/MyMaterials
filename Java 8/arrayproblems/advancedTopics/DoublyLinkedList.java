package arrayproblems.advancedTopics;

class DListNode {
    String key;
    String val;
    DListNode prev;
    DListNode next;

    public DListNode() {

    }

    public DListNode(String key, String val) {
	this.key = key;
	this.val = val;
    }
}

public class DoublyLinkedList {
    private DListNode head;
    private int size;

    public DoublyLinkedList() {
	head = new DListNode();
	head.prev = head.next = head;
	size = 0;
    }

    public int size() {
	return size;
    }

    public DListNode removeFirst() {
	DListNode first = head.next;
	first.next.prev = head;
	head.next = first.next;
	--size;
	return first;
    }

    public DListNode addLast(String key, String val) {
	DListNode tmp = new DListNode(key, val);
	tmp.next = head;
	tmp.prev = head.prev;
	head.prev.next = tmp;
	head.prev = tmp;
	++size;
	return tmp;
    }

    public void removeAndAddLast(DListNode tmp) {
	// unlink
	tmp.prev.next = tmp.next;
	tmp.next.prev = tmp.prev;
	// add tmp at last position
	tmp.next = head;
	tmp.prev = head.prev;
	head.prev.next = tmp;
	head.prev = tmp;
    }

    public void display() {
	for (DListNode current = head.next; current != head; current = current.next)
	    System.out.print("(" + current.key + "," + current.val + ")");
	System.out.println();
    }
}
