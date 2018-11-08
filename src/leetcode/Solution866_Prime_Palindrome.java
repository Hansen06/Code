package leetcode;

/**
 * https://leetcode.com/problems/prime-palindrome/description/
 */
public class Solution866_Prime_Palindrome {

    /**
     * 找到比N大的最小的奇数回文
     *
     * @param N
     * @return
     */
    public static int primePalindrome(int N) {
        if (8 <= N && N <= 11) {
            return 11;
        }
        for (int x = 1; x < 100000; x++) {
            String s = Integer.toString(x);
            String r = new StringBuilder(s).reverse().toString().substring(1);
            int y = Integer.parseInt(s + r);
            if (y >= N && isPrime(y)) {
                return y;
            }
        }
        return -1;
    }


    private static boolean isPrime(int x) {
        if (x < 2 || x % 2 == 0) {
            return x == 2;
        }
        for (int i = 3; i * i <= x; i += 2) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println(primePalindrome(n));
    }
}
