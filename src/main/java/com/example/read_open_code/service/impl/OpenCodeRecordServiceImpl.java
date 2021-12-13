package com.example.read_open_code.service.impl;

import com.example.read_open_code.model.OpenCodeRecord;
import com.example.read_open_code.dao.OpenCodeRecordMapper;
import com.example.read_open_code.service.IOpenCodeRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 开奖结果记录表 服务实现类
 * </p>
 *
 * @author aLang
 * @since 2021-12-13
 */
@Service
public class OpenCodeRecordServiceImpl extends ServiceImpl<OpenCodeRecordMapper, OpenCodeRecord> implements IOpenCodeRecordService {

    @Override
    public OpenCodeRecord getOpenCodeByDate() {
        return getBaseMapper().selectById(1);
    }
}
