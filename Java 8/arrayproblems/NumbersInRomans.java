package arrayproblems;

/**
 * Program to convert Integers to Roman numbers representation. The logic
 * is:<br>
 * to have the constants defined at first which contains major significant
 * numbers like 10, 50, 100, 500 and 1000.<br>
 * Along with these values, we need to have lesser values depending on the
 * numbers. <br>
 * Iterate through the length of constants array and check if the given number
 * falls within any range<br>
 * If it is with the range decrease the number by the constant and append the
 * roman constant to string. Continue this till the last digit gets the roman
 * number value.
 * 
 * 
 * @author pksuresh
 *
 */
public class NumbersInRomans {

	private static final int[] integerConstants = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
	private static final String[] romanConstants = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV",
			"I" };

	public static String displayNumberInRomans(int number) {

		StringBuilder builder = new StringBuilder();

		for (int index = 0; index < integerConstants.length; index++) {
			while (number >= integerConstants[index]) {
				number -= integerConstants[index];
				builder.append(romanConstants[index]);
			}
		}
		return builder.toString();
	}

	public static void main(String[] args) {

		System.out.println(displayNumberInRomans(32647));
	}

}
