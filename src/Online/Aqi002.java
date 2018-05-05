package Online;

import java.util.Arrays;
import java.util.Scanner;

public class Aqi002 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int[] arr = new int[3];
            int count = 0;

            for (int i = 0; i < 3; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);
            if((arr[1]-arr[0])%2 == 0){
                count += ((arr[1]-arr[0])/2);
                count += (arr[2] - arr[1]);
            }else {
                count += 1;
                arr[2] = arr[2] + 1;
                arr[1] = arr[1] + 1;
                count += ((arr[1]-arr[0])/2);
                count += (arr[2] - arr[1]);
            }
            System.out.println(count);
        }
    }
}
