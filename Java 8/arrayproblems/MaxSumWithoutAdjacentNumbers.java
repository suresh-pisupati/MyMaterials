package arrayproblems;

import java.util.Arrays;

/**
 * Program to find the maximum sum of the elements within the array by not
 * considering the any two adjacent numbers. <br>
 * Logic:<br>
 * First Step: to create an separate array with the length + 2 to that of given
 * array. Fill the last two elements in the new array with 0.<br>
 * Second Step: iterate thru the given array from right.<br>
 * Third Step: While iterating find the add the current number in the array and
 * and the last element in the new array which is current index + 2<br>
 * Fourth Step: Collect the index + 1 element in the memory<br>
 * Fifth Step: Find the max of these two numbers.
 */
public class MaxSumWithoutAdjacentNumbers {

    private static int findMaxSum(int[] givenArray) {

        // Create an array with the length = given array length + 2
        int[] memory = new int[givenArray.length + 2];
        // Fill the last two elements in the new array to 0.
        memory[givenArray.length] = memory[givenArray.length + 1] = 0;
        // Iterate through the given array from right
        for (int index = givenArray.length - 1; index >= 0; --index) {
            // Add the current number in the given array with the last element in the new
            // array
            int include = givenArray[index] + memory[index + 2];
            // Collect the current index + 1 element in the memory
            int exclude = memory[index + 1];
            // Compare the previous two values and find the maximum among them
            memory[index] = Math.max(include, exclude);
        }
        traceNumbers(givenArray, memory);
        return memory[0];
    }

    // Method to trace the numbers which gives maximum sum in the given array
    private static void traceNumbers(int[] givenArray, int[] memory) {

        System.out.println(Arrays.toString(memory));
        // Iterate thru the given array
        for (int index = 0; index < givenArray.length;) {
            // If the two ajacent elements in the memory are same, increment the index by 1
            if (memory[index] == memory[index + 1]) {
                index = index + 1;
            } else {
                // Else print the current element in the given array and increment index by 2
                System.out.print(givenArray[index] + " \t");
                index = index + 2;
            }
        }
    }

    public static void main(String[] args) {

        int[] a = { 1, 2, 3, 5 };
        System.out.println("Max sum is " + findMaxSum(a));

    }
}
