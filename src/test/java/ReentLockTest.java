import java.util.concurrent.locks.ReentrantLock;

public class ReentLockTest {
    static volatile int value = 0;

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock(true);

        new Thread(() -> {
            try {
                while (true) {
                    reentrantLock.lock();
                    value++;
                    System.out.println(value + "==>" + Thread.currentThread().getName());
                    Thread.sleep(3000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //reentrantLock.unlock();
            }

        }).start();
        new Thread(() -> {
            while (true) {
                try {
                    reentrantLock.lock();
                    value++;
                    System.out.println(value + "==>" + Thread.currentThread().getName());

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    //reentrantLock.unlock();
                }
            }

        }).start();
    }

}
