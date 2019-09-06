package com.example.demo.common.util;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * @author Hanyh
 * @create 2017-12-19 10:01
 * @desc
 **/
public class App {
    private static Properties properties = null;

    static {
        ClassPathResource resource = new ClassPathResource(
                "/application.properties");
        try {
            properties = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 保存全局属性值
     */
    private static Map<String, String> map = Maps.newHashMap();

    /**
     * 获取ap路径
     */
    public static String getDictList(String typeCode) {
        return getConfig("apPath");
    }
    /**
     * 获取配置
     *
     * @see ${fns:getConfig('Path')}
     */
    public static String getConfig(String key) {
        String value = map.get(key);
        if (value == null) {
            value = properties.getProperty(key);
            map.put(key, value != null ? value : StringUtils.EMPTY);
        }
        return value;
    }
}
