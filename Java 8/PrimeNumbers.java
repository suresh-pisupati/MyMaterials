import java.util.ArrayList;
import java.util.List;

/**
 * Program to find the count of prime numbers in a given range. The logic is:
 * the multiples of the current number can be marked as non-prime numbers and
 * this will be continued till the given range.
 */
public class PrimeNumbers {

    /**
     * The method to determine the prime number count.
     * 
     * @param range, an integer
     * @return count, number of prime numbers in the given range
     */
    public static int getPrimeNumberCount(int range) {

        /**
         * Declare the boolean array and initialize all the values to true.
         */
        boolean[] primes = new boolean[range + 1];
        for (int index = 0; index < range; index++) {
            primes[index] = true;
        }
        /**
         * Since the first two values 0 and 1, these are not prime numbers.
         */
        primes[0] = false;
        primes[1] = false;
        /**
         * Starting from 2, till the range, for each number, find the product values
         * within the range and mark them as non-prime numbers.
         */
        for (int i = 2; i * i <= range; i++) {
            if (primes[i]) {
                for (int j = i; j * i <= range; j++) {
                    primes[j * i] = false;
                }
            }
        }
        /**
         * Iterate thru the array to find the prime number count
         */
        int count = 0;
        for (boolean isPrime : primes) {
            if (isPrime) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println("Count of prime numbers " + getPrimeNumberCount(10000000));
    }
}
