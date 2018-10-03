package leetcode_sort;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-anagram/
 */
public class Solution242_Valid_Anagram {
    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        String s1 = String.valueOf(ch1);
//        String s2 = String.valueOf(ch2);
        String s2 = new String(ch2);
        if (!s1.equals(s2)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
}
