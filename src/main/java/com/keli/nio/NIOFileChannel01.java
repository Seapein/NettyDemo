package com.keli.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author seapein
 * 将信息写入到文件中
 */
public class NIOFileChannel01 {
  public static void main(String[] args) throws Exception {
      String str="Hello,Can you speak chinese?会";
      //创建一个输出流
      FileOutputStream fileOutputStream = new FileOutputStream("d:\\file01.txt");//FileOutputStream里面包含channel

      //通过fileOutputStream获取对应的FileChannel
      //这个channel的真实类型是FileChannelImpl
      FileChannel fileChannel = fileOutputStream.getChannel();

      //创建一个缓冲区ByteBuffer
      ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

      //将str放入byteBuffer
      byteBuffer.put(str.getBytes());

      //对byteBuffer进行flip
      byteBuffer.flip();

      //将byteBuffer数据写入fileChannel
      fileChannel.write(byteBuffer);
      fileOutputStream.close();
  }
}
