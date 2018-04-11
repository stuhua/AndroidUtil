package reflect;

import java.lang.reflect.Field;

/**
 * Created by liulh on 2018/4/11.
 */

public class ReflectTest {
    //获取类：3种方法

    /**
     * 使用反射获取类的方法1
     */
    public static void getClassMethod1() {
        try {
            Class<?> class1 = Class.forName("java.lang.String");
            System.out.println(class1);
            //取得本类的全部属性
            Field[] field = class1.getDeclaredFields();
            for (Field field2 : field) {
                System.out.println( field2 );
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用反射获取类的方法2
     */
    public static void getClassMethod2() {
        Class<?> class1 = String.class;
        System.out.println(class1);

    }

    /**
     * 使用反射获取类的方法3
     */
    public static void getClassMethod3() {
        String str = new String();
        Class<?> class1 = str.getClass();
        System.out.println(class1);
    }
}
