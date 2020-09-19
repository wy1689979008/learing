package wy.study.learing;

import java.util.HashMap;
import java.util.Map;

public class test1 {


    public static void main(String[] args) {
//        int index = 0;
//        int length = 128;
//        for (int i = 10000; i < 100000; i++) {
//            int hash = i ^ (i >>> 16);
//            int in = hash & (length - 1);
//            if (in == index) {
//                System.out.println(i);
//            }
//        }
        Map<Integer, Integer> map = new HashMap(128);
        int value = 0;
        int[] maps = new int[]{10112, 10240, 10368, 10496, 10624, 10752, 10880, 11008, 11136};
        for (int m : maps) {
            map.put(m, value);
            value++;
//            System.out.println((m & 127) + "===>" + (m % 128));
        }

    }
}
