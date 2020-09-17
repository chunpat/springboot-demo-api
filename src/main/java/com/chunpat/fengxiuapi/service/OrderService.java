package com.chunpat.fengxiuapi.service;

import com.chunpat.fengxiuapi.Logic.PlaceOrderChecker;
import com.chunpat.fengxiuapi.bo.OrderMessageBO;
import com.chunpat.fengxiuapi.core.enumeration.OrderStatus;
import com.chunpat.fengxiuapi.core.money.HalfUpDiscount;
import com.chunpat.fengxiuapi.dto.OrderDto;
import com.chunpat.fengxiuapi.exception.ParameterException;
import com.chunpat.fengxiuapi.model.Order;
import com.chunpat.fengxiuapi.repository.OrderRepository;
import com.chunpat.fengxiuapi.util.Common;
import com.chunpat.fengxiuapi.util.OrderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    SkuService skuService;

    @Autowired
    CouponService couponService;

    @Autowired
    HalfUpDiscount halfUpDiscount;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Value("${chunpat.pay-time-limit}")
    private int payTimeLimit;

    @Value("${spring.redis.listen-database}")
    private int listenDatabase;

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    //下单
    @Transactional
    public Long placeOrder(Long uid, OrderDto orderDto, PlaceOrderChecker placeOrderChecker) {
        //todo 下单
        //过期时间
        Calendar now = Calendar.getInstance();
        Date expireTime = (Common.expireTime(now,this.payTimeLimit)).getTime();
        Date createTime = (Common.expireTime(now,this.payTimeLimit)).getTime();
        Order order = Order.builder()
            .userId(uid)
            .orderNo(OrderUtil.getOrderCode(uid.intValue()))
            .totalPrice(orderDto.getTotalPrice())
            .finalTotalPrice(orderDto.getFinalTotalPrice())
            .snapTitle(placeOrderChecker.snapTitle())
            .snapImg(placeOrderChecker.snapImg())
            .expireTime(expireTime)
            .status(OrderStatus.UNPAID.getValue()).build();

        order.setSnapItems(placeOrderChecker.snapItems());
        order.setCreateTime(createTime);
        order.setSnapAddress(orderDto.getAddress());

        //下单
        this.orderRepository.save(order);

        //核销库存
        this.reduceStock(placeOrderChecker);

        //核销优惠券
        if(orderDto.getCouponId() != null){
            this.writeOffConpon(uid,orderDto.getCouponId(),order.getId());
        }

        //延迟消息
        Long couponId = 0L;
        if(orderDto.getCouponId() != null){
            couponId = orderDto.getCouponId();
        }
        this.pubMessageRedis(uid,order.getId(),couponId);
        return order.getId();
    }

    //检测
    public void isOk(Long uid, PlaceOrderChecker placeOrderChecker) {
        placeOrderChecker.isOK(uid,this.couponService,this.halfUpDiscount);
    }

    //核销库存
    public void reduceStock(PlaceOrderChecker placeOrderChecker) {
        placeOrderChecker.snapItems().forEach(orderDetail -> {
           this.skuService.reduceStock(orderDetail.getSkuId(),orderDetail.getCount());
        });
    }

    //核销优惠券
    public void writeOffConpon(Long uid, Long couponId, Long orderId) {
        this.couponService.writeOffConpon(uid,couponId,orderId);
    }

    /**
     * 推送延迟消息
     * @param userId
     * @param orderId
     * @param couponId
     */
    public void pubMessageRedis(Long userId,Long orderId,Long couponId){
        String key =  orderId + "-" + userId + "-" + couponId;
        try{
            //旧版方法
//            JedisConnectionFactory connectionFactory = (JedisConnectionFactory) redisTemplate.getConnectionFactory();
//            connectionFactory.setDatabase(9);//切换9号数据库

            //stringRedisTemplate 切换数据库
//            LettuceConnectionFactory lcf = (LettuceConnectionFactory) stringRedisTemplate.getConnectionFactory();
//            if (lcf != null) {
//                lcf.setDatabase(this.listenDatabase);
//                stringRedisTemplate.setConnectionFactory(lcf);
//                this.stringRedisTemplate.opsForValue().set(key,"1", Duration.ofSeconds(this.payTimeLimit));
//            }
            //注意，使用上述方法进行Redis数据库切换后，整个项目的RedisTemplate连接数据库都会被切换。比如，
            // 在UserServiceImpl类中将注入的RedisTemplate的数据库切换到db1，那么EmployeeServiceImpl注入
            // 的RedisTemplate的数据库也会切换至db1。所以这种方法并不是线程安全的，可能会导致数据库中没有存放期待的数据。
            //可以新建新的Jedis连接，Jedis与RedisTemplate彼此独立，或许可以做到一个项目中访问多个Redis数据库。

            //jredis操作
            //连接本地的 Redis 服务
            Jedis jedis = new Jedis(this.host,this.port);
            jedis.select(this.listenDatabase);
            System.out.println("连接成功");
            //设置 redis 字符串数据
            jedis.setex(key, this.payTimeLimit,"1");

        }catch (RuntimeException e){
            //todo log
            e.printStackTrace();
        }
    }

    /**
     * detail
     * @param uid
     * @param orderId
     * @return
     */
    public Order getDetail(Long uid, Long orderId) {
        Optional<Order> order = this.orderRepository.findFirstByUserIdAndId(uid,orderId);
        order.orElseThrow(()-> new ParameterException(50009));
        return order.get();
    }

    public Page<Order> getByStatus(Long uid, Integer status,Integer pageNum, Integer size) {
        Pageable page = PageRequest.of(pageNum, size, Sort.by("createTime").descending());
        switch (status){
            case 0:
                return this.orderRepository.findAllByUserId(uid,page);
            case 2://支付
            case 3://发货
            case 4://完成
                return this.orderRepository.findAllByStatus(uid,status,page);
            default:
                throw new ParameterException(50012);
        }
    }

    /**
     *
     * @param uid
     * @param pageNum
     * @param size
     * @return
     */
    public Page<Order> getUnpaidList(Long uid, Integer pageNum, Integer size) {
        Pageable getUnPayPage = PageRequest.of(pageNum, size, Sort.by("createTime").descending());
        Calendar now = Calendar.getInstance();
        return this.orderRepository.findAllUnpaid(uid,now.getTime(),getUnPayPage);
    }

    /**
     *
     * @param userId
     * @param orderId
     * @param prepayId
     */
    public void updatePrepayId(Long userId, Long orderId, String prepayId) {
        Date now = Calendar.getInstance().getTime();
        if(this.orderRepository.updatePrepayId(userId,orderId,prepayId,now) != 1){
            throw new ParameterException(50010);
        };
    }

    /**
     * 订单取消
     * @param orderMessageBO orderMessageBO
     */
    @Transactional
    @EventListener
    public void cancel(OrderMessageBO orderMessageBO){
        Order order = this.getDetail(orderMessageBO.getUserId(),orderMessageBO.getOrderId());
        //改变订单状态
        if(!order.getStatus().equals(OrderStatus.UNPAID.getValue())){
            throw new ParameterException(10000);
        }
        this.cancelOrder(orderMessageBO.getUserId(),orderMessageBO.getOrderId());
        //退库存
        order.getSnapItems().forEach(OrderDetail->{
            this.skuService.addStock(OrderDetail.getSkuId(),OrderDetail.getCount());
        });
    }

    /**
     *
     * @param userId
     * @param orderId
     */
    private void cancelOrder(Long userId, Long orderId) {
        if(this.orderRepository.cancel(userId,orderId) != 1){
            throw new ParameterException(50010);
        };
    }
}
