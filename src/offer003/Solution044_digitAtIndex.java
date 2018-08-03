package offer003;

/**
 * 数字序列中某一位的数字
 */
public class Solution044_digitAtIndex {

    public static int digitAtIndex(int index){
        if (index < 0){
            return -1;
        }
        int digits = 1;
        while (true){
            int number = countOfIngegers(digits);
            if (index < number * digits){
                return digitAtIndex(index, digits);
            }
            index -= digits * number;
            digits++;
        }
    }

    /**
     * 找出数字  如 811 = 270 * 3 +1
     * @param index
     * @param digits
     * @return
     */
    private static int digitAtIndex(int index, int digits) {
        int num = 0;
        if (digits == 1){
            num = 0 + index/digits;
        }else{
            num = (int)Math.pow(10, digits - 1) + index/digits; // Math.pow(10, digits - 1) 求第一个digits位的数字
        }
        int indexFromRight = digits - index % digits;
        for (int i = 1; i < indexFromRight; i++) {
            num /= 10;
        }
        return num % 10;
    }

    /**
     * 计算m位数字共有多少个  如两位 返回10~99 = 90个
     * @param digits
     * @return
     */
    private static int countOfIngegers(int digits) {
        if (digits == 1){
            return 10;
        }
        int count = 9 * (int)Math.pow(10, digits - 1);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(digitAtIndex(5));
        System.out.println(digitAtIndex(13));
        System.out.println(digitAtIndex(1001));
    }
}
