import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

class FooBar {
    public static void main(String[] args) {

        new Thread(() -> {
            FooBar fooBar = new FooBar(2);
            try {
                fooBar.foo(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("foo");
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            FooBar fooBar = new FooBar(2);
            try {
                fooBar.bar(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("bar");
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private int n;
    private static volatile boolean flag = true;


    public FooBar(int n) {
        this.n = n;
    }

    ReentrantLock lock = new ReentrantLock();

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (!flag) {
                synchronized (this){
                    notify();
                }
            }
            try {
                lock.lock();
                printFoo.run();
                flag = false;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();

            }
        }
        //countDownLatchOne.await();
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (flag) {
                synchronized (this){
                    notify();
                }
            }
            try {
                lock.lock();
                printBar.run();
                flag = true;

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}