package leetcode;

import java.util.HashMap;

/**
 * 459. Repeated Substring Pattern
 */
public class Solution459_RepeatedSubstringPattern {

    //没有拼接快  垃圾思路
    public static boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        int i = 0;
        while (i <= s.length() - t.length()) {
            String a = s.substring(i, i + t.length());
            if (!a.equals(t)) {
                return false;
            }
            i = i + t.length();
        }
        return true;
    }

    public static boolean repeatedSubstringPattern(String s) {
        if (s == null) {
            return false;
        }

        int len = s.length();
        int index = len / 2;
        while (index >= 1) {
            if (len % index == 0){
                int time = len / index;
                String sub = s.substring(0, index);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < time; i++) {
                    sb.append(sub);
                }
                if (sb.toString().equals(s)){
                    return true;
                }
            }
            index--;
        }
        return false;
    }

    public static boolean repeatedSubstringPattern1(String str) {
        int l = str.length();
        for (int i = l / 2; i >= 1; i--) {
            if (l % i == 0) {
                int m = l / i;
                String subS = str.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < m; j++) {
                    sb.append(subS);
                }
                if (sb.toString().equals(str))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "ababababababababababababababababababababababababababababababababababab";
        String str1 = "abac";
        String str2 = "babbabbabbabbab";
        String str3 = "ababab";
//        System.out.println(repeatedSubstringPattern1(str));
//        System.out.println(repeatedSubstringPattern1(str1));
        System.out.println(repeatedSubstringPattern(str2));
//        System.out.println(repeatedSubstringPattern1(str3));
    }
}
