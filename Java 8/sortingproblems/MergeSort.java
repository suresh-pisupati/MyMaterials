package sortingproblems;

/**
 * Merge sort works on the principal of divide and conquer. In this process,
 * given array of elements are divided into two equal halves and this process is
 * continued until we cannot break the elements. Once the elements are divided,
 * we will start merging them and during this process the elements are sorted.
 *
 */
public class MergeSort {

	public static void mergeSort(int[] array) {
		int[] aux = new int[array.length];
		mergeSort(array, 0, array.length - 1, aux);
	}

	public static void mergeSort(int[] array, int left, int right, int[] aux) {

		if (left >= right) {
			return;
		}

		int mid = left + (right - 1) / 2;
		mergeSort(array, left, mid, aux);
		mergeSort(array, mid + 1, right, aux);

		merge(array, left, mid, right, aux);
	}

	private static void merge(int[] in, int l, int m, int r, int[] aux) {
		int i = l, j = m + 1, k = 0;
		while (i <= m && j <= r) {
			if (in[i] < in[j])
				aux[k++] = in[i++];
			else
				aux[k++] = in[j++];
		}
		while (i <= m)
			aux[k++] = in[i++];
		while (j <= r)
			aux[k++] = in[j++];
		for (i = 0; i < k; ++i)
			in[l++] = aux[i];
	}

	public static void main(String[] args) {
		int[] array = { 10, 9 };
		System.out.println("After sorting...................");
		mergeSort(array);
		for (int i : array) {
			System.out.print(i + " -> ");
		}
	}

}
