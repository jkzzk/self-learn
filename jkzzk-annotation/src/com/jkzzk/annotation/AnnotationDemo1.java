package com.jkzzk.annotation;

/**
 *  注解：
 *      概念：说明程序的，给计算机看的
 *      定义：
 *          JDK1.5之后的新特性
 *          说明程序的
 *          使用注解：@注解名称
 *      功能：
 *          1.生成文档
 *          2.代码分析
 *          3.编译检查
 *
 *      JDK内置注解：
 *          1.@Override ： 检测方法是否为重写父类方法
 *          2.@Deprecated ： 已过时标记
 *          3.@SuppressWarnings ： 压制警告
 *              一般传入参数 all @SuppressWarnings("all")
 *
 *      自定义注解：
 *          格式：
 *              元注解
 *              public @interface 注解名称{ ... }
 *
 *          本质：就是一个接口，继承了 Annotation接口
 *              public interface 注解名称 extends java.lang annotation.Annotation  {}
 *
 *          属性：抽象方法
 *              1.属性的返回值类型
 *                  (1).基本数据类型
 *                  (2).字符串
 *                  (3).枚举
 *                  (4).注解类型
 *                  (5).以上类型的数组
 *              2.在使用时，需要赋值
 *              3.可以赋默认值  在方法后加入 default 默认值
 *              4.如果属性只有一个，且名称为value，则赋值是属性名可以省略
 *              6.数组赋值，需要大括号包裹，如果数组中只有一个值，可以省略大括号
 *
 *          元注解: 描述注解的注解，JKD已经定义好了
 *              1.@Target：描述注解能够作用到位置
 *                  TYPE：可以作用于类上
 *                  METHOD：可以作用于方法上
 *                  FIELD：可以作用于字段上
 *              2.@Retention：描述注解能够保留到的阶段
 *                  SOURCE：编译阶段
 *                  CLASS：类加载阶段
 *                  RUNTIME：运行时阶段 (自定义注解，一般会使用这个值，因为轻易不会操作比编译器)
 *              3.@Documented：描述注解是否被抽取到JavaDOC中
 *              4.@Inherited：描述注解是否被子类继承
 */
@SuppressWarnings("all")
public class AnnotationDemo1 {

    public static void main(String[] args) {



    }

    @MyAnnotation(age = 20)
    public void show01() {

    }

}
