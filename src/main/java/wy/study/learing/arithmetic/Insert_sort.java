package wy.study.learing.arithmetic;

import java.math.MathContext;
import java.util.Random;
import java.util.UUID;

public class Insert_sort {
    /**
     * 插入排序
     * 思想：相当于抓扑克牌游戏，左手抓牌都是有序的，每抓一张牌都会按照顺序插入
     */
    public static int[] InsertSort(int[] arrays) {
        for (int i = 1; i < arrays.length; i++) {
            //左手上的扑克牌数量取决于I的值
            int index = i;
            int middle = i - 1;
            while (middle >= 0 && arrays[index] < arrays[middle]) {
                Swap.Swap(arrays, middle, index);
                index--;
                middle--;
            }
        }
        return arrays;
    }

    public static void main(String[] args) throws Exception {
        Random random = new Random(100000);

        int[] arrays=new int[10000];
        for (int i=0;i<arrays.length;i++){
            int value = random.nextInt();
            arrays[i]=value;
        }
        System.out.println("开始执行=======》");
        long start = System.currentTimeMillis();
        //int[] ints = InsertSort(arrays);
        int[] ints= Quick_sort.QuickSort(arrays, 0, arrays.length - 1);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
        long end = System.currentTimeMillis();
        long time=end-start;
        System.out.println(time);
    }
}
