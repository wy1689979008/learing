package wy.study.learing.arithmetic;

public class Quick_sort {
    /**
     * 快速排序
     * 步骤：先选取一个基数，默认pivot=arrays[0],然后从high向low遍历，找到第一个小于pivot的值，放入arrays[0],然后从low
     * 向high遍历，找到比pivot大的数放入刚才比pivot大的数的那个位置，直到i==j.....
     * 递归调用
     * 时间复杂度：nlog(n)
     * 思想：分治法
     */
    public static void main(String[] args) {
        int[] arrays = {5, 6, 8, 2, 10, 9,-2,100,99,200,-3,101,55,500};
        int[] ints = QuickSort(arrays, 0, arrays.length - 1);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

    }

    public static int[] QuickSort(int[] arrays, int low, int high) {
        int pivot = arrays[low];
        int left = low;
        int right = high;
        while (left < right) {
            //从右向左开始找<pivot，找不到就right--
            while (arrays[right] > pivot && left < right) {
                right--;
            }
            if (arrays[right] < pivot && left < right) {
                //交换位置
                arrays[left] = arrays[right];
                arrays[right] = pivot;
            }
            //从左向右开始找>pivot，找不到就left++
            while (arrays[left] < pivot && left < right) {
                left++;
            }
            if (arrays[left] > pivot && left < right) {
                //交换位置
                arrays[right] = arrays[left];
                arrays[left] = pivot;
            }
            if (left > low) {
                QuickSort(arrays, low, left - 1);
            }
            if (right < high) {
                QuickSort(arrays, right + 1, high);
            }
        }
        return arrays;

    }
}
