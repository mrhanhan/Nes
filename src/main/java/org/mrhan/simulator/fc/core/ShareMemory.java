package org.mrhan.simulator.fc.core;

import org.mrhan.simulator.fc.api.core.IMemory;
import org.mrhan.simulator.fc.common.BaseComponent;


/**
 * 全局共享的内存地址
 *
 * @author Mrhanhao
 * @date 2019/4/9 8:48
 */
public class ShareMemory extends BaseComponent implements IMemory {


    /**
     * 读取指定地址的内存数据
     *
     * @param addr 地址数据
     * @return 返回操作结果
     */
    @Override
    public char read(int addr) {
        return 0;
    }

    /**
     * 在指定地址写入数据
     *
     * @param addr Addr 地址
     * @param data data 数据
     */
    @Override
    public void write(int addr, char data) {

    }

    /**
     * 获取最大内存地址
     *
     * @return 返回最大地址
     */
    @Override
    public int getMaxAddr() {
        return 0;
    }

    /**
     * 获取当前内存组件名称
     *
     * @return 返回名称
     */
    @Override
    public String getMemoryName() {
        return null;
    }

    /**
     * 初始化组件
     */
    @Override
    public void initComponent() {

    }

    /**
     * 销毁组件
     */
    @Override
    public void destroyComponent() {

    }
}
