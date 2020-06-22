package com.keli.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author seapein
 * @date 2020/6/17 2:27 下午
 */
public class NIOFileChannel03 {
  public static void main(String[] args) throws Exception {
      FileInputStream fileInputStream = new FileInputStream("1.txt");
      FileChannel fileChannel01 = fileInputStream.getChannel();

      FileOutputStream fileOutputStream = new FileOutputStream("2.txt");
      FileChannel fileChannel02 = fileOutputStream.getChannel();

      ByteBuffer byteBuffer = ByteBuffer.allocate(512);
      while(true){//循环读取
          //这里有一个重要的操作，一定不要忘了
          byteBuffer.clear();//清空buffer
          /*public final Buffer clear() {
              position = 0;
              limit = capacity;
              mark = -1;
              return this;
          }*/
          int read=fileChannel01.read(byteBuffer);
          if(read==-1){
              break;
          }
          //将buffer中的数据写到fileChannel02中 --02.txt
          byteBuffer.flip();
          fileChannel02.write(byteBuffer);
      }
      //关闭相关的流
      fileOutputStream.close();
      fileInputStream.close();
  }
}
