package arrayproblems;

public class FirstPositiveMissingNumber {

	private static void findPositiveMissingNumber(int[] givenArray) {

		int expectedResult = (givenArray.length * (givenArray.length + 1)) / 2;
		int actualResult = 0;
		for (int index = 0; index < givenArray.length; index++) {
			actualResult = actualResult + givenArray[index];
		}
		System.out.println("Missing Number is  " + (expectedResult - actualResult));
	}

	public static void main(String[] args) {

		int[] givenArray = { 1 };
		findPositiveMissingNumber(givenArray);
	}

}
