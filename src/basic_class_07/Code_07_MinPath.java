package basic_class_07;

import java.util.HashMap;
import java.util.Map;

public class Code_07_MinPath {

    public static int minPath(int[][] matrx) {
        return process(matrx, 0, 0);
    }

    private static int process(int[][] matrx, int i, int j) {

        //base case 结束条件，到达最后一个位置
        if (i == matrx.length - 1 && j == matrx[0].length - 1) {
            return matrx[i][j];
        }

        //到达最后一行
        if (i == matrx.length - 1) {
            return matrx[i][j] + process(matrx, i, j + 1);//只能往左走
        }
        //到达最后一列
        if (j == matrx[0].length - 1) {
            return matrx[i][j] + process(matrx, i + 1, j);//只能往下走
        }
        return matrx[i][j] + Math.min(process(matrx, i, j + 1), process(matrx, i + 1, j));//选择(i+1,j)和(i,j+1)中最小的那个-
    }

    static HashMap<String, Integer> cache = new HashMap<>();

    private static int process2(int[][] matrx, int i, int j) {

        int result = 0;
        if (i == matrx.length - 1 && j == matrx[0].length - 1) {
            result = matrx[i][j];
        } else if (i == matrx.length - 1) {
            int next = 0;
            String nextKey = String.valueOf(i) + "_" + String.valueOf(j + 1);
            if(cache.containsKey(nextKey)){
                next = cache.get(nextKey);
            }else{
                next = process(matrx, i, j+1);
            }
            result = matrx[i][j] + next;
        } else if (j == matrx[0].length - 1) {
            int next = 0;
            String nextKey = String.valueOf(i+1) + "_" + String.valueOf(j);
            if (cache.containsKey(nextKey)){
                next = cache.get(nextKey);
            }else{
                next = process(matrx, i+1, j);
            }
            result = matrx[i][j] + next;
        } else {
            int down = 0;
            int right = 0;
            String downKey = String.valueOf(i) + "_" + String.valueOf(j+1);
            if (cache.containsKey(downKey)){
                down = cache.get(downKey);
            }else {
                down = process(matrx, i, j + 1);
            }
            String rightKey = String.valueOf(i+1) + "_" + String.valueOf(j);
            if (cache.containsKey(rightKey)){
                right = cache.get(rightKey);
            }else {
                right = process(matrx, i + 1, j);
            }
            result = matrx[i][j] + Math.min(down, right);
        }
        String key = String.valueOf(i) + "_" + String.valueOf(j);
        cache.put(key, result);
        return result;
    }

    public static void main(String[] args) {
        int[][] martix = {{1,3,2},{0,4,3},{1,2,3}};
        System.out.println(minPath(martix));
    }

}
