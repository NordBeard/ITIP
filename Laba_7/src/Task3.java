import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task3 {
    public static void main(String[] args) {
        int[] items = {30, 60, 40, 20, 10, 35, 50, 55, 15};

        int maxCapacity = 150;
        int numWorkers = 3;

        CountDownLatch startSignal = new CountDownLatch(1); //Начать переноску товаров
        CountDownLatch doneSignal = new CountDownLatch(numWorkers); // Завершить переноску

        ExecutorService executor = Executors.newFixedThreadPool(numWorkers);

        for (int i = 0; i < numWorkers; i++) {
            int workerId = i;
            executor.execute(() -> {
                try {
                    startSignal.await();

                    int currentWeight = 0;
                    for (int item : items) {
                        if (currentWeight + item <= maxCapacity) {
                            currentWeight += item;
                            System.out.println("Рабочий " + workerId + " Поднимает " + item + " кг");
                        } else {
                            System.out.println("Рабочий " + workerId + " завершил работу");
                            currentWeight = item;
                        }
                    }

                    doneSignal.countDown();
                } catch (InterruptedException e) {
                    e.getMessage();
                }
            });
        }

        System.out.println("Начать переноску...");
        startSignal.countDown();

        try {
            doneSignal.await(); // Ждем, пока все завершат работу
        } catch (InterruptedException e) {
            e.getMessage();
        }

        System.out.println("Переноска завершена");
        executor.shutdown();
    }
}
