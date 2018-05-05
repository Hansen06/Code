package Exercise;

import java.lang.reflect.Method;

public class Reflect2 {
    public static void main(String[] args) throws Exception{

        Class stuClass = Class.forName("Exercise.Student");//注意此字符串必须是真实路径，就是带包名的类路径，包名.类名

        System.out.println("***************获取所有的”公有“方法*******************");
        Method[] methods = stuClass.getMethods();
        for(Method m : methods){
            System.out.println(m);
        }


        System.out.println("=========================================================");
        Method method = stuClass.getMethod("show1",String.class);
        Method method1 = stuClass.getDeclaredMethod("show2");

        Object object = stuClass.getConstructor().newInstance();
        method.invoke(object,"kkkkkkkk");
        method1.invoke(object);
    }
}