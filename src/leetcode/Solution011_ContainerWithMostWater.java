package leetcode;

/**
 * https://leetcode.com/problems/container-with-most-water/description/
 */
public class Solution011_ContainerWithMostWater {

    public static int maxArea(int[] height) {
        if (height == null){
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int max_area = 0;
        int cur = 0;
        while (left < right){
            cur = (right - left) * Math.min(height[left], height[right]);
            if (height[left] < height[right]){
                left++;
            }else {
                right--;
            }
            if(max_area < cur){
                max_area = cur;
            }
        }
        return max_area;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }
}
