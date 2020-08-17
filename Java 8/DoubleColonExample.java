import java.util.ArrayList;
import java.util.List;

/**
 * The double colon (::) operator, also known as method reference operator in
 * Java, is used to call a method by referring to it with the help of its class
 * directly.
 */
public class DoubleColonExample {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);

		// To print the elements in the list we can use lambda expressions
		// instead
		// method reference will be used.
		list.forEach(System.out::println);
	}

}