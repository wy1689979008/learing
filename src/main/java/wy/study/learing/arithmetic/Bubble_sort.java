package wy.study.learing.arithmetic;

public class Bubble_sort {
    /**
     * 冒泡排序  从头开始逐个比较，直到最小的浮到最上面
     */
    static Integer[] sort = {3, -1,1, 5, 200, 100, 9, 10, 8};

    public static Integer[] bubble(Integer[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length-1-i; j++) {
                if (arrays[j] > arrays[j+1]) {
                    //交换顺序
                    int middle=arrays[j];
                    arrays[j]=arrays[j+1];
                    arrays[j+1]=middle;
                }
            }
        }
        return arrays;
    }

    public static void main(String[] args) {
        Integer[] bubble = bubble(sort);
        for (Integer integer : bubble) {
            System.out.println(integer);
        }
        System.out.println(bubble);
    }
}
