package x2018.pingan;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 把数组排成最小的数
 */
public class pingan01 {

    public static String PrintMinNumber(int [] numbers) {

        if (numbers == null){
            return "";
        }

        StringBuilder sb = new StringBuilder();

        String[] result = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(result, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String tmp1 = s1 + s2;
                String tmp2 = s2 + s1;
                return tmp1.compareTo(tmp2);
            }
        });

        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int tmp;
        for (int i = 0; i < n; i++) {
            tmp = sc.nextInt();
            arr[i] = tmp;
        }

        System.out.println(PrintMinNumber(arr));
    }
}
