package com.vg.spring6x.domain.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 振动
 * @TableName vibration_samples
 */
@TableName(value ="vibration_samples")
@Data
public class VibrationSamples implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 设备类型
     */
    private String deviceType;

    /**
     * 数据来源（暂时当做数据过滤条件）
     */
    private String source;

    /**
     * 
     */
    private String mongoId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}