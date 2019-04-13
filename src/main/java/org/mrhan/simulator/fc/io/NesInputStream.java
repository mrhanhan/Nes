package org.mrhan.simulator.fc.io;

import org.mrhan.simulator.fc.api.core.IMemory;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Mrhanhao
 * @date 2019/4/9 18:32
 */
public class NesInputStream extends InputStream {

    /**
     * 读取地址
     */
    private volatile int readAddress;
    /**
     * 标记地址
     */
    private volatile int markAddress;
    /**
     * 内存组件
     */
    private IMemory memory;

    public NesInputStream(IMemory memory){
        this.memory = memory;
        readAddress = 0;
        markAddress = 0;
    }

    @Override
    public synchronized int read() throws IOException {
        if(memory == null){
            throw new IOException("Nes 内存输入流已被关闭");
        }
        if(readAddress >= memory.getMaxAddr()){
            return  -1;
        }
        return memory.read(readAddress++);
    }

    @Override
    public boolean markSupported() {
        return true;
    }

    /**
     * 标记指定内存地址
     *
     * @param address 内存地址
     */
    @Override
    public synchronized void mark(int address) {
            if(address < memory.getMaxAddr()){
                markAddress = address;
            }
    }

    /**
     * 标记当前地址
     */
    public void mark(){
        mark(readAddress);
    }

    @Override
    public synchronized void reset() throws IOException {
            readAddress = markAddress;
    }

    @Override
    public void close() throws IOException {
        memory = null;
    }
}
