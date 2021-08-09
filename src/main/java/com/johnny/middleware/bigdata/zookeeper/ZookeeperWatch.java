package com.johnny.middleware.bigdata.zookeeper;

import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

public class ZookeeperWatch {

    private static final String connectionString = "sandbox-1:2181,sandbox-2:2181,sandbox-3:2181";

    public static void main(String[] args) throws IOException {
        ZooKeeper zooKeeper = new ZooKeeper(connectionString, 3000, null);


    }
}
