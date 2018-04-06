package Online;

import java.util.Scanner;

public class Tencent003 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNextInt()){
            int n = in.nextInt();
            int m = in.nextInt();

            if(n%(2*m) != 0){
                break;
            }

            int[] arr = new int[n+1];
            for (int i = 1; i <= n; i++) {
                arr[i] = -i;
            }

            int begin = m + 1;
            while(begin <= n){
                for (int i = 0; i < m; i++) {
                    arr[begin] = Math.abs(arr[begin]);
                    begin++;
                }
                begin = begin + m;
            }

            int sum = 0;
            for (int i = 1; i <= n; i++) {
                System.out.println(arr[i]);
                sum = sum + arr[i];
            }
            System.out.println(sum);
        }
    }
}
