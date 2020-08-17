import java.util.Arrays;

public class ArraysEqualsCheck {

	public static void main(String[] args) {

		int[] array1 = { 0, 4, 3, 4, 0, 3 };
		int[] array2 = { 4, 4, 3, 0, 0, 3 };

		// Sol1: Naive thought. To sum all the elements in the given arrays and
		// check for equality
		int sum1 = 0, sum2 = 0;
		for (int i : array1) {
			sum1 = sum1 + i;
		}
		for (int i : array2) {
			sum2 = sum2 + i;
		}

		if (array1.length == array2.length) {
			if (sum1 == sum2) {
				System.out.println("Arrays are equal     " + sum1 + "    " + sum2);
			} else {
				System.out.println("Arrays are not equal     " + sum1 + "    " + sum2);
			}
		} else {
			System.out.println("Arrays are not equal.");
		}

		// Sol2: The above solution fails for the following data
		int[] array3 = { 0, 4, 3, 4, 0, 3 };
		int[] array4 = { 7, 4, 3, 0, 0, 0 };
		// Solution is to sort the given arrays and then compare the elements in
		// them
		Arrays.sort(array3);
		Arrays.sort(array4);

		boolean areEqual = true;
		for (int i = 0; i < array3.length; i++) {
			if (array3[i] != array4[i]) {
				areEqual = false;
			}
		}
		System.out.println("Arrays are   " + areEqual);
	}

}
