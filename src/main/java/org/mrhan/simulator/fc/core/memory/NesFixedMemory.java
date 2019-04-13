package org.mrhan.simulator.fc.core.memory;

import org.mrhan.simulator.fc.api.core.IMemory;
import org.mrhan.simulator.fc.common.BaseComponent;

/**
 * 静态内存
 * <pre>
 *     固定内存内存组件
 * </pre>
 * @author Mrhanhao
 * @date 2019/4/9 16:10
 */
public class NesFixedMemory  extends BaseComponent implements IMemory {

    private  int maxAddr;

    /**
     * 内存数组
     */
    private volatile char[] memory = null;


    public NesFixedMemory(int size){
        maxAddr = size;
        initComponent();
    }

    /**
     * 读取指定地址的内存数据
     *
     * @param addr 地址数据
     * @return 返回操作结果
     */
    @Override
    public char read(int addr) {
        synchronized (memory){
            return memory[addr];
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
        synchronized (memory) {
            memory[addr] = data;
        }
    }

    /**
     * 获取最大内存地址
     *
     * @return 返回最大地址
     */
    @Override
    public int getMaxAddr() {

        return maxAddr;
    }

    /**
     * 获取当前内存组件名称
     *
     * @return 返回名称
     */
    @Override
    public String getMemoryName() {
        return "Nes 静态内存组件";
    }

    /**
     * 初始化组件
     */
    @Override
    public void initComponent() {
        memory = new char[maxAddr];
    }

    /**
     * 销毁组件
     */
    @Override
    public void destroyComponent() {
        memory = null;
    }
}
