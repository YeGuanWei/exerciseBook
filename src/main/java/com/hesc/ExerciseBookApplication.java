package com.hesc;

import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ServletComponentScan
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "PT5M")//默认分布式锁的时间
@EnableSwagger2
@EnableAsync
@MapperScan({"com.hesc.mapper", "com.hesc.model.obj.mapper"})
public class ExerciseBookApplication extends SpringBootServletInitializer {

    private static final Logger log = LogManager.getLogger(ExerciseBookApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ExerciseBookApplication.class);
    }

    public static void main(String[] args) {
        // 启动时间计时
        long startTime = System.currentTimeMillis();
        // 启动项目
        SpringApplication.run(ExerciseBookApplication.class, args);
        // 输出启动时间
        log.info("启动完成，耗时：" + (System.currentTimeMillis() - startTime) / 1000.0 + "秒");
    }

}