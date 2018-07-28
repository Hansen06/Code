package utils;

import utils.Array_To_Stack_Queue.ArrayStack;

public class test {

    public static void main(String[] args) {
        int size = 15;
        ArrayStack stack;
        stack = new ArrayStack(size);

        stack.push(1);
        stack.push(2);

        while (stack.getSize() > 0){
            System.out.print(stack.pop() + " ");
        }

        for (int i = 0; i < size; i++) {
            int tmp = stack.pop();
            if(tmp != -1){
                System.out.println(tmp);
            }else {
                break;
            }

        }
    }
}
