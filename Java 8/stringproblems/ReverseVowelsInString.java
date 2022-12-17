package stringproblems;

public class ReverseVowelsInString {

    private void reverseVowels(String givenString) {

        char[] charArray = givenString.toCharArray();
        int left = 0, right = givenString.length() - 1;
        while (left < right) {
            if (!isVowel(charArray[left])) {
                left++;
                continue;
            }
            if (!isVowel(charArray[right])) {
                right--;
                continue;
            }

            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            left++;
            right--;
        }

        System.out.println(new String(charArray));
    }

    private boolean isVowel(char givenChar) {
        return givenChar == 'a' || givenChar == 'e' || givenChar == 'i' || givenChar == 'o' || givenChar == 'u';
    }

    public static void main(String[] args) {

        ReverseVowelsInString obj = new ReverseVowelsInString();
        obj.reverseVowels("leetcode");
    }
}
