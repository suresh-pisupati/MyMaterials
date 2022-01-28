package arrayproblems;

public class SecondLargestElementInArray {

	/**
	 * The logic is: <br>
	 * 1. Declare two variables and initialize them to Integer.Min value. <br>
	 * 2. Iterate through each element and <br>
	 * i. if the current element is greater than firstMax element, store the
	 * current firstMax value in the secondMax element and current element in
	 * the firstMax variable<br>
	 * ii. if the current element is in between secondMax and firstMax, update
	 * secondMax to current value
	 * 
	 * @param givenArray
	 * 			@return, an integer, which is second largest element in the
	 *            given array
	 */
	private static int secondLargestElement(int[] givenArray) {

		int firstMax = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		for (int element : givenArray) {
			if (element > firstMax) {
				secondMax = firstMax;
				firstMax = element;
			//In the below statement the first condition is required to check if the current element is greater than second largest element
			//For ex: 10, 12, 11
			//The second condition will check and make sure the current element is not the highest
			//For ex: 10, 12, 12, 11
			} else if (element > secondMax && element != firstMax) {
				secondMax = element;
			}
		}
		return secondMax;
	}

	public static void main(String[] args) {

		int[] givenArray = { 12, 35, 15, 16 };
		System.out.println(secondLargestElement(givenArray));
	}

}
