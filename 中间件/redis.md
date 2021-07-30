Redis设计与实现

# 数据结构
## bitmap的原理及使用
    https://blog.csdn.net/u011957758/article/details/74783347
## string(sds)
## list(double-list)
    zipList
## hash
    dict 
    ziplist
## sorted set
    skipList
    ziplist
    hashtable
## set 
    intset
        当集合中只包含整数值元素，且整个集合的元素数量不多时。
        底层实现是数组,涉及到底层数组数据类型升级 int16 -> int32 -> int64, 不支持降级
    hashtable
## zipList
    节约内存而开发的数据结构

type struct redisObject{
    type,     //对象类型
    encoding, //实现对象的底层数据结构类型
    *ptr      //实现对象的底层数据结构地址
}
    

# redis cluster
## 作用：多个redis节点间共享数据
## 原理：
    没有使用一致性hash，使用了hash槽的概念，redis集群有16384个hash槽(2^14)  
    每个key放置到哪个槽：slot = CRC16(key) % 16384
## 一致性保证：无法保证一致性
    异步复制
    网络分区（客户端和master B节点分区） 分区A： A、C、A1、B1、C1  分区B： B和客户端
    
## redis sentinel

# Redis各个版本特性讲解 
## 4.0 5.0 6.0
    https://blog.csdn.net/sinat_14840559/article/details/108326178