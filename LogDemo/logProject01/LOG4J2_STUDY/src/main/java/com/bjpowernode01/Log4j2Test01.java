package com.bjpowernode01;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4j2Test01 {

    @Test
    public void test01(){

        Logger logger = LoggerFactory.getLogger(Log4j2Test01.class);

        //日志的记录
        for (int i = 0; i < 2000; i++) {

            logger.error("error信息");
            logger.warn("warn信息");
            logger.info("info信息");
            logger.debug("debug信息");
            logger.trace("trace信息");

        }

        //系统业务逻辑
        for (int i = 0; i < 1000; i++) {

            System.out.println("------------------");

        }

    }

}
