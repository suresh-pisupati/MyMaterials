package stringproblems;

public class CountOfEachCharacterInAString {

	public static void displayCountOfEachCharacter(String givenString) {

		// Need to take a new array which takes ASCII characters in it. So
		// the array size is maximum number of ASCII characters in java which is
		// 256
		// If the character is repeated, this array will have two as value for
		// that character
		int[] counter = new int[256];
		for (int index = 0; index < givenString.length(); index++) {
			counter[givenString.charAt(index)]++;
		}
		// Now take the two loops and determine the count of each character
		int count = 0;
		for (int i = 0; i < givenString.length(); i++) {
			count = 0;
			for (int j = 0; j <= i; j++) {
				if (givenString.charAt(i) == givenString.charAt(j)) {
					count++;
				}
			}
			if (count == 1) {
				System.out.println("Character   " + givenString.charAt(i) + " repeated    "
						+ counter[givenString.charAt(i)] + " time(s)");
			}
		}
	}

	public static void main(String[] args) {
		displayCountOfEachCharacter("aaabbc");
	}

}
