package LeetCode;

/**
 * 构建矩形满足：
 * 1.长大于款
 * 2.长宽的差距最小
 */
public class Solution003_constructRectangle {

    public static  int[] constructRectangle(int area) {

        int[] result = new int[2];
        if (area == 0){
            return result;
        }

        int a = (int)Math.sqrt(area);
        while (area % a != 0){
            a--;
        }

        int b = area/a;
        result[0] = b;
        result[1] = a;
        return result;
    }

    public static void main(String[] args) {
        int result[] = constructRectangle(6);
        System.out.println(result[0] + " " + result[1]);
    }

}
