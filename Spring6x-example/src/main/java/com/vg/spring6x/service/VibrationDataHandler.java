package com.vg.spring6x.service;

import cn.hutool.json.JSONObject;
import com.vg.spring6x.domain.model.VibrationSamples;
import com.vg.spring6x.domain.mongo.VibrationMongo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class VibrationDataHandler extends AbstractFaultDataHandler{

    @Autowired
    private VibrationSamplesService vibrationSamplesService;

    @Autowired
    private MongoTemplate mongoTemplate;

    public static List<String> faultList = new ArrayList<>();

    @Override
    protected void handleFaultData(String filePath, JSONObject jsonObject) {
        long startTime = System.nanoTime();

        VibrationMongo vibrationMongo = new VibrationMongo();
        vibrationMongo.setData(jsonObject);

        vibrationMongo = mongoTemplate.save(vibrationMongo);


        VibrationSamples vibrationSamples = new VibrationSamples();
        vibrationSamples.setMongoId(vibrationMongo.getId());
        vibrationSamples.setDeviceType("motor");
        vibrationSamples.setSource(filePath.replace("E:\\桌面资料收纳\\故障样本数据\\振动", ""));
        vibrationSamplesService.save(vibrationSamples);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        log.info("filePath={}, 方法执行时长:{} ms", filePath,  duration / 1_000_000);
    }
}
