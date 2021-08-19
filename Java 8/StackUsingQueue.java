import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    private Queue<Integer> queue;

    public StackUsingQueue() {

        queue = new LinkedList<>();
    }

    /**
     * When pushing the element into the stack<br>
     * <li>first take the size of the queue</li>
     * <li>push the element into the queue</li>
     * <li>iterate through the queue and while iterating, take a temporary variable and 
     * store the removed element</li>
     * <li>add the removed element to the queue</li>
     * 
     * @param number
     */
    public void push(int number) {

        int size = queue.size();
        queue.add(number);
        for(int index = 0; index < size; index++) {
            int temp = queue.remove();
            queue.add(temp);
        }
    }

    /**
     * Removes the element from the queue and returns the value
     * 
     * @return
     */
    public int pop() {

        return queue.remove();
    }

    /**
     * Displays the elements in the queue
     */
    public void display() {

        queue.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        
        StackUsingQueue stack = new StackUsingQueue();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.display();
        System.out.println();
        stack.pop();
        stack.display();
    }
}
