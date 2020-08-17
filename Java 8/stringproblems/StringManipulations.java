package stringproblems;

public class StringManipulations {

	public static String convertCamelCaseToSnakeCase(String givenCamelCaseString) {

		if (givenCamelCaseString.length() == 0) {
			return null;
		}
		String requiredString = "";
		requiredString = requiredString + Character.toLowerCase(givenCamelCaseString.charAt(0));
		for (int index = 1; index < givenCamelCaseString.length(); index++) {
			if (Character.isUpperCase(givenCamelCaseString.charAt(index))) {
				requiredString = requiredString + "_";
				requiredString = requiredString + Character.toLowerCase(givenCamelCaseString.charAt(index));
			} else {
				requiredString = requiredString + Character.toLowerCase(givenCamelCaseString.charAt(index));
			}
		}
		return requiredString;
	}

	public static String convertSnakeCaseToCamelCase(String givenSnakeCaseString) {

		if (givenSnakeCaseString.length() == 0) {
			return null;
		}
		String requiredString = "";
		for (String temp : givenSnakeCaseString.split("_")) {
			requiredString = requiredString + Character.toUpperCase(temp.charAt(0)) + temp.substring(1);
		}
		return requiredString;
	}

	public static void main(String[] args) {

		String givenCamelCaseString = "ThisIsCamelCaseString";
		System.out.println("Given Word   " + givenCamelCaseString + " converted string is "
				+ convertCamelCaseToSnakeCase(givenCamelCaseString));

		String givenSnakeCaseString = "This_is_Snake_Case_String";
		System.out.println("Given Word   " + givenSnakeCaseString + " converted string is "
				+ convertSnakeCaseToCamelCase(givenSnakeCaseString));
	}

}
