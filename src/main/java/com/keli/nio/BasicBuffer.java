package com.keli.nio;

import java.nio.IntBuffer;

/**
 * @Author seapein
 */
public class BasicBuffer {
  public static void main(String[] args) {
      //举例说明buffer的使用
      //创建一个Buffer,大小为5，即可存放5个int
      IntBuffer intBuffer = IntBuffer.allocate(5);

      //向buffer中存放数据
     /* intBuffer.put(10);
      intBuffer.put(11);
      intBuffer.put(12);
      intBuffer.put(13);
      intBuffer.put(14);*/
     for(int i=0;i<intBuffer.capacity();i++){
         intBuffer.put(i*2);
     }
     //如何从buffer读取数据
      //将buffer转换，读写切换
      intBuffer.flip();
      intBuffer.position(1); //从2开始
      intBuffer.limit(3);//以3结束（不包括3）
      while (intBuffer.hasRemaining()){
      System.out.println(intBuffer.get());
     }
  }
}
