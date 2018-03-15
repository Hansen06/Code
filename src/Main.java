import Offer.Solution001;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");
        int[] arr = {1,2,3,4};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println((-1/2));

        Random r = new Random();
        r.setSeed(1);
        System.out.println(r.nextInt(123));
        System.out.println(Math.ceil(2.5));

        int[][] arrray = {{1,2,5},{3,4,6},{7,8,9}};
        Solution001 solution001 = new Solution001();
        System.out.println(solution001.Find(4,arrray));
        System.out.println(solution001.Find(12,arrray));


        System.out.println("   " + Math.pow(2,3));
    }
}
