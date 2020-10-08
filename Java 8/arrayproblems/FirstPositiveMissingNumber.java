package arrayproblems;

import java.util.Arrays;

public class FirstPositiveMissingNumber {

	private static void findPositiveMissingNumber(int[] givenArray) {

		Arrays.sort(givenArray);
		int minimumNumber = 1;
		for (int index = 0; index < givenArray.length; index++) {
			if (givenArray[index] == minimumNumber) {
				minimumNumber++;
			}
		}
		System.out.println("Missing Number is  " + minimumNumber);
	}

	public static void main(String[] args) {

		int[] givenArray = { 3, 4, -1, 1 };
		findPositiveMissingNumber(givenArray);
	}

}
