package arrayproblems;

import java.util.Arrays;

public class MergingSortedArrays {

	public static int[] getMergedArray(int[] firstArray, int[] secondArray) {

		int i = 0, j = 0, k = 0;
		int firstArrayLength = firstArray.length;
		int secondArrayLength = secondArray.length;
		int[] requiredArray = new int[firstArrayLength + secondArrayLength];

		while (i < firstArrayLength && j < secondArrayLength) {
			if (firstArray[i] < secondArray[j]) {
				requiredArray[k++] = firstArray[i++];
			} else {
				requiredArray[k++] = secondArray[j++];
			}
		}

		while (i < firstArray.length) {
			requiredArray[k++] = firstArray[i++];
		}

		while (j < secondArray.length) {
			requiredArray[k++] = secondArray[j++];
		}

		return requiredArray;
	}

	/**
	 * Method to determine the median of the given sorted Array. For finding the
	 * median the given array must be a sorted array. The median is determined
	 * by:<br>
	 * If the length of the sorted array is odd number then
	 * <p>
	 * the middle element of the array is the required median
	 * </p>
	 * If the length of the sorted array is the even number then
	 * <p>
	 * then the average of middle element and its prior element is the median
	 * </p>
	 * 
	 * @param mergedArray
	 * @return
	 */
	private static double getMedian(int[] mergedArray) {

		double[] doubleArray = Arrays.stream(mergedArray).asDoubleStream().toArray();
		double median;
		int length = doubleArray.length;
		// If the length is odd number
		// then the median is the middle element
		if ((length % 2) != 0) {
			median = doubleArray[(length / 2)];
		} else {
			median = (doubleArray[(length / 2)] + doubleArray[(length / 2) - 1]) / 2;
		}
		return median;
	}

	public static void main(String[] args) {

		int[] array = getMergedArray(new int[] {}, new int[] { 1 });
		for (int i : array) {
			System.out.print(i + "  ");
		}
		System.out.println();
		System.out.println("Median of sorted array is   " + getMedian(array));
	}

}
