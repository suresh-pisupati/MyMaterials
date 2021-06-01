package arrayproblems;

import java.util.Arrays;

public class FindDuplicateAndMissingNumbers {

	private static int[] findDuplicateAndMissingNumber(int[] givenArray) {

		int duplicateElement = -1, missingElement = -1;
		// Lets find the duplicate element.
		// Logic is to traverse through the indexes of each element and negate
		// them.
		// If the element is already negate then it is the duplicate the
		// element.
		for (int number : givenArray) {
			// If the element is already negated then it is the duplicate
			// element
			if (givenArray[Math.abs(number) - 1] < 0) {
				duplicateElement = Math.abs(number);
			} else {
				// Element is not negated. Negate the element.
				givenArray[Math.abs(number) - 1] *= -1;
			}
		}
		// We need to find the missing element.
		// Logic is: Iterate through the array which is modified and if there is
		// any non negative element then it is the number + 1 will be the
		// missing number
		for (int index = 0; index < givenArray.length; index++) {
			if (givenArray[index] > 0) {
				missingElement = givenArray[index] + 1;
			}
		}
		return new int[] { duplicateElement, missingElement };
	}

	public static void main(String[] args) {
		int[] givenArray = { 1, 2, 2, 4 };
		System.out.println(Arrays.toString(findDuplicateAndMissingNumber(givenArray)));
	}

}
