package springboot_02_data_redis.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisDaoTest {

    @Autowired
    private RedisDao redisDao;

    @Test
    public void addValue() throws Exception {
        redisDao.addValue("testkey","testvalue");
        Object value = redisDao.getValue("testkey");
        System.out.println(value);
    }
}