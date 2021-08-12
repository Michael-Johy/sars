# 设计目标
## High throughput
## large data backlogs
## low-latency
## partitioned, distributed
## fault-tolerance

# Persistence & efficiency(disk efficiency)
## sequential disk access faster than random memory access
    OS read-ahead & write behind
    prefetch data in large block multiples and group small logical write into large physical write
## PageCache-Centric design
    all data immediately write to a persist log on filesystem without necessarily flush to disk
## too many small I/O operations
    protocol built on message set abstraction(group messages together)
    生产者合并消息，减少网络请求往返；broker每次写chunks of message; consumer pull large liner chunks of message
## excessive byte copying
    生产者、消费者、broker都使用标准的二进制消息格式
    sendfile 由pagecache直接copy到NIC
## End-to-End compression(bandwidth efficiency, cpu efficiency)
    Efficient compression requires compressing multiple messages together rather than 
        compressing each message individually.

# message delivery semantics
## at least once 
    producer: retry>1 && ack=all
    consumer: process message , then commit offset
## at most once
    producer: retry=0 && ack=0
    consumer: commit offset, then process message
## exactly once
    producer: enable.idempotence=true 开启幂等性， ack=all
    consumer: isolation.level=read_committed kafka事务语义

# transaction
    https://www.jianshu.com/p/64c93065473e
    Kafka事务特性是指一系列的生产者生产消息和消费者提交偏移量的操作在一个事务中，
    或者说是一个原子操作，生产消息和提交偏移量同时成功或者失败。
## 场景
    1.生产者发送多条消息可以封装在一个事务中，形成原子操作，要么全部成功要么全部失败
    2.read-process-write：消费消息、生产消息放在一起形成原子操作

# replication
## 实现机制
### 高水位HighWaterMark
    HighWaterMark + LEO 界定消息对外可见性和副本机制
### Leader epoch
    防止由于高水位更新时间错配，导致日志截断，从而导致日志丢失
## follower pull from leader like consumer
## majority vote 2f+1   kafka未使用
    majority vote used for configuration not for primary data storage system
## Quorum 、in-sync-replicas   kafka使用ISR选举leader和保证size(IRS)-1 失败时，消息不丢失
    kafka动态维护了ISR，只有ISR成员才能选举为leader
## unclean.leader.election.enable
    若所有的replicas挂掉，kafka默认选择不恢复，若设置true，则找到一个存活的节点作为leader
# Log compaction
    Log compaction is a mechanism to give finer-grained per-record retention, 
    rather than the coarser-grained time-based retention
    保证日志至少保存每个key的最新状态
#Quotas

# controller控制器组件
    在zk的帮助下协调和管理整个kafka集群
## topic管理
## 分区重分配
## preferred 领导者选举 ??
## 集群成员管理(broker)
## 数据服务
    集群元数据信息

# group coordinator
    offset commit、consumer group rebalance