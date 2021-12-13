package com.example.read_open_code.service;

import com.example.read_open_code.model.OpenCodeRecord;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 开奖结果记录表 服务类
 * </p>
 *
 * @author aLang
 * @since 2021-12-13
 */
public interface IOpenCodeRecordService extends IService<OpenCodeRecord> {
    OpenCodeRecord getOpenCodeByDate();
}
