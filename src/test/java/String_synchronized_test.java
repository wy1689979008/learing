public class String_synchronized_test extends Thread{

    private ThreadTest1 threadTest;
    public String_synchronized_test(ThreadTest1 threadTest1){
        this.threadTest=threadTest1;
    }

    @Override
    public void run() {
        threadTest.print("AA");
    }
}
