package com.johnny.sars.executor;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * * Description: ThreadPool 统一保存地方，防止应用初始化过多线程池
 */
public class ThreadPoolExecutorHolders {

    public static final ExecutorService executors = new ThreadPoolExecutor(5, 10, 0, TimeUnit.MINUTES, new LinkedBlockingDeque<>()
            , new CustomizableThreadFactory("executors"));

}
