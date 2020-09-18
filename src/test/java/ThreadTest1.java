public class ThreadTest1 {
    public void print(String a) {
        synchronized (a) {
            while (true){
                System.out.println(Thread.currentThread().getName());
            }

        }
    }


}
