import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <b>map()</b> is function in Stream interface which converts one object into
 * another object. <br>
 * For example: String objects can be converted to Integer objects and <br>
 * not only that from one form to another form by applying a function. <br>
 * This is intermediate stream operation, as such some other Stream operations
 * can be performed on this function to create a chain of operations. <br>
 * </br>
 * <b>filter()</b> is function in Stream interface which can filter the objects
 * based on the condition that is applied.<br>
 * This is also an intermediate operation which means some other Stream
 * operations can be performed to create a chain of operations </br>
 * <b>collect()</b> is reduction operation which takes sequence of input
 * elements performs operations and combines them into single summary result.
 */
public class CollectMapFilterExample {

	public static void primeNumbersFilteringSquaringAndAdding() {

		List<String> stringNumbersList = new ArrayList<>();
		stringNumbersList.add("1");
		stringNumbersList.add("2");
		stringNumbersList.add("3");
		stringNumbersList.add("4");
		stringNumbersList.add("5");

		// First thing we need to do is to convert list of string elements into
		// list of integer numbers
		// map() in stream class helps to achieve this.
		// Once this is done we will apply filter() to filter for prime numbers
		// Then we will square the numbers which will be performed using map
		// Finally we will sum them using collectors
		int sum = stringNumbersList.stream().map((s) -> Integer.valueOf(s)).filter(number -> !isPrime(number))
				.map((number) -> (number * number)).collect(Collectors.summingInt(Integer::intValue));

		System.out.println(sum);
	}

	private static boolean isPrime(int number) {

		if (number == 1) {
			return true;
		}
		boolean isPrime = false;
		for (int i = 2; i <= number / 2; i++) {
			isPrime = (number % i == 0);
		}
		return isPrime;
	}

	public static void main(String[] args) {
		primeNumbersFilteringSquaringAndAdding();
	}

}
