# 顺序消息
## 分区有序  多个queue参与，则对于每个queue，分区有序
## 全局有序  通过控制发送的顺序消息只依次发送到同一个queue，消费时只从这个queue消费
   创建topic时，指定-b 参数指定topic在哪个broker上创建，不能指定-c ClusterName
    eg sh mqadmin updateTopic -n rq-namesrv1:9876 -b rq-master1:10911 -p 6 -t orders14

# 延时消息
## 只支持设置固定的延时登记，从1s到2h分别对应1-18

# 批量消息：显著提升传递小消息的性能
## 限制：必须有相同topic、相同waitStoreMsgOk，不能是延时消息，消息总大小不能超过4M

# 过滤消息
## tag
## SQL特性可以通过发送消息时properties属性来进行计算

# 事务消息
## 步骤
     step1.生产者发送half消息，MQ服务器响应消息写入结果。若失败，则本地事务逻辑不执行;若成功，执行本地事务
     step2.根据本地事务执行状态执行消息commit or rollback。
        若commit, 则生成消息索引，half消息对消费者可见
        若rollback, 则删除消息
        若超时，则进行3，补偿机制(用于解决消息commit 或 rollback失败或超时的情况)
     step3.对没有commit或rollback的pengding状态消息，服务端执行一次回查
        producer收到回查消息，检查回查消息对应的本地事务执行状态，重新commit或者rollback


# 设计
## 消息存储
## 通信机制
## 消息过滤
## 负载均衡
## 事务消息
## 消息查询