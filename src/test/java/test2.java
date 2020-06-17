import wy.study.learing.bean.Person;
import wy.study.learing.service.AbatractTest;
import wy.study.learing.service.AbstractTest2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class test2 {
    private static Person singleInstance;

    public static Person getSingleInstance() {
        if (singleInstance == null) {
            synchronized (test2.class) {
                if (singleInstance == null) {
                    singleInstance=new Person("wy");
                }
            }
        }
        return singleInstance;
    }

    public static void main(String[] arg) {
        AbatractTest abatractTest=new AbstractTest2();
        abatractTest.incr();
        //DCL double click lock    //xls格式
        getSingleInstance();
    }

}

class MyThread implements Runnable {

    private Lock lock = new ReentrantLock();

    public void run() {

        lock.lock();
        System.out.println(Thread.currentThread().getState());
        try {
            for (int i = 0; i < 5; i++)
                System.out.println(Thread.currentThread().getName() + ":" + i);
            System.out.println(Thread.currentThread().getState());
        } finally {
            System.out.println(Thread.currentThread().getState());
            lock.unlock();
            System.out.println(Thread.currentThread().getState());

        }
    }


}

