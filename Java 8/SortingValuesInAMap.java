import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SortingValuesInAMap {

	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Joe");
		map.put(2, "Bob");
		map.put(3, "David");
		map.put(4, "Cinday");
		map.put(5, "Andy");
		map.put(6, "Rachel");
		map.put(7, "Annabel");
		map.put(8, "Amy");

		List<Map.Entry<Integer, String>> list = new LinkedList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {
			@Override
			public int compare(Map.Entry<Integer, String> obj1, Map.Entry<Integer, String> obj2) {

				return obj1.getValue().compareTo(obj2.getValue());
			}
		});

		Map<Integer, String> valueSortedMap = new LinkedHashMap<>();
		for (Map.Entry<Integer, String> mapList : list) {
			valueSortedMap.put(mapList.getKey(), mapList.getValue());
		}

		for (Map.Entry<Integer, String> finalMap : valueSortedMap.entrySet()) {
			System.out.println("Key:   " + finalMap.getKey() + " Value   " + finalMap.getValue());
		}
	}
}