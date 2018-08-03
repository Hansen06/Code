package offer003;

/**
 * 正则表达式匹配
 */
public class Solution019_match {

    public boolean match(char[] str, char[] pattern){

        if (str == null || pattern == null){
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, pattern, strIndex, patternIndex);
    }

    private boolean matchCore(char[] str, char[] pattern, int strIndex, int patternIndex) {

        if (strIndex == str.length && patternIndex == pattern.length){
            return true;
        }
        if (strIndex != str.length && patternIndex == pattern.length){
            return false;
        }

        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if ((pattern[patternIndex] == str[strIndex] && strIndex != str.length) || (pattern[patternIndex] == '.' && strIndex != str.length)){
                return matchCore(str, pattern, strIndex, patternIndex+2) ||
                       matchCore(str, pattern, strIndex+1,patternIndex+2) ||
                       matchCore(str, pattern, strIndex+1, patternIndex);
            }
            else {
                return matchCore(str, pattern, strIndex+1, patternIndex+1);
            }
        }

        if ((strIndex != str.length &&str[strIndex] == pattern[patternIndex]) || (pattern[patternIndex] == '.' && strIndex != str.length)){
            return matchCore(str, pattern, strIndex+1, patternIndex+1);
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
