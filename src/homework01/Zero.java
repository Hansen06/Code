package homework01;

public class Zero {

    public static long Factorial(int num){

        if(num == 0){
            return num;
        }

        long result = 1;
        for (int i = 1; i <= num; i++) {
            result = result*i;
        }
        return result;
    }

    public static int zeroNum(int num){

        int zero_num = 0;

        return zero_num;
    }

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();   //获取开始时间

        for (int i = 0; i < 1000; i++) {
            System.out.println("[" + i + "]" + " " + Factorial(i));
        }

        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");

    }
}
