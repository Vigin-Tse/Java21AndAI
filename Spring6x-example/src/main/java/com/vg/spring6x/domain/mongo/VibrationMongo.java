package com.vg.spring6x.domain.mongo;

import cn.hutool.json.JSONObject;
import com.vg.spring6x.domain.mongo.base.MongoBase;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "vibration_samples")
public class VibrationMongo extends MongoBase {

    private JSONObject data;
}
