package stringproblems;

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
		enumerateAllStrings("abcd");
	}

}
