package Offer004;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 */
public class Solution031_IsPopOrder {

    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length != popA.length || pushA.length == 0 || popA.length == 0){
            return false;
        }

        int popIndex = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[popIndex]){
                stack.pop();
                popIndex++;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,5,3,2,1};
        System.out.println(IsPopOrder(pushA,popA));
    }
}
