// Implement a custom functional interface TestExecutor with a single abstract method to:
// Execute a test case based on its priority.
// Use @FunctionalInterface annotation and lambda expressions to define multiple execution strategies.

package feb10;

@FunctionalInterface
interface TestExecutor {
    void execute(int priority);
}

public class Ques2 {
    public static void main(String[] args) {
        TestExecutor highPriority = priority -> System.out.println("Executing high priority test: " + priority);
        TestExecutor lowPriority = priority -> System.out.println("Executing low priority test: " + priority);
        TestExecutor customStrategy = priority -> System.out.println("Executing test with custom strategy, priority: " + priority);

        highPriority.execute(1);
        lowPriority.execute(5);
        customStrategy.execute(3);
    }
}
