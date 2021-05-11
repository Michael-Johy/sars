# Data Types

# 事务(innodb支持，mylSam不支持)

事务的隔离级别

# 索引

* 索引的定义: 帮助mysql高效获取数据的结构
* 索引的类型: B+ tree、 Hash、 B tree
* B+树存储索引优点？B tree呢 or Hash or 红黑树
* B+树叶子节点存储的数据？innodb(聚簇索引) & mylsam
* 聚簇索引和非聚簇索引？
* 回表查询 & 普通索引一定回表查询
* 联合索引 & 最佳左前缀索引
* union & union all区别
* mysql 数据页大小16K，单节点大小16K
* buffer pool 缓存数据和索引
* innodb四大特性
    * insert buffer 索引要求：1.辅助索引 2.索引非唯一
    * double writer 避免脏页刷盘风险
    * adaptive hash index 热点数据，构建热点数据的hash index
    * read ahead 预读 (extend = 64page)
        * 线性预读 将当前extent的后面一个extent读进内存
        * 随机预读 将当前extent中后续的page读进内存

# 锁

* 共享锁和排他锁
    * update\delete\insert
    * select for update 排他锁
* 锁粒度
    * 行锁 优点：粒度小，并发度高 缺点：开销大，加锁慢，容易出现死锁
    * 表锁 优点：开销小，加锁快，不容易死锁 缺点：并发度低
    * 页锁 每次锁定一页 16K Innodb支持行锁、Mylsam支持表锁
* innodb锁的算法
    * Record lock：记录锁，单条索引记录上加锁
    * Gap lock：间隙锁，在索引记录之间的间隙中加锁
    * next-key lock：间隙锁，在索引记录之间的间隙中加锁
* 乐观锁和悲观锁
    * 更新时带上版本号（cas更新）
    * 使用共享锁和排它锁

# Innodb 和 MylSam的区别

# mysql慢查询优化 explain

    
    