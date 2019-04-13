package org.mrhan.simulator.fc.core.memory;

import org.mrhan.simulator.fc.api.core.IMemory;
import org.mrhan.simulator.fc.api.core.memory.IMemoryControl;
import org.mrhan.simulator.fc.common.BaseComponent;

/**
 * 内存单元容器类
 *  <pre>
 *      例如：RAM 6000
 *           ROM 4000
 *           就可以用两个进行分开操作
 *           例如：
 *           NesFixedMemory Ram = new NesFixedMemory(6000)
 *           NesFixedMemory Rom = new NesFixedMemory(4000)
 *           rom.read(0) =>  40001实际则为：
 * </pre>
 *
 *
 * @author Mrhanhao
 * @date 2019/4/9 21:59
 */
public class MemoryControl extends BaseComponent implements IMemoryControl {



    /**
     * 添加内存组件
     *
     * @param memory 内存组件
     * @return 返回这个内存组件所在的地址
     */
    @Override
    public int addMemoryComponent(IMemory memory) {
        return 0;
    }

    /**
     * 移除指定HID的存储单位,移除后重新计算内存地址
     *
     * @param hid HID
     * @return 返回移除的IMemeory
     */
    @Override
    public IMemory removeMemoryComponent(String hid) {
        return null;
    }

    /**
     *
     */
    public void sortMemoryCompoent(){

    }

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
