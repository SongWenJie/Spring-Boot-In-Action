package data_datasource;

import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

//@RunWith(SpringJUnit4ClassRunner.class)
////@SpringApplicationConfiguration(WebMain.class)
//@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

@RunWith(SpringRunner.class)
@SpringBootTest
public class jdbcTest {

    @Resource(name="oneJdbcTemplate")
    protected JdbcTemplate jdbcTemplate1;
    @Resource(name="twoJdbcTemplate")
    protected JdbcTemplate jdbcTemplate2;

    @Test
    public void test() throws Exception {
        jdbcTemplate1.update("insert into t_author(id, real_name, nick_name) values(?, ?, ?)", 2, "宋文杰", "songwenjie");
        jdbcTemplate2.update("insert into t_author(id, real_name, nick_name) values(?, ?, ?)", 2, "宋文杰", "songwenjie");
    }
}
