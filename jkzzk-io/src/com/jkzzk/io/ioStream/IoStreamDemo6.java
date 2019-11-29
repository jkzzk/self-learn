package com.jkzzk.io.ioStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *  复制文件
 */
public class IoStreamDemo6 {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Administrator\\Desktop\\problem\\party\\kaoshibg.png");
        FileOutputStream fileOutputStream = new FileOutputStream("TestFile\\kaoshibg.png");

/*        int len = 0;
        while((len = fileInputStream.read()) != -1) {
            System.out.println(len);
            fileOutputStream.write(len);
        }*/

        long start = System.currentTimeMillis();
        //使用数组缓冲
        byte[] bytes = new byte[102400];
        int len = 0;
        while((len = fileInputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes,0,len);
        }
        long end = System.currentTimeMillis();

        fileOutputStream.close();
        fileInputStream.close();



        System.out.println(end - start);
    }

}
