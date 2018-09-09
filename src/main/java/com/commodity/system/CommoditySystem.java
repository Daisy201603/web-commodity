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
     * 获取文件上传根地址
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
        configProperties.put("com.commodity.ordinary.file.url", properties.getProperty("com.commodity.ordinary.file.url"));
        configProperties.put("com.commodity.protocol", properties.getProperty("com.commodity.protocol"));
        configProperties.put("com.commodity.domain", properties.getProperty("com.commodity.domain"));
        configProperties.put("com.commodity.port", properties.getProperty("com.commodity.port"));
    }

    /**
     * 获取项访问路径(需要映射)
     *
     * @author GongDiXin
     * @date 2018/9/9 15:51
     * @param
     * @return
     * @exception
    */
    public static String getCommodityUrl() {
        String commodityUrl = configProperties.get("com.commodity.protocol")
                                + "://"
                                + configProperties.get("com.commodity.domain")
                                + ":"
                                + configProperties.get("com.commodity.port");
        return commodityUrl;
    }

    /**
     * 获取普通文件地址
     *
     * @author GongDiXin
     * @date 2018/9/9 15:51
     * @param
     * @return ordinaryFileUrl
     */
    public static String getOrdinaryFileUrl() {
        String ordinaryFileUrl = getCommodityUrl()
                                + "/"
                                + configProperties.get("com.commodity.ordinary.file.url");
        return ordinaryFileUrl;
    }
}
