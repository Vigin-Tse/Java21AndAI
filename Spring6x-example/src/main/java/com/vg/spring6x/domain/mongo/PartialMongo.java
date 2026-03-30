package com.vg.spring6x.domain.mongo;

import com.vg.spring6x.domain.mongo.base.MongoBase;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@Document(collection = "partial_samples")
public class PartialMongo extends MongoBase {

    private Map<String, List<String>> atlasData;

    /**
     * 故障类型，airgap=间隙；float=悬浮；particle=颗粒；point=尖端
     */
    private String faultType;

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
}
