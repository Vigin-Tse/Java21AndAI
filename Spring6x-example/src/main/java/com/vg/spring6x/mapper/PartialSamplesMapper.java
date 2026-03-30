package com.vg.spring6x.mapper;

import com.vg.spring6x.domain.model.PartialSamples;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author a8440
* @description 针对表【partial_samples(局放故障样本库)】的数据库操作Mapper
* @createDate 2025-12-05 14:46:06
* @Entity com.vg.spring6x.domain.model.PartialSamples
*/
@Mapper
public interface PartialSamplesMapper extends BaseMapper<PartialSamples> {

}




