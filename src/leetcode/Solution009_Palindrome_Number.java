package leetcode;

/**
 * https://leetcode.com/problems/palindrome-number/description/
 */

public class Solution009_Palindrome_Number {


    public static char[] getString(String str){
        if (str == null || str.length() <1){
            return null;
        }
        char[] chArr = str.toCharArray();
        char[] res = new char[2*str.length()+1];
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : chArr[index++];
        }
        return res;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        String str = String.valueOf(x);
        char[] chArr = getString(str);
        int mid = chArr.length / 2;
        int left = mid - 1;
        int right = mid + 1;
        while (left >= 0 && right <= chArr.length){
            if (chArr[left] == chArr[right]){
                left--;
                right++;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int x = 122;
        System.out.println(isPalindrome(x));
    }

}
