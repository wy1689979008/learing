import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class parent {
    @Test
    private void testCurrent() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                caculate(1, 5000, 0);
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                caculate(5001, 10000, 5000);
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                caculate(10001, 15000, 10000);
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                caculate(15001, 20000, 15000);
            }
        });
        Future<?> submit = executorService.submit(new Runnable() {
            @Override
            public void run() {
                caculate(20001, 25000, 20000);
            }
        });
        System.out.println(submit.get());
    }

    private Integer caculate(int start, int end, Integer value) {
        for (int i = 0; i < end - start; i++) {
            value++;
        }
        return value;
    }
}
