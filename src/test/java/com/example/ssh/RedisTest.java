package com.example.ssh;

import com.example.base.redis.RedisRepository;
import com.example.entity.Area;
import com.example.service.AreaService;
import com.example.base.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * @author xiaobu
 * @version JDK1.8.0_171
 * @date on  2018/11/21 15:42
 * @description V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisTest {
    @Autowired
    RedisRepository redisRepository;

    @Autowired
    RedisTemplate<String, Serializable> redisTemplate;

    @Autowired
    AreaService areaService;


    @Test
    public void testRedis() {
        redisRepository.setKey("name", "xiaobu");
        redisRepository.setKey("age", "24");
        log.info(redisRepository.getValue("name"));
        log.info(redisRepository.getValue("age"));
    }


    @Test
    public void test() {
        // TODO 以下只演示整合，具体Redis命令可以参考官方文档，Spring Data Redis 只是改了个名字而已，Redis支持的命令它都支持
        String key = "example:area:1";
        redisTemplate.opsForValue().set(key, new Area(1, "admin", DateUtil.getCurrentDateTimeToStr1()), 1, TimeUnit.MINUTES);
        // TODO 对应 String（字符串）
        final Area area = (Area) redisTemplate.opsForValue().get(key);
        log.info("[对象缓存结果] - [{}]", area);
    }


    @Test
    public void testRedisEcache() {
        Area area = areaService.saveOrUpdate(new Area(5, "u5", "d5"));
        log.info("[saveOrUpdate] - [{}]", area);
        Area area1 = areaService.get(5);
        log.info("[get] - [{}]", area1);
        area = areaService.saveOrUpdate(area);
        log.info("[saveOrUpdate2] - [{}]", area);
        areaService.delete(5);
        area1 = areaService.get(5);
        log.info("[get2] - [{}]", area1);
    }



    @Test
    public void testRedisEcache2() {
        Area area = areaService.saveOrUpdate(new Area(5, "u5", "d5"));
        log.info("[saveOrUpdate] - [{}]", area);
        area = areaService.saveOrUpdate(area);
        log.info(area.toString());
    }
}
