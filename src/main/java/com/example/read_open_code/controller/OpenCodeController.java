package com.example.read_open_code.controller;

import com.example.read_open_code.model.OpenCodeRecord;
import com.example.read_open_code.service.IOpenCodeRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "根据各种条件查看开奖结果统计数据")
@RestController
@RequestMapping(value = "/openCode")
public class OpenCodeController {

    @Autowired
    private IOpenCodeRecordService openCodeRecordService;

    @ApiOperation("根据日期查找，按开奖码次数升序排序")
    @GetMapping(value = "/getOpenCode")
    public OpenCodeRecord getOpenCode() {
        return openCodeRecordService.getOpenCodeByDate();
    }

}
