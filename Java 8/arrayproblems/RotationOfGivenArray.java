package arrayproblems;

/**
 * Rotation of array. The approaches for this problem are:
 * <li>Naive Thought:</li> Take the first element and store in temporary
 * variable and copy the remaining elements into the new array. <br>
 * TC: O(n*m) where n is the number of elements and m is the times we need to
 * rotate array.<br>
 * SC: O(1)
 * <li>Adhoc strategy:</li> Take an array of size m and copy the elements either
 * from last or from the first based on the rotation required. Then shift the
 * remaining elements and copy back the m size array to main array.<br>
 * TC: O(n+m)<br>
 * SC:O(n)
 * <li>Adhoc strategy:</li> Idea is to reduce the extra space. Reverse the m
 * parts of the array and reverse the n-m part of the array and finally do the
 * complete reversal of the array. Or we can do the complete reversal of the
 * array and then reverse the two parts of the array, the m part of the array
 * and n-m part of the array.<br>
 * TC:O(n) <br>
 * SC:O(1)
 */
public class RotationOfGivenArray {

	public static void main(String[] args) {

		int[] givenArray = { 1, 2, 3, 4, 5 };
		rotateArray(givenArray, 3);
		for (int i : givenArray) {
			System.out.print(i + ", ");
		}
	}

	// TC: O(n * m)
	// SC: O(1)
	private static void rotateArrayBy(int[] givenArray, int nTimes) {

		for (int n = 1; n <= nTimes; n++) {

			int j = 0, firstElement = givenArray[0];

			for (int i = 0; i < givenArray.length - 1; i++) {
				givenArray[j++] = givenArray[i + 1];
			}
			givenArray[j++] = firstElement;
		}
	}

	// Idea 3. To reverse the given Array
	// Reverse the sub arrays accordingly
	// TC: O(n)
	// SC: O(1)
	public static void rotateArray(int[] givenArray, int index) {

		// complete array
		doReverse(givenArray, 0, givenArray.length - 1);
		// to rotate given array by index times
		doReverse(givenArray, 0, index);
		// to rotate remaining elements n-m elements
		doReverse(givenArray, index + 1, givenArray.length - 1);
	}

	private static int[] doReverse(int[] givenArray, int firstIndex, int lastIndex) {
		while (firstIndex <= lastIndex) {
			int temp = givenArray[firstIndex];
			givenArray[firstIndex] = givenArray[lastIndex];
			givenArray[lastIndex] = temp;

			firstIndex++;
			lastIndex--;
		}
		return givenArray;
	}
}
