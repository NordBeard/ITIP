import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class Task1 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int numThreads = 4;

        int[] x = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] x2 = Arrays.copyOfRange(x, 5, 15);
        for(int i = 0; i< x2.length; i++)
        {
            System.out.println(x2[i]);
        }

        ExecutorService executor = Executors.newFixedThreadPool(numThreads); // Создаем фиксированное количество потоков


        List<Future<Integer>> results = new ArrayList<>();

        // Разделяем наш массив поровну и отправляем каждую часть в отдельный поток
        int chunkSize = array.length / numThreads;
        for (int i = 0; i < numThreads; i++) {
            int startIndex = i * chunkSize;
            int endIndex = (i == numThreads - 1) ? array.length : startIndex + chunkSize;
            int[] chunk = Arrays.copyOfRange(array, startIndex, endIndex);

            Callable<Integer> task = () -> {
                int sum = 0;
                for (int num : chunk) {
                    sum += num;
                }
                return sum;
            };

            Future<Integer> result = executor.submit(task);
            results.add(result);
        }


        int totalSum = 0;
        for (Future<Integer> result : results) {
            try {
                totalSum += result.get();
            } catch (InterruptedException | ExecutionException e) {
                e.getMessage();
            }
        }
        executor.shutdown();
        System.out.println(totalSum);
    }
}