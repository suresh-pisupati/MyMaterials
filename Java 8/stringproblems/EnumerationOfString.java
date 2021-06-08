package stringproblems;

/**
 * Enumeration of given string Enumeration is extracting all the possible sub
 * strings starting from the single character without missing the order.<br>
 * For ex: for the given String "abc" enumerated strings are: a, ab, abc, b, bc,
 * c<br>
 * The logic to solve this problem is to iterate through each character of the
 * string by taking two loops where the second loop will traverse for the sub
 * strings with each character in the first loop.
 * 
 * @author pksuresh
 *
 */
public class EnumerationOfString {

	// TC: Theta(n^2) SC:Theta(1)
	public static void enumerateAllStrings(String givenString) {

		for (int i = 0; i < givenString.length(); ++i) {
			for (int j = i; j <= givenString.length(); ++j) {
				System.out.println(givenString.substring(i, j));
			}
		}
	}

	public static void main(String[] args) {
		enumerateAllStrings("abc");
	}

}
