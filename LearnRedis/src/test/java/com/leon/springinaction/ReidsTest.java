package com.leon.springinaction;

import com.leon.springinaction.bean.Product;
import com.leon.springinaction.config.RedisConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

/**
 * Unit test for simple App.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RedisConfig.class)
public class ReidsTest
{

    @Autowired
    private RedisConnectionFactory cf;

//    @Autowired
//    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private RedisTemplate<String, Product> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testUseRedis() {
        RedisConnection connection = cf.getConnection();
        connection.set("greeting".getBytes(), "Hello world".getBytes());
        byte[] greetingBytes = connection.get("greeting".getBytes());
        String greeting = new String(greetingBytes);
        Assert.assertEquals(greeting, "Hello world");
    }

//    @Test
//    public void testRedisTemplate() {
//        redisTemplate.opsForValue().set("name123", "pxl");
//        String name = redisTemplate.opsForValue().get("name123");
//        Assert.assertEquals(name, "pxl");
//    }

    @Test
    public void testStringRedisTemplate() {
        stringRedisTemplate.opsForValue().set("name1234", "pxl111");
        String name = stringRedisTemplate.opsForValue().get("name1234");
        Assert.assertEquals(name, "pxl111");
    }

    @Test
    public void testUseList() {
        //队列尾部添加一个元素
        redisTemplate.opsForList().rightPush("cart", new Product("cart1value"));
        //队列首部添加一个元素
        redisTemplate.opsForList().leftPush("cart", new Product("cart2value"));

//        Product p = redisTemplate.opsForList().rightPop("cart");
        //获取从索引为2的到12（不包括）的元素列,超出列表范围,则只返回包含索引的元素
        List<Product> plist = redisTemplate.opsForList().range("cart", 0, 12);

        for (Product item : plist) {
            System.out.println(item.getName());
        }

    }

    @Test
    public void testUseSet() {
//        Product p1 = new Product("haha1");
//        Product p2 = new Product("haha2");
//        Product p3 = new Product("haha3");
//        redisTemplate.opsForSet().add("cart1", p1);
//        redisTemplate.opsForSet().add("cart1", p1);
//        redisTemplate.opsForSet().add("cart2", p1);
//        redisTemplate.opsForSet().add("cart2", p3);


        System.out.println("cart1:");
        for (Product p : redisTemplate.opsForSet().members("cart1")) {
            System.out.println(p.getName());
        }

        System.out.println("cart2:");
        for (Product p : redisTemplate.opsForSet().members("cart2")) {
            System.out.println(p.getName());
        }

        //差集
        Set<Product> diff = redisTemplate.opsForSet().difference("cart2", "cart1");
        System.out.println("差集:");
        for (Product p : diff) {
            System.out.println(p.getName());
        }

        //并集
        Set<Product> union = redisTemplate.opsForSet().union("cart1", "cart2");
        System.out.println("并集:");
        for (Product p : union) {
            System.out.println(p.getName());
        }
        //交集
        Set<Product> isect = redisTemplate.opsForSet().intersect("cart1", "cart2");
        System.out.println("交集:");
        for (Product p : isect) {
            System.out.println(p.getName());
        }

//        redisTemplate.opsForSet().remove("cart2", p1);

    }



}
