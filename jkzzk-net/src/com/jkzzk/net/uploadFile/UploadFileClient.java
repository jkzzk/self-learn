package com.jkzzk.net.uploadFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *      上传文件客户端
 */
public class UploadFileClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8080);

        FileInputStream fileInputStream = new FileInputStream("TestFile\\kaoshibg.png");

        byte[] bytes = new byte[1024];
        int reader = 0;
        while ((reader = fileInputStream.read(bytes)) != -1) {
            socket.getOutputStream().write(bytes);
        }

        /**
         *  关闭输出流，告诉服务器，此文件已经上传完毕
         * */
        socket.shutdownOutput();


        byte[] buffer = new byte[1024];
        int len = socket.getInputStream().read(buffer);
        System.out.println(new String(buffer,0,len));

        fileInputStream.close();
        socket.close();
    }

}
