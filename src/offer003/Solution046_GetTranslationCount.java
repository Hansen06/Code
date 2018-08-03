package offer003;

/**
 * 把数字翻译成字符创
 */

public class Solution046_GetTranslationCount {

    public static int GetTranslationCount(int number){
        if(number < 0){
            return 0;
        }

        String str = String.valueOf(number);
        return GetTranslationCount(str);
    }

    /**
     *  f(r-2) = f(r-1)+g(r-2,r-1)*f(r)
     * @param str
     * @return
     */
    private static int GetTranslationCount(String str) {
        int len = str.length();
        int f1 = 0;
        int f2 = 1;
        int g = 0;
        int temp = 0;
        for (int i = len - 2; i >=0 ; i--) {
            int converted = Integer.parseInt(str.charAt(i) + "" + str.charAt(i + 1));
            if (converted >= 10 && converted < 26){
                g = 1;
            }else {
                g = 0;
            }
            temp = f2;
            f2 = f2 + g * f1;
            f1 = temp;
        }
        return f2;
    }

    public static void main(String[] args) {
        System.out.println(GetTranslationCount(12258));
    }
}
