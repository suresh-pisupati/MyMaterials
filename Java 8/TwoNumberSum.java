import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

	/**
	 * Method to determine the indexes of the elements who values upon adding is
	 * equal to the required sum
	 * 
	 * @param givenArray
	 * @param requiredSum
	 * @return
	 */
	public static int[] getPair2(int[] givenArray, int requiredSum) {

		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		for (int index = 0; index < givenArray.length; index++) {
			int target = requiredSum - givenArray[index];
			if (map.containsKey(target)) {
				return new int[] { map.get(target), index };
			} else {
				map.put(givenArray[index], index);
			}
		}
		return result;
	}

	public static void main(String[] args) {

		int[] givenArray = new int[] { 2, 7, 11, 15 };
		int requiredSum = 9;
		int[] result = getPair2(givenArray, requiredSum);
		System.out.println(Arrays.toString(result));
	}

}
