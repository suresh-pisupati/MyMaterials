package threadproblems;

/**
 * This class demonstrates the multi threading concept by running the two
 * threads running in parallel.
 */
public class DisplayingTwoThreadsSimoultaneously {

    private int numberOfTimes;
    private int currentNumber;

    public DisplayingTwoThreadsSimoultaneously(int numberOfTimes) {

        this.numberOfTimes = numberOfTimes;
    }

    private void displayEvenNumbers() {

        synchronized (this) {
            while (currentNumber < numberOfTimes) {
                if (currentNumber % 2 == 0) {
                    try {
                        wait();
                    } catch (Exception e) {
                    }
                }
                notify();
                System.out.print(currentNumber + "\t");
                currentNumber++;

            }
        }
    }

    private void displayOddNumbers() {

        synchronized (this) {
            while (currentNumber < numberOfTimes) {
                if (currentNumber % 2 != 0) {
                    try {
                        wait();
                    } catch (Exception e) {
                    }
                }
                notify();
                System.out.print(currentNumber + "\t");
                currentNumber++;
            }
        }
    }

    public static void main(String[] args) {

        DisplayingTwoThreadsSimoultaneously obj = new DisplayingTwoThreadsSimoultaneously(20);

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                obj.displayEvenNumbers();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                obj.displayOddNumbers();
            }
        });

        t1.start();
        t2.start();
    }
}
