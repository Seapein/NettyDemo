package com.keli.nio;

import java.nio.ByteBuffer;

/**
 * @author seapein
 * @date 2020/6/17 3:52 下午
 */
public class NIOByteBufferPutGet {
  public static void main(String[] args) {
      //创建一个buffer
      ByteBuffer byteBuffer = ByteBuffer.allocate(64);

      //类型化方式放入数据
      byteBuffer.putInt(100);
      byteBuffer.putLong(9);
      byteBuffer.putChar('晴');
      byteBuffer.putShort((short) 4);

      //取出
      byteBuffer.flip();

      System.out.println(byteBuffer.getInt());
      System.out.println(byteBuffer.getLong());
      System.out.println(byteBuffer.getChar());
      System.out.println(byteBuffer.getShort());
  }
}
