package Offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * F(n) = F(n-1) + F(n-2) + ... + F(!)
 * F(n-1) = F(n-2) + ... + F(1)
 * 两式相减F(n) = 2F(n-1)
 */
public class Solution004_JumpFloorII {

    public static int JumpFloorII(int target) {
        if(target == 0){
            return 0;
        }
        if(target == 1){
            return 1;
        }else {
            return 2*JumpFloorII(target - 1);
        }
    }

    public static void main(String[] args) {

        System.out.println(JumpFloorII(5));
    }

}
