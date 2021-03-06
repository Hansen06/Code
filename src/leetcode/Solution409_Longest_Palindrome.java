package leetcode;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

/**
 * https://leetcode.com/problems/longest-palindrome/
 */
public class Solution409_Longest_Palindrome {


    /**
     * 次数为偶数，直接相加，为奇数，除以2乘以2，然后+1
     * @param s
     * @return
     */
    public static int longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        int[] map = getMap(s);
        int res = 0;
        boolean flag = false;
        for (int i = 0; i < map.length; i++) {
            if (map[i] % 2 == 0) {
                res += map[i];
            } else {
                res += (map[i] / 2) * 2;
                flag = true;
            }
        }
        if (flag) {
            return res + 1;
        } else {
            return res;
        }
    }

    /**
     * hash 计算每个字母出现的次数
     * @param s
     * @return
     */
    private static int[] getMap(String s) {
        int[] res = new int[256];
        for (int i = 0; i < s.length(); i++) {
            res[s.charAt(i)]++;
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "abccccdd";
        System.out.println(longestPalindrome(str));
        System.out.println(longestPalindrome("ccc"));

    }
}
