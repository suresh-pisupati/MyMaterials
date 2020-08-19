package sortingproblems;

/**
 * This is the simple sorting algorithm where each and every element is compared
 * with next element in the array and will be swapped if the next element is
 * less than the left element.
 *
 * This will not use any extra space hence the space complexity SC: O(1)
 * 
 * This algorithm has worst time complexity as each and every element will be
 * compared time complexity TC: O(n^2)
 */
public class BubbleSort {

	public static int[] bubbleSort(int[] givenArray) {

		int length = givenArray.length;
		for (int i = 0; i < length - 1; i++) {
			for (int j = 0; j < length - 1; j++) {
				if (givenArray[j] > givenArray[j + 1]) {
					givenArray[j] = givenArray[j] + givenArray[j + 1];
					givenArray[j + 1] = givenArray[j] - givenArray[j + 1];
					givenArray[j] = givenArray[j] - givenArray[j + 1];
				}
			}
		}
		return givenArray;
	}

	public static void main(String[] args) {

		int[] array = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.println("After sorting...................");
		for (int i : bubbleSort(array)) {
			System.out.print(i + " -> ");
		}
	}

}
