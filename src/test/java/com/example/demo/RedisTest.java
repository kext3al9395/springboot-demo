package com.example.demo;

import com.example.demo.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lisen on 2017/6/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DemoApplication.class)
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("springboot:test", "success");
        Assert.assertEquals("success", stringRedisTemplate.opsForValue().get("springboot:test"));
    }

    @Test
    public void redisSerializerTest() {
        User user = new User();
        user.setName("蜘蛛侠");
        user.setAge(22);
        redisTemplate.opsForValue().set("springboot:" + user.getName(), user);

        user.setName("蝙蝠侠");
        user.setAge(35);
        redisTemplate.opsForValue().set("springboot:" + user.getName(), user);

        user.setName("闪电侠");
        user.setAge(25);
        redisTemplate.opsForValue().set("springboot:" + user.getName(), user);

        Assert.assertEquals(22, redisTemplate.opsForValue().get("springboot:蜘蛛侠").getAge().longValue());
        Assert.assertEquals(35, redisTemplate.opsForValue().get("springboot:蝙蝠侠").getAge().longValue());
        Assert.assertEquals(25, redisTemplate.opsForValue().get("springboot:闪电侠").getAge().longValue());


    }

}
