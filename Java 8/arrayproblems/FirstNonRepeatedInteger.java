package arrayproblems;

public class FirstNonRepeatedInteger {

	private static int getNonRepeatingElement(int[] givenArray) {

		int length = givenArray.length;
		for (int i = 0; i < length; i++) {

			int j;
			for (j = 0; j < length; j++) {
				/*
				 * Since the first element will be same, as we started both the
				 * arrays at same index, we should ignore the first element
				 * check in both the arrays.
				 * 
				 * If the elements are same then break the condition and iterate
				 * with the next index.
				 */
				if (i != j && givenArray[i] == givenArray[j]) {
					break;
				}
			}
			if (j == length) {
				return givenArray[i];
			}
		}
		return -1;
	}
}

// Input:
//
// int[] givenArray = { 19, 24, 36, 47, 24, 19
// };Output:
// First non
// repeating element is->36