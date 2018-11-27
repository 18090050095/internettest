package com.pvetec.internettext.udp;

import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by Administrator on 2018/11/27.
 */

public class ReceiveDemo {
    public static final String TAG = "ReceiveDemo";

    public static void main(String[] args) throws IOException {
        //1.建立udp接收端socket服务
        DatagramSocket socket = new DatagramSocket(9527);
        while (true) {
            //2.准备用于存储发送数据的数据包
            byte[] buff = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buff, buff.length);
            //3.调用udp的socket的接收方法接收数据存储到数据包
            socket.receive(dp);//阻塞式方法
            //4.通过数据包中的方法获取具体的数据
            String ip = dp.getAddress().getHostAddress();//接收端的IP地址
            int port = dp.getPort();//接收端的端口号
            String text = new String(dp.getData(), 0, dp.getLength());//发送的具体字符串数据
            Log.d(TAG, "ip: " + ip + ",发送内容：" + text + ",端口：" + port);

        }
    }
}
