package com.hwh.common.util;

import java.util.Collection;

/**
 * @author HwH
 * @date 2021/9/12 23:55
 * @description 判断工具类
 */
public class VerifyUtil {
    /**
     * 判断字符串是否为空
     * @param string 字符串
     * @return 空返回true
     */
    public static boolean isEmpty(String string){
        return  (null == string  || "".equals(string) || string.trim().isEmpty());
    }

    /**
     * 判断对象是否为空
     * @param object 对象
     * @return 空返回true
     */
    public static boolean isNull(Object object){
        return null == object;
    }

    /**
     * 判断集合是否为空
     * @param collection 集合
     * @return 空返回true
     */
    public static boolean isEmpty(Collection<?> collection){
        return  (null == collection || collection.size() == 0);
    }

    /**
     * 判断数字是否为空
     * @param integer 数字
     * @return 空返回true
     */
    public static boolean isEmpty(Integer integer) {
        return (null == integer);
    }
}
