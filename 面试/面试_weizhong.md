# spring cloud组件
## eureka 
    服务注册和发现，分为client和server端，client启动时会将自己的服务信息注册到server，同时会
    拉取服务端的服务信息缓存到本地，同时会周期性的同服务端心跳交换信息，更细服务租约和服务信息
## ribbon
    客户端负载均衡工具
## hystrix
    断路器、保护系统、控制故障范围
    通过隔离、熔断等措施避免服务雪崩。服务不可用时，依赖该服务的线程就会阻塞，直至耗完servert容器
    的线程资源，从而影响依赖调用方的服务，故障传播。通过熔断，对该服务的调用可以及时返回，不影响上游服务
## zuul
    api服务网关，路由、负载均衡等作用
    在微服务架构下，后端服务不直接面向调用方，而是通过一个api网关根据请求的url路由到对应的服务。
    添加api网关后，该网关可以进行权限控制等，并将请求分发给后端的业务服务器

# 事务
## mysql事务基本用法
    begin;   开启事务
    commit/rollback; 提交事务/回滚事务  
    savepoint id 创建保存点
    release savepoint id 删除保存点
    rollback to savepoint id 回滚到保存点
     
    设置隔离级别: read uncommited; read commited; repeatable read; serializable
    autoCommit: 手动提交&自动提交

## jdbc实现
    setAutoCommit  commit or rollback
    使用java.sql.Connection
## mybatis实现
    有2种事务管理方式。jdbc 和 managed
    使用JDBC时，依然使用Connection进行事务提交和回滚
    使用managed时，mybatis不会实现事务管理，而是将事务管理交给容器，即使mybatis commit也没有效果
## spring事务
    实现：sqlSessionFactory
    方式：
        编程式事务：浸入式事务管理，使用platformTransactionManager
        声明式事务：使用AOP实现，其本质是在注解了@Transactional的方法前后进行拦截，在方法开始执行之前加入或者
              开启一个事务，在方法执行之后，根据执行的结果进行提交或者回滚
        声明式事务不足：粒度是方法级别的，而编程式事务是代码块级别的
    特点：
        传播特性：7种，  一个事务是否应该被挂起或启动；或者是方法是否在事务上下文执行
            never(外层有事务异常)
            not_supported(外层有事务挂起，执行完继续外层事务)
            supported(有事务则加入事务执行，没有事务则非事务执行)
            required(有事务则加入事务，没事务则新建事务)
            require_new(新建一个事务执行)
            nested(放在事务内部执行，可以保存状态保存点，后续回滚到该点)
            mandatory(没有事务则异常)
        隔离级别：4种
        超时: 避免对数据库资源的长时间锁定。超时时钟只在事务启动时开始，只能对启动一个新事务的传播行为有效
        只读: 利用事务只读特性采取一些优化措施。该措施只在事务启动时由后端数据库做，因此只对能启动一个新事务的传播行为有效
        回滚规则：默认情况下，只在出现运行时异常时回滚，受检查异常则不回滚，可以设置rollbackfor

# sql注入
## mybatis有2种动态传递参数的方式。 #{} ${}
## 区别：
    #{} 参数占位符, sql预编译, 替换后，自动加上'',防止sql注入
    ${} 字符串替换, sql拼接， 替换后，不加'', 不能防止sql注入
## 用法：
    尽量使用#{}, 特殊情况下用${}, eg：表名，列名

# slf4j 门面模式的典型应用
## simple logging facade for java 简单日志门面
## 门面模式
    了解所有子系统的功能
    不了解具体子系统的实现原理
    负责把具体的请求委派到具体的子系统实现，没有实际业务逻辑
## 作用：
    提供日志接口，提供获取具体日志对象的方法，多个具体日志的实现可以切换(log4j, logback)
    统一日志打印格式，优化打印性能
    实现桥接模式，将其它日志实现，通过slf4j，绑定到项目中的日志实现
    
# 对称加密算法和非对称加密算法
## 区别
    对称加密算法加密和解密时使用的密钥是同一个。加密速度快，计算量小  eg： DES、AES、RC6
    非对称加密算法使用一对公钥和私钥。加密速度慢，效率低，计算量大  eg：RSA
## hash算法(摘要算法) md5, sha256
    单向算法，可利用hash算法对目标信息生成一段特定长度的hash值，却不能通过该hash值获取原目标信息
    常用语信息完整性校验、不可还原的密码存储
## 使用
    非对称加密算法常用来加密需要传输的密钥
    对称加密算法用来加密传输的内容
    hash算法用来信息完整性校验
## USBKey工作原理
    当尝试交易时，银行会向你发送防重字符串，你通过USBKey对该字符串加密并发送回银行，银行使用同样的方式
    加密，看是否和你发送的一致，若一致，则可以交易
    理论上：不同的防重字串加密后的内容不同

# spring bean 生命周期
## https://www.zhihu.com/question/38597960
    实例化 -> 属性设置 -> aware注入 -> 初始化 -> 使用 -> 销毁  
    实例化 -> 
    设置对象属性(依赖注入) -> 
    注入aware接口(spring会检查对象实现了xxxAware接口，若实现了，则注入xxxAware) -> 
    BeanPostProcessor(postProcessBeforeInitialzation & postProcessAfterInitialzation) ->
    InitializingBean与init-method ->
    DisposableBean和destroy-method 

# 定时任务框架有哪些？实现分布式定时任务(数据库悲观锁)， spring的定时任务
## quarts、elastic-job(zk)
## select * from for update 事务执行过程中必须获取锁
## spring task  @Schedule(cron)
## 比较
    quarts多个节点实现分布式通过数据库悲观锁实现
    elastic-job(zk)

quartz 是一个开源的分布式调度库，它基于java实现。
> 它有着强大的调度功能，支持丰富多样的调度方式,比如简单调度，基于cron表达式的调度等等。
> 支持调度任务的多种持久化方式。比如支持内存存储，数据库存储，Terracotta server 存储。
> 支持分布式和集群能力。
> 采用JDBCJobStore方式存储时，针对事务的处理方式支持全局事务（和业务服务共享同一个事务）和局部事务（quarzt 单独管理自己的事务）
> 基于plugin机制以及listener机制支持灵活的扩展。
    
    