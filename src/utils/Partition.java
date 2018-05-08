package utils;

public class Partition {

    public static int Partition(int[] data, int start, int end){

        int index = start + (int)(Math.random() * (end - start + 1));//随机选取一个数作为对比数
        swap(data, index, end);
        int p = data[end];
        int less = start - 1;
        for ( index = start; index < end; index++){
            if (data[index] < data[end]){
                ++less;
                if (less != index){
                    swap(data, index, less);
                }
            }
        }
        ++less;
        swap(data, less, end);
        return less;
    }

    public static int Partition2(int[] data, int start, int end){

        int p = data[end];
        int less = start - 1;
        for ( int i = start; i < end; i++){
            if (data[i] <= data[end]){
                ++less;
                if (less != i){
                    swap(data, i, less);
                }
            }
        }
        ++less;
        swap(data, less, end);
        return less;
    }

    public static int Partition1(int[] data, int start, int end){

        int p = data[end];
        int less = start - 1;
        for ( int i = start; i < end; i++){
            if (data[i] <= p ) {
                swap(data, ++less, i);
            }
        }
        ++less;
        swap(data, less, end);
        return less;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int a = 4;
        int b = 9;
        for (int i = 0; i < 5; i++) {
            System.out.println(a + (int)(Math.random() * (b - a + 1)));
        }

    }
}
