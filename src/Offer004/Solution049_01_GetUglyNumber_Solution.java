package Offer004;

/**
 * 丑数
 */
public class Solution049_01_GetUglyNumber_Solution {

    public int GetUglyNumber_Solution(int index) {

        if (index <= 0){
            return 0;
        }

        int[] uglyNum = new int[index];
        uglyNum[0] = 1;
        int nextUglyIndex = 1;
        int uglyNum2 = 0;
        int uglyNum3 = 0;
        int uglyNum5 = 0;

        while (nextUglyIndex < index){
            uglyNum[nextUglyIndex] = min(uglyNum[uglyNum2] * 2, uglyNum[uglyNum3] * 3, uglyNum[uglyNum5] * 5);

            while (uglyNum[uglyNum2] * 2 <= uglyNum[nextUglyIndex]){
                ++uglyNum2;
            }
            while (uglyNum[uglyNum3] * 3 <= uglyNum[nextUglyIndex]){
                ++uglyNum3;
            }
            while (uglyNum[uglyNum5] * 5 <= uglyNum[nextUglyIndex]){
                ++uglyNum5;
            }
            ++nextUglyIndex;
        }
        int ugly = uglyNum[nextUglyIndex - 1];
        return ugly;
    }

    private int min(int number1, int number2, int number3) {
        int min = (number1 < number2) ? number1 : number2;
        min = (min < number3) ? min : number3;
        return min;
    }
}
