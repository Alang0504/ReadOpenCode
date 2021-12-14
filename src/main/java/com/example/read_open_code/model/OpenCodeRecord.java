package com.example.read_open_code.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalTime;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 开奖结果记录表
 * </p>
 *
 * @author aLang
 * @since 2021-12-13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class OpenCodeRecord extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "record_id", type = IdType.AUTO)
    private Long recordId;

    /**
     * 开奖结果
     */
    private String codeResult;

    /**
     * 最后两位开奖码
     */
    private String lastCode;

    /**
     * 开奖日期
     */
    private LocalDate openDate;

    /**
     * 开奖时间
     */
    private LocalTime openTime;

    /**
     * 记录创建时间(正常是open_date+open_time)
     */
    private LocalDateTime createTime;


}
