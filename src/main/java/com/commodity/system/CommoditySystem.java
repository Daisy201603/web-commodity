package com.commodity.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
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

    private static Logger logger = LoggerFactory.getLogger(CommoditySystem.class);

    /**
     * 系统配置
     */
    public static Map<String, String> configProperties = new HashMap<>();

    /**
     * 系统地址
     * */
    public static String systemUrl = "";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        getSystemConfig();
        getServerUrl(sce);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    /**
     * 获取系统服务地址
     *
     * @author GongDiXin
     * @date 2018/9/5 22:15
     * @param
     * @return
     * @exception
    */
    private static void getServerUrl(ServletContextEvent sce) {
       ServletContext context = sce.getServletContext();
       systemUrl = context.getRealPath("/");
    }

    /**
     * 加载系统配置
     *
     * @author GongDiXin
     * @date 2018/9/5 22:14
     * @param
     * @return
    */
    private static void getSystemConfig() {
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
}
