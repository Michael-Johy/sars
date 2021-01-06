package com.johnny.sars.executor;

import com.johnny.sars.exception.Exceptions;
import org.apache.commons.lang3.ThreadUtils;

import java.util.concurrent.TimeUnit;

/**
 * * Description: refer to {@link ThreadUtils}
 */
public class Threads {

    public static void sleep(long cnt, TimeUnit unit) {
        try {
            unit.sleep(cnt);
        } catch (Exception e) {
            throw Exceptions.uncheckException(e);
        }
    }

}
