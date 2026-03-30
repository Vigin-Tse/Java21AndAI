package mongo;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import com.vg.spring6x.Spring6xApplication;
import com.vg.spring6x.domain.mongo.TestMongo;
import com.vg.spring6x.service.PartialDataHandler;
import com.vg.spring6x.service.VibrationDataHandler;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

@Slf4j
@SpringBootTest(classes = Spring6xApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MongoTest {

    @Resource
    private MongoTemplate mongoTemplate;

    @Resource
    private PartialDataHandler partialDataHandler;

    @Resource
    private VibrationDataHandler vibrationDataHandler;

    @Test
    public void addMongoTest(){
        TestMongo testMongo = new TestMongo();
        testMongo.setMessage("test-" + DateUtil.format(DateUtil.date(), "yyyy-MM-dd HH:mm:ss"));
        mongoTemplate.save(testMongo);

        TestMongo query = mongoTemplate.findById(testMongo.getId(), TestMongo.class);
        System.out.println(JSONUtil.toJsonStr(query));
    }

    @Test
    public void handlerPartialData(){
        long startTime = System.nanoTime();
        partialDataHandler.processJsonFilesRecursively("E:\\桌面资料收纳\\故障样本数据\\局放");
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        log.info("总耗时:{} ms, 失败 = {}",  duration / 1_000_000, JSONUtil.parseObj(PartialDataHandler.faultList));

    }

    @Test
    public void handlerVibrationData(){
        long startTime = System.nanoTime();
        vibrationDataHandler.processJsonFilesRecursively("E:\\桌面资料收纳\\故障样本数据\\振动\\simulation\\no");
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        log.info("总耗时:{} ms, 失败 = {}",  duration / 1_000_000, JSONUtil.parseObj(PartialDataHandler.faultList));

    }
}
