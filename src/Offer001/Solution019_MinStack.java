package Offer001;

import java.util.Stack;

public class Solution019_MinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> stackMin = new Stack<>();

    public void push(int node) {
        if (stackMin.isEmpty()) {
            stackMin.push(node);
        } else if (node < min()) {
            stackMin.push(node);
        }else {
            int min = stackMin.peek();
            stackMin.push(min);
        }
        stack.push(node);
    }

    public void pop() {
        stack.pop();
        stackMin.pop();
    }

    public void push1(int node) {
        if (stackMin.isEmpty()) {
            stackMin.push(node);
        } else if (node <= min()) {
            stackMin.push(node);
        }
        stack.push(node);
    }

    public void pop1() {
        int value = stack.pop();
        if (value == stackMin.pop()){
            stackMin.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return stackMin.peek();
    }

    public static void main(String[] args) {

    }
}
