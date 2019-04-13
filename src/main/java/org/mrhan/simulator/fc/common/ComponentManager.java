package org.mrhan.simulator.fc.common;

/**
 * 组件管理器
 * (暂无任何作用)
 * @author Mrhanhao
 * @date 2019/4/9 21:38
 */
public class ComponentManager {

    private volatile ComponentManager manager;

    /**
     * 组件组件管理器
     *
     * @return
     */
    public synchronized ComponentManager getManager() {
        if(manager == null){
            manager = new ComponentManager();
        }
        return manager;
    }

    private ComponentManager(){

    }
}
