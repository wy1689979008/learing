public class Thread_join extends Thread {

    static int value=0;
    @Override
    public void run() {
        Thread[] threads=new Thread[10];
        for (int i=0;i<threads.length;i++){
            threads[i]=new Thread(()->{
                value++;
                System.out.println(value);
            });
            threads[i].start();
        }
    }

    public static void main(String[] args) throws InterruptedException {

//        Thread_join threadJoin=new Thread_join();
//        threadJoin.start();
//        threadJoin.join();

        ThreadLocal threadLocal=new ThreadLocal();
        threadLocal.set("t1");
        new Thread(()->{
            threadLocal.set("t1");
            System.out.println(Thread.currentThread().getName()+"==>"+threadLocal.get());
        }).start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"==>"+threadLocal.get());
        }).start();
    }
}
