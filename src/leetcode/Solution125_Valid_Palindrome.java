package leetcode;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/valid-palindrome/
 */

public class Solution125_Valid_Palindrome {


    public static char[] getString(String str) {
        char[] chArr = str.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < chArr.length; i++) {
            if ((chArr[i] >= 'a' && chArr[i] <= 'z') || (chArr[i] >= 'A' && chArr[i] <= 'Z')) {
                list.add(Character.toLowerCase(chArr[i]));
            }
        }
        char[] res = new char[2 * list.size() + 1];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : list.get(index++);
        }
        return res;
    }

    public static boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }
        char[] chArr = getString(s);
        int mid = chArr.length / 2;
        int left = mid - 1;
        int right = mid + 1;
        while (left >= 0 && right <= chArr.length) {
            if (chArr[left] == chArr[right]) {
                left--;
                right++;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 系统函数搞定
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome1(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }

    public static void main(String[] args) {
        String x = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(x));

        String str = "race a car";
        System.out.println(isPalindrome(str));

        System.out.println(isPalindrome(""));

        System.out.println(isPalindrome("OP"));
    }

}
