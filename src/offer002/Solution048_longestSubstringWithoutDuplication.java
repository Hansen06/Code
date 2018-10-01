package offer002;

/**
 * 最长不含重复字符的子字符串
 */
public class Solution048_longestSubstringWithoutDuplication {


    public static int longestSubstringWithoutDuplication(String str){
        if (str == null || str.length() < 1){
            return 0;
        }

        int maxLen = 0;
        int curLen = 0;
        int[] position = new int[26];
        for (int i = 0; i < 26; i++) {
            position[i] = -1;
        }

        for (int i = 0; i < str.length(); i++) {
            int preIndex = position[str.charAt(i) - 'a'];
            if (preIndex < 0 || i - preIndex > curLen){
                ++curLen;
            }else{
                if (curLen > maxLen){
                    maxLen = curLen;
                }
                curLen = i - preIndex;
            }
            position[str.charAt(i) - 'a'] = i;
            System.out.println(str.substring(i - curLen + 1, i+1));
        }

        if (curLen > maxLen){
            maxLen = curLen;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String str = "arab";
        System.out.println(longestSubstringWithoutDuplication(str));
    }
}
