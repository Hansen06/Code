package leetcode_depth_first_search;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 205. Isomorphic Strings
 */
public class Solution290_WordPattern {


    public static boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null || pattern.length() != str.split(" ").length) {
            return false;
        }

        String[] ch = str.split(" ");
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char a = pattern.charAt(i);
            String b = ch[i];
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
        String s = "abba";
        String t = "dog cdt cat dog";
        System.out.println(wordPattern(s,t));

    }
}
