package com.johnny.sars.trace.holder;

import com.google.common.collect.Lists;
import com.johnny.sars.lang.exception.Exceptions;
import com.johnny.sars.trace.TraceLog;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * * Description: memory traceLog holder
 */
@Slf4j
public class TraceLogHolder {

    private static List<TraceLog> traceLogs = Lists.newArrayList();
    private static final ReentrantLock lock = new ReentrantLock();

    public static void put(TraceLog log1) {
        lock.lock();
        try {
            if (traceLogs.size() < 10_000) {
                traceLogs.add(log1);
            } else {
                log.warn("traceLog size > 10_000, discard....");
            }
        } catch (Exception e) {
            log.warn("put traceLog fault, error = " + Exceptions.getStackTrace(e));
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
            log.warn("get traceLog fault, error = " + Exceptions.getStackTrace(e));
        } finally {
            lock.unlock();
        }
        return Lists.newArrayList();
    }

}
