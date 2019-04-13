package org.mrhan.simulator.fc.core.memory;

import org.mrhan.simulator.fc.utils.AddressUtils;
import org.mrhan.simulator.fc.api.core.IMemory;
import org.mrhan.simulator.fc.common.BaseComponent;
import org.mrhan.simulator.fc.exception.MemoryAddressOutException;

import java.util.ArrayList;
import java.util.List;

/**
 * NesDynamicMemory 缓冲器，作为 Nes 模拟器的内存 动态变化可变大
 * <pre>
 *     缓存实现：
 *     每一帧大小固定后，不可改变
 * </pre>
 * @author Mrhanhao
 * @date 2019/4/9 8:51
 */
public class NesDynamicMemory extends BaseComponent implements IMemory {
    /**
     * 内存缓存
     */
    private volatile List<char[]> buffer;
    
    /**
     * 初始化帧大小
     * 设定后无法改变
     */
    private int initSize;
    /**
     * 初始化帧个数
     */
    private int initCount;

    private int maxAddr;

    public NesDynamicMemory(){
        this(4 , 128);
    }

    /**
     * 够着方法
     *
     * @param count 帧数
     * @param frameSize 帧大小
     */
    public NesDynamicMemory(int count  , int frameSize){
        initSize = frameSize;
        initCount = count;
        maxAddr = initSize * initCount;
        init();
    }
    /**
     * 读取指定地址的内存数据
     *
     * @param addr 地址数据
     * @return 返回操作结果
     */
    @Override
    public char read(int addr) {
        char[] memoryFrame = getFrame(addr);
        int offsetAddr = AddressUtils.filterFrameAddr(addr , initSize);
        
        synchronized (buffer){
            return memoryFrame[offsetAddr];
        }
    }

    /**
     * 在指定地址写入数据
     *
     * @param addr Addr 地址
     * @param data data 数据
     */
    @Override
    public void write(int addr, char data) {
        char[] memoryFrame = getFrame(addr);
        int offsetAddr = AddressUtils.filterFrameAddr(addr , initSize);
        synchronized (buffer){
            memoryFrame[offsetAddr] = data;
        }
    }

    @Override
    public int getMaxAddr() {
        return maxAddr;
    }

    /**
     * 获取内存帧的大小个数
     *
     * @return 返回
     */
    public int getFrameCount(){
        synchronized (buffer){
            return buffer.size();
        }
    }

    public int getInitSize() {
        return initSize;
    }

    public int getInitCount() {
        return initCount;
    }

    @Override
    public String getMemoryName() {
        return "NES 动态内存组件";
    }

    /* ================================================= 私有方法 ============================================== */

    /**
     * 初始化
     *
     */
    protected void init(){
        if(buffer != null){
            buffer.clear();
            buffer = null;
        }
        buffer = new ArrayList<char[]>(initCount);
        for(int i = 0; i < initCount; i++){
            buffer.add(new char[initSize]);
        }
    }

    /**
     * 追加一个帧
     */
    private void appendFrame(){
        buffer.add(new char[initSize]);
        maxAddr = getFrameCount() * getInitSize();
    }

    /**
     * 获取内存地址所在的内存区域
     *
     * @param addr 内存地址
     * @return 返回内存区域
     * @throws MemoryAddressOutException 内存地址超出
     */
    private char[] getFrame(int addr){
        int frame = AddressUtils.convertAddrToFrameAddr(addr , initSize);
        int offsetAddr = AddressUtils.filterFrameAddr(addr , initSize);
        if(addr > maxAddr || frame < 0 || offsetAddr < 0 ){
            throw  new MemoryAddressOutException(this , addr);
        }
        char[] memoryFrame = buffer.get(frame);
        return memoryFrame;
    }


    /**
     * 初始化组件
     */
    @Override
    public void initComponent() {
        init();
    }

    /**
     * 销毁组件
     */
    @Override
    public void destroyComponent() {
        if(buffer != null){
            buffer.clear();
        }
        buffer = null;
    }
}
