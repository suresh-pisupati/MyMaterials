package sortingproblems;

/**
 * TC: O(n) for best case scenario where the elements are already sorted<br>
 * O(n^2) for worst case scenario where the given array is sorted descending
 * order
 * 
 */
public class InsertionSort {

	public void insertionSort(int[] givenArray) {
		// We start the loop with the second element or the first index value
		// element
		// as if there are only 1 element then its position is fixed.
		for (int index = 1; index < givenArray.length; index++) {
			// We need to store the current element in case the element needs to
			// be changed for
			// its correct position.
			int currentElement = givenArray[index];
			// We will iterate through the all elements starting from index 0
			int j = index - 1;
			// As long as new index is > 0 and element at this index is >
			// current element
			// from main iteration, we shift the element to the right and
			// decrease the j
			while (j >= 0 && givenArray[j] > currentElement) {
				givenArray[j + 1] = givenArray[j];
				j--;
			}
			// Finally we copy the current element at the last
			givenArray[j + 1] = currentElement;
		}
	}
}
