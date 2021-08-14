package com.johnny.middleware.bigdata.zookeeper.example;

import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.List;

public class ZookeeperWatch {

    private static final String connectionString = "sandbox1:2181,sandbox2:2181,sandbox3:2181";

    public static void main(String[] args) throws Exception {
        ZooKeeper zooKeeper = new ZooKeeper(connectionString, 300000, new WatcherImpl());

        List<String> children = zooKeeper.getChildren("/zk_test", true);

        Stat stat = zooKeeper.exists("/zk_test/test01", true);

        zooKeeper.removeWatches("/zk_test/test02", null, Watcher.WatcherType.Any, true);

        Thread.sleep(1000 * 60 * 60);
        System.out.println(stat.getDataLength());

    }
}
