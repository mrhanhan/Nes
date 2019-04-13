package org.mrhan.simulator.fc.utils;

/**
 *
 * 内存地址工具类
 * <pre>
 *     内存地址  0x0000
 *              0x0001
 *              0x0002
 *              0x0003
 *              ...
 *
 *     段地址    0x0000 : 0x0000 0x0001 0x0002...    段大小：0x1000
 *              0x1000 : 0x1000 0x1001 0x1002...    段大小：0x1000
 *              0x2000 : 0x2000 0x2001 0x2002...    段大小：0x1000
 * </pre>
 * @author Mrhanhao
 * @date 2019/4/9 15:33
 */
public class AddressUtils {

    /**
     * 内存字段转换为段地址
     *
     * @param addr 内存地址
     * @param frameSize 内存段大小、内存帧大小
     * @return 返回段地址
     */
    public static int convertAddrToFrameAddr(int addr , int frameSize){
        if(frameSize == 0){
            return 0;
        }
        return addr / frameSize;
    }

    /**
     * 过滤段地址
     *
     * @param addr 内存地址
     * @param frameSize 短地址大小
     * @return 返回过滤后的帧地址
     */
    public static int filterFrameAddr(int addr , int frameSize){
        if(frameSize == 0){
            return 0;
        }
        return addr % frameSize;
    }


}
