package sortingproblems;

/**
 * Idea of this algorithm is to have a sub array which is always sorted.
 * 
 * Algorithm: 1. Iterate through the given elements and pick the smallest
 * element and swap the positions. 2. Repeat the same process until all the
 * elements are sorted.
 * 
 * Space Complexity is O(n^2) as it will scan for all the elements in the given
 * array
 *
 */
public class SelectionSort {

	public static int[] selectionSort(int[] givenArray) {

		int length = givenArray.length;
		for (int i = 0; i < length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < length; j++) {
				if (givenArray[j] < givenArray[i]) {
					index = j;
				}
			}
			int temp = givenArray[index];
			givenArray[index] = givenArray[i];
			givenArray[i] = temp;
		}
		return givenArray;
	}

	public static void main(String[] args) {
		int[] array = { 10, 9 };
		System.out.println("After sorting...................");
		for (int i : selectionSort(array)) {
			System.out.print(i + " -> ");
		}
	}
}
