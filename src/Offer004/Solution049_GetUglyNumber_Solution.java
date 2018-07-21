package Offer004;

/**
 * 丑数
 */
public class Solution049_GetUglyNumber_Solution {

    public int GetUglyNumber_Solution(int index) {

        if (index <= 0){
            return 0;
        }
        int number = 0;
        int uglyNum = 0;
        while (uglyNum < index){
            ++number;
            if (IsUgly(number)){
                ++uglyNum;
            }
        }
        return number;
    }

    private boolean IsUgly(int number) {
        while (number % 2 == 0){
            number /= 2;
        }
        while (number % 3 == 0){
            number /= 3;
        }
        while (number % 5 == 0){
            number /= 5;
        }

        return (number == 1) ? true : false;
    }
}
