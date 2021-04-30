package com.johnny.utils.trace;

import com.johnny.utils.trace.holder.TraceLogHolder;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;

/**
 * * Description: TraceLogger to start a titled log, record log , end log , send log to memory-holder
 */
public class TraceLogger {

    private static final ThreadLocal<TraceLog> traceLogThreadLocal = new ThreadLocal<>();

    public static void start(String title) {
        TraceLog traceLog = new TraceLog();
        traceLog.setEventId(TraceLogContext.getEventId());
        traceLog.setStartTime(LocalDateTime.now().toString());
        traceLog.setTitle(title);
        traceLogThreadLocal.set(traceLog);
    }

    public static void log(String message) {
        TraceLog traceLog = traceLogThreadLocal.get();
        String log = StringUtils.isBlank(traceLog.getLog()) ? message : traceLog.getLog() + "\r\n" + message;
        traceLog.setLog(log);
    }

    public static void end() {
        TraceLog traceLog = traceLogThreadLocal.get();
        traceLog.setEndTime(LocalDateTime.now().toString());

        TraceLogHolder.put(traceLog);
        traceLogThreadLocal.remove();
    }

}
