package com.jkzzk.Exception.Demo4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 要求：模拟注册操作，如果用户已经存在，则抛出异常，提醒用户
 * 步骤：
 *          1.用数组保存用户注册信息
 *          2.使用Scanner类获取用户注册信息
 *          3.定义方法，遍历数组，查找用户注册信息是否已存在
 * @author Jkzzk
 */
public class ExceptionDemo1CustomException {

    public static void main(String[] args) {

        List<String> userNameList = new ArrayList<>();

        String next = null;

        while(!"exit".equals(next)) {
            Scanner scan  = new Scanner(System.in);
            next = scan.next();
//            System.out.println(next);

            int var = 0;
            try {
                var = detectionRepeat(userNameList,next);
            } catch (CustomException e) {
                System.out.println(e.getMessage());
                var = -1;
            }

            if(var == 0) {
                userNameList.add(next);
            }
        }
    }

    public static int detectionRepeat(List<String> userNameList,String next) throws CustomException {

        for (String s : userNameList) {
            System.out.print(s + "\t");
            if(s.equals(next)) {
                System.out.println();
                throw new CustomException("用户名已存在");
            }
        }
        System.out.println();
        return 0;
    }

}
