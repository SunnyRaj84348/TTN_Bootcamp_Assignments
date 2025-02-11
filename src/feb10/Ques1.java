// Write a Java program using lambda expressions to:
// Filter a list of test cases based on their status (e.g., Passed, Failed).
// Sort the test cases by execution time.
// Generate a summary report with the total count of passed and failed test cases.

package feb10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class TestCase {
    String name, status;
    int executionTime;

    TestCase(String name, String status, int executionTime) {
        this.name = name;
        this.status = status;
        this.executionTime = executionTime;
    }
}

public class Ques1 {
    public static void main(String[] args) {
        List<TestCase> testCases = Arrays.asList(
                new TestCase("TC1", "Passed", 5),
                new TestCase("TC2", "Failed", 9),
                new TestCase("TC3", "Passed", 4),
                new TestCase("TC4", "Failed", 7)
        );

        List<TestCase> passedTests = testCases.stream()
                .filter(t -> t.status.equals("Passed"))
                .collect(Collectors.toList());

        List<TestCase> failedTests = testCases.stream()
                .filter(t -> t.status.equals("Failed"))
                .collect(Collectors.toList());

        List<TestCase> sortedTests = testCases.stream()
                .sorted(Comparator.comparingInt(t -> t.executionTime))
                .collect(Collectors.toList());

        System.out.println("Passed: " + passedTests.size() + ", Failed: " + failedTests.size());
        sortedTests.forEach(t -> System.out.println(t.name + " - " + t.executionTime + "ms"));
    }
}
