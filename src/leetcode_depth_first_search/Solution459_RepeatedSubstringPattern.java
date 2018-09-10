package leetcode_depth_first_search;

import java.util.HashMap;

/**
 * 459. Repeated Substring Pattern
 */
public class Solution459_RepeatedSubstringPattern {

    public static boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        int i = 0;
        while (i <= s.length() - t.length()){
            String a = s.substring(i, i + t.length());
            if (!a.equals(t)){
                return false;
            }
            i = i + t.length();
        }
        return true;
    }

    public static boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length()%2 != 0){
            return false;
        }

        int mid = s.length()/2;
        boolean flag = false;
        while(mid > 0){
            if (isIsomorphic(s, s.substring(0, mid))){
                flag = true;
                break;
            }else {
                mid = mid - 1;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        String str = "ababababababababababababababababababababababababababababababababababab";
        String str1 = "abac";
        String str2 = "babbabbabbabbab";
        System.out.println(repeatedSubstringPattern(str));
        System.out.println(repeatedSubstringPattern(str1));
        System.out.println(repeatedSubstringPattern(str2));
    }
}
