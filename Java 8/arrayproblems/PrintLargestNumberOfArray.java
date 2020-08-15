package arrayproblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrintLargestNumberOfArray {

	public static void printLargestNumber(List<String> givenNumberList) {

		Collections.sort(givenNumberList, new Comparator<String>() {

			@Override
			public int compare(String x, String y) {

				String xy = x + y;

				String yx = y + x;

				return xy.compareTo(yx) > 0 ? -1 : 1;
			}
		});

		givenNumberList.stream().forEach(System.out::print);
	}

	public static void main(String[] args) {

		int[] array = { 99, 100, 87, 111, 53 };
		List<String> list = new ArrayList<>();
		for (int i : array) {
			list.add(String.valueOf(i));
		}
		printLargestNumber(list);
	}
}