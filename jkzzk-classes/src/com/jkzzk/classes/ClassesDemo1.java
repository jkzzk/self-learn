package com.jkzzk.classes;

/**
 *     反射： 框架设计的灵魂
 *          将类的各个组成部分，封装为其他的对象，这就是反射
 *          好处：
 *              可以在程序运行的过程中，可以操作对象
 *              可以解耦，提高程序的可扩展性
 *          缺点：
 *              效率低下，除非必须用到反射，不然不要乱用
 *     框架：半成品软件，可以应用其进行二次开发，加快开发进程
 *
 *     Class 对象
 *          获取方式：
 *              1.Class.forName("全类名");  通过将字节码文件加载进内存获取Class对象
 *                  多用于配置文件中
 *              2.类名.class;    通过类名的属性class获取Class对象
 *                  多用于参数的传递
 *              3.对象.getClass();  getClass方法在Object类中定义着
 *                  多用于对象获取字节码
 *          结论：
 *              同一个字节码文件，在同一个程序内，只会被加载一遍
 *
 *          功能方法：
 *              获取功能：
 *                  1.获取成员变量
 *                      Field getField(String name) 返回一个 Field对象，它反映此表示的类或接口的指定公共成员字段
 *                          注意是获取所有public修饰的变量
 *                      Field[] getFields() 返回包含一个数组 Field对象反射由此表示的类或接口的所有可访问的公共字段
 *                          获取指定名称的被public修饰的变量
 *
 *                      Field getDeclaredField(String name) 返回一个 Field对象，它反映此表示的类或接口的指定已声明字段
 *                      Field[] getDeclaredFields() 返回的数组 Field对象反映此表示的类或接口声明的所有字段
 *
 *                      Field类
 *                          设置值
 *                              Object get(Object obj) 返回该所表示的字段的值 Field ，指定的对象上
 *                          获取值
 *                              void set(Object obj, Object value) 将指定对象参数上的此 Field对象表示的字段设置为指定的新值
 *                          注意：
 *                              1.在设置和访问有权限修饰符的成员变量时，要忽略其访问权限
 *                                  使用public void setAccessible(boolean flag)方法忽略其权限安全检查
 *                  2.获取构造方法
 *                      Constructor<T> getConstructor(类<?>... parameterTypes)
 *                          返回一个 Constructor对象，该对象反映 Constructor对象表示的类的指定的公共类函数
 *                      Constructor<?>[] getConstructors()
 *                          返回包含一个数组 Constructor对象反射由此表示的类的所有公共构造
 *
 *                      Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
 *                          返回一个 Constructor对象，该对象反映 Constructor对象表示的类或接口的指定类函数
 *                      Constructor<?>[] getDeclaredConstructors()
 *                          返回一个反映 Constructor对象表示的类声明的所有 Constructor对象的数组类
 *
 *
 *                      Constructor类：
 *                          构造对象方法：
 *                              public T newInstance(Object ... initargs)
 *                              还可以使用Class对象中的方法
 *                              T newInstance() 创建由此 类对象 表示的类的新实例
 *                          可以操作其他权限的构造方法，但是也需要忽略权限安全检查
 *                  3.获取成员方法
 *                      Method getMethod(String name, 类<?>... parameterTypes)
 *                          返回一个 方法对象，它反映此表示的类或接口的指定公共成员方法
 *                      Method[] getMethods()
 *                          返回包含一个数组 方法对象反射由此表示的类或接口的所有公共方法，
 *                          包括那些由类或接口和那些从超类和超接口继承的声名
 *
 *                      Method getDeclaredMethod(String name, 类<?>... parameterTypes)
 *                          返回一个 方法对象，它反映此表示的类或接口的指定声明的方法
 *                      Method[] getDeclaredMethods()
 *                          返回包含一个数组 方法对象反射的类或接口的所有声明的方法，
 *                          通过此表示 类对象，包括公共，保护，默认（包）访问和私有方法，但不包括继承的方法
 *
 *                      Method类
 *                          可以操作其他权限的成员方法，但是也需要忽略权限安全检查，同上
 *                          执行方法：
 *                              Object invoke(Object obj, Object... args） 在具有指定参数的 方法对象上调用此 方法对象表示的底层方法
 *                  4.获取类名
 *                      String getName() 返回由类对象表示的实体（类，接口，数组类，原始类型或空白）的名称
 *                          此处返回类的全类名
 *                  *5.获取泛型
 *                  *6.获取注解
 */
public class ClassesDemo1 {

    public static void main(String[] args) throws ClassNotFoundException {

        //1.Class.forName("全类名");
        Class cls1 = Class.forName("com.jkzzk.classes.Person");
        System.out.println(cls1);

        //2.类名.class; 
        Class cls2 = Person.class;
        System.out.println(cls2);

        //3.对象.getClass()
        Person person = new Person();
        Class cls3 = person.getClass();
        System.out.println(cls3);


        System.out.println(cls1 == cls2);// true
        System.out.println(cls2 == cls3);// true
        System.out.println(cls1 == cls3);// true
    }
}
