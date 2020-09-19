public class TryFianllyTest {
    public static int test() {
        int[] a=new int[]{1};
        String b="b";
        String intern = b.intern();
        System.out.printf(intern+"\n");
        try {
            a[0]=3;
            return a[0];
        } finally {
            a[0]=4;
            return a[0];
        }
    }

    public static void main(String[] args) {
        int value = test();
        System.out.printf("value id "+value+"\n");
    }
}
