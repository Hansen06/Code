package Exercise;

import Online.Te;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test1 {

    static class Test{
        private int data;
        int result = 0;
        public void m(){
            result += 2;
            data += 2;
            System.out.print(result + " " + data);
        }
    }

    static class ThreadEx extends Thread{
        private Test mv;
        public ThreadEx(Test mv){
            this.mv = mv;

        }
        public void run(){
            synchronized (mv){
                mv.m();
            }
        }
    }

    public static void main(String[] args) {
        Test mv = new Test();
        Thread t1 = new ThreadEx(mv);
        Thread t2 = new ThreadEx(mv);
        Thread t3 = new ThreadEx(mv);
        t1.start();
        t2.start();
        t3.start();
    }

}

