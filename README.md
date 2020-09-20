## springboot 知识点
官网：https://spring.io/
github：https://github.com/spring-projects/spring-boot
版本：2.3.0.RELEASE

## maven 包查询
https://mvnrepository.com/

## 目录结构，com开始
```

├── logs                                                //日志目录
├── pom.xml                                             //springboot 依赖配置文件
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       ├── chunpat
│   │   │       │   └── fengxiuapi                          //springboot 依赖配置文件
│   │   │       │       ├── FengxiuApiApplication.java      //入口
│   │   │       │       ├── Logic                           //逻辑层，如复杂的下单逻辑检测逻辑、优惠券检测
│   │   │       │       ├── bo                              //方便数据整理传输层
│   │   │       │       ├── core                            //核心层
│   │   │       │       │   ├── annotation                  //自定义注解
│   │   │       │       │   ├── configuration               //工程初始化配置
│   │   │       │       │   ├── enumeration                 //枚举
│   │   │       │       │   ├── hack                        //映射注入层
│   │   │       │       │   ├── interceptor                 //拦截
│   │   │       │       │   └── money                       //钱包处理工具
│   │   │       │       │       ├── HalfUpDiscount.java
│   │   │       │       │       └── IMoneyDiscount.java
│   │   │       │       ├── dto                             //参数数据接受层
│   │   │       │       │   ├── BannerDto.java
│   │   │       │       │   └── validator
│   │   │       │       │       ├── TokenPassword.java
│   │   │       │       │       └── TokenPasswordValidator.java
│   │   │       │       ├── exception                       //异常
│   │   │       │       │   ├── AuthenticatedException.java
│   │   │       │       │   ├── CreateSuccess.java
│   │   │       │       │   ├── DeleteSuccess.java
│   │   │       │       │   ├── ForbiddenException.java
│   │   │       │       │   ├── HttpException.java
│   │   │       │       │   ├── NotFoundException.java
│   │   │       │       │   ├── ParameterException.java
│   │   │       │       │   ├── ServerInnerException.java
│   │   │       │       │   └── UpdateSuccess.java
│   │   │       │       ├── lib                             //自定义第三方类库
│   │   │       │       │   └── WxNotify.java
│   │   │       │       ├── manager                         //第三方工具包
│   │   │       │       │   ├── redis
│   │   │       │       │   │   ├── MessageListenerConfiguration.java
│   │   │       │       │   │   └── TopicMessageListener.java
│   │   │       │       │   └── rocketmq
│   │   │       │       │       ├── OrderMessageConsumer.java
│   │   │       │       │       └── OrderMessageProducer.java
│   │   │       │       ├── model                           //模型层
│   │   │       │       │   ├── User.java   
│   │   │       │       ├── repository                      //数据层
│   │   │       │       │   └── UserRepository.java
│   │   │       │       ├── service                         //服务层
│   │   │       │       │   ├── UserService.java
│   │   │       │       ├── util                            //工具层
│   │   │       │       │   ├── Common.java
│   │   │       │       ├── v1                              //控制器
│   │   │       │       │   └── TokenController.java
│   │   │       │       └── vo                              //视图层 ── 接口数据返回处理
│   │   │       │           └── ThemePureVo.java
│   │   │       └── github                                  //第三方包 ── 那些没有公共依赖包的 
│   │   │           └── wxpay
│   │   │               └── sdk
│   │   │                   └── WXPayXmlUtil.java
│   │   └── resources                                       //第三方包 ── 那些没有公共依赖包的 
│   │       ├── ValidatonMessages.properties                //验证器语言包         
│   │       ├── application.yml                             //自定义配置
│   │       ├── config                                      //配置
│   │       │   ├── application-dev.yml                     //开发配置
│   │       │   ├── application-prod.yml                    //生产配置
│   │       │   └── exception-code.properties               //异常码语言包
│   │       ├── log4jdbc.log4j2.properties                  //数据库操作日志
│   │       ├── logback.xml                                 //日志设置
│   │       ├── static                                      //静态资源
│   │       │   └── imgs
│   │       │       └── test@2x.jpeg
│   │       └── templates
│   └── test                                                //单元测试
│       └── java
│           └── com
│               └── chunpat
│                   └── fengxiuapi
```

## springboot 托管 bean
@service @autowired 注解 注入 ===》变成单例  

* 注解注入是在实例化后，所以在构造函数是拿不到注解注入的数据


## JPA
### 1、JPQL 完成多表关联查询
```
//通过分类id获取活动内的优惠券列表
@Query("select c from Coupon c \n" +
        "join CouponCategory coupon_category on coupon_category.couponId = c.id\n" +
        "join Category category on category.id = coupon_category.categoryId\n" +
        "join Activity ac on ac.id = c.activityId \n" +
        "and ac.online = 1 \n" +
        "and ac.startTime < :nowdate\n" +
        "and ac.endTime > :nowdate\n" +
        "where category.id = :cid")
List<Coupon> findAllByCategory(Long cid, Date nowdate);
```
### 3、JPQL 更新操作 需要加@Modify，还要加事务@Transactional
```
//核销库存库存
@Modifying
@Query("update Sku s set s.stock = s.stock - :quantity where s.id = :skuId and s.stock >= :quantity")
int reduceStock(Long skuId, Integer quantity);
```

## ThreadLocal 线程安全存储登录的用户信息




## Springboot JPA日志输出打印SQL语句和传入的参数 
链接：https://blog.csdn.net/qq_35387940/article/details/102563845

## Redis Pub/Sub EVENT NOTIFICATION 来做延迟消息队列

> 配置，默认不开启 

修改配置redis.conf, 将notify-keyspace-events Ex注释打开
```
notify-keyspace-events Ex
```

> 开启订阅模式

```
127.0.0.1:6379> PSUBSCRIBE __keyevent@0__:expired
Reading messages... (press Ctrl-C to quit)
1) "psubscribe"
2) "__keyevent@0__:expired"
3) (integer) 1
```

> 客户端pub 设置消息

```
127.0.0.1:6379> setex test 5 niubi
OK
```

> 查看订阅端，多了四行数据
```
➜  ~ redis-cli
127.0.0.1:6379> PSUBSCRIBE __keyevent@0__:expired
Reading messages... (press Ctrl-C to quit)
1) "psubscribe"
2) "__keyevent@0__:expired"
3) (integer) 1
1) "pmessage"
2) "__keyevent@0__:expired"
3) "__keyevent@0__:expired"
4) "test"
```

## rocketMQ 延迟消息队列

### 安装与测试

> 1、下载bin包

http://rocketmq.apache.org/dowloading/releases/ 

> 2、Quick Start

http://rocketmq.apache.org/docs/quick-start/

1）查看环境变量  
```
/usr/libexec/java_home -V // /Users/zzhpeng/Library/Java/JavaVirtualMachines/corretto-1.8.0_252/Contents/Home
```

2）配置 Name Server
vim bin/runserver.sh，在第31行添加/Users/zzhpeng/Library/Java/JavaVirtualMachines/corretto-1.8.0_252/Contents/Home
```
 27 [ ! -e "$JAVA_HOME/bin/java" ] && JAVA_HOME=$HOME/jdk/java
 28 [ ! -e "$JAVA_HOME/bin/java" ] && JAVA_HOME=/usr/java
 29 [ ! -e "$JAVA_HOME/bin/java" ] && error_exit "Please set the JAVA_HOME variable in your environment, We need java(x64)!"
 30 
 31 export JAVA_HOME=/Users/zzhpeng/Library/Java/JavaVirtualMachines/corretto-1.8.0_252/Contents/Home
 32 export JAVA="$JAVA_HOME/bin/java"
 33 export BASE_DIR=$(dirname $0)/..
 34 export CLASSPATH=.:${BASE_DIR}/conf:${CLASSPATH}
```

3）启动 Start Name Server
```
sh bin/mqnamesrv
```
显示
```
➜  rocketmq-all-4.7.1-bin-release sh bin/mqnamesrv    
OpenJDK 64-Bit Server VM warning: Using the DefNew young collector with the CMS collector is deprecated and will likely be removed in a future release
OpenJDK 64-Bit Server VM warning: UseCMSCompactAtFullCollection is deprecated and will likely be removed in a future release.
The Name Server boot success. serializeType=JSON
```

4）配置 broker Server，和name server一样，添加上java_home
```
vim bin/runbroker.sh 
```

5）启动 Start broker
```
sh bin/mqbroker -n localhost:9876
```
显示
```
➜  rocketmq-all-4.7.1-bin-release sh bin/mqbroker     
The broker[zzhpeng.local, 192.168.11.31:10911] boot success. serializeType=JSON
```

6）执行官方example,不过需要配置环境变量
```
 > export NAMESRV_ADDR=localhost:9876
 > sh bin/tools.sh org.apache.rocketmq.example.quickstart.Producer
 SendResult [sendStatus=SEND_OK, msgId= ...

 > sh bin/tools.sh org.apache.rocketmq.example.quickstart.Consumer
 ConsumeMessageThread_%d Receive New Messages: [MessageExt...
```

