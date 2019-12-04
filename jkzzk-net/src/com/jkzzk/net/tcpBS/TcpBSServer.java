package com.jkzzk.net.tcpBS;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 *  模拟BS服务器
 *
 * GET /web/index.html HTTP/1.1
 * Host: 127.0.0.1:8888
 * Connection: keep-alive
 * Cache-Control: max-age=0
 * Upgrade-Insecure-Requests: 1
 * User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.25 Safari/537.36 Core/1.70.3741.400 QQBrowser/10.5.3863.400
 * Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,\/**\;q=0.8
 * Accept-Encoding:gzip,deflate,br
 * Accept-Language:zh-CN,zh;q=0.9
 */
public class TcpBSServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);

        while(true) {
            Socket accept = serverSocket.accept();

            new Thread(() -> {
                try{
                    InputStream inputStream = accept.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String[] split = bufferedReader.readLine().split(" ");

                    FileInputStream fileInputStream = new FileInputStream(split[1].substring(1));

                    OutputStream outputStream = accept.getOutputStream();
                    outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
                    outputStream.write("Content-Type:text/html\r\n".getBytes());
                    outputStream.write("\r\n".getBytes());
                    byte[] bytes = new byte[1024];
                    int len = 0;
                    while((len = fileInputStream.read(bytes)) != -1) {
                        outputStream.write(bytes,0,len);
                    }

                    bufferedReader.close();
                    fileInputStream.close();
                    accept.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }

//        serverSocket.close();
    }

}
