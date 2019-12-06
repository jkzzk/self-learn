package com.jkzzk.junit;

import java.util.Calendar;

/**
 *      测试分类：
 *          1.黑盒测试：不需要编写代码，直接点点点，测试其运行是否得到预期效果
 *          2.白盒测试：需要编写一定量的代码进行测试，不仅测试其运行是否得到预期效果，还可以测试其性能与效率
 *      Junit单元测试（白盒测试）
 *          1.定义一个测试类(测试用例)
 *              类型可以叫被测试类+Test
 *              包左可以叫test
 *          2.定义测试方法：可以独立运行
 *              方法名：test + 被测试方法名
 *              返回值：void，没有返回值
 *              参数列表：建议空参
 *          3.给方法给加上@Test注解，使方法可以独立运行
 *          4.导入Junit依赖
 *          5.断言：
 *              在测试方法中，一般不会输出，以为输出有时，并不能说明是否程序有问题
 *            Assert类，中有很多静态方法，可以判断我们的预期值与输出值是否相同
 *
 *      注解：
 *          1.@Before
 *              在所有测试方法执行前，都会执行一遍
 *          2.@After
 *              在所有测试方法执行后，都会执行一遍
 *
 */
public class JunitDemo1 {

    //传统测试方法
    public static void main(String[] args) {
        Calculate calculate = new Calculate();

        int add = calculate.add(1, 2);
        System.out.println(add);

        int sub = calculate.sub(1, 2);
        System.out.println(sub);
    }

}
