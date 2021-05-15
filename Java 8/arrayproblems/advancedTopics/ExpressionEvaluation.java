package arrayproblems.advancedTopics;

/**
 * The program to evaluate and return the expression required to get the
 * expected result using + or - operators
 */
public class ExpressionEvaluation {

	/**
	 * An auxiliary method is required to get the expected expression and match
	 * the target. The logic is: in each step we need to remove the first
	 * character from the input, add that to the expected result. While doing
	 * this, we will also add the same to the result in order to match the
	 * target.
	 * <p>
	 * (input.charAt(0) - '0') will give the digit equivalent to value at
	 * input.charAt(0)
	 * </p>
	 * 
	 * @param input,
	 *            a string, with the removed first character of given input
	 * @param expectedExpression,
	 *            a string, the required expression
	 * @param result,
	 *            an integer, which will be collected in each recursive call by
	 *            adding the first character
	 * @param target,
	 *            an integer, the expected value
	 */
	private static void auxEvaluate(String input, String expectedExpression, int result, int target) {

		if (input.length() == 0) {
			if (result == target) {
				System.out.println(expectedExpression);
			}
			return;
		}
		// First to evaluate the expression using '+' operator
		auxEvaluate(input.substring(1), expectedExpression + "+" + input.charAt(0), result + (input.charAt(0) - '0'),
				target);
		// Second to evaluate the expression using '-' operator
		auxEvaluate(input.substring(1), expectedExpression + "-" + input.charAt(0), result - (input.charAt(0) - '0'),
				target);
	}

	/**
	 * Method to evaluate the given input string and match with the given target
	 * 
	 * @param input,
	 *            a string, given digits from 1-9
	 * @param target,
	 *            an integer, required output
	 */
	public static void evaluate(String input, int target) {

		auxEvaluate(input.substring(1), "" + input.charAt(0), input.charAt(0) - '0', target);
	}

	public static void main(String[] args) {

		int target = Integer.parseInt(args[1]);
		evaluate(args[0], target);
	}

}
