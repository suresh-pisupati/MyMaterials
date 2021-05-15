package arrayproblems.advancedTopics;

import java.util.Arrays;

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

	for (int digit = 1; digit <= 2; ++digit) {
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
