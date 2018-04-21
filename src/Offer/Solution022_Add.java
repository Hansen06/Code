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

    public static void main(String[] args) {

        System.out.println(Add(2,3));
    }
}
