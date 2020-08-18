package stringproblems;

import java.util.Stack;

/**
 * Program to check if the given string contains balanced parenthesis or not.
 * 
 * Logic: 1. Declare a stack to contain characters. 2. Iterate through the each
 * character of the string and if { or [ or ( is encountered push it to stack.
 * 3. If characters like } or ] or ) are encountered, pop the element from the
 * stack 4. return if stack is empty or not. If empty string is balanced else
 * not.
 * 
 */
public class BalancedParenthesisExample {

	public static boolean isParenthesisBalanced(String givenString) {

		Stack<Character> stack = new Stack<>();
		for (int index = 0; index < givenString.length(); index++) {
			char ch = givenString.charAt(index);
			if ('{' == ch || '[' == ch || '(' == ch) {
				stack.push(ch);
			}

			if ('}' == ch || ']' == ch || ')' == ch) {
				char charFromStack = stack.peek();
				if (('}' == ch && '{' == charFromStack) || (']' == ch && '[' == charFromStack)
						|| (')' == ch && '(' == charFromStack)) {
					stack.pop();
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {

		System.out.println(isParenthesisBalanced("a*(b+c)-(d*e)"));
	}

}
