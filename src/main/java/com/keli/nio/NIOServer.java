package com.keli.nio;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class NIOServer {
    public static void main(String[] args) throws Exception{
        //创建ServerSocketChannel->ServerSocket
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //得到一个Selector对象
        Selector selector = Selector.open();

        //绑定一个端口666，在服务器端监听
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));
        //设置为非阻塞
        serverSocketChannel.configureBlocking(false);

        //把serverSocketChannel注册到Selector 关心事件为OP_ACCEPT
        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);

        //循环等待客户端连接
        while (true){
            //这里我们等待一秒，如果没有事件发生（连接事件）
            if (selector.select(1000)==0){//没有事件发生
                System.out.println("服务器等待了1秒，无连接");
                continue;
            }
        }

    }

}
