import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractURLFromText {

	private static List<String> pullLinks(String text) {
		List<String> links = new ArrayList<>();

		String regex = "\\(?\\b(http://|www[.])[-A-Za-z0-9+&amp;@#/%?=~_()|!:,.;]*[-A-Za-z0-9+&amp;@#/%=~_()|]";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		while (m.find()) {
			String urlStr = m.group();
			if (urlStr.startsWith("(") && urlStr.endsWith(")")) {
				urlStr = urlStr.substring(1, urlStr.length() - 1);
			}
			links.add(urlStr);
		}
		return links;
	}

	public static void main(String[] args) {

		List<String> urlsList = pullLinks("<Math><MathVariable><test>http://www.oracle.com</test></MathVariable></Math>");
		urlsList.stream().forEach(System.out::println);
	}
}
