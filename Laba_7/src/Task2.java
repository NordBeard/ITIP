import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class Task2 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int numThreads = 4;

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        List<Future<Integer>> results = new ArrayList<>();


        int numRows = matrix.length;
        int chunkSize = numRows / numThreads;
        for (int i = 0; i < numThreads; i++) {
            int startIndex = i * chunkSize;
            int endIndex = (i == numThreads - 1) ? numRows : startIndex + chunkSize;
            int[][] chunk = Arrays.copyOfRange(matrix, startIndex, endIndex);

            Callable<Integer> task = () -> {
                int max = -247219472;
                for (int[] row : chunk) {
                    for (int value : row) {
                        if (value > max) {
                            max = value;
                        }
                    }
                }
                return max;
            };

            Future<Integer> result = executor.submit(task);
            results.add(result);
        }


        int max = -1247293;
        for (Future<Integer> result : results) {
            try {
                int threadMax = result.get();
                if (threadMax > max) {
                    max = threadMax;
                }
            } catch (InterruptedException | ExecutionException e) {
                e.getMessage();
            }
        }
        executor.shutdown();
        System.out.println(max);
    }
}