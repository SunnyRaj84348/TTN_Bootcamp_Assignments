// Write a program to asynchronously read and process multiple log files containing test results:
// Use the CompletableFuture API to read, filter, and write processed results concurrently.
// Generate a summary report indicating the time taken for each file and the total time for processing all files.

package feb10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Ques10 {
    public static void main(String[] args) throws Exception {
        List<String> files = List.of("log1.txt", "log2.txt", "log3.txt");
        long startTime = System.currentTimeMillis();

        List<CompletableFuture<Long>> futures = files.stream().map(file ->
                CompletableFuture.supplyAsync(() -> processFile(file))
        ).collect(Collectors.toList());

        List<Long> times = futures.stream().map(CompletableFuture::join).collect(Collectors.toList());
        long totalTime = System.currentTimeMillis() - startTime;

        try (FileOutputStream fos = new FileOutputStream("summary.txt")) {
            fos.write(("Total Time: " + totalTime + " ms\n").getBytes());
            for (int i = 0; i < files.size(); i++) {
                fos.write((files.get(i) + " processed in " + times.get(i) + " ms\n").getBytes());
            }
        }
    }

    private static long processFile(String file) {
        long start = System.currentTimeMillis();
        try (FileInputStream fis = new FileInputStream(file);
             FileOutputStream fos = new FileOutputStream("filtered_" + file)) {
            StringBuilder sb = new StringBuilder();
            int ch;
            while ((ch = fis.read()) != -1) {
                if (ch == '\n') {
                    String line = sb.toString();
                    if (line.contains("ERROR")) {
                        fos.write((line + "\n").getBytes());
                    }
                    sb.setLength(0);
                } else {
                    sb.append((char) ch);
                }
            }
        } catch (IOException ignored) {
        }
        return System.currentTimeMillis() - start;
    }
}
