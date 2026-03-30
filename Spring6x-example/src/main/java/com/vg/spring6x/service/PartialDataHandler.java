package com.vg.spring6x.service;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.vg.spring6x.domain.model.PartialSamples;
import com.vg.spring6x.domain.mongo.PartialMongo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class PartialDataHandler extends AbstractFaultDataHandler{

    @Autowired
    private PartialSamplesService partialSamplesService;

    @Autowired
    private MongoTemplate mongoTemplate;

    public static List<String> faultList = new ArrayList<>();

    @Override
    protected void handleFaultData(String filePath, JSONObject jsonObject) {
        long startTime = System.nanoTime();

        Map<String,List<String>> data = null;
        try {
            data = JSONUtil.toBean(jsonObject, Map.class);
        } catch (Exception e) {
            System.out.println("处理文件失败：" + filePath);
            faultList.add(filePath);
            return;
        }

        String faultType = "";
        double peak = 0;
        int peakPhase=0;
        int frequency = 0;

        double avg = 0;

        int totalPoints = 0;
        double totalSum = 0;

        // 判断类型 airgap=间隙；float=悬浮；particle=颗粒；point=尖端
        if (filePath.contains("airgap"))
            faultType = "airgap";
        else if (filePath.contains("float"))
            faultType = "float";
        else if (filePath.contains("particle"))
            faultType = "particle";
        else
            faultType = "point";

        for (Map.Entry entry : data.entrySet()){
            List<String> values = (List<String>) entry.getValue();
            totalPoints += values.size();

            for (int i = 0; i < values.size(); i++){
                double value = Double.parseDouble(values.get(i));
                totalSum += value;

                if (value > peak){
                    peak = value;
                    peakPhase = i + 1;
                }

                if (value > 0.0)
                    frequency += 1;
            }
        }

        avg = NumberUtil.round(totalSum / totalPoints, 2).doubleValue();
        peak = NumberUtil.round(peak, 2).doubleValue();

        // 保存到MongoDB
        PartialMongo partialMongo = new PartialMongo();
        partialMongo.setAtlasData(data);
        partialMongo.setFaultType(faultType);
        partialMongo.setPeak(peak);
        partialMongo.setAvg(avg);
        partialMongo.setPeakphase(peakPhase);
        partialMongo.setFrequency(frequency);
        partialMongo = mongoTemplate.save(partialMongo);

        PartialSamples partialSamples = new PartialSamples();
        partialSamples.setFaultType(faultType);
        partialSamples.setMongoId(partialMongo.getId());
        partialSamples.setPeak(peak);
        partialSamples.setAvg(avg);
        partialSamples.setPeakphase(peakPhase);
        partialSamples.setFrequency(frequency);
        partialSamplesService.save(partialSamples);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        log.info("方法执行时长:{} ms",  duration / 1_000_000);
    }
}
