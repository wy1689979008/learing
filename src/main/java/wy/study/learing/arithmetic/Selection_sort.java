package wy.study.learing.arithmetic;

public class Selection_sort {
    /**
     * 选择排序  3 ,2,5,7,4
     * 思想：从一组数字中选取最小的一个数，放到一边，然后再从剩余的数字中选取最小的数字放到刚才那组数字右边，直到取完最后一个数字
     */
    public static int[] SelectionSort(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            int next = i + 1;
            while (next < arrays.length) {
                if (arrays[next] < arrays[i]) {
                    //交换顺序
                    Swap.Swap(arrays, i, next);
                }
                next++;
            }
        }
        return arrays;
    }

    public static void main(String[] args) {
        int[] sort = {3, -1,1, 5, 200, 100, 9, 10, 8};
        int[] selectionSort = SelectionSort(sort);
        for (Integer integer : selectionSort) {
            System.out.println(integer);
        }
    }
}
