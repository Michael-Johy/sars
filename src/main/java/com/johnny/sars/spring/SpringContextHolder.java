package com.johnny.sars.spring;

import com.johnny.sars.lang.exception.Exceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * * Created By: yangtao3
 * * Date: 2019/8/22 17:08
 * * Description:
 */
@Component

public class SpringContextHolder implements ApplicationContextAware {
    private static final Logger log = LoggerFactory.getLogger(SpringContextHolder.class);

    private static ApplicationContext applicationContext = null;

    private static CountDownLatch latch = new CountDownLatch(1);

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.applicationContext = applicationContext;
    }

    private static ApplicationContext getApplicationContext() {
        if (null == applicationContext) {
            try {
                new Thread(() -> {
                    while (true) {
                        if (null != applicationContext) {
                            latch.countDown();
                        }
                    }
                });
                latch.await(2, TimeUnit.MINUTES);
            } catch (InterruptedException e) {
                log.error("failed to getApplicationContext, error = {}", Exceptions.getStackTrace(e));
            }
        }
        return SpringContextHolder.applicationContext;
    }

    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    public static <T> T getBean(Class<T> tClass) {
        return getApplicationContext().getBean(tClass);
    }

}
