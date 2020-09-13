package com.xxt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @description: com.xxt
 * @author: haytt.xiang
 * @date: 2020-09-10 19:52
 **/
public class Main {

    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    private static Logger mylogger = LogManager.getLogger(Main.class);
    private static Logger monitor = LogManager.getLogger("monitor");

    public static void main(String[] args) {
            // 记录trace级别的信息
            logger.trace("log4j2日志输出：This is trace message.");
            // 记录debug级别的信息
            logger.debug("log4j2日志输出：This is debug message.");
            // 记录info级别的信息
            logger.info("log4j2日志输出：This is info message.");
            // 记录error级别的信息
            logger.error("log4j2日志输出：This is error message.");
            mylogger.trace("main logger info ");
            monitor.trace("monitor info");
            logger.info("我是{}，你是{}", "我自己", "你自己");
            logger.info("我是，你是", "我自己", "你自己");
            try {
                throw new RuntimeException("this is a runtimeException");
            }catch (Exception e){
                logger.warn("有一个异常：",e);
                logger.warn("有一个异常{}：",e);
            }
    }

}
