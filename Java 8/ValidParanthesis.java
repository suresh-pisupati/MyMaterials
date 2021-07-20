import java.util.Stack;

public class ValidParanthesis {

	public static boolean isValidParanthesis(String inputString) {

		Stack<Character> stack = new Stack<>();
		for (int index = 0; index < inputString.length(); index++) {
			char ch = inputString.charAt(index);
			if ('(' == ch || '{' == ch || '[' == ch) {
				stack.push(ch);
			}
			if (stack.isEmpty() && (')' == ch || '}' == ch || ']' == ch)) {
				stack.push(ch);
			}
			if (!stack.isEmpty() && (')' == ch || '}' == ch || ']' == ch)) {
				char popedChar = stack.peek();
				if ((popedChar == '(' && ch == ')' || popedChar == '{' && ch == '}' || popedChar == '[' && ch == ']')) {
					stack.pop();
				} else {
					stack.push(ch);
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		String s = "([])";
		System.out.println(isValidParanthesis(s));
	}

}
