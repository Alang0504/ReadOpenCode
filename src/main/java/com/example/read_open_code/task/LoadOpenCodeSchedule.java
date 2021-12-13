package com.example.read_open_code.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LoadOpenCodeSchedule {

    private static final Logger logger = LoggerFactory.getLogger(LoggerFactory.class);

    @Scheduled(fixedDelay = 60 * 1000)
    public void loadOpenCodeTask() {
        logger.debug("每分钟执行一次 debug");
        logger.info("每分钟执行一次 Info");
        logger.error("每分钟执行一次 error");
    }
}
