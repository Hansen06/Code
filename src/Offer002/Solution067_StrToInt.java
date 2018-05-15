package Offer002;

/**
 * 把字符串转换成整数
 */
public class Solution067_StrToInt {

    public static int StrToInt(String str) {
        Integer result = 0;
        if (str == null || str.length() < 1) {
            return result;
        }

        char[] arr = str.toCharArray();
        if (arr[0] == '+') {
            arr[0] = '0';
            result = StrToIntCore(arr, 1);
        } else if (arr[0] == '-') {
            arr[0] = '0';
            result = StrToIntCore(arr, -1);
        }else{
            result = StrToIntCore(arr,1);
        }
        return result;
    }

    private static int StrToIntCore(char[] arr, int sign) {
        int num = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= '0' && arr[i] <= '9') {
                num = num * 10 + (arr[i] - '0');
                if (num > 0x7fffffff || num < 0x80000000){
                    num = 0;
                    break;
                }
            } else {
                num = 0;
                break;
            }
        }
        return sign * num ;
    }

    public static void main(String[] args) {

        String str = "-123";
        System.out.println(StrToInt(str));
        System.out.println(StrToInt("+2444433333333333333333331111111111111111111111111"));
        System.out.println(StrToInt(""));
    }
}
