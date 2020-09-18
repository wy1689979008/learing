import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

import static org.springframework.test.context.transaction.TestTransaction.start;

public class FizzBuzz {
    volatile static int i = 1;

    public static void main(String[] args) {
        int n = 10;
        Object object = new Object();
        Semaphore semaphore = new Semaphore(1);

        FizzBuzz fizzBuzz = new FizzBuzz(n);
        new Thread(() -> {
            while (i < n) {
                if (i % 3 == 0 && i % 5 != 0) {
                    synchronized (object) {
                        System.out.println("fizz" + "==>" + i);
                        object.notifyAll();
                        i++;
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
        new Thread(() -> {
            while (i < 10) {
                if (i % 3 != 0 && i % 5 == 0) {
                    synchronized (object) {
                        System.out.println("buzz" + "==>" + i);
                        object.notifyAll();
                        i++;
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
        new Thread(() -> {
            while (i<n){
                if (i % 3 == 0 && i % 5 == 0) {
                    synchronized (object) {
                        System.out.println("fizzbuzz" + "==>" + i);
                        object.notifyAll();
                        i++;
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
        new Thread(() -> {
            while (i<n){
                if (i % 3 != 0 && i % 5 != 0) {
                    synchronized (object) {
                        System.out.println(i);
                        object.notifyAll();
                        i++;
                        try {
                            object.wait();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }

    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    Semaphore semaphore = new Semaphore(n);

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            while (i % 3 == 0 && i % 5 != 0) {
                semaphore.acquire();
                printFizz.run();
                semaphore.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            while (i % 3 != 0 && i % 5 == 0) {
                semaphore.acquire();
                printBuzz.run();
                semaphore.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            while (i % 3 == 0 && i % 5 == 0) {
                semaphore.acquire();
                printFizzBuzz.run();
                semaphore.release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            while (i % 3 != 0 && i % 5 != 0) {
                semaphore.acquire();
                printNumber.accept(i);
                semaphore.release();
            }
        }
    }
}
