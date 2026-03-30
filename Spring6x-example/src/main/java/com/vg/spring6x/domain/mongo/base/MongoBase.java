package com.vg.spring6x.domain.mongo.base;

import cn.hutool.core.lang.UUID;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class MongoBase {

    @Id
    private String id;

    public MongoBase() {
        this.setId(UUID.fastUUID().toString(true));
    }
}
