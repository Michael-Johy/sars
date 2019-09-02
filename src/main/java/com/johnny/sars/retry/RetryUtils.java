package com.johnny.sars.retry;

import com.johnny.sars.lang.concurrent.executor.Threads;
import com.johnny.sars.lang.exception.Exceptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import java.util.concurrent.TimeUnit;

/**
 * * Created By: yangtao3
 * * Date: 2019/8/22 17:59
 * * Description:RetryUtils
 */
@Slf4j
public class RetryUtils {

    public interface Handler<T> {
        T handle() throws Exception;
    }

    public static <T> T retry(Handler<T> handler) {
        return retry(handler, 3);
    }

    public static <T> T retry(Handler<T> handler, int retryCount) {
        Assert.notNull(handler, "handler must not be null");
        Assert.isTrue(retryCount > 0, "retryCount must greater than zero");
        int retrys = 0;
        while (retryCount > 0) {
            retrys++;
            try {
                return handler.handle();
            } catch (Exception e) {
                log.warn("重试次数 = {} , error = {}", retrys, Exceptions.getStackTrace(e));
                retryCount--;
                if (retryCount == 0) {
                    throw Exceptions.uncheckException(e);
                }
            }
        }
        return null;
    }

    public static <T> T retry(Handler<T> handler, int retryCount, int interval, TimeUnit timeUnit) {
        Assert.notNull(handler, "handler must not be null");
        Assert.isTrue(retryCount > 0, "retryCount must greater than zero");
        int retrys = 0;
        while (retryCount > 0) {
            retrys++;
            try {
                return handler.handle();
            } catch (Exception e) {
                log.warn("重试次数 = {} , error = {}", retrys, Exceptions.getStackTrace(e));
                retryCount--;
                if (retryCount == 0) {
                    throw Exceptions.uncheckException(e);
                } else {
                    Threads.sleep(interval, timeUnit);
                }
            }
        }
        return null;
    }
}
