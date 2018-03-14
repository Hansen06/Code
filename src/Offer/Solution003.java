package Offer;

public class Solution003 {

    public static int JumpFloor(int target) {
        if(target == 0){
            return 0;
        }
        if(target == 1){
            return 1;
        }else{
            int result = 0;
            int f_1 = 1;
            int f_2 = 0;
            for (int i = 1; i <= target ; i++) {
                result = f_1 + f_2;
                f_2 = f_1;
                f_1 = result;
            }
            return result;
        }

    }

    public static void main(String[] args) {
        System.out.println(JumpFloor(3));
    }
}
