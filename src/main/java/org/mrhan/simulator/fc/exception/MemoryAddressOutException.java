package org.mrhan.simulator.fc.exception;

import org.mrhan.simulator.fc.api.core.IMemory;

/**
 * 内存地址溢出异常
 *
 * @author Mrhanhao
 * @date 2019/4/9 15:39
 */
public class MemoryAddressOutException extends RuntimeException {
    /**
     * 构造方法
     *
     * @param memory 内存组件
     * @param addr 地址
     */
    public MemoryAddressOutException(IMemory memory , int addr){
        super(new StringBuilder().append("内存地址超出\n").append("内存组件：").append(memory.getMemoryName())
                .append("\n")
                .append("组件最大内存：")
                .append(memory.getMaxAddr())
                .append("\n错误地址：").append(addr).append("\n").toString());
    }
}
