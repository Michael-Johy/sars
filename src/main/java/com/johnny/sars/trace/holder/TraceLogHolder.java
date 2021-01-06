package com.johnny.sars.trace.holder;

import com.google.common.collect.Lists;
import com.johnny.sars.exception.Exceptions;
import com.johnny.sars.trace.TraceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * * Description: memory traceLog holder
 */
public class TraceLogHolder {

    private static final Logger logger = LoggerFactory.getLogger(TraceLogHolder.class);

    private static List<TraceLog> traceLogs = Lists.newArrayList();
    private static final ReentrantLock lock = new ReentrantLock();

    public static void put(TraceLog log) {
        lock.lock();
        try {
            if (traceLogs.size() < 10_000) {
                traceLogs.add(log);
            } else {
                logger.warn("traceLog size > 10_000, discard....");
            }
        } catch (Exception e) {
            logger.warn("put traceLog fault, error = " + Exceptions.getStackTrace(e));
        } finally {
            lock.unlock();
        }
    }

    public static List<TraceLog> get() {
        lock.lock();
        try {
            List<TraceLog> result = traceLogs;
            traceLogs = Lists.newArrayList();
            return result;
        } catch (Exception e) {
            logger.warn("get traceLog fault, error = " + Exceptions.getStackTrace(e));
        } finally {
            lock.unlock();
        }
        return Lists.newArrayList();
    }

}
