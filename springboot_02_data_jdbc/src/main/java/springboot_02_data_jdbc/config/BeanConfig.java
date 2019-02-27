package springboot_02_data_jdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;


@Configuration
@EnableTransactionManagement
@PropertySource(value = {"classpath:config/source.properties"})
public class BeanConfig {

    @Autowired
    private Environment env;

    @Bean(destroyMethod="close")
    public DataSource dataSource(){
        DataSource dataSource = new DruidDataSource();
        ((DruidDataSource) dataSource).setDriverClassName(env.getProperty("source.driverClassName").trim());
        ((DruidDataSource) dataSource).setUrl(env.getProperty("source.url").trim());
        ((DruidDataSource) dataSource).setUsername(env.getProperty("source.username"));
        ((DruidDataSource) dataSource).setPassword(env.getProperty("source.password"));
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate =new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
}
