// Implement a producer-consumer problem for test execution logs:
// Use a blocking queue to handle log generation (producer) and log processing (consumer) threads.
// Ensure thread safety without explicit synchronization.

package feb10;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Ques9 {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(5);

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    String log = "Log " + i;
                    queue.put(log);
                    Thread.sleep(100);
                    System.out.println("Produced: " + log);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    String log = queue.take();
                    Thread.sleep(200);
                    System.out.println("Consumed: " + log);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
    }
}