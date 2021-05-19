# 可靠性

* kafka:异步刷盘(异步replication)(pageCache & Memory mapped files)
* rocketmq:支持同步刷盘(同步replication)、异步刷盘(异步replication)
* 对比:
    * 同步刷盘比异步刷盘可靠性高，不会由于OSCrash丢失数据，数据无单点
    * kafka中master宕机后，主备切换可能会导致kafka数据丢失。rocketmq不支持master宕机

# 性能

* kafka:单机达到百万qps,消息大小10字节
* rocketmq:单机3broker达到10w+qps，消息大小10字节
* 原因:
    * kafka: producer将小消息合并，批量发送到broker
    * rocketmq: 缓存消息可由上层业务系统完成
* 对比:
    * rocketmq使用java语言，缓存消息，gc有问题
    * 消息未发送到broker，返回成功，若producer宕机，会导致消息丢失，业务出错

# 性能-单机支持队列数

* kafka:单机支持64个队列，超过后load会发生明显的飙高现象，队列越多，load越高，导致发送消息响应时间变长
    * 一个分区一个文件，当topic增加时，分区增加，文件增加，对消息刷盘时，会出现文件竞争磁盘，导致性能下降
* rocketmq:单机支持最高5万个队列，且load不会明显变高
    * 所有队列都存储在一个文件(commitLog中)，每个commitLog存储消息量比较少，对性能影响较小
* 好处:
    * 队列多可以支持创建更多的topic
    * consumer集群规模和队列数成正比,可以支持更大规模的consumer实例

# 消息投递实时性

* kafka:采用短轮询方式，延迟取决于轮询时间间隔
* rocketmq:采用长轮询方式，延迟一般在几毫秒

# 消息失败重试

* kafka:不支持消息失败重试
* rocketmq:支持定时重试，每次重试时间间隔顺延
* 运用场景：充值类业务

# 严格的顺序消息

*

# 定时消息

* kafka:不支持定时消息
* rocketmq:支持delayedMessage，指定定时level 2分钟-2小时

# 消息查询

* kafka:不支持消息查询
* rocketmq:支持根据messageID查询消息，也支持根据消息内容查询 (发送消息时，指定一个message key，例如可以为orderId)
* 运用场景:
    * 消息查询对于定位消息丢失问题有帮助，到底是消息丢失了还是消费出问题了

# 消息回朔

* kafka:支持根据offset来回朔消息
* rocketmq:支持根据时间来回朔消息，精度到ms
* 运用场景:
    * 由于程序逻辑出错或依赖故障，导致当天消费的消息都无效，需要重新消费

# 消费消息并行度

* kafka:消费并行度取决于topic配置的分区数，例如10个分区，最多10个消费者实例
* rocketmq:
    * 顺序消费，同kafka一样
    * 乱序消费，取决于consumer的线程数

# broker消息过滤

* kafka:不支持broker消息过滤
* rocketmq:可根据message tag过滤

# 社区活跃度 & 成熟度 & 商业支持



