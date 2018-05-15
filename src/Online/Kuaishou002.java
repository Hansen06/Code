package Online;

import java.util.Scanner;

public class Kuaishou002 {

    public static void main(String[] args) {

        int[] arr = {1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192};

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if ((num & num - 1) == 0){
                System.out.println("lucky");
            }else {
                for (int j = 0; j < arr.length; j++) {
                    if (num - arr[j] < 0) {
                        num = num - arr[j - 1];
                        break;
                    }
                }
                if (num == 3){
                    System.out.println("lucky");
                    break;
                }
                for (int j = 0; j < arr.length; j++) {
                    if (num - arr[j] < 0) {
                        num = num - arr[j - 1];
                        break;
                    }
                }
                if (num > 0 && num != 3){
                    System.out.println("lucky");
                }else{
                    System.out.println("don't be discouraged");
                }
//                if ((num & num - 1) == 0) {
//                    System.out.println("lucky");
//                } else {
//                    System.out.println("don't be discouraged");
//                }
            }
        }
    }
}
