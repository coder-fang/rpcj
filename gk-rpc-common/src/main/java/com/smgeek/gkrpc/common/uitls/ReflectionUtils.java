package com.smgeek.gkrpc.common.uitls;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * 反射工具类
 *
 * @author LiFang
 * @version 1.0
 * @since 2022/2/22 12:16
 */
public class ReflectionUtils {
    /**
     * @param clazz 待创建对象的类
     * @return T 创建好的对象
     * @description 根据class创建对象
     * @author LiFang
     * @date 2022/2/22 12:52
     */
    public static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException();
        }
    }

    /**
     * @param clazz
     * @return java.lang.reflect.Method[] 当前类声明的公共方法
     * @description 获取某个class的公共方法
     * @author LiFang
     * @date 2022/2/22 13:02
     */
    public static Method[] getPublicMethods(Class clazz) {
        // 返回当前类所有的方法
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> pmethods = new ArrayList<>();
        for (Method method : methods) {
            if (Modifier.isPublic(method.getModifiers())) {
                pmethods.add(method);
            }
        }
        return pmethods.toArray(new Method[0]);
    }
    /**
     * @description 调用指定对象的指定方法
     * @param [obj, method, args] 被调用方法的对象、被调用的方法、方法的参数
     * @return java.lang.Object 返回结果
     * @author LiFang
     * @date 2022/2/22 13:10
     */
    public static Object invoke(Object obj,Method method,Object... args){
        try{
            return method.invoke(obj,args);
        }catch (Exception e){
            throw new IllegalStateException(e);
        }
    }
}
