package com.vg.spring6x.domain.mongo;

import cn.hutool.core.util.IdUtil;
import com.vg.spring6x.domain.mongo.base.MongoBase;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "test")
public class TestMongo extends MongoBase {

    private String message;
}
