package com.jkzzk.net.tcp;

import java.io.IOException;
import java.net.Socket;

/**
 *  TCP通信客户端：向服务器发送连接请求，给服务器发送数据，读取服务器回写的数据
 *  表示客户端的类：
 *      java.net.Socket ： 该类实现客户端套接字（也称为“套接字”），套接字是两台机器之间通讯的端点
 *      套接字：包含了IP地址和端口的网路单位
 *
 *      构造方法：
 *          Socket(String host, int port) 创建流套接字并将其连接到指定主机上的指定端口号
 *          参数：
 *              String host ： 服务器主机的名称，服务器的IP地址
 *              int port ： 服务器的端口号
 *      成员方法：
 *          OutputStream getOutputStream() 返回此套接字的输出流
 *          InputStream getInputStream() 返回此套接字的输入流
 *          void close() 关闭此套接字
 *
 *      实现步骤：
 *          1.创建一个客户端Socket对象，构造方法中绑定服务器的IP地址和端口号
 *          2.调用getOutputStream方法获取输出流，使用write方法与服务器交互
 *          3.调用getInputStream方法获取输入流，使用read方法读取服务器的回写方法
 *          4.释放资源(Socket)
 */
public class TcpClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8080);

        socket.getOutputStream().write("你好，服务器！".getBytes());

        byte[] bytes = new byte[1024];
        int len = socket.getInputStream().read(bytes);
        System.out.println(new String(bytes,0,len));

        socket.close();
    }
}
