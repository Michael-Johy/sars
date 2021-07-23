# Data Types

# 三大范式
 * 第一范式：所有列都不可以再拆分
 * 第二范式：非主键列完全依赖于主键列，而不能是依赖于主键的一部分
 * 第三范式：非主键列只依赖于主键列，不依赖于其它非主键列

# 事务(innodb支持，mylSam不支持)
# mysql的事务隔离级别
## mysql可重复读如何实现
* row_id 、 trx_id 、db_roll_ptr
## mysql幻读如何实现
* Gap lock(锁定一个id范围，使得属于该id范围的数据，无法插入)
## mysql RR级别下，Gap锁默认是开启的, 可实现幻读

# 索引
* 索引的定义: 帮助mysql高效获取数据的结构
* 索引的类型: B+ tree、 Hash、 B tree
* B+树存储索引优点？B tree呢 or Hash or 红黑树
* B+树叶子节点存储的数据？innodb(聚簇索引) & mylsam
* 聚簇索引和非聚簇索引？
* 回表查询 & 普通索引不一定回表查询(索引字段包含了所有需要查询的数据)
* 联合索引 & 最佳左前缀索引
* union & union all区别
* mysql 数据页大小16K，单节点大小16K
  单条数据大小为1k， 单个key+指针 = 14字节，则高度为3的树最多： 16 * 1024/14 = 1100个节点
  三层： 1100 * 1100 * 16k/单条数据大小 = 千万级别
* buffer pool 是innodb维护的一个缓存区域，缓存数据和索引， 包括热点数据和即将访问到的数据， 提升数
  据的访问效率。更新时若数据所在的页在buffer pool中，则更新，此时叫脏页，后面定时刷新到 磁盘中
* innodb四大特性
    * insert buffer 
      主键索引直接追加，辅助索引随机IO。为了提高辅助索引的插入效率，引入insert buffer
      索引要求：1.辅助索引 2.索引非唯一
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

# Innodb 和 MylSam的区别以及如何选择

# mysql慢查询优化 explain

# 慢查询优化：
  * 是否使用了索引，explain中type， key， row， extra字段
  * 是否load了不必要的数据， 优化sql
  * 是否数据量太大，数据库分库分表

# 主从复制
  * 异步复制，主库（log dump thread） 和从库(io thread & SQL thread)
  * 半同步复制，主库的binlog同步到至少一个从库的relay log中
  * 同步辅助，

# 日志系统
  * redo & undo & binlog  
    保证事务的持久性、用于复制
  * error log
    查询类似死锁，io瓶颈
  * general log & slow query log
    定位慢查询
  * relay log
    用于复制。slave上的io线程接收binlog并写入relay log，sql thread
    应用中继日志文件到本地数据库



    
    