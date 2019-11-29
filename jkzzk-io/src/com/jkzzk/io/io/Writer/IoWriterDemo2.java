package com.jkzzk.io.io.Writer;

import java.io.FileWriter;
import java.io.IOException;

/**
 *  flush方法和close方法的区别：
 *          abstract void flush() 刷新该流的缓冲
 *          abstract void close(） 关闭流，先刷新该流的缓冲区,在释放缓冲流
 */
public class IoWriterDemo2 {

    public static void main(String[] args) throws IOException {

        FileWriter fileWriter = new FileWriter("TestFile\\e.txt");

        fileWriter.write(97);
        fileWriter.flush();
        fileWriter.write(98);

        fileWriter.close();

        //流已经关闭，不能再次使用了
        fileWriter.write(98);// java.io.IOException: Stream closed

    }

}
