package Offer;

/**
 * 在一个字符串(1<=字符串长度<=10000，
 * 全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置
 */
public class Solution014_FirstNotRepeatingChar {

    public static int FirstNotRepeatingChar(String str) {

        if (str.length() == 0){
            return -1;
        }

        char[] chars = str.toCharArray();
        int len = chars.length;
        int[] map = new int[256];

        for (int i = 0; i < len; i++) {
            map[chars[i]]++;
        }

        for (int i = 0; i < len; i++) {
            if (map[chars[i]] == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        String str = "abaccdeff";
//        String[] arr = str.split("");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }

        int index = FirstNotRepeatingChar(str);
        System.out.println(index);
    }
}
