package com.zhichenkeji.utils;

import java.util.ResourceBundle;

public class Factory {

    public static Object getBean(String key) {

        try {
            // 读取配置文件
            ResourceBundle resourceBundle = ResourceBundle.getBundle("bean");
            // 根据传递的key获取value
            String value = resourceBundle.getString(key);
            // 根据value全限定名通过反射创建对象
            Class clazz = Class.forName(value);
            // 对象返回
            Object obj = clazz.newInstance();
            return obj;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
