package com.example.read_open_code.task;

import com.example.read_open_code.dao.OpenCodeRecordMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class LoadOpenCodeSchedule {

    private static final Logger logger = LoggerFactory.getLogger(LoggerFactory.class);

    private final OpenCodeRecordMapper openCodeRecordMapper;

    @Value("${open.code.param}")
    private  String param;

    //@Autowired,spring4.3之后构造器注入注解可以省略,隐式注入
    public LoadOpenCodeSchedule(OpenCodeRecordMapper openCodeRecordMapper) {
        this.openCodeRecordMapper = openCodeRecordMapper;
    }

    @Scheduled(fixedDelay = 60 * 1000)
    public void loadOpenCodeTask() {
        try {

            /*JSONObject paramJson = new JSONObject();
            paramJson.put("data", param);
            JSONObject result = RestClientUtil.executeOpenCode("https://wdweb.tshdjx.com/api/lottery/getLotteryInfo", HttpMethod.POST, paramJson);
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
