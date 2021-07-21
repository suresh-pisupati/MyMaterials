package arrayproblems.advancedTopics;

import java.util.Arrays;

/**
 * Program to display Beautiful Arrangements. An arrangement is said to be
 * beautiful arrangement, if even position number is divisible by 2 and odd
 * position is divisible by 3.
 * 
 * @author pksuresh
 *
 */
public class BeautifulArrangementsProblem {

	private static boolean isValid(int index, int digit) {
		if (index == 0 || index % 2 == 0) {
			if (digit % 2 != 0)
				return false;
		} else {
			if (digit % 3 != 0)
				return false;
		}
		return true;
	}

	private static void auxArrangements(int index, int[] out) {

		if (index == out.length) {
			System.out.println(Arrays.toString(out));
			return;
		}

		// For each index, check whether the digit is valid or not such
		// that it forms a beautiful arrangement or not.
		for (int digit = 1; digit <= 9; ++digit) {
			if (isValid(index, digit)) {
				out[index] = digit;
				auxArrangements(index + 1, out);
			}
		}
	}

	// TC: Theta (4 ^ n) SC: Theta (n)
	public static void arrangements(int index) {

		int[] out = new int[index];
		auxArrangements(0, out);
	}

	public static void main(String[] args) {

		int n = Integer.parseInt(args[0]);
		arrangements(n);
	}

}
