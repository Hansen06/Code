package x2018.pingan;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 版本号排序
 * 2.96 < 3.4.5 < 4.8.2 < 4.8.4 < 4.13 < 6.4
 * 4.8 < 4.8.0
 */
public class pingan05 {


//    public static int compareVersion(String v1, String v2) {
//        if (v1.equals(v2)) {
//            return 0;
//        }
//        String[] version1Array = v1.split("[._]");
//        String[] version2Array = v2.split("[._]");
//        int index = 0;
//        int minLen = Math.min(version1Array.length, version2Array.length);
//        long diff = 0;
//
//        while (index < minLen
//                && (diff = Long.parseLong(version1Array[index])
//                - Long.parseLong(version2Array[index])) == 0) {
//            index++;
//        }
//        if (diff == 0) {
//            for (int i = index; i < version1Array.length; i++) {
//                if (Long.parseLong(version1Array[i]) > 0) {
//                    return 1;
//                }
//            }
//
//            for (int i = index; i < version2Array.length; i++) {
//                if (Long.parseLong(version2Array[i]) > 0) {
//                    return -1;
//                }
//            }
//            return 0;
//        } else {
//            return diff > 0 ? 1 : -1;
//        }
//    }

    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1 == null || o2 == null) {
                return -1;
            }
            if (o1.compareTo(o2) > 0) {
                return 1;
            }
            if (o1.compareTo(o2) < 0) {
                return -1;
            }
            if (o1.compareTo(o2) == 0) {
                return 0;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }
//        String[] arr = {"2.96", "4.8"};
//        String[] arr1 = {"4.8", "4.8.0", "2.96"};
        Arrays.sort(arr, new MyComparator());
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
