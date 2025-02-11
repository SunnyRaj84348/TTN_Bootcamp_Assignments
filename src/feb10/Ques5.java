// Develop a thread pool to handle a batch of 10 test cases concurrently:
// Use different types of thread pools. Log the execution time for each test case.

package feb10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ques5 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService fixedPool = Executors.newFixedThreadPool(5);
        ExecutorService cachedPool = Executors.newCachedThreadPool();
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();

        Runnable testCase = () -> {
            long startTime = System.currentTimeMillis();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Test case executed in " + (endTime - startTime) + "ms by " + Thread.currentThread().getName());
        };

        System.out.println("Fixed Thread Pool:");
        for (int i = 0; i < 10; i++) {
            fixedPool.submit(testCase);
        }
        fixedPool.shutdown();
        fixedPool.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Cached Thread Pool:");
        for (int i = 0; i < 10; i++) {
            cachedPool.submit(testCase);
        }
        cachedPool.shutdown();
        cachedPool.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Single Thread Pool:");
        for (int i = 0; i < 10; i++) {
            singleThreadPool.submit(testCase);
        }
        singleThreadPool.shutdown();
        singleThreadPool.awaitTermination(1, TimeUnit.MINUTES);
    }
}