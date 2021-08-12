# JMM
## 并发编程领域的关键问题
    * 线程之间的通信：共享内存和消息传递
    * 线程之间的同步：
        * 同步是程序控制多个线程之间操作发生相对顺序的机制
        * 共享内存：同步显式执行
        * 消息传递：同步隐式执行
## 计算机的内存模型
    * 复杂度来源：CPU的运行速度和内存的存取速度不匹配的矛盾
    * 引入：高速缓存
    * 引入问题：缓存一致性，一致性协议
## JMM
    * 定义了Java线程和主内存之间的抽象关系，线程之间的共享变量保存在主内存中，每个线程
      都有一个私有的本地内存，保存了共享变量的副本，本地内存是抽象的，涵盖了高速缓存等
    * JMM内存区域划分
    * JMM带来的问题
        * 可见性问题
    * JMM中的重排序
        * 编译器重排序。as-if-serial，单线程执行语义
        * 指令重排序。不存在数据依赖性，可执行指令重排序
        * 解决并发下重排序带来的问题
            * 内存屏障。4类：LoadLoad、LoadStore、StoreLoad、StoreStore
    * Happens-before
        * 保证正确同步的多线程的执行结果不被改变
    * 关键字
        * volatile
            * 内存语义：写之前插入StoreStore，之后StoreLoad
                       读之前加入LoadLoad、LoadStore
            * 实现原理：使用Volatile修饰的变量在写时会使用cpu的Lock前缀
                      将当前cpu缓存行的数据写回到内存中
                      使其它cpu缓存了该内存地址的数据失效
        * final 
            * 内存语义：对final域写入，和把该对象引入赋值给其它引用变量，不能重排序
                      读包含final域的对象和读fianl域，不能重排序
            * 实现原理：读final域的操作前插入一个LoadLoad屏障，写之后插入一个StoreStore屏障
        * synchronized
            * 内存语义：线程和主内存的关系来说
            * 实现原理：前插入monitorenter、后插入monitorexit
      

# 内存溢出
## 堆    OutOfMemory:java heap space
## 栈    StackOverFlow: thread stack overflow
## 永久代 OutOfMemory: meta space