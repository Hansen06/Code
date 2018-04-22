package Offer;

public class Solution022_Add {

    public static int Add(int num1, int num2)
    {
        while (num2 != 0){
           int temp = num1^num2;
           num2 = (num1&num2) << 1;
           num1 = temp;
        }
        return num1;
    }


    public static int minus(int first,int second)//first为减数， second为被减数
    {
        int sum = first ^ second;
        int carry = (sum & second) << 1;
        while(carry != 0){
            sum = sum ^ carry;
            carry = (sum & carry) << 1;
        }
        return sum;
    }

    public static void main(String[] args) {

        System.out.println(Add(2,3));
        System.out.println(minus(4,3));
    }
}
