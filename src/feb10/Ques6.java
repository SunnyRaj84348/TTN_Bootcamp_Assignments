// Write a multithreaded program to simulate test data updates:
// Use synchronized methods to prevent data inconsistency when multiple threads update the same resource.
// Demonstrate both intrinsic and explicit locks.Write a multithreaded program to simulate test data updates:
// Use synchronized methods to prevent data inconsistency when multiple threads update the same resource.
// Demonstrate both intrinsic and explicit locks.

package feb10;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TestData {
    private int cnt = 0;
    private Lock lock = new ReentrantLock();

    public synchronized void incIntrinsic() {
        cnt++;
    }

    public void incExplicit() {
        lock.lock();
        try {
            cnt++;
        } finally {
            lock.unlock();
        }
    }

    public int getValue() {
        return cnt;
    }
}

public class Ques6 {
    public static void main(String[] args) {
        TestData data1 = new TestData();
        TestData data2 = new TestData();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                data1.incIntrinsic();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                data1.incIntrinsic();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Intrinsic Final Value: " + data1.getValue());

        t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                data2.incExplicit();
            }
        });

        t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                data2.incExplicit();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Explicit Final Value: " + data1.getValue());
    }
}