package com.chunpat.fengxiuapi.v1;

import com.chunpat.fengxiuapi.dto.PersonDto;
import com.chunpat.fengxiuapi.manager.rocketmq.OrderMessageProducer;
import com.chunpat.fengxiuapi.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    OrderMessageProducer orderMessageProducer;

    @Value("${rocketmq.producer.topic}")
    private String topic;

    @PostMapping("")
    public void test( @RequestBody @NotBlank PersonDto personDto){

        System.out.println("ape " + personDto.getName());
        this.testService.niubi(personDto.getAge());
//        this.testService.niubi(new Integer(1));
//        System.out.println(this.testService);
//        List<Integer> a1 = new ArrayList<Integer>();
//        a1.add(1);
//        Integer inter = new Integer(1);
//        inter.g
//        List<Object> a2 = a1;
        //plus拼接字符串方式
        String s = "";
        long ts = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            s = s + String.valueOf(i);
        }
        long te = System.currentTimeMillis();
        System.out.println("Plus cost {"+( te - ts) +"} ms");
        //concat拼接字符串方式
        String s2 = "";
        long ts2 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            s2 = s2.concat(String.valueOf(i));
        }
        long te2 = System.currentTimeMillis();
        System.out.println("concat cost {"+(te2 - ts2)+"} ms");
        //StringUtils.join拼接字符串方式
        List<String> list = new ArrayList<String>();
        long ts3 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            list.add(String.valueOf(i));
        }
        StringUtils.join(list, "");
        long te3 = System.currentTimeMillis();
        System.out.println("StringUtils.join cost {"+(te3 - ts3)+"} ms");
        //StringBuffer拼接字符串方式
        StringBuffer sb = new StringBuffer();
        long ts4 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sb.append(String.valueOf(i));
        }
        sb.toString();
        long te4 = System.currentTimeMillis();
        System.out.println("StringBuffer cost {"+(te4 - ts4)+"} ms");
        //StringBuilder拼接字符串方式
        StringBuilder sb5 = new StringBuilder();
        long ts5 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sb5.append(String.valueOf(i));
        }
        sb5.toString();
        long te5 = System.currentTimeMillis();
        System.out.println("StringBuilder cost {"+(te5 - ts5)+"} ms");

        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);
        System.out.println(x.equals(y));
    }

    @GetMapping("test2")
    public void test2(){
        try{
//            LettuceConnectionFactory lcf = (LettuceConnectionFactory) stringRedisTemplate.getConnectionFactory();
//            if (lcf != null) {
//                lcf.setDatabase(6);
//                stringRedisTemplate.setConnectionFactory(lcf);
//                this.stringRedisTemplate.opsForValue().set("chunpat","1", 1800);
//            }
            //注意，使用上述方法进行Redis数据库切换后，整个项目的RedisTemplate连接数据库都会被切换。比如，
            // 在UserServiceImpl类中将注入的RedisTemplate的数据库切换到db1，那么EmployeeServiceImpl注入
            // 的RedisTemplate的数据库也会切换至db1。所以这种方法并不是线程安全的，可能会导致数据库中没有存放期待的数据。
            //可以新建新的Jedis连接，Jedis与RedisTemplate彼此独立，或许可以做到一个项目中访问多个Redis数据库。
            //jredis操作
            //连接本地的 Redis 服务
//            Jedis jedis = new Jedis("127.0.0.1",6379);
//            jedis.select(6);
//            System.out.println("连接成功");
//            //设置 redis 字符串数据
//            jedis.setex("runoobkey", 10,"1");

            orderMessageProducer.send(this.topic, "niubi");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
