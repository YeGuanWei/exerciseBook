package com.hesc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@ServletComponentScan
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