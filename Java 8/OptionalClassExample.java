import java.util.Optional;

/**
 * <b>Optional</b> class in java is a final class which is used to deal with
 * NullPointer exception.
 *
 */
public class OptionalClassExample {

	public static void main(String[] args) {
		String[] names = new String[10];
		// Usually this line will throw
		// NullPointerException as value is not present
		// System.out.println(names[5].toUpperCase());
		// We can avoid this using the Option class to check if the value is
		// present or not.
		Optional<String> optional = Optional.ofNullable(names[5]);
		if (optional.isPresent()) {
			System.out.println(names[5].toUpperCase());
		} else {
			System.out.println("5th element is not present");
		}
	}

}
