package arrayproblems.advancedTopics;

import java.util.Stack;

/**
 * Using a single stack to get the maximum element among the given numbers.
 * Logic is<br>
 * while performing the <b>push</b> operation we need to store an additional
 * value which keeps track of previous maximum number. And while performing the
 * <b>pop</b> operation, we need to check if poped element is the maximum number
 * in order keep track of next maximum number.
 *
 */
public class SingleStackMaximumElement {

    Stack<Integer> singleStack = null;
    int maxElement;

    public SingleStackMaximumElement() {

	singleStack = new Stack<>();
	maxElement = Integer.MAX_VALUE;
    }

    /**
     * Declare a maxElement with some initial value. While pushing a number to
     * the stack, check if the given number is greater than the maximum number
     * or not. If it is greater than the maximum number, we need to insert the
     * number with a math logic: <br>
     * 2 * number - maxElement<br>
     * such that it will keep track of previous maximum number.<br>
     * If the stack is empty then the maxElement is the given number.<br>
     * If the given number is less than the maxElement, then simply push into
     * the stack.<br>
     * TC: O(1)<br>
     * SC: O(1)
     * 
     * @param number,
     *            which is to be pushed into the stack.
     */
    public void push(int number) {

	if (number > maxElement) {
	    singleStack.push(2 * number - maxElement);
	    maxElement = number;
	} else {
	    if (singleStack.isEmpty()) {
		maxElement = number;
	    }
	    singleStack.push(number);
	}
    }

    /**
     * When the <b>pop</b> is called, check whether the poped element is the
     * special element or not. This can be done with the logic:<br>
     * If the result (of poping the element) is greater than maxElement, then it
     * is a special element which contains the information about previous
     * maxElement. So update the maxElement by:<br>
     * maxElement = 2 * result (of poped element) - maxElement<br>
     * In this case we should return the maxElement before performing the above
     * operation.<br>
     * If the result (of pop operation) is less than the maxElement, simply
     * return the poped element.<br>
     * TC: 0(1) <br>
     * SC:O(1)
     * 
     * @return temp, the poped element
     */
    public int pop() {
	int temp;
	int result = singleStack.pop();
	if (result > maxElement) {
	    temp = maxElement;
	    maxElement = 2 * maxElement - result;
	} else {
	    temp = result;
	}
	return temp;
    }

    /**
     * Simply return the maxElement which will be determined while performing
     * the <b>push</b> operation.<br>
     * TC: O(1)<br>
     * SC: O(1)
     * 
     * @return maxElement, integer which is greater/maximum number in the stack
     */
    public int maximumElement() {

	return maxElement;
    }

    /**
     * Displayes the elements in the stack
     */
    public void display() {

	System.out.println(singleStack);
    }

    public static void main(String[] args) {

	SingleStackMaximumElement singleStack = new SingleStackMaximumElement();
	for (int i = 1; i <= 10; ++i) {
	    singleStack.push(i);
	    singleStack.display();
	}
	System.out.println(singleStack.maximumElement());
	for (int i = 1; i <= 5; ++i) {
	    System.out.println(singleStack.pop());
	    singleStack.display();
	}
	System.out.println(singleStack.maximumElement());
    }

}
