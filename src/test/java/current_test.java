import org.junit.jupiter.api.Test;

import java.util.Timer;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class current_test {
    CountDownLatch countDownLatch = new CountDownLatch(10);
    volatile static int flag = 0;

    @Test
    public void testt() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Thread[] threads = new Thread[10];
        Timer timer=new Timer();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    try {
                        lock.tryLock(6000,TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (Thread.currentThread().getName().equals("Thread-6")){
                        Thread thread=new Thread();
                        Thread.interrupted();
                        thread.isInterrupted();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    flag++;
                    System.out.println(flag);
                    lock.unlock();
                }
                System.out.println(Thread.currentThread().getName());
            });
            threads[i].start();
        }
    }
}