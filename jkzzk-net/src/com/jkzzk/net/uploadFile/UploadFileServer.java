package com.jkzzk.net.uploadFile;

import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 *      上传文件服务器端
 */
public class UploadFileServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket accept = serverSocket.accept();
            new Thread(() -> {
                try {
                    String fileName = System.currentTimeMillis() + new Random(999999).nextInt() + ".png";

                    FileOutputStream fileOutputStream = new FileOutputStream("TestFile" + File.separator + "upload" + File.separator + fileName);
                    byte[] bytes = new byte[1024];
                    int reader = 0;
                    while ((reader = accept.getInputStream().read(bytes)) != -1) {
                        fileOutputStream.write(bytes);
                    }

                    accept.getOutputStream().write("上传成功".getBytes());

                    fileOutputStream.close();
                    accept.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }


        //serverSocket.close();
    }

}
