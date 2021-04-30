package com.johnny.utils.trace;

import com.google.common.collect.Maps;
import com.johnny.utils.json.JsonUtils;
import com.johnny.utils.trace.holder.TraceLogHolder;
import com.johnny.utils.trace.model.TraceLog;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 *
 */
public class TraceLogService {
    private static final Logger logger = LoggerFactory.getLogger(TraceLogService.class);

    private static final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    private static final AtomicBoolean start = new AtomicBoolean(false);

    public void start() {
        if (start.get()) {
            logger.info("traceLogService 已启动");
            return;
        }
        Map<String, Object> props = Maps.newHashMap();
        props.put("bootstrap.servers", "");
        props.put("retries", 3);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new KafkaProducer<>(props);

        executor.scheduleWithFixedDelay(() -> {
            List<TraceLog> traceLogList = TraceLogHolder.get();
            logger.info("send traceLog size = " + traceLogList.size());
            for (TraceLog traceLog : traceLogList) {
                ProducerRecord<String, String> record = new ProducerRecord<>("traceLog", JsonUtils.toJSONString(traceLog));
                producer.send(record);
            }

        }, 10, 30, TimeUnit.SECONDS);
    }
}
