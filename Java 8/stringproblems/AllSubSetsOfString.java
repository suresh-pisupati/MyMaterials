package stringproblems;

/**
 * Subsets of given string:<br>
 * A sub-set is possible strings of a given string without considering the
 * sequence of characters in it. The difference between Enumeration of the
 * String and SubSets of given string is, in the enumeration sequence will not
 * be missed. Where as in case of subsets, the order will be missing.<br>
 * For ex: for the given String "abc"<br>
 * sub strings are:<br>
 * a, ab, abc, ac, b, bc, c<br>
 * In case of Enumeration of the above string 'ac' will not be in the result.
 * <p>
 * The idea to solve the sub string is calling a recursive function where the
 * each character is included in one iteration and excluded in another
 * iteration.
 * </p>
 * 
 * @author pksuresh
 *
 */
public class AllSubSetsOfString {

	public static void allSubsets1(String in) {

		auxAllSubsets1(0, in, "");
	}

	/**
	 * Initially the required index will be from zero position. Increment the
	 * position till the length of the string. While incrementing the index, at
	 * the first step include the character in one iteration and in another
	 * iteration exclude that character.
	 * 
	 * @param d
	 * @param in
	 * @param res
	 */
	private static void auxAllSubsets1(int d, String in, String res) {

		if (d == in.length()) {
			System.out.println(res);
			return;
		}
		// Include the character
		auxAllSubsets1(d + 1, in, res + in.charAt(d));
		// Exclude the character
		auxAllSubsets1(d + 1, in, res + "");
	}

	public static void allSubsets2(String in) {

		auxSubsets2(in, "");
	}

	private static void auxSubsets2(String in, String res) {

		System.out.println(res);
		if (0 == in.length())
			return;
		for (int i = 0; i < in.length(); ++i)
			auxSubsets2(in.substring(i + 1), res + in.charAt(i));
	}

	public static void main(String[] args) {

		allSubsets2("abc");
	}

}