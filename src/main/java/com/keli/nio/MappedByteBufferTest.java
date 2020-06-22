package com.keli.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author seapein
 * @date 2020/6/17 4:20 下午 说明 1.MappedByteBuffer 可以让文件直接在内存（堆外内存）修改，操作系统不需要拷贝一次
 */
public class MappedByteBufferTest {
  public static void main(String[] args) throws Exception {
    RandomAccessFile randomAccessFile = new RandomAccessFile("1.txt", "rw");

    // 获取对应的通道
    FileChannel fileChannel = randomAccessFile.getChannel();
    /*
     * 参数1：FileChannel.MapMode.READ_WRITE：使用的读写模式
     * 参数2：0：可以修改的起始位置
     * 参数3：5：映射到内存的大小（不是索引位置） 即将1.txt的多少个字节映射到内存
     * 可以直接修改的范围就是0-5
     * 实际类型 DirectByteBuffer
     * */
    MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
    mappedByteBuffer.put(0, (byte) 'A');
    mappedByteBuffer.put(3, (byte) 9);

    randomAccessFile.close();
    System.out.println("修改成功");
  }
}
