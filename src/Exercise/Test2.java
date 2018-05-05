package Exercise;

public class Test2 {

    public static void main(String[] args) {

        final TestRun run = new TestRun();

        Thread thread = new Thread(run);
        Thread thread2 = new Thread(run);
        thread.start();
        thread2.start();

    }
}

class TestRun implements Runnable {

    public Integer i  ;
    public Object  lock ;

    TestRun(){
        i    = Integer.valueOf(0);
        lock = new Object();
    }


    @Override
    public void run() {
        synchronized (i) {
            i = Integer.valueOf(i.intValue() + 1);
            System.out.println((new StringBuilder("step1:")).append(i).toString());
            i = Integer.valueOf(i.intValue() + 1);
            System.out.println((new StringBuilder("step2:")).append(i).toString());  System.out.println("step1:" + i);

        }
    }
}