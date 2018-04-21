package Online;

import java.util.Scanner;

public class Meituan002 {

    public static int gcd(int a,int b)
    {
        int temp;
        while(b != 0)
        {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();

        int[] arr = new int[N];
        arr[0] = p;
        for (int i = 1; i < N; i++) {
            arr[i] = (arr[i-1] + 153)%p;
        }

        int result = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                result += arr[gcd(i,j)-1];
            }
        }
        System.out.println(result);
    }
}
