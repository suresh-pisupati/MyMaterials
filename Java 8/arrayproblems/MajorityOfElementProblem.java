package arrayproblems;

public class MajorityOfElementProblem {

	public static int majorityElement(int[] givenArray) {

		int majorityElement = Integer.MAX_VALUE;
		int count = 1;
		for (int i = 0; i < givenArray.length; ++i) {
			if (givenArray[i] == majorityElement) {
				++count;
			} else {
				--count;
				if (count == 0) {
					majorityElement = givenArray[i];
					count = 1;
				}
			}
		}
		return majorityElement;
	}

	public static void main(String[] args) {

		int[] array = { 2, 1, 2, 1, 2 };
		System.out.println(majorityElement(array));
	}

}
