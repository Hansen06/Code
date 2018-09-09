package leetcode_depth_first_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 205. Isomorphic Strings
 */
public class Solution205_IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < ch2.length; i++) {
            if (!list.contains(ch2[i])) {
                list.add(ch2[i]);
            }
        }
        boolean flag = false;
        ArrayList<Character> set = new ArrayList<>();
        for (int j = 0; j < ch1.length ; j++) {
            if (!set.contains(ch1[j])) {
                set.add(ch1[j]);
            }
        }
        if (set.size() == list.size()) {
            String cur = s;
            for (int j = 0; j < list.size(); j++) {
                cur = cur.replaceAll(String.valueOf(set.get(j)), String.valueOf(list.get(j)));
            }
            if (cur.equals(t)) {
                flag = true;
            }
        }
        return flag;
    }

    public static boolean isIsomorphic1(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)])
                return false;
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }

    public static boolean isIsomorphic2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (map.containsKey(a)){
                if (map.get(a).equals(b)){
                    continue;
                }else {
                    return false;
                }
            }else {
                if (!map.containsValue(b)){
                    map.put(a,b);
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "foo";
        String t = "bar";
        System.out.println(isIsomorphic1(s,t));
        System.out.println(isIsomorphic2(s,t));

    }
}
