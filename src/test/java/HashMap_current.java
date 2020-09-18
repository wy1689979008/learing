import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class HashMap_current {
    static int key = 0;
    static int value = 0;
    //Map<Integer, Integer> map = new HashMap<>(512);
    ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>(512);

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        HashMap_current hashMapCurrent = new HashMap_current();

        CountDownLatch countDownLatch = new CountDownLatch(threads.length);
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                hashMapCurrent.incr();
                //System.out.println(hashMapCurrent.value);
                countDownLatch.countDown();
            });
            threads[i].start();

        }
        countDownLatch.await();
        System.out.println(hashMapCurrent.value);
        System.out.println(hashMapCurrent.key);
        System.out.println(hashMapCurrent.map.size());

    }

    public int incr() {
        for (int j = 0; j < 1000; j++) {
            synchronized (this) {
                map.put(key, value);
                key++;
                value++;
            }
        }
        return value;
    }
}
