package org.mrhan.simulator.fc.api.core;

/**
 * 组件接口
 *
 * @author Mrhanhao
 * @date 2019/4/9 16:07
 */
public interface IComponent {

    /**
     * 初始化组件
     */
    void initComponent();

    /**
     * 销毁组件
     */
    void destroyComponent();

    /**
     * 获取硬件唯一ID
     *
     * @return 返回ID标识符
     */
    String getHID();

    /**
     * 组件描述
     *
     * @return 返回组件秒速
     */
    String getDes();
}
