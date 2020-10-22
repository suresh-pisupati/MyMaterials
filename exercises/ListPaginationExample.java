import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * HackerRank problem for sorting the string 2d array and display the list items
 * with given criteria's like to items per page and page number from which the
 * records needs to be displayed.
 *
 */
public class ListPaginationExample {

	public static void displayItemsPerPage(List<List<String>> itemsList, int itemsPerPage, int givenPageNumber,
			int parameterToSort, int orderOfSorting) {

		// Sort the given list of String 2d array elements by converting them
		// into List
		sortItemsList(itemsList, parameterToSort, orderOfSorting);
		// Display the elements based on the criteria required
		displayItemsInPage(itemsList, itemsPerPage, givenPageNumber);
	}

	private static void sortItemsList(List<List<String>> itemsList, int parameterToSort, int orderOfSorting) {

		itemsList.sort(new Comparator<List<String>>() {

			@Override
			public int compare(List<String> list1, List<String> list2) {

				if (parameterToSort == 0) {
					String firstString_list1 = list1.get(0);
					String firstString_list2 = list2.get(0);
					return orderOfSorting == 0 ? firstString_list2.compareTo(firstString_list1)
							: firstString_list1.compareTo(firstString_list2);
				}

				if (parameterToSort == 1) {
					Integer firstString_list1 = Integer.valueOf(list1.get(1));
					Integer firstString_list2 = Integer.valueOf(list2.get(1));
					return orderOfSorting == 0 ? firstString_list2.compareTo(firstString_list1)
							: firstString_list1.compareTo(firstString_list2);
				}

				if (parameterToSort == 2) {
					Integer firstString_list1 = Integer.valueOf(list1.get(2));
					Integer firstString_list2 = Integer.valueOf(list2.get(2));
					return orderOfSorting == 0 ? firstString_list2.compareTo(firstString_list1)
							: firstString_list1.compareTo(firstString_list2);
				}
				return 0;
			}
		});
	}

	private static void displayItemsInPage(List<List<String>> itemsList, int itemsPerPage, int givenPageNumber) {

		Map<Integer, List<String>> mapItems = new HashMap<>();

		int totalNumberOfPages = (itemsList.size() / itemsPerPage) + 1;
		int startIndex = 0;
		int endIndex = itemsPerPage;
		for (int index = 0; index < totalNumberOfPages; index++) {
			mapItems.put(index, new ArrayList<>());
			List<List<String>> subList = itemsList.subList(startIndex, endIndex);
			for (List<String> item : subList) {
				mapItems.get(Integer.valueOf(index)).addAll(item);
			}
			startIndex = startIndex + itemsPerPage;
			endIndex = endIndex + startIndex;
			if (endIndex > itemsList.size()) {
				endIndex = itemsList.size();
			}
		}
		List<String> requiredList = mapItems.get(givenPageNumber);
		System.out.println(requiredList);
	}

	public static void main(String[] args) {
		String[][] items = new String[][] { { "Item1", "17", "100" }, { "Item2", "2", "200" }, { "Item3", "13", "300" },
				{ "Item4", "44", "400" }, { "Item5", "5", "500" }, { "Item6", "66", "600" } };
		List<List<String>> itemsList = Arrays.stream(items).map(Arrays::asList).collect(Collectors.toList());

		displayItemsPerPage(itemsList, 4, 0, 1, 1);
	}
}