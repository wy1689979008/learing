import java.util.*;

public class MedianFinder {
    double middleValue;
    List<Integer> list = new LinkedList();

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {

    }

    public void addNum(int num) {
        list.add(num);
    }

    public double findMedian() {
        Integer[] array = list.toArray(new Integer[list.size()]);
        Arrays.sort(array);
        if (array.length % 2 == 0) {
            System.out.println(array[array.length / 2]);
            System.out.println(array[array.length / 2 - 1]);
            middleValue = (array[array.length / 2] + array[array.length / 2 - 1]) / 2.0;
            System.out.println(middleValue);
        } else {
            middleValue = array[(array.length + 1) / 2 - 1];
        }
        return middleValue;
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        double median = medianFinder.findMedian();
        System.out.println(median);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

