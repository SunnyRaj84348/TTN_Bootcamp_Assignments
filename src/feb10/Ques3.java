// Develop a program to: Use the Stream API to process a collection of log entries.
// Filter error logs, map them to their respective error codes, and group them by severity.
// Use terminal operations like collect() to generate a summary report.

package feb10;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class LogEntry {
    String message;
    private String severity;
    private int errorCode;

    LogEntry(String message, String severity, int errorCode) {
        this.message = message;
        this.severity = severity;
        this.errorCode = errorCode;
    }

    String getSeverity() {
        return severity;
    }

    int getErrorCode() {
        return errorCode;
    }
}

public class Ques3 {
    public static void main(String[] args) {
        List<LogEntry> logs = Arrays.asList(
                new LogEntry("Error 404", "HIGH", 404),
                new LogEntry("Error 500", "CRITICAL", 500),
                new LogEntry("Error 403", "MEDIUM", 403),
                new LogEntry("Error 502", "CRITICAL", 503)
        );

        Map<String, List<Integer>> report = logs.stream()
                .filter(log -> log.getSeverity().equals("CRITICAL") || log.getSeverity().equals("HIGH"))
                .collect(Collectors.groupingBy(LogEntry::getSeverity,
                        Collectors.mapping(LogEntry::getErrorCode, Collectors.toList())));

        System.out.println(report);
    }
}
