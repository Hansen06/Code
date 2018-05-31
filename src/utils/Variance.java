package utils;

public class Variance {

    public static double[] getVariance(int[][] arr){
        if (arr == null || arr.length < 1){
            return null;
        }
        int rows = arr.length;
        int cols = arr[0].length;
        double[] sum = new double[cols];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                sum[i] += arr[j][i];
            }
        }
        double[] variance = new double[cols];
        for (int i = 0; i < cols; i++) {
            double average = sum[i]/rows;
            for (int k = 0; k < rows; k++) {
                variance[i] += Math.pow((arr[k][i] - average), 2);
            }
            variance[i] = Math.sqrt(variance[i]);
        }
        return variance;
    }

    public static void main(String[] args) {
//        int[][] arr = {{2,3},{5,4},{9,6},{4,7},{8,1},{7,2}};
        int[][] arr1 = {{2,3},{5,4},{4,7}};
        int[][] arr2 = {{9,6},{8,1}};
        double[] result1 = getVariance(arr1);
        double[] result2 = getVariance(arr2);
        for (int i = 0; i < result1.length; i++) {
            System.out.println(result1[i]);
        }
        for (int i = 0; i < result2.length; i++) {
            System.out.println(result2[i]);
        }
    }
}
