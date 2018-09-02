package newcoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 字典序
 * https://www.nowcoder.com/practice/6c9d8d2e426c4c58bbadfdf67d591696?tpId=85&&tqId=29877&rp=1&ru=/activity/oj&qru=/ta/2017test/question-ranking
 */
public class Zidianxu {

    public static class Mycomparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(i+1);
        }
        Arrays.sort(arr);
        System.out.println(arr[m-1]);

    }
}
