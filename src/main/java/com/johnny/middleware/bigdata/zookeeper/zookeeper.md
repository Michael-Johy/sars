# 定义
## distributed coordination service,  offer sets of primitives to build high 
    level service like synchronizatio、config managemen、 group、 naming
   协调服务不容易实现，总是由于条件竞争或死锁导致错误，使用zookeeper可以使分布式程序从实现协调服务中
   解放出来
   
# 设计目标
## simple
    coordinate through a hierarchical namespace, namespace consist of znode
    data keep in memory, high throughput and low latency nums
    high performance: used in large distributed systems
    high relibility: no single point of failure
    strictly ordered access: sophisticated synchronization primitive can implement
## replicated
## ordered
    stamps each update with a number than reflect zookeeper transactions,
## fast 
    read more common than write, ratio around 10-1

# Data Model and hierarchical namespace

# ZNode 和临时ZNod（session)

# updates & watch

# Guarantees
### sequential consistent
### atomicity
### single system image
### Reliability
### timelines

# simple api
# implementation
