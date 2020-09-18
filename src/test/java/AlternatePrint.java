import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class AlternatePrint {

    /**
     * 交替打印
     *
     * @param args
     */

    //解法四，自旋锁
    enum readToRun{T1, T2}
    static volatile readToRun T=readToRun.T1;


    public static void main(String[] args) {
        char[] a = "ABCDEFG".toCharArray();
        char[] b = "1234567".toCharArray();

        //第一种解法，LockSupport.park 与LockSupport.unpark()
//        new Thread(() -> {
//            for (char c : a) {
//                System.out.println(c);
//                LockSupport.unpark(t2);
//                LockSupport.park();
//            }
//        },"t1").start();
//         new Thread(() -> {
//            for (char c : b) {
//                LockSupport.park();
//                System.out.println(c);
//                LockSupport.unpark(t1);
//
//            }
//        },"t2").start();
        //       t1.start();
        //     t2.start();



        //第二种解法，synchronized+notify()+wait()
         final Object o = new Object();
        new Thread(() -> {
            synchronized (o) {
                for (char c : a) {
                    System.out.println(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();//为什么这里加notify()？因为执行完毕总有一个线程阻塞在那里,那也就无法停止程序
            }
        }, "t1").start();
        new Thread(() -> {
            synchronized (o) {
                for (char c : b) {
                    System.out.println(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }, "t1").start();


        //第三种解法，condition(相当于一个阻塞队列)
//        ReentrantLock lock = new ReentrantLock();
//        Condition condition1 = lock.newCondition();
//        Condition condition2 = lock.newCondition();
//        new Thread(() -> {
//            try {
//                lock.lock();
//                for (char c : a) {
//                    System.out.println(c);
//                    condition2.signal();
//                    condition1.await();
//                }
//                condition2.signal();
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                lock.unlock();
//            }
//        }, "t1").start();
//
//        new Thread(() -> {
//            try {
//                lock.lock();
//                for (char c : b) {
//                    System.out.println(c);
//                    condition1.signal();
//                    condition2.await();
//                }
//                condition1.signal();
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                lock.unlock();
//            }
//        }, "t2").start();




        //解法四：自旋锁
//        new Thread(()->{
//            for (char c:a){
//                while (!(T==readToRun.T1)){}//自旋等待
//                System.out.println(c);
//                T=readToRun.T2;
//            }
//        },"t1").start();
//        new Thread(()->{
//            for (char c:b){
//                while (!(T==readToRun.T2)){}//自旋等待
//                System.out.println(c);
//                T=readToRun.T1;
//            }
//        },"t2").start();


        //解法五：semaphore
        Semaphore semaphore1=new Semaphore(1);
        Semaphore semaphore2=new Semaphore(0);
        new Thread(()->{
            for (char c:a){
                try {
                    semaphore1.acquire();
                    System.out.println(c);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore2.release();
                    //semaphore1.release();

                }
            }
        },"t1").start();

        new Thread(()->{
            for (char c:b){
                try {
                    semaphore2.acquire();
                    System.out.println(c);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //semaphore2.release();
                    semaphore1.release();

                }
            }
        },"t2").start();


    }



}
