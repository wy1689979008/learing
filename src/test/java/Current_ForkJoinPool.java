import org.junit.jupiter.api.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Current_ForkJoinPool extends RecursiveAction {

    private int START, END;

    public Current_ForkJoinPool(int s, int e) {
        s=this.START;
        e=this.END;
    }

    @Override
    protected void compute() {
        int caculate = caculate(0, 10000);

        Current_ForkJoinPool task1=new Current_ForkJoinPool(1,5000);
        Current_ForkJoinPool task2=new Current_ForkJoinPool(5001,10000);
        task1.caculate(1,5000);
        task2.caculate(5001,1000);
        task1.fork();
        task2.fork();
    }

    public int caculate(int start, int end) {
        int minddle=(end-start)/2;
        Current_ForkJoinPool task1=new Current_ForkJoinPool(start,minddle);
        Current_ForkJoinPool task2=new Current_ForkJoinPool(minddle+1,end);
        for (int i = start; i < end; i++) {
            start++;
        }

        System.out.println(start);
        return start;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool=new ForkJoinPool();
    }
}
