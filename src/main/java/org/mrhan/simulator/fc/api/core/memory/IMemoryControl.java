package org.mrhan.simulator.fc.api.core.memory;

import org.mrhan.simulator.fc.api.core.IMemory;

/**
 *
 * 内存控制中心
 *  <pre>
 *      可附加内存组件，
 *      其本身也是一个内存组件，支持读写，但是其本身并不进行存储，
 *      只是进行管理存储，
 *  </pre>
 * @author Mrhanhao
 * @date 2019/4/9 21:22
 */
public interface IMemoryControl extends IMemory {

    /**
     * 添加内存组件
     * @param memory 内存组件
     * @return 返回这个内存组件所在的地址
     */
    int addMemoryComponent(IMemory memory);

    /**
     * 移除指定HID的存储单位,移除后重新计算内存地址
     *
     * @param hid HID
     * @return 返回移除的IMemeory
     */
    IMemory removeMemoryComponent(String hid);

}
