package com.triscit.util;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.beans.BeanCopier;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 和JavaBean 有关的东西
 * @Description
 * @author xyb
 * @Date 2022年04月01日 10:39:13
 *
 */
public class PojoUtil {

    private static final Map<String, BeanCopier> BEAN_COPIER_MAP = new ConcurrentHashMap<>();

    /** 日志 */
    private static final Logger logger = LoggerFactory.getLogger(PojoUtil.class);

    /**
     * 复制list
     * @param resources 原始的数据list
     * @param clazz 目标class
     * @param <R> 原始数据class
     * @param <T> 目标class
     * @return 目标资源
     */
    public static <R, T> List<T> copyList (List<R> resources, Class<T> clazz){
        List<T> list = new ArrayList<>();
        try {
            T t;
            if (CollectionUtils.isNotEmpty(resources)) {
                BeanCopier copier = beanCopier(resources.get(0).getClass(), clazz);
                for (R r : resources) {
                    t = newInstance(clazz);
                    copier.copy(r, t, null);
                    list.add(t);
                }
            }
        } catch (Exception e) {
            logger.error("复制异常，{}", e.getMessage());
            e.printStackTrace();
        }
        return list;
    }


    /***
     * 反射赋值
     * @param bean
     * @param name
     * @param value
     */
    public static void setProperty(final Object bean, String name, final Object value) {
        Class<?> clazz = bean.getClass();
        try {
            Field field = clazz.getDeclaredField(name);
            field.setAccessible(true);
            field.set(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 利用cglib的BeanCopier 拷贝对象
     * @param r 源
     * @param clazz 目标
     */
    public static <R, T> T copyBean(R r, Class<T> clazz){
        T t = null;
        try {
            BeanCopier copier = beanCopier(r.getClass(), clazz);
            t = newInstance(clazz);
            copier.copy(r, t, null);
        } catch (Exception e) {
            logger.error("复制异常，{}", e.getMessage());
            e.printStackTrace();
        }
        return t;
    }


    /**
     * 获取到 BeanCopier
     * @param r 源
     * @param t 目标
     * @param <R>
     * @param <T>
     * @return
     */
    private static <R, T> BeanCopier beanCopier (Class<R> r, Class<T> t){
        String beanKey = r.toString() + t.toString();
        BeanCopier copier;
        if (BEAN_COPIER_MAP.containsKey(beanKey)) {
            copier = BEAN_COPIER_MAP.get(beanKey);
        } else {
            copier = BeanCopier.create(r, t, false);
            BEAN_COPIER_MAP.put(beanKey, copier);
        }
        return copier;
    }


    /**
     * 深拷贝
     * @Description
     * @Date 2019年11月21日 上午11:25:07
     * @param resources
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> List<T> deepCopy (List<T> resources){
        try {
            ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bytesOut);
            out.writeObject(resources);
            ByteArrayInputStream bytesIn = new ByteArrayInputStream(bytesOut.toByteArray());
            ObjectInputStream in = new ObjectInputStream(bytesIn);
            return (List<T>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据类型初始化对象
     * @param clazz
     * @param <T>
     * @return
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public static <T> T newInstance(Class<T> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return clazz.getDeclaredConstructor().newInstance();
    }

}
