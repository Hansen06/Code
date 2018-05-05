package Exercise;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Struct;

public class Reflect1 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, NoSuchFieldException {


        Class stuClass = Class.forName("Exercise.Student");//注意此字符串必须是真实路径，就是带包名的类路径，包名.类名
        System.out.println(stuClass);//判断三种方式是否获取的是同一个Class对象

        Constructor constructor = stuClass.getConstructor(String.class,int.class);
        Object object = constructor.newInstance("张三", 126);

        //2.获取字段
        System.out.println("************获取所有公有的字段********************");
        Field[] fieldArray = stuClass.getDeclaredFields();
        for(Field f : fieldArray){
            System.out.println(f);
        }

        System.out.println("===================================================");
        Field f = stuClass.getField("name");
        System.out.println(f);
        f.set(object,"李四");
        Student student = (Student)object;
        System.out.println(student.name);

    }
}