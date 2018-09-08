package x2018;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        char[] arr = {'a','b'};
        System.out.println(new String(arr));
        System.out.println(String.valueOf(arr));

//        String str = "8.9";
//        String[] str1 = str.split("/.");
//        System.out.println(str1[1]);

//        for (int i = 1; i <= 10; i++) {
//            System.out.println(i + " " + (i & 1));
//        }

        String str = "周杰|周杰伦|刘德华|王力宏";
        String str1 = "冰雨a|冰雨|北京欢迎你|七里香";
        String[] strr = str1.split("\\|");
        Arrays.sort(strr);
        for (int i = 0; i < strr.length; i++) {
            System.out.println(strr[i]);
        }

    }
}
