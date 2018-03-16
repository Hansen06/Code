package Offer;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，
 * 总共有多少种方法？
 */
public class Solution006 {

    public static int RectCover(int target) {

        if(target <= 2){
            return target;
        }

        int f_1 = 2;
        int f_2 = 1;
        int result = 0;
        for (int i = 2; i < target; i++){
            result = f_1 + f_2;
            f_2 = f_1;
            f_1 = result;
        }
        return result;
    }

    public static int RectCover1(int target) {

        if(target <= 2){
            return target;
        }else{
            return RectCover1(target - 1) + RectCover1(target - 2);
        }

    }

    public static void main(String[] args) {

        System.out.println(RectCover(4));
        System.out.println(RectCover1(4));
    }
}
