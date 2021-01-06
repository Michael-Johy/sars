package com.johnny.sars.trace;

import lombok.Data;

/**
 * * Description: TraceLog represents a segment log
 */
@Data
public class TraceLog {
    private String title;
    private String eventId;
    private String log;
    private String startTime;
    private String endTime;
}
