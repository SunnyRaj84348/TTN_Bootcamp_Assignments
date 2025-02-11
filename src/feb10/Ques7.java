// Create a program to simulate deadlock using two threads and two resources:
// Implement strategies to avoid deadlock, such as lock ordering or using a timeout mechanism.

package feb10;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ques7 {
    private static final Lock resource1 = new ReentrantLock();
    private static final Lock resource2 = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            resource1.lock();
            try {
                Thread.sleep(100);
                resource2.lock();
                try {
                    System.out.println("Thread 1 acquired both resources");
                } finally {
                    resource2.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                resource1.unlock();
            }
        });

        Thread t2 = new Thread(() -> {
            resource1.lock();
            try {
                Thread.sleep(100);
                resource2.lock();
                try {
                    System.out.println("Thread 2 acquired both resources");
                } finally {
                    resource2.unlock();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                resource1.unlock();
            }
        });

        t1.start();
        t2.start();
    }
}