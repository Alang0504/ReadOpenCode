package com.example.read_open_code.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.read_open_code.util.RestClientUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "根据各种条件查看开奖结果统计数据")
@RestController
@RequestMapping(value = "/openCode")
public class OpenCodeController {

    @Value("${open.code.param}")
    private String param;

    @ApiOperation("查找当前开奖号码")
    @GetMapping(value = "/getOpenCode")
    public String getOpenCode() {
        JSONObject paramJson = new JSONObject();
        paramJson.put("data", param);
        JSONObject result = RestClientUtil.executeOpenCode("https://wdweb.tshdjx.com/api/lottery/getLotteryInfo", HttpMethod.POST, paramJson);
        String openCode = result.getString("opencodestr");
        return openCode;
    }

}
