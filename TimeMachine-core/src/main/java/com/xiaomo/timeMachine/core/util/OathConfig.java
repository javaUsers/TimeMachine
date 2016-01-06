package com.xiaomo.timeMachine.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * Oauth 授权
 *
 * @author L.cm
 *         email: 596392912@qq.com
 *         site:  http://www.dreamlu.net
 * @date Jun 24, 2013 9:58:25 PM
 */
public class OathConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(OathConfig.class);

    private static Properties props = new Properties();

    static {
        try {
            props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("oauth.properties"));
        } catch (IOException e) {
            LOGGER.error("没有找到配置文件[{}],请检查配置，应放于resources根目录下,具体错误信息为[{}]", "oauth.properties", e);
        }
    }

    public static void setProps(Properties prop) {
        props = prop;
    }

    public static String getValue(String key) {
        return props.getProperty(key);
    }
}
