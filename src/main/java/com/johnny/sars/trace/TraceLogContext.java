package com.johnny.sars.trace;

/**
 * * Description: TraceLog holds trace-thread-context variable eg:eventId
 */
public class TraceLogContext {

    private static ThreadLocal<String> eventIdLocal = new ThreadLocal<>();

    public static void setEventId(String eventId) {
        eventIdLocal.set(eventId);
    }

    public static String getEventId() {
        return eventIdLocal.get();
    }

    public static void clearEventId() {
        eventIdLocal.remove();
    }
}
