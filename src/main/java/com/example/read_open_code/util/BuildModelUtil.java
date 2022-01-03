package com.example.read_open_code.util;

import com.example.read_open_code.model.po.OpenCodeRecord;

import java.time.LocalDateTime;

public class BuildModelUtil {

    public static OpenCodeRecord buildOpenCodeRecord(String codeResult, String lastCode) {
        //获取当前本地时间
        LocalDateTime currentTime = LocalDateTime.now();
        OpenCodeRecord openCodeRecord = new OpenCodeRecord();
        openCodeRecord.setCodeResult(codeResult);
        openCodeRecord.setLastCode(lastCode);
        openCodeRecord.setOpenDate(currentTime.toLocalDate());
        openCodeRecord.setOpenTime(currentTime.toLocalTime());
        openCodeRecord.setCreateTime(currentTime);

        return openCodeRecord;
    }
}
