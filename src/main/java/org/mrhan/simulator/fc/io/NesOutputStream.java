package org.mrhan.simulator.fc.io;

import org.mrhan.simulator.fc.api.core.IMemory;

import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author Mrhanhao
 * @date 2019/4/9 18:32
 */
public class NesOutputStream extends OutputStream {

    /**
     * 读取地址
     */
    private volatile int writeAddress;
    /**
     * 标记地址
     */
    private volatile int markAddress;
    /**
     * 内存组件
     */
    private IMemory memory;

    public NesOutputStream(IMemory memory){
        this.memory = memory;
        writeAddress = 0;
    }


    @Override
    public synchronized void write(int b) throws IOException {
        if(memory == null){
            throw new IOException("Nes 内存输出流已被关闭");
        }
        if(writeAddress >= memory.getMaxAddr()){
            throw new IOException("Nes 内存已满无法写入");
        }
        memory.write(writeAddress ++ , (char) b);
    }

    /**
     * 标记指定内存地址
     *
     * @param address 内存地址
     */
    public synchronized void mark(int address) {
        if(address < memory.getMaxAddr()){
            markAddress = address;
        }
    }

    /**
     * 标记当前地址
     */
    public void mark(){
        mark(writeAddress);
    }

    /**
     * 重置到上次标记地址
     *
     */
    public synchronized void reset() {
        writeAddress = markAddress;
    }

    @Override
    public void close() throws IOException {
        memory = null;
    }


}
