package com.jkzzk.test;

import com.jkzzk.junit.Calculate;
import org.junit.Assert;
import org.junit.Test;

/**
 *  测试Calculat类
 */
public class CalculateTest {

    @Test
    public void testAdd() {
        Calculate calculate = new Calculate();

        int add = calculate.add(1, 2);

//        System.out.println(add);
        Assert.assertEquals(3,add);
    }
}
