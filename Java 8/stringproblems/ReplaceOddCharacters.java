package stringproblems;

public class ReplaceOddCharacters {

    public static void main(String[] args) {
        String s = "samsung";
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for(int index = 1; index < s.length(); index++) {
            if(index == 1 || index % 2 != 0) {
                int i = s.charAt(index);
                String temp = "" +  (char)(i + 3);
                sb.append( temp.toUpperCase());
            }
            else {
                sb.append(s.charAt(index));
            }
        }
        System.out.println( "Replaced with next third character   "  +sb.toString());
    }
}
