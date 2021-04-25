package arrayproblems.advancedTopics;

public class MajorityOfElementProblem {

    // TC: O(n)
    // SC: O(1)
    /**
     * Logic: Initialize a max and count variables Iterate thru the given array
     * elements length and for each element check with max element. If the
     * element is equal to max element increment the count else decrement the
     * count. While decrementing the count if the count is equal to 0 then max
     * value will be the current element and count needs to be set to 1
     * 
     * @param givenArray
     * @return integer, majority element
     */
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
