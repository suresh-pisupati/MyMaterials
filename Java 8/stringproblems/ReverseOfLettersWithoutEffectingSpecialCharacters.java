package stringproblems;

public class ReverseOfLettersWithoutEffectingSpecialCharacters {

    public ReverseOfLettersWithoutEffectingSpecialCharacters() {

    }

    private static void reverseGivenString(char[] str) {
        int left = 0, right = str.length - 1;
        while (left < right) {
        if(!Character.isAlphabetic(str[left])) {
            left++;
        }
        else if(!Character.isAlphabetic(str[right])) {
            right--;
        }
        else {
                char temp = str[left];
                str[left] = str[right];
                str[right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {

        String str = "ab!";
        char[] array = str.toCharArray();
        reverseGivenString(array);
        String revStr = new String(array);
        System.out.println("Output string: " + revStr);
    }
}
