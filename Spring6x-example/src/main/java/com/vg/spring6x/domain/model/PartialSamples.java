package com.vg.spring6x.domain.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 局放故障样本库
 * @TableName partial_samples
 */
@TableName(value ="partial_samples")
@Data
public class PartialSamples implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 故障类型，airgap=间隙；float=悬浮；particle=颗粒；point=尖端
     */
    private String faultType;

    /**
     * 关联mongdoDB 局放图谱
     */
    private String mongoId;

    private String deviceType;

    /**
     * 峰值
     */
    private Double peak;

    /**
     * 平均值
     */
    private Double avg;

    /**
     * 峰值相位
     */
    private Integer peakphase;

    /**
     * 脉冲次数
     */
    private Integer frequency;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}