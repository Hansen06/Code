package Online;

import java.util.Scanner;

public class Tencent001 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        int[] x = new int[t];
        int[] y = new int[t];

        for (int i = 0; i < t; i++) {
            for (int j = 0; j < 4; j++) {
                x[j] = sc.nextInt();
            }
            for (int j = 0; j < 4; j++) {
                y[j] = sc.nextInt();
            }

            int a = (x[0]-x[1])*(x[0]-x[1]) + (y[0]-y[1])*(y[0]-y[1]);
            int b = (x[0]-x[2])*(x[0]-x[2]) + (y[0]-y[2])*(y[0]-y[2]);
            int c = (x[1]-x[2])*(x[1]-x[2]) + (y[1]-y[2])*(y[1]-y[2]);


            if(a+b == c){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }

    }

}
