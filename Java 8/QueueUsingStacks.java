import java.util.Stack;

/**
 * Program to implement the Queue functionality using Stack
 */
public class QueueUsingStacks {

    private Stack<Integer> temporaryStack;
    private Stack<Integer> finalStack;

    /**
     * Default constructor
     */
    public QueueUsingStacks() {

        temporaryStack = new Stack<>();
        finalStack = new Stack<>();
    }

    /**
     * Method to add the number into the queue. Since we are using the stack to get
     * the functionality of Queue, the following steps need to be followed:
     * <li>remove all the elements from the final stack and push it into temporary
     * stack</li>
     * <li>add the element into the stack</li></li>
     * <li>add all the elements from the temporay stack to the final stack</li>
     * 
     * @param number
     */
    public void enQueue(int number) {

        while (!finalStack.isEmpty()) {
            temporaryStack.push(finalStack.pop());
        }
        finalStack.add(number);
        while (!temporaryStack.isEmpty()) {
            finalStack.push(temporaryStack.pop());
        }
    }

    /**
     * Method to remove the element from the Queue. Since we are using the stacks to
     * implement the queue, the first inserted element will be removed upon calling
     * this method.
     * 
     * @return first element of the queue
     */
    public int deQueue() {

        return finalStack.pop();
    }

    /**
     * Displays all the elements in the final stack
     */
    public void display() {

        finalStack.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {

        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);

        queue.display();
        queue.deQueue();

        System.out.println();
        queue.display();
    }
}
