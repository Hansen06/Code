package newcoder;

import java.util.Scanner;

public class Code_01_PalindromeString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String str = scanner.next();
            char[] arr = str.toCharArray();
            boolean flag = false;
            int last = arr.length - 1;
            for (int i = 0; i < arr.length/2; i++) {
                if (arr[i] != arr[last]){
                    flag = true;
                    System.out.println("No!");
                    break;
                }
                if (last > arr.length/2){
                    last--;
                }
            }
            if(flag == false){
                System.out.println("Yes!");
            }
        }
    }
}
