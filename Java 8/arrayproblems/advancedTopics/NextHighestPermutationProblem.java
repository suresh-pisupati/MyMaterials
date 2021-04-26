package arrayproblems.advancedTopics;

import java.util.Arrays;
import java.util.Random;

/**
 * The logic is: starting from the last number check the order of the numbers.
 * The order should be smallest number should be at last. Continue this order
 * until there is breakage of this order. When the order is disturbed, note that
 * index. Starting from that index till the last element in the given array find
 * the next element. Swap the two numbers. After Swapping the two numbers, the
 * remaining elements must be reversed to get the next highest permutation.
 * 
 *
 */
public class NextHighestPermutationProblem {

    /**
     * Swap the two numbers using their indexes
     * 
     * @param in
     * @param i
     * @param j
     */
    private static void swap(int[] in, int i, int j) {
	int temp = in[i];
	in[i] = in[j];
	in[j] = temp;
    }

    /**
     * Reverse the numbers using their indexes
     * 
     * @param in
     * @param i
     * @param j
     */
    private static void reverse(int[] in, int i, int j) {
	while (i < j) {
	    swap(in, i, j);
	    ++i;
	    --j;
	}
    }

    // 2 2 4 1
    public static void nextHighestPermutation(int[] input) {

	int index;
	for (index = input.length - 2; index >= 0; --index) {
	    if (input[index] < input[index + 1]) {
		break;
	    }
	}
	/**
	 * Index will be < 0 for decreasing number sequence like 5 4 3 2 1. Just
	 * return as there will not be any permutations after this
	 */
	if (index < 0) {
	    return;
	}
	/**
	 * Once the index, at which the increasing sequence from last element,
	 * is determined, we need to find the next immediate highest number
	 * index. Once the index is determined, we need to swap the numbers and
	 * then do the reverse remaining numbers.
	 */
	int min_index = index;
	for (int i = index + 1; i < input.length; ++i) {
	    if (input[i] > input[index])
		min_index = i;
	    else
		break;
	}
	swap(input, index, min_index);
	reverse(input, index + 1, input.length - 1);
    }

    public static void main(String[] args) {

	int size = Integer.parseInt(args[0]);
	int[] inputArray = new int[size];
	Random random = new Random();
	for (int i = 0; i < size; ++i) {
	    inputArray[i] = random.nextInt(size) + 1;
	}
	System.out.println(Arrays.toString(inputArray));
	nextHighestPermutation(inputArray);
	System.out.println(Arrays.toString(inputArray));
    }
    // Input: 3, 1, 3, 2
    // Output: 3, 2, 1, 3
}
