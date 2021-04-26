package arrayproblems;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateNumber {

	private static int findDuplicate(int[] nums) {

		int requ = Integer.MIN_VALUE;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (set.add(nums[i]) == false) {
				requ = nums[i];
			}
		}
		return requ;
	}

	/*
	 * Solution is to use extra space by taking boolean array Take each element
	 * from the given array, and check for 'true' status in the boolean array.
	 * If it is true, then it is duplicate array.
	 */
	// SC: O(n) TC: O(n)
	private static int findDupliateWithExtraSpace(int[] nums) {

		// Take a boolean array of size equal to given array size
		boolean[] aux = new boolean[nums.length];
		// Iterate thru each element against boolean array
		for (int i = 0; i <= nums.length; ++i) {
			int temp = nums[i];
			if (aux[temp] == true) {
				return temp;
			}
			System.out.println(aux[temp] + "     " + temp);
			aux[temp] = true;
		}
		return Integer.MAX_VALUE;
	}

	public static void main(String[] args) {

		int[] input = { 1, 3, 4, 2, 2 };
		System.out.println(findDupliateWithExtraSpace(input));
	}
}

// Output: prints 2
