package com.vg.spring6x.mapper;

import com.vg.spring6x.domain.model.VibrationSamples;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author a8440
* @description 针对表【vibration_samples(振动)】的数据库操作Mapper
* @createDate 2025-12-05 16:32:57
* @Entity com.vg.spring6x.domain.model.VibrationSamples
*/
@Mapper
public interface VibrationSamplesMapper extends BaseMapper<VibrationSamples> {

}




