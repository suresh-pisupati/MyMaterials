package stringproblems;

/**
 * Sequences of given String: Sequences of given string means, for a given
 * string of length n, starting each character of the string is repeated length
 * n times and then next characters are replaced starting from last index. <br>
 * For example: for the given string "abc" the sequences are: aaa, aab, aac,
 * aba, abb, abc, aca, acb, acc etc.... and last sequence is ccc
 * 
 * @author pksuresh
 *
 */
public class AllSequencesOfString {

	public static void allSequences(String str) {

		auxillary(str, 0, "");
	}

	/**
	 * The logic is to call the function recursively starting with the first
	 * index till the length of the string is reached. While iterating, collect
	 * the each character at the index in the result string. Break the loop once
	 * the index reaches the length of the string.
	 * 
	 * @param str
	 * @param index
	 * @param res
	 */
	private static void auxillary(String str, int index, String res) {

		if (index == str.length()) {
			System.out.println(res);
			return;
		}
		for (int i = 0; i < str.length(); ++i) {
			auxillary(str, index + 1, res + str.charAt(i));
		}
	}

	public static void main(String[] args) {

		allSequences("abc");
	}

}
