package stringproblems;

/**
 * Program to find the longest palindromic sub string. Approach: Starting the
 * length of the string, decrement the index till the first character. While
 * doing so, get the sub string for each length Check whether the sub string is
 * palindrome or not.
 * 
 * TC: O(n^3) SC: O(1)
 */
public class LongestPalidromicSubString {

    private static boolean isPalindrome(String givenString, int start, int end) {

        while (start < end) {
            if (givenString.charAt(start) == givenString.charAt(end)) {
                ++start;
                --end;
            } else {
                return false;
            }
        }
        return true;
    }

    public static String longestPalindromicString(String givenString) {

        // Iterate from the length by decrementing the index till single character is
        // reached.
        for (int index = givenString.length(); index >= 1; --index) {
            // Find the sub string for each iteration
            for (int subIndex = 0; subIndex < givenString.length() - index + 1; ++subIndex) {
                // check for Palindrome
                if (isPalindrome(givenString, subIndex, subIndex + index - 1)) {
                    return givenString.substring(subIndex, subIndex + index);
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {

        String str = "abaab";
        System.out.println(longestPalindromicString(str));
    }
}
