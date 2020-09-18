import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMap_test {
    public static void main(String[] args) {
//        2226080
//        2226208
//        2226336
//        2226464
//        2226592
//        2226720
//        2226848
//        2226976
//        2227104
//        2227232

        BigDecimal   r   =   new   BigDecimal(1d/3*100);
        r  =   r.setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println(r);
        List<Integer> list = new ArrayList();
        int hash = 0;
        int middle = 0;
        for (int i = 0; i < 10000; i++) {
            hash++;
            int index = (hash ^ (hash >>> 16)) & (1);
            if (hash == 1) {
                middle = index;
            }
            if (index == middle) {
                list.add(hash);
                if (list.size() == 100) {
                    break;
                }
               // System.out.println(hash);
            }
        }
        HashMap<Integer, Integer> map = new HashMap(2);
        int value = 1;
        for (Integer i : list) {
            if (i == 197) {
                break;
            }
            map.put(i, value);
            value++;

        }
        System.out.println(map.size());

        map.put(197, value++);
        System.out.println(map.size());


//        HashMap<Integer,Integer> map = new HashMap(128);
//        int[] ints=new int[]{2226080,2226208,2226336,2226464,2226592,2226720,2226848,2226976,2227104,2227232};
//        map.put(2226080,2226080);
//        map.put(2226208,2226208);
//        for (int i:ints){
//            map.put(i,i);
//            //System.out.println(i & 127);
//
//        }
//        int key=2;
//        for (int i=0;i<18;i++){
//            key*=2;
//        }
//
//        map.put(key, 259);
//        map.put(1,1);

        //异常情况
        /**
         * 导入数据失败
         * 定时任务不执行
         *
         */
    }
}
