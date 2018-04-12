package Offer;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Solution018_replaceSpace {

    public static String replaceSpace(StringBuffer str) {

        if (str == null){
            return null;
        }

        int old_len = str.length();
        int space_num = 0;
        for (int i = 0; i < old_len; i++) {
            if (str.charAt(i) == ' '){
                space_num++;
            }
        }

        int  new_len = old_len + space_num*2;
        int indexold = old_len - 1;
        int indexnew = new_len - 1;
        str.setLength(new_len);
        
        for (; indexold >= 0 && indexold < new_len; indexold--) {
            if (str.charAt(indexold) == ' '){
                str.setCharAt(indexnew--, '0');
                str.setCharAt(indexnew--, '2');
                str.setCharAt(indexnew--, '%');
            }else {
                str.setCharAt(indexnew--, str.charAt(indexold));
            }
        }

        return str.toString();
    }


    //辅助空间O(n)
    public static String replaceSpace1(StringBuffer str){
        if(str==null){
            return null;
        }
        StringBuilder newStr = new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                newStr.append('%');
                newStr.append('2');
                newStr.append('0');
            }else{
                newStr.append(str.charAt(i));
            }
        }
        return newStr.toString();
    }

    public static void main(String[] args) {

        StringBuffer str = new StringBuffer("we are happy");
        String resulut = replaceSpace(str);
        System.out.println(resulut);
    }
}
