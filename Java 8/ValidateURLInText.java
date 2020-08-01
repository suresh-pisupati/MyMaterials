import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateURLInText {

	private static final String URL_REGEX = "^(http(s?))\\:\\/\\/[0-9a-zA-Z]([-.\\w]*[0-9a-zA-Z])*(:(0-9)*)*(\\/?)([a-zA-Z0-9\\-\\.\\?\\,\\:\\'\\/\\\\\\+=&amp;%\\$#_]*)?$";
	private static final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
	
	public static boolean validateURL(String url) {
		if(url == null) {
			return false;
		}
		if(!url.contains("://")) {
			url = "http://" +url; 
		}
		Matcher matcher = URL_PATTERN.matcher(url);
		return matcher.matches();
	}
	
	public static void main(String[] args) {
		
		String url = "http://www.oracle.com";
		System.out.println( "url is                   "    +validateURL(url));
	}
