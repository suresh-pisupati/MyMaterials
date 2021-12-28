/**
 * The logic is to multiply the given numbers and their use their product
 * multiplication table till the given range.
 */
public class NumbersDivisibleByMoreThanOne {

    public static void main(String[] args) {

        int i = 5, j = 7, k = 1;
        while ((i * j * k) < 10000) {
            System.out.println(i * j * k);
            k++;
        }
    }
}
