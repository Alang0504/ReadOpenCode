package com.example.read_open_code.task;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.example.read_open_code.dao.OpenCodeRecordMapper;
import com.example.read_open_code.model.OpenCodeRecord;
import com.example.read_open_code.util.BuildModelUtil;
import com.example.read_open_code.util.RestClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class LoadOpenCodeSchedule {

    private static final Logger logger = LoggerFactory.getLogger(LoggerFactory.class);

    private final OpenCodeRecordMapper openCodeRecordMapper;

    //@Autowired,spring4.3之后构造器注入注解可以省略,隐式注入
    public LoadOpenCodeSchedule(OpenCodeRecordMapper openCodeRecordMapper) {
        this.openCodeRecordMapper = openCodeRecordMapper;
    }

    @Scheduled(fixedDelay = 60 * 1000)
    public void loadOpenCodeTask() {
        try {
            /*String url = "";
            JSONObject param = new JSONObject();
            JSONObject result = RestClientUtil.executeOpenCode(url, HttpMethod.GET, param);
            String openCode = result.getString("opencodestr");
            String lastCode = StrUtil.isNotBlank(openCode) ? openCode.substring(openCode.length() - 2) : openCode;
            OpenCodeRecord openCodeRecord = BuildModelUtil.buildOpenCodeRecord(openCode, lastCode);

            openCodeRecordMapper.insert(openCodeRecord);*/
            logger.info("执行定时任务");
        } catch (Exception e) {
            logger.error("执行定时任务出错!!!!", e);
        }

    }

}
