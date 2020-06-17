import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest {

    public static AtomicInteger flag = new AtomicInteger(0);
    static CountDownLatch c = new CountDownLatch(3);

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 10, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(500));
        executor.execute(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10000;i++){
                    System.out.println(i++);
                }

            }
        });
//        new Thread(() -> {
//            for (int i = 0; i < 10000; i++) {
//                //flag++;
//                flag.incrementAndGet();
//            }
//            System.out.println(Thread.currentThread().getName() + "状态==》" + Thread.currentThread().getState());
//            System.out.println("数量==》" + Thread.activeCount());
//
//            c.countDown();
//            System.out.println(Thread.currentThread().getName() + "状态==》" + Thread.currentThread().getState());
//            System.out.println("数量==》" + Thread.activeCount());
//
//        }).start();
//        new Thread(() -> {
//            for (int i = 0; i < 10000; i++) {
//                //flag++;
//                flag.incrementAndGet();
//            }
//            System.out.println(Thread.currentThread().getName() + "状态==》" + Thread.currentThread().getState());
//
//            c.countDown();
//            System.out.println(Thread.currentThread().getName() + "状态==》" + Thread.currentThread().getState());
//
//        }).start();
//        new Thread(() -> {
//            for (int i = 0; i < 10000; i++) {
//                //flag++;
//                flag.incrementAndGet();
//
//            }
//            c.countDown();
//        }).start();
//        try {
//            c.await();
//            System.out.println("数量==》" + Thread.activeCount());
//
//            System.out.println(Thread.currentThread().getName() + "状态==》" + Thread.currentThread().getState());
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(flag);
//        System.out.println("数量==》" + Thread.activeCount());
//
//    }
    }
}