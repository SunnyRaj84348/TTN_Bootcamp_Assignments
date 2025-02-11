// Create a multithreaded Java application to:
// Simulate a QA automation test suite where each thread executes a specific test case.
// Demonstrate thread lifecycle methods (start(), join(), isAlive()).

package feb10;

class TestC extends Thread {
    private String testName;

    TestC(String testName) {
        this.testName = testName;
    }

    public void run() {
        System.out.println(testName + " started");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(testName + " completed");
    }
}

public class Ques4 {
    public static void main(String[] args) {
        TestC t1 = new TestC("Login Test");
        TestC t2 = new TestC("Signup Test");
        TestC t3 = new TestC("Checkout Test");

        t1.start();
        t2.start();
        t3.start();

        System.out.println("Login Test is alive: " + t1.isAlive());
        System.out.println("Signup Test is alive: " + t2.isAlive());
        System.out.println("Checkout Test is alive: " + t3.isAlive());

        try {
            t1.join();
            t2.join();
            t3.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("All test cases completed");
    }
}
