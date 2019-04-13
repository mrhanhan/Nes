package org.mrhan.simulator.fc.utils;

import java.util.UUID;

/**
 * 编码获取工具
 *
 * @author Mrhanhao
 * @date 2019/4/9 21:42
 */
public class IDUtils {

    private static volatile Integer count = 0;


    /**
     * 获取UID
     *
     * @return 返回生成的ID
     */
    public static String genID(){
       return genID(null);
    }

    /**
     *获取指定前缀的ID
     *
     * @param prefix 前缀
     * @return 返回字符串ID
     */
    public static String genID(String prefix){
        String countStr = null;
        synchronized (count){
            countStr = count.toString();
            count ++;
        }

        String code = "H0000000000";
        code = code.substring(0 , code.length() - countStr.length()) + countStr;
        if(StringUtils.isNotEmpty(prefix)){
            code = prefix + "-" + code;
        }
        return code;
    }

}
