package com.vg.spring6x.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vg.spring6x.domain.model.BasDevice;
import com.vg.spring6x.service.BasDeviceService;
import com.vg.spring6x.mapper.BasDeviceMapper;
import org.springframework.stereotype.Service;

/**
* @author a8440
* @description 针对表【bas_device(设备信息)】的数据库操作Service实现
* @createDate 2026-04-01 09:58:50
*/
@Service
public class BasDeviceServiceImpl extends ServiceImpl<BasDeviceMapper, BasDevice>
    implements BasDeviceService{

}




