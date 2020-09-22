package wy.study.learing.arithmetic;

public class Swap {
    /**
     * 交换顺序
     */
    public static void Swap(int[] arrays,int start, int end) {
        int middle = arrays[start];
        arrays[start] = arrays[end];
        arrays[end] = middle;

    }
}
