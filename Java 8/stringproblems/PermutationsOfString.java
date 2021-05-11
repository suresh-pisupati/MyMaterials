package stringproblems;

public class PermutationsOfString {

    // TC: Theta (n^n) SC: Theta (n)
    public static void getPermutationsOfString(String givenString) {

	auxPermutations(givenString, "");
    }

    private static void auxPermutations(String givenString, String requiredString) {

	if (givenString.length() == 0) {
	    System.out.println(requiredString);
	    return;
	}

	for (int index = 0; index < givenString.length(); index++) {
	    auxPermutations(givenString.substring(0, index) + givenString.substring(index + 1),
		    requiredString + givenString.charAt(index));
	}
    }

    // ----------------------------------------------------------------------------------------------------------------------------------------------------
    /**
     * Back tracking solution TC: Theta (n ^ n +1) SC: Theat (n)
     * 
     * @param str
     */
    public static void allSequences(String str) {

	auxillary(str, 0, "");
    }

    /**
     * Auxiliary method to find out all the permutations of given string
     * 
     * @param str,
     *            the given input
     * @param index,
     *            an integer, to perform reduction
     * @param res,
     *            a string, to collect the result
     */
    private static void auxillary(String str, int index, String res) {

	if (index == str.length()) {
	    if (isValid(res)) {
		System.out.println(res);
	    }
	    return;
	}
	for (int i = 0; i < str.length(); ++i) {
	    auxillary(str, index + 1, res + str.charAt(i));
	}
    }

    /**
     * This method will determine whether the result string is sequence of
     * string or permutation of string. If characters are repeating then it is
     * sequential string
     * 
     * @param res,
     *            a string, collected sequence of string
     * @return a boolean, if the string is sequence string it is false else true
     */
    private static boolean isValid(String res) {

	for (int i = 1; i < res.length(); ++i) {
	    for (int j = 0; j < i; ++j) {
		if (res.charAt(i) == res.charAt(j)) {
		    return false;
		}
	    }
	}
	return true;
    }

    public static void main(String[] args) {

	// getPermutationsOfString("abc");
	allSequences("abc");

    }

}
