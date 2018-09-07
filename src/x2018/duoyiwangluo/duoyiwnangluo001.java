package x2018.duoyiwangluo;

import java.util.Scanner;

public class duoyiwnangluo001 {


    public static void printRandM(int[] array, int n){

        if(array == null || array.length == 0 || n < 0){
            return;
        }

        n = Math.min(array.length, n);
        int count = 0;
        int i = 0;
        while(count < n){
            i = (int)(Math.random() * (array.length - count));
            System.out.println(array[i]);
            swap(array,array.length - (count++) - 1, i);
        }
    }

    public static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = i;
        }
        printRandM(arr, n);
    }
}
