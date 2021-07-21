package stringproblems;

import java.util.Stack;
import java.util.StringTokenizer;

public class ReverseOfWords {

	public static String reverseOfWords(String givenString) {

		Stack<String> stack = new Stack<>();
		StringBuilder builder = new StringBuilder();
		StringTokenizer tokenizer = new StringTokenizer(givenString, " ");
		while (tokenizer.hasMoreTokens()) {
			stack.push(tokenizer.nextToken());
		}
		while (!stack.isEmpty()) {
			builder.append(stack.pop()).append(" ");
		}
		return builder.toString().trim();
	}

	public static void main(String[] args) {

		System.out.println(reverseOfWords("  Bob    Loves  Alice   "));
	}

}
