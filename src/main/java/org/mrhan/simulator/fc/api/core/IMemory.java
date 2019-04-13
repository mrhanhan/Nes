package org.mrhan.simulator.fc.api.core;

/**
 * 存储器
 *
 * @author Mrhanhao
 * @date 2019/4/9 8:27
 */
public interface IMemory extends IComponent{

    /**
     * 读取指定地址的内存数据
     *
     * @param addr 地址数据
     * @return 返回操作结果
     */
    char read(int addr);

    /**
     * 在指定地址写入数据
     *
     * @param addr Addr 地址
     * @param data data 数据
     */
    void write(int addr , char data);

    /**
     * 获取最大内存地址
     *
     * @return 返回最大地址
     */
    int getMaxAddr();

    /**
     * 获取当前内存组件名称
     *
     * @return 返回名称
     */
    String getMemoryName();
}
