# 内存管理
## 虚拟内存
    https://www.cnblogs.com/zhenbianshu/p/10300769.html
    分页(Page):操作系统以页为单位管理物理内存，1页=4k
    页表:虚拟内存地址到物理内存地址的映射表，当页表内不存在虚拟地址到
         物理地址的映射时，系统会产生缺页中断，缺页处理时，系统会切换
         内核态为虚拟地址分配物理地址
### 好处
    进程内存管理、进程隔离
    数据共享
    swap：物理内存不够时，将暂时不用的内存数据保存到磁盘上。。扩充内存

## 零拷贝(zero-copy)
    https://mp.weixin.qq.com/s/mZujKx1bKl1T6gEI1s400Q
### 用到的技术：DMA(直接寄存器访问)数据传输技术和内存区域映射技术
### I/O读写方式
    轮询、I/O中断、DMA技术
### 传统I/O方式 & 零拷贝方式
    传统I/O方式：2次cpu上下文切换、1次cpu拷贝、1次DMA拷贝
    零拷贝方式：
        1.用户态直接I/O
        2.减少数据拷贝次数
            mmap + write  
                4次上下文切换、1次cpu拷贝、2次DMA拷贝。   适用于大文件，映射时以页为单位，可能浪费内存
            sendfile      
                2次上下文切换、1次cpu拷贝、2次DMA拷贝。   数据对用户态不可见，完全是数据传输，不可修改
            sendfile+DMA gather copy  
                2次上下文切换、0次cpu拷贝、2次DMA拷贝。 数据对用户态不可见，只用于从文件传输到socket
            splice        
                2次上下文切换、0次cpu拷贝、2次DMA拷贝。   在内核的读缓冲区和网络缓冲区之间建立管道，不需要cpu拷贝
        3.写时复制技术
            多个进程共享同一块数据，当某个进程需要对数据进行修改时，则需要将其拷贝到用户的进程地址空间
    
    Rocket mq： 使用了sendfile方式
    kafka：mmap + write
    netty：FileChannel 基于sendfile    
           mappedByteBuf 基于mmap内存映射
            


    

    