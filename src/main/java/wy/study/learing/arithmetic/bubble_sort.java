package wy.study.learing.arithmetic;

public class bubble_sort {
    /**
     * 冒泡排序
     */
    static Integer[] sort = {3, -1,1, 5, 200, 100, 9, 10, 8};

    public static Integer[] bubble(Integer[] arrays) {
        for (int i = 0; i < arrays.length - 1; i++) {
            for (int j = i; j < arrays.length - 1; j++) {
                if (arrays[j] > arrays[j + 1]) {
                    //交换顺序
                    swap(arrays, j, j + 1);
                }
            }
        }
        return sort;
    }

    /**
     * 交换顺序
     */
    static void swap(Integer[] arrays, int firstIndex, int endIndex) {
        int middle = arrays[firstIndex];
        arrays[firstIndex] = arrays[endIndex];
        arrays[endIndex] = middle;
    }

    public static void main(String[] args) {
        Integer[] bubble = bubble(sort);
        for (Integer integer : bubble) {
            System.out.println(integer);
        }
        System.out.println(bubble);
    }
}
