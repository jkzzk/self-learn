package com.jkzzk.io.Buffer.stream;

import java.io.*;

/**
 *      使用字节缓冲流来复制文件
 */
public class IoBufferDemo3 {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Administrator\\Desktop\\problem\\party\\kaoshibg.png");
        FileOutputStream fileOutputStream = new FileOutputStream("TestFile\\kaoshibg.png");

        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        long start = System.currentTimeMillis();

        //使用数组缓冲
        byte[] bytes = new byte[1024];
        int len = 0;
        while((len = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes,0,len);
        }
        long end = System.currentTimeMillis();

        bufferedOutputStream.close();
        bufferedInputStream.close();


        System.out.println(end - start);
    }

}
