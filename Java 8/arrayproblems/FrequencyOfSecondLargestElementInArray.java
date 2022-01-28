package arrayproblems;

public class FrequencyOfSecondLargestElementInArray {

	/**
	 * The logic is: <br>
	 * 1. Declare two variables and initialize them to Integer.Min value. <br>
	 * 2. Declare two variables to hold the count of first largest and second
	 * largest elements count. <br>
	 * 3. When the first highest element is changed, assign the count of
	 * previous highest count to second highest count and assign the first
	 * highest count to 0 since this is new element <br>
	 * 4. If the current element is equal to firstMax element, increment first
	 * highest element count.<br>
	 * 5. If the current element is equal to secondMax increment second highest
	 * count.
	 * 
	 * @param givenArray
	 * 			@return, an integer, which is second largest element in the
	 *            given array
	 */
	private static void getFrequencyOfSecondLargestElement(int[] givenArray) {

		int firstMaxElement = Integer.MIN_VALUE;
		int secondMaxElement = Integer.MIN_VALUE;
		int firstMaxElementCount = 0, secondMaxElementCount = 0;

		for (int index = 0; index < givenArray.length; index++) {

			if (givenArray[index] > firstMaxElement) {
				secondMaxElement = firstMaxElement;
				firstMaxElement = givenArray[index];
				secondMaxElementCount = firstMaxElementCount;
				firstMaxElementCount = 0;
			} else if (givenArray[index] > secondMaxElement && givenArray[index] != firstMaxElement) {
				secondMaxElement = givenArray[index];
				secondMaxElementCount = 0;
			}
			if (givenArray[index] == firstMaxElement) {
				firstMaxElementCount++;
			}
			if (givenArray[index] == secondMaxElement) {
				secondMaxElementCount++;
			}
		}
		System.out.println(
				"Second Largest Element is  " + secondMaxElement + " and its frequency is   " + secondMaxElementCount);
	}

	public static void main(String[] args) {

		int[] givenArray = { 10, 11, 11, 10, 11, 7, 6, 3, 18, 1, 10, 12, 1, 11, 8, 11, 11 };
		getFrequencyOfSecondLargestElement(givenArray);
	}

}
