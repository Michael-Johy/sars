package com.johnny.utils.lang.executor;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * * Created By: yangtao3
 * * Date: 2019/6/17 11:26
 * * Description: ThreadPool 统一保存地方，防止应用初始化过多线程池
 */
public class ThreadPoolHolders {

    public static final ExecutorService commonExecutors = new ThreadPoolExecutor(5, 10, 0, TimeUnit.MINUTES, new LinkedBlockingDeque<>()
            , new CustomizableThreadFactory("commonExecutors"));

    public static final ExecutorService vipExecutors = new ThreadPoolExecutor(3, 9, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<>(),
            new CustomizableThreadFactory("vipExecutors"), new ThreadPoolExecutor.CallerRunsPolicy());

}
