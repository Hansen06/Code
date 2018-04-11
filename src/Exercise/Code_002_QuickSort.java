package Exercise;

public class Code_002_QuickSort {


    public static int partition(int[] arr, int low, int high){
        if (low >= high){
            return 0;
        }
        int key = arr[low];
        while (low < high){
            while (low < high && arr[high] >= key){
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] < key){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = key;
        return low;
    }

    public static int partition1(int[] arr, int low, int high){
        int p = arr[high];
        int less = low - 1;
        for (int i = low; i <= high; i++) {
            if(arr[i] <= p){
                swap(arr, ++less, i);
            }
        }
        return less;
    }


    public static int[] partition2(int[] arr, int low, int high){
        int less = low - 1;
        int more = high;
        while (low < more){
            if (arr[low] < arr[high]){
                swap(arr, ++less, low++);
            }else if (arr[low] > arr[high]){
                swap(arr, --more, low);
            }else{
                low++;
            }
        }
        swap(arr, more, high);
        return new int[]{less+1, more};
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort(int[] arr, int low, int high){
        if (low < high){
            int p[] = partition2(arr, low, high);
            quickSort(arr,low, p[0]-1);
            quickSort(arr, p[1] + 1, high);
        }
    }

    public static void quickSort(int[] arr){
        if (arr == null || arr.length < 2){
            return ;
        }
        quickSort(arr, 0, arr.length-1);
    }

    public static void main(String[] args) {
        int[] arr = {1,10,4,6,7,0};
        quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
