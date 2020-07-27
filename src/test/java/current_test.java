import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class current_test {
    CountDownLatch countDownLatch = new CountDownLatch(10);
    volatile int flag=0;
    @Test
    public void testt() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Thread.sleep(5000);
        // ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < 10; j++) {
                    flag++;
                    System.out.println(flag);
                }

            });

        }
    }
}