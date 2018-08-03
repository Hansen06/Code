package offer003;

/**
 *翻转单词顺序列
 */
public class Solution058_ReverseSentence {

    public static String ReverseSentence(String str) {

        if (str == null || str.length() < 2){
            return str;
        }

        char[] ch = str.toCharArray();
        ReverseCore(ch, 0, ch.length - 1);

        int begin = 0;
        int end = 0;
        while (begin < ch.length-1){
            if (ch[begin] == ' '){
                begin++;
                end++;
            }else if (end == ch.length || ch[end] == ' '){ // 错误 ch[end] == ' ' || end == ch.length
                ReverseCore(ch, begin, --end);
                System.out.println(ch);
                begin = ++end;
            }else {
                end++;
            }
        }

        return String.valueOf(ch);
    }

    public static void ReverseCore(char[] ch , int begin, int end){
        if (begin > end){
            return;
        }
        while (begin < end){
            char tem = ch[begin];
            ch[begin] = ch[end];
            ch[end] = tem;
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {

        String str = "student a am I";
        System.out.println(ReverseSentence(str));
    }
}
