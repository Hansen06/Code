package Offer003;

/**
 * 整数中1出现的次数（从1到n整数中1出现的次数）
 */
public class Solution043_NumberOf1Between1AndN_Solution {

    public static int NumberOf1Between1AndN_Solution(int n) {
        if (n == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;
            while (num > 0) {
                if (num % 10 == 1) {
                    sum++;
                }
                num = num / 10;
            }
        }
        return sum;
    }

    public static int NumberOf1Between1AndN_Solution1(int n) {

        int count = 0;
        int  i = 1;
        for (i = 1; i <= n; i *= 10) {
            //i表示当前分析的是哪一个数位
            int a = (int) (n / i);
            int b = (int) (n % i);
            count = count + (a + 8) / 10 * i + (a % 10 == 1 ? 1 : 0) * (b + 1);
        }
        return count;
    }

    public static int NumberOf1Between1AndN_Solution2(int n) {
        if (n <= 0){
            return 0;
        }

        char[] ch = String.valueOf(n).toCharArray();
        return NumberOf1(ch, n);
    }

    private static int NumberOf1(char[] ch ,int num) {
        if (ch == null || ch[0] > '9' || ch[0] < '0'){
            return 0;
        }
        int first = ch[0] - '0';
        int len = ch.length;
        if (len == 1 && first == 0){
            return 0;
        }

        if (len == 1 && first > 0){
            return 1;
        }

        int numFist = 0;
        if (first > 1){
            numFist = (int) Math.pow(10, len - 1);
        }else if(first == 1){
            numFist = num - (int)Math.pow(10, len - 1) + 1;
        }

        int numOther = first * (len - 1) * (int)Math.pow(10, len - 2);
        int nextNum = num - (ch[0] - '0') * (int)Math.pow(10, len - 1);
        int numRec = NumberOf1(String.valueOf(nextNum).toCharArray() , nextNum);
        return numFist + numOther + numRec;
    }


    public static void main(String[] args) {
        int sum = NumberOf1Between1AndN_Solution1(35);

        System.out.println(sum);

        System.out.println(NumberOf1Between1AndN_Solution(345));
        System.out.println(NumberOf1Between1AndN_Solution2(345));
        System.out.println(NumberOf1Between1AndN_Solution(245));
        System.out.println(NumberOf1Between1AndN_Solution2(245));
        System.out.println(NumberOf1Between1AndN_Solution(135));
        System.out.println(NumberOf1Between1AndN_Solution2(135));

    }
}
