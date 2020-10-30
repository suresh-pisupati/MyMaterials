import java.util.HashSet;
import java.util.Set;

public class TwoNumberSum {

	// Using the data structure pattern
	// TC: O(n)
	// SC: O(n) //Worst case scenario
	public static void getPair(int[] givenArray, int requiredSum) {

		Set<Integer> set = new HashSet<>();
		for (int index = 0; index < givenArray.length; index++) {
			int element = requiredSum - givenArray[index];
			if (set.contains(element)) {
				System.out.println("Required indexes are      " + (givenArray[index]) + " , " + element);
			} else {
				set.add(givenArray[index]);
			}
		}
	}

	public static void main(String[] args) {

		int[] givenArray = { 1, 5, 3, 2, 6, 9, 4 };
		int requiredSum = 7;
		getPair(givenArray, requiredSum);

	}

}
