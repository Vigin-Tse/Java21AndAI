package com.vg.spring6x.mapper;

import com.vg.spring6x.domain.model.BasDevice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author a8440
* @description 针对表【bas_device(设备信息)】的数据库操作Mapper
* @createDate 2026-04-01 09:58:50
* @Entity com.vg.spring6x.domain.model.BasDevice
*/
@Mapper
public interface BasDeviceMapper extends BaseMapper<BasDevice> {

}




