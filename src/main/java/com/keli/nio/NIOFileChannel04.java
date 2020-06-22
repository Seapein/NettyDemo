package com.keli.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * @author seapein
 * @date 2020/6/17 3:36 下午
 * 拷贝文件
 */
public class NIOFileChannel04 {
  public static void main(String[] args) throws Exception {
      //创建相关流
      FileInputStream fileInputStream = new FileInputStream("/Users/lie/Desktop/a1.jpeg");
      FileOutputStream fileOutputStream = new FileOutputStream("/Users/lie/Desktop/a2.jpeg ");

      //获取各个对应的fileChannel
      FileChannel sourceCh = fileInputStream.getChannel();
      FileChannel destCh = fileOutputStream.getChannel();

      //使用transferForm完成拷贝
      destCh.transferFrom(sourceCh,0,sourceCh.size());

      //关闭相关的通道和流
      sourceCh.close();
      destCh.close();
      fileInputStream.close();
      fileOutputStream.close();
  }
}
