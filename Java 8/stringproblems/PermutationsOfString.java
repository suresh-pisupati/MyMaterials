package stringproblems;

public class PermutationsOfString {

	public static void getPermutationsOfString(String givenString) {

		auxPermutations(givenString, "");
	}

	private static void auxPermutations(String givenString, String requiredString) {

		if (givenString.length() == 0) {
			System.out.println(requiredString);
			return;
		}

		for (int index = 0; index < givenString.length(); index++) {
			char ch = givenString.charAt(index);
			String restOfString = givenString.substring(0, index) + givenString.substring(index + 1);
			auxPermutations(restOfString, requiredString + ch);
		}
	}

	public static void main(String[] args) {

		getPermutationsOfString("abc");
	}

}
