package com.johnny.middleware.bigdata.zookeeper.example;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

public class WatcherImpl implements Watcher {
    @Override
    public void process(WatchedEvent event) {
        System.out.println("path = " + event.getPath());
        System.out.println("state = " + event.getState().name());
        System.out.println("type = " + event.getType().name());
    }
}
