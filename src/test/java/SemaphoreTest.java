import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    static volatile int flag = 10;
    Semaphore zeroSemaphore = new Semaphore(1);
    Semaphore evenSemaphore = new Semaphore(0);
    Semaphore oddSemaphore = new Semaphore(0);
    static int i = 0;

    public static void main(String[] args) {
        //定义三个线程，分别输出0、 奇、 偶数
        for (i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(0);
            }).start();


            new Thread(() -> {
                if (i % 2 == 1) {
                    System.out.println(i);
                }

            }).start();

            new Thread(() -> {
                if (i % 2 == 0) {
                    System.out.println(i);
                }

            }).start();

        }
    }


}
