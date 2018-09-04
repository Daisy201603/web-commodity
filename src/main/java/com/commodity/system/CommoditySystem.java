package com.commodity.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 系统初始化类
 *
 * @author GongDiXin
 * @version 1.0
 * @created 2018/9/4 23:33
 */
public class CommoditySystem extends HttpServlet implements ServletContextListener{

    private Logger logger = LoggerFactory.getLogger(CommoditySystem.class);

    public static Map<String, String> configProperties = new HashMap<>();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Properties properties = new Properties();
        try {
            properties.load(CommoditySystem.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            if (logger.isErrorEnabled()) {
                logger.error("配置文件加载失败", e);
            }
        }
        configProperties.put("com.commodity.file.url", properties.getProperty("com.commodity.file.url"));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
