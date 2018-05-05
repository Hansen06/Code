package Design_Pattern;


//懒汉式单例类.在第一次调用的时候实例化自己
public class Singleton1 {
    private static Singleton1 single=null;
    private Singleton1() {}
    
    public static synchronized Singleton1 getInstance() {
        if (single == null) {
            single = new Singleton1();
        }
        return single;
    }
}
