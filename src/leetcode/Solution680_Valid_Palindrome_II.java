package leetcode;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 */

public class Solution680_Valid_Palindrome_II {

    public static ArrayList<Character> getString(String str) {
        char[] chArr = str.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < chArr.length; i++) {
            if ((chArr[i] >= 'a' && chArr[i] <= 'z') || (chArr[i] >= 'A' && chArr[i] <= 'Z')) {
                list.add(Character.toLowerCase(chArr[i]));
            }
        }
        ArrayList<Character> res = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < 2 * list.size() + 1; i++) {
            res.add((i & 1) == 0 ? '#' : list.get(index++));
        }
        return res;
    }

    public static boolean validPalindrome(String s) {
        if (s == null) {
            return true;
        }
        ArrayList<Character> chArr = getString(s);
        int mid = chArr.size() / 2;
        int left = mid - 1;
        int right = mid + 1;
        while (left >= 0 && right <= chArr.size()) {
            if (chArr.get(left) == chArr.get(right)) {
                left--;
                right++;
            } else {
                ArrayList<Character> left_re = new ArrayList<>(chArr);
//                ArrayList<Character> right_re = new ArrayList<>(chArr);
                ArrayList<Character> right_re = (ArrayList<Character>) chArr.clone();
                left_re.remove(left);
                left_re.remove(left--);
                right_re.remove(right);
                right_re.remove(right++);
                return isPalindromeCore(left_re) || isPalindromeCore(right_re);
            }
        }
        return true;
    }

    private static boolean isPalindromeCore(ArrayList<Character> list) {
        int mid = list.size() / 2;
        int left = mid - 1;
        int right = mid + 1;
        while (left >= 0 && right <= list.size()) {
            if (list.get(left) == list.get(right)) {
                left--;
                right++;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean validPalindrome1(String s) {
        int l = -1;
        int r = s.length();
        while (++l < --r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindromic(s, l, r + 1) || isPalindromic(s, l - 1, r);
            }
        }
        return true;
    }

    public static boolean isPalindromic(String s, int l, int r) {
        while (++l < --r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String x = "aba";
        System.out.println(validPalindrome(x));

        String str = "abca";
        System.out.println(validPalindrome(str));

        System.out.println(validPalindrome(""));

        System.out.println(validPalindrome("OP"));
        System.out.println(validPalindrome("eedede"));
        System.out.println(validPalindrome1("eedede"));
    }

}
