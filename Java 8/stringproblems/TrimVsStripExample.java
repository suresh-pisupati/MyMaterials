package stringproblems;

/**
 * This class will demonstrate' the differences between trim() and strip() which is introduced in java11.
 * trim() will remove the leading and trailing white spaces whereas it will fail if there are any UTF characters in the given string.
 * strip() will not only remove the white space characters but can also deal's with UTF characters if there are any in the given string.
 */
public class TrimVsStripExample {

    public static void main(String[] args) {
        String str = "\t suresh \n";
        Character utfCharacter = '\u2000';
        String utfString = utfCharacter + "abc" + utfCharacter;

        System.out.println( "After trimming str is    "  +str.trim().length());
        System.out.println( "After stripping str is    "  +str.strip().length());

        System.out.println( "After trimming utfString is    "  +utfString.trim().length());
        System.out.println( "After stripping utfString is    "  +utfString.strip().length());

    }
}
