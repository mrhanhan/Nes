package org.mrhan.simulator.fc.common;

import org.mrhan.simulator.fc.api.core.IComponent;
import org.mrhan.simulator.fc.utils.IDUtils;

/**
 * 基础实现IComponent
 *
 * @author Mrhanhao
 * @date 2019/4/9 21:36
 */
public abstract class BaseComponent implements IComponent {
    /**
     * 当前组件ID
     */
    private String HID;

    public BaseComponent(){
        HID = IDUtils.genID();
    }

    /**
     * 组件ID
     *
     * @param id ID
     */
    public void setHID(String id){
        HID = id;
    }
    @Override
    public String getHID() {
        return HID;
    }

    @Override
    public String getDes() {
        return "Nes 组件";
    }
}
