package mybatis;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import com.vg.spring6x.Spring6xApplication;
import com.vg.spring6x.domain.mongo.TestMongo;
import com.vg.spring6x.service.BasDeviceService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

@Slf4j
@SpringBootTest(classes = Spring6xApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MybatisTest {

    @Resource
    private BasDeviceService basDeviceService;

    @Test
    public void testQueryDevice(){
        log.info("查询设备：{}", JSONUtil.toJsonStr(basDeviceService.list()));
    }
}
