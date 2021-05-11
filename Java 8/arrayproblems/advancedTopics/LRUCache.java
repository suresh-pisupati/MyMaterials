package arrayproblems.advancedTopics;

import java.util.HashMap;
import java.util.Random;

public class LRUCache {

    private HashMap<String, DListNode> hmap;
    private DoublyLinkedList list;
    private int capacity;

    public LRUCache(int capacity) {
	this.capacity = capacity;
	hmap = new HashMap<String, DListNode>();
	list = new DoublyLinkedList();
    }

    // TC:O(1)
    public void put(String key, String val) {
	DListNode tmp = hmap.get(key);
	if (tmp != null) {
	    tmp.val = val;
	} else {
	    if (capacity == list.size()) {
		DListNode lruNode = list.removeFirst();
		hmap.remove(lruNode.key);
	    }
	    DListNode lastNode = list.addLast(key, val);
	    hmap.put(key, lastNode);
	}

    }

    // TC:O(1)
    public String get(String key) {
	DListNode tmp = hmap.get(key);
	if (tmp == null)
	    return null;
	list.removeAndAddLast(tmp);
	return tmp.val;
    }

    public void display() {
	list.display();
    }

    public static void main(String[] args) {
	LRUCache cache = new LRUCache(3);
	for (int i = 0; i < 10; ++i) {
	    cache.put("key" + i, "val" + i);
	    cache.display();
	}
	Random r = new Random(100);
	for (int i = 0; i < 5; ++i) {
	    String key = "key" + r.nextInt(10);
	    System.out.println(key);
	    System.out.println(cache.get(key));
	    cache.display();
	}

    }
}
