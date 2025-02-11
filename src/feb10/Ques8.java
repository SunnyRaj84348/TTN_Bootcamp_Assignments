// Write a Java program to demonstrate the use of the volatile keyword:
// Use it to ensure proper visibility of a shared variable among threads simulating real-time test data updates.

package feb10;

public class Ques8 {
    private static volatile boolean flag = true;

    public static void main(String[] args) {
        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                flag = false;
                System.out.println("Flag set to false by writer thread.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread readerThread = new Thread(() -> {
            while (flag) {
            }
            System.out.println("Flag detected as false by reader thread.");
        });

        writerThread.start();
        readerThread.start();
    }
}
