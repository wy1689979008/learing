package wy.study.learing.arithmetic;

public class Shell_sort {
    /**
     * 希尔排序
     * 要点：将一个数组以d为增量的组，d开始默认为数组大小的一半，后来逐渐减半，直到d==1结束，便不再分割
     */
    public static int[] ShellSort(int[] arrays) {
        int d = arrays.length / 2;
        while (d >= 1) {
            for (int i = 0; i < arrays.length; i++) {
                int start = i;
                int end = d + i;
                while (end < arrays.length) {
                    if (arrays[start] > arrays[end]) {
                        int middle = arrays[end];
                        arrays[end] = arrays[start];
                        arrays[start] = middle;
                    }
                    start++;
                    end++;
                }
            }
            d /= 2;
        }
        return arrays;
    }

    public static void main(String[] args) {
        int[] arrays = {5, 6, 8, 2, 10, 9, -2, 100, 99, 200, -3, 101, 55, 500};
        int[] ints = ShellSort(arrays);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

}


