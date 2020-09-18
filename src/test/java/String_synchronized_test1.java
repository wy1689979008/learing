
    public class String_synchronized_test1 extends Thread{
        private String b;

        public void setB(String b) {
            this.b = b;
        }

        public String getB() {
            return b;
        }

        private ThreadTest1 threadTest;
        public String_synchronized_test1(ThreadTest1 threadTest1){
            this.threadTest=threadTest1;
        }

        @Override
        public void run() {
            threadTest.print("BB");
        }

        public static void main(String[] args) {

//            ThreadTest1 threadTest=new ThreadTest1();
//            String_synchronized_test test1=new String_synchronized_test(threadTest);
//            test1.setName("A");
//            test1.start();
//
//
//            String_synchronized_test1 test2=new String_synchronized_test1(threadTest);
//            test2.setName("B");
//            test2.start();
            Object lock=new Object();
            Thread thread1=new Thread(()->{
                synchronized (lock){
                    System.out.println("wait 开始时间"+System.currentTimeMillis());
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("wait 结束时间"+System.currentTimeMillis());
                }
            });
            Thread thread2=new Thread(()->{
                synchronized (lock){
                    System.out.println("notify 开始时间"+System.currentTimeMillis());
                    lock.notify();
                    System.out.println("notify 结束时间"+System.currentTimeMillis());
                }
            });
            thread1.start();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread2.start();

        }

}
