import wy.study.learing.bean.Person;

import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    private final static int THREAT_COUNT = 30;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAT_COUNT);
        Semaphore semaphore = new Semaphore(0);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("hello");
                        semaphore.release();
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程执行次数==》"+Thread.currentThread().getName());
                    semaphore.release();
                }
            });
        }
    }
}