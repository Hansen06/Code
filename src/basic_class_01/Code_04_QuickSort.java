package basic_class_01;

import java.util.Arrays;

public class Code_04_QuickSort {

	public static void quickSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		quickSort(arr, 0, arr.length - 1);
	}

	public static void quickSort(int[] arr, int l, int r) {
		if (l < r) {
			swap(arr, l + (int) (Math.random() * (r - l + 1)), r);//不是固定的以最后一个数作为划分值，而是随机的找一个数，叫做随机选择排序
			int[] p = partition(arr, l, r);
			quickSort(arr, l, p[0] - 1);//等于区的左部分
			quickSort(arr, p[1] + 1, r);//等于区的右部分
		}
	}


    public static int partition1(int[] arr, int L, int R) {
    	int p = arr[R];
    	int less = L - 1;//小于等于区右边界
    	for (int i = L; i <= R; i++ ) {
    		//如何当前值比划分值小，则和小于区的下一个数互换
    		if (arr[i] <= p) {
    			swap(arr, ++less, i);
    		}
    	}
//    	++less;
//    	swap(arr,less,R);
    	return less;
    }

	public static int[] partition(int[] arr, int l, int r) {
		int less = l - 1;
		int more = r;
		while (l < more) {
			if (arr[l] < arr[r]) {
				swap(arr, ++less, l++);
			} else if (arr[l] > arr[r]) {
				swap(arr, --more, l);
			} else {
				l++;
			}
		}
		swap(arr, more, r);
		return new int[] { less + 1, more };//返回等于区的第一个和最后一个位置
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {

		int[] test = {3,2,4,5,7,6};
		int index = partition1(test, 0,test.length-1);
		for (int i = 0; i < test.length; i++ ) {
			System.out.print(test[i] + " ");
		}
		System.out.println();
		System.out.println(index);

		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			quickSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		quickSort(arr);
		printArray(arr);

	}

}
