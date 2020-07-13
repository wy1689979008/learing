import java.util.concurrent.*;

public class CallAble {

    public static void main(String[] args) {
        Callable callable=new Callable() {
            @Override
            public String call() throws Exception {
                return "hello world";
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future submit = executorService.submit(callable);
        try {
            System.out.println(submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
