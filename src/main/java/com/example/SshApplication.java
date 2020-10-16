package com.example;

import com.example.base.repository.BaseRepositoryFactoryBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author xiaobu
 * @date 2018/11/20 17:51
 * @descprition   @EnableCaching用于缓存 @EnableJpaRepositories指定repository所在的包
 * @version 1.0    @EnableScheduling开启任务调度  @EnableAsync对@Async开启
 */
@EnableAsync
//@EnableScheduling
@EnableCaching
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.example.repository"}, repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
@Slf4j
public class SshApplication implements CommandLineRunner {



    public static void main(String[] args) {
        SpringApplication.run(SshApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("服务启动完成.....");
    }


}
