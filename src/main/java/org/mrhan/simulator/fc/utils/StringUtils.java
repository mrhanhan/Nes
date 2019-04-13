package org.mrhan.simulator.fc.utils;

/**
 *
 * String 字符串工具类
 *
 * @author Mrhanhao
 * @date 2019/4/9 21:43
 */
public class StringUtils {

    /**
     * 是否为空字符串
     *
     * @param str String 字符串
     * @return 返回结果
     */
    public static boolean isEmpty(String str){
        return str == null || str.length() == 0;
    }

    /**
     * 字符串是否不为空
     *
     * @param str 字符串
     * @return 返回结果
     */
    public static boolean isNotEmpty(String str){
        return str != null && str.length() > 0;
    }
}
