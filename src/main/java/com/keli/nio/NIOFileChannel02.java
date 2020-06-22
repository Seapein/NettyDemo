package com.keli.nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


/*
* 读取文件中的信息
* */
public class NIOFileChannel02 {
  public static void main(String[] args) throws Exception {
      //创建文件的输入流
      File file = new File("/Users/lie/Desktop/1.txt");
      FileInputStream fileInputStream = new FileInputStream(file);

      //通过fileInputStream获取对应的fileChannel ->实际类型FileChannelImpl
      FileChannel fileChannel = fileInputStream.getChannel();

      //创建缓冲区
      ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());

      //将通道的数据读入到buffer中
      fileChannel.read(byteBuffer);

      // 将byteBuffer的字节数据转为字符串
      System.out.println(new String(byteBuffer.array()));

      fileInputStream.close();
  }
}
