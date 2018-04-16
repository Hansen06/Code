package newcoder;

import java.util.Scanner;

public class Code_01_PalindromeNumber {

    public static boolean isPalindrome(int x) {

        if (x < 0){
            return false;
        }

        int temp = 0;
        int _x = 0;
        temp = x;
        while (temp != 0){
            _x = _x * 10 + temp % 10;
            temp /= 10;
        }
        if (x == _x){
            return true;
        }else {
            return false;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()){
            Integer num = scanner.nextInt();
            boolean result = isPalindrome(num);
            if (result){
                System.out.println("Yes!");
            }else{
                System.out.println("No!");
            }

        }
    }
}
