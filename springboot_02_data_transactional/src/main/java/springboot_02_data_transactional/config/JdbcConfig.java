package springboot_02_data_transactional.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @program:
 * @description: JDBC配置类
 * @author: songwenjie
 * @create: 2019-03-01 09:11
 **/
@Configuration
@PropertySource(value = "classpath:config/source.properties")
//声明式事务
//使用了 @EnableTransactionManagement 后，Spring 会自动扫描注解 @Transactional 的方法和类。
@EnableTransactionManagement
public class JdbcConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource(){
        DataSource dataSource = new DruidDataSource();
        ((DruidDataSource) dataSource).setUrl(env.getProperty("source.url").trim());
        ((DruidDataSource) dataSource).setDriverClassName(env.getProperty("source.driverClassName").trim());
        ((DruidDataSource) dataSource).setUsername(env.getProperty("source.username").trim());
        ((DruidDataSource) dataSource).setPassword(env.getProperty("source.password").trim());
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate =new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

}
