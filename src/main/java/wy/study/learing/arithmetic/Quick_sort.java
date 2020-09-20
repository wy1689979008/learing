package wy.study.learing.arithmetic;

public class Quick_sort {
    /**
     * 快速排序
     * 步骤：先选取一个基数，默认pivot=arrays[0],然后从high向low遍历，找到第一个小于pivot的值，放入arrays[0],然后从low
     * 向high遍历，找到比pivot大的数放入刚才比pivot大的数的那个位置，直到i==j.....
     * 递归调用
     * 思想：分治法
     */
    public static void main(String[] args) {
        int[] arrays = {7, 6, 8, 2, 10, 9};
        int[] ints = QuickSort(arrays, 0, arrays.length - 1);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] QuickSort(int[] arrays, int low, int high) {
//        int pivot = low;
//        int value=arrays[low];
//        while (low < high) {
//            if (arrays[high] < arrays[pivot] && low < high) {
//                arrays[low] = arrays[high];
//                arrays[high] = arrays[pivot];
//                while (arrays[low] < arrays[pivot] && low < high) {
//                    low++;
//                    if (arrays[low] > arrays[pivot]) {
//                        arrays[high] = arrays[low];
//                        arrays[low] = arrays[pivot];
//                    }
//                }
//            } else {
//                high--;
//            }
//            if (low == high) {
//                QuickSort(arrays, low, pivot - 1);
//                QuickSort(arrays, pivot + 1, high);
//            }
//
//
//        }

        if (low < high)
        {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = low, j = high, x = arrays[low];
            while (i < j)
            {
                while(i < j && arrays[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if(i < j)
                    arrays[i++] = arrays[j];

                while(i < j && arrays[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if(i < j)
                    arrays[j--] = arrays[i];
            }
            arrays[i] = x;
            QuickSort(arrays, low, i - 1); // 递归调用
            QuickSort(arrays, i + 1, low);
        }
        return arrays;
    }

    public static int[] sort(int[] arrays, int low, int high, int pivot) {
//        while (low < high) {
//            if (arrays[high] < pivot && low != high) {
//                arrays[low] = arrays[high];
//                low++;
//            }
//            if (arrays[low] > pivot && low != high) {
//                arrays[high] = arrays[low];
//                high--;
//            }
//            if (low==high){
//                sort(arrays,low,)
//            }
//
//
//        }

        return arrays;

    }
}
