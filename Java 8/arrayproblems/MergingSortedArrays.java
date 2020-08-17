package arrayproblems;

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

	public static void main(String[] args) {

		int[] array = getMergedArray(new int[] { 1, 3 }, new int[] { 2, 4, 6 });
		for (int i : array) {
			System.out.print(i + "  ");
		}
	}

}
