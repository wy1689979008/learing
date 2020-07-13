import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;

public class C {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Executors.newFixedThreadPool(100).execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程" + Thread.currentThread().getName());
                }
            });
        }
    }
    static int flag = 0;
    Thread r = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 11; i++) {
                if (i == 10) {
                    return;
                } else {
                    synchronized (this) {
                        flag++;
                    }
                }
                System.out.println("线程==>" + Thread.currentThread().getName() + "==" + flag);
            }
        }
    });

    @Test
    public void multiThread() {
        for (int i = 0; i < 10; i++) {
            Executors.newFixedThreadPool(100).execute(r);
        }
    }
}
