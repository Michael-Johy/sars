# volatile
## 底层实现原理
    1.对volatile修改的变量写操作时，会将高速缓存回写到主内存
    2.高速缓存回写到主内存会导致其它处理高速缓存行该地址数据失效，后续访问需要重新读取主内存
## 优化
    高速缓存行：64字节宽
    通过扩展队列的头节点引用和尾节点引用到64字节，可同时操作头节点和尾节点

# synchronized
## 底层实现原理
    JVM基于进入和退出Monitor对象来实现方法同步和代码块同步
    代码块同步使用monitorenter和monitorexit指令实现，方法同步不太一样，未提及
    monitorenter指令是在编译后插入到同步代码块的开始位置，而monitorexit是插入到方法结束处或异常处
    每个对象都有一个monitor与之关联
## Java对象头
    Mark Word、 Class Metadata Address、 Array length
    Mark Word默认存储对象的hashcode、分代年龄、锁标记,记录的数据随着锁标记位不断变化
## 锁的升级与对比
    无锁状态、偏向锁、轻量级锁、重量级锁

# 原子操作的实现原理
## 处理器实现：总线锁或缓存锁
## JAVA实现
### CAS  底层使用处理器指令CMPXCHG
        ABA问题：变量加上版本号  eg：AtomicStampedReference
        循环时间长开销大：使用pause指令减少cpu使用
        只能保证一个共享变量的原子操作：AtomicReference
### 锁机制

        
