package x2018.tencent;

import java.util.Scanner;

/**
 *
 */
public class tencent03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int[] arr = new int[7];
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            arr[0] = A;
            arr[1] = B;
            arr[2] = C;
            arr[3] = A + B;
            arr[4] = A + C;
            arr[5] = B + C;
            arr[6] = A + B + C;
            for (int j = 0; j < 7; j++) {
                if (arr[i] % A == 0){
                    if (arr[i] % B == C){
                        System.out.println("YES");
                        break;
                    }
                }
            }
            System.out.println("NO");
        }
    }
}
