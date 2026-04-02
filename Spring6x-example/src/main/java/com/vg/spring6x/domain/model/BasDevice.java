package com.vg.spring6x.domain.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 设备信息
 * @TableName bas_device
 */
@TableName(value ="bas_device")
@Data
public class BasDevice implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 设备编码(命名规则：项目编码.模型类别.设备类型_编号)
     */
    private String deviceCode;

    /**
     * 名称
     */
    private String deviceName;

    /**
     * 类型代码
     */
    private String deviceType;

    /**
     * 责任部门
     */
    private Integer responsibleDepartmentId;

    /**
     * 上级设备id
     */
    private Integer parentId;

    /**
     * 地铁线路编码
     */
    private String lineCode;

    /**
     * 项目编码
     */
    private String xCode;

    /**
     * 站点编码
     */
    private String stationCode;

    /**
     * 站点名称
     */
    private String stationName;

    /**
     * 边端编码
     */
    private String edgeCode;

    /**
     * 边端设备描述(如：36kV配电房，第一排开关柜)
     */
    private String edgeName;

    /**
     * 型号
     */
    private String model;

    /**
     * 安装处
     */
    private String insLocation;

    /**
     * 投运日期
     */
    private String serialSn;

    /**
     * 图片资源路径
     */
    private String picPath;

    /**
     * 厂家
     */
    private String manufactor;

    /**
     * 出厂日期
     */
    private Date manufactureDate;

    /**
     * 备注
     */
    private String remark;

    /**
     * 启用状态(1启用，0不启用)
     */
    private Integer enableStatus;

    /**
     * 额定参数
     */
    private String ratedParam;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    /**
     * 
     */
    private String createUser;

    /**
     * 
     */
    private String updateUser;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

}