package arrayproblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Program to find the position of element in the un-sorted given array after
 * sorting the array.
 * 
 * @author pksuresh
 *
 */
public class ArrayManipulation {

    public static void findPosition(int[] givenArray) {

	int[] sortedArray = new int[givenArray.length];
	Map<Integer, Integer> map = new HashMap<>();
	int index = 0;
	for (int i : givenArray) {
	    sortedArray[index++] = i;
	    map.put(i, index);
	}
	Arrays.sort(sortedArray);
	System.out.println("Sorted Array is:   ");
	for (int i : sortedArray) {
	    System.out.print(i);
	    System.out.println("\t Position of " + i + " in given array is   " + (map.get(i) - 1));
	    System.out.print("\n");
	}

    }

    public static void main(String[] args) {

	findPosition(new int[] { 4, 2, 3, 1 });
    }

}
