package x2018;

import Online.Te;
import org.omg.CORBA.INTERNAL;

import java.util.*;

public class Test {
    public static void main(String[] args) {
//        char[] arr = {'a','b'};
//        System.out.println(new String(arr));
//        System.out.println(String.valueOf(arr));

//        String str = "8.9";
//        String[] str1 = str.split("/.");
//        System.out.println(str1[1]);

//        for (int i = 1; i <= 10; i++) {
//            System.out.println(i + " " + (i & 1));
//        }

//        String str = "周杰|周杰伦|刘德华|王力宏";
//        String str1 = "冰雨a|冰雨|北京欢迎你|七里香";
//        String[] strr = str1.split("\\|");
//        Arrays.sort(strr);
//        for (int i = 0; i < strr.length; i++) {
//            System.out.println(strr[i]);
//        }

//        System.out.println("A");
//        new Test();
//        new Test();


        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 4);
        map.put(2, 5);
        map.put(3, 2);

        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            //升序排序
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int rank = 0;
        for (Map.Entry<Integer, Integer> e : list) {
            System.out.println(e.getKey() + ":" + e.getValue());
            rank++;
            if (e.getKey() == 2){
                System.out.println(rank);
                break;
            }
        }
    }

    public Test() {
        System.out.println("B");
    }

    {
        System.out.println("C");
    }

    static {
        System.out.println("D");
    }
}
