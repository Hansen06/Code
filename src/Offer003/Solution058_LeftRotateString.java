package Offer003;

/**
 * 左旋转字符串
 */

public class Solution058_LeftRotateString {

    public static String LeftRotateString(String str, int n) {

        if (str == null || str.length() < n){
            return str;
        }

        char[] ch = str.toCharArray();
        int begin = 0;
        int mid = n - 1;
        int end = ch.length - 1;
        ReverseCore(ch, begin, mid);
        ReverseCore(ch, n, end);
        ReverseCore(ch, begin, end);
        return String.valueOf(ch);
     }

    public static void ReverseCore(char[] ch , int begin, int end){
        if (begin > end){
            return;
        }
        while (begin < end){
            char tem = ch[begin];
            ch[begin] = ch[end];
            ch[end] = tem;
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        String str = "abcdefg";
        System.out.println(LeftRotateString(str, 2));
    }
}
