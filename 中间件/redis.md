links：http://www.redis.cn/

# redis cluster
## 作用：多个redis节点间共享数据
## 原理：
    没有使用一致性hash，使用了hash槽的概念，redis集群有16384个hash槽(2^14)  
    每个key防置到哪个槽：slot = CRC16(key) % 16384
## 一致性保证：无法保证一致性
    异步复制
    网络分区（客户端和master B节点分区） 分区A： A、C、A1、B1、C1  分区B： B和客户端
    
## redis sentinel