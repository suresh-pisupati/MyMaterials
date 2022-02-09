import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * CompletableFuture is extension of Future Interface which provides additional
 * functionalities like handling exceptions and combining multiple future tasks.
 * <p>
 * The important methods of Completable Future are
 * <li>supplyAsync</li>
 * <li>thenApply</li>
 * <li>join</li>
 * </p>
 * <b>supplyAsync() </b>: this method will performs the task asynchronously<br>
 * <b>thenApply() </b>: this method will take function as parameter and uses it
 * to process the result.<br>
 * <b>join()</b>: this method will returns a value when completed the task. It
 * throws a unchecked exception if completed exceptionally.
 * 
 */
public class CompletableFutureExample {

	public static void main(String[] args) {

		// This example squares the given numbers and returns the individual
		// values.
		List<Integer> numbers = Arrays.asList(5, 9, 14);
		numbers.stream().map((n) -> CompletableFuture.supplyAsync(() -> getSquare(n))
				    .thenApply(i -> i + i)))
				    .map(t -> t.join())
				    .forEach(System.out::println);

	}

	private static int getSquare(int number) {

		System.out.println("number is    " + number);
		return number * number;
	}
}
