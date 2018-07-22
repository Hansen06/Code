package Offer004;

/**
 * 孩子们的游戏(圆圈中最后剩下的数)
 */
public class Solution062_LastRemaining_Solution {

    public static int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1){
            return -1;
        }
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = 0;
        }
        int position = -1; //当前循环位置
        int step = 0;
        int count = n;
        while (count > 0){
            position++;
            if (position >= n){
                position = 0;
            }
            if (list[position] == -1){
                continue;
            }
            step++;
            if (step == m){
                list[position] = -1;
                step = 0;
                count--;
            }
        }
        return position;
    }

    public static int LastRemaining_Solution1(int n, int m) {
        if (n < 1 || m < 1){
            return -1;
        }
        return (LastRemaining_Solution1(n-1, m) + m) % n;
    }

    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(5,3));
        System.out.println(-2 % 3);
    }

}
