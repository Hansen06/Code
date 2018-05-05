package thread;

public class Synchronized {

    private static int i = 0;
    public static void main(String[] args) {
//        for (int j = 0; j < 10; j++) {
//            // 进行自加的操作
//            synchronized (SynchronizedTest.class) {
//                System.out.println( i++);
//            }
//        }

        TestRun run = new TestRun();

        Thread thread = new Thread(run);
        Thread thread2 = new Thread(run);
        thread.start();
        thread2.start();
    }
}
class TestRun implements Runnable {

    public Integer i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 5; j++) {
            synchronized (Synchronized.class) {
                System.out.println(i++);
            }
        }
    }
}