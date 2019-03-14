package springboot_02_data_cache_rediscache.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @program: 在spring中，有两种Redis缓存操作方式。
 * 第一种是使用redisTemplate手动管理
 * 第二种是使用@EnableCaching开启缓存支持，采用声明式缓存管理
 * @description:
 * @author: songwenjie
 * @create: 2019-03-14 10:56
 **/
@Configuration
@EnableCaching //开启缓存支持
@PropertySource(value = "classpath:config/redis.properties")
public class RedisConfig {
    @Autowired
    private Environment env;

    /**
     * @Description: 自定义Jedis连接池
     * @Param: []
     * @return: redis.clients.jedis.JedisPoolConfig
     * @Author: songwenjie
     * @Date: 2019/2/28
     */
    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //最大连接数
        jedisPoolConfig.setMaxTotal(100);
        //最小空闲连接数
        jedisPoolConfig.setMinIdle(20);
        //当池内没有可用连接时，最大等待时间
        jedisPoolConfig.setMaxWaitMillis(10000);
        //其他属性可以自行添加
        return jedisPoolConfig;
    }

    /**
     * @Description: 使用了jedis连接池的RedisConnectionFactory
     * @Param: [jedisPoolConfig]
     * @return: org.springframework.data.redis.connection.RedisConnectionFactory
     * @Author: songwenjie
     * @Date: 2019/2/28
     */
    @Bean
    public RedisConnectionFactory redisConnectionFactory(JedisPoolConfig jedisPoolConfig){
        //单机配置
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(env.getProperty("redis.host").trim());
        redisStandaloneConfiguration.setPort(Integer.parseInt(env.getProperty("redis.port").trim()));
        redisStandaloneConfiguration.setDatabase(Integer.parseInt(env.getProperty("redis.database").trim()));
        redisStandaloneConfiguration.setPassword(env.getProperty("redis.password").trim());

        //这里需要注意的是，edisConnectionFactoryJ对于Standalone模式的没有（RedisStandaloneConfiguration，JedisPoolConfig）的构造函数，对此
        //我们用JedisClientConfiguration接口的builder方法实例化一个构造器，还得类型转换
        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder jpcf = (JedisClientConfiguration.JedisPoolingClientConfigurationBuilder) JedisClientConfiguration.builder();
        //修改我们的连接池配置
        jpcf.poolConfig(jedisPoolConfig);
        //通过构造器来构造jedis客户端配置
        JedisClientConfiguration jedisClientConfiguration = jpcf.build();
        return new JedisConnectionFactory(redisStandaloneConfiguration,jedisClientConfiguration);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        //通过JavaConfig创建自定义redisTemplate时，可以在此处进行编码统一处理
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setValueSerializer(redisSerializer);

        //默认编码处理
        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }

    /** 
    * @Description: 使用RedisCacheManage进行声明式缓存管理,RedisCache编码处理,防止Redis存储乱码
    * @Param: [] 
    * @return: org.springframework.data.redis.cache.RedisCacheConfiguration 
    * @Author: songwenjie 
    * @Date: 2019/3/14 
    */ 
    @Bean
    public RedisCacheConfiguration redisCacheConfiguration() {
        return RedisCacheConfiguration
                .defaultCacheConfig()
                .serializeKeysWith(
                        RedisSerializationContext
                                .SerializationPair
                                .fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(
                        RedisSerializationContext
                                .SerializationPair
                                .fromSerializer(new GenericJackson2JsonRedisSerializer()));
    }
}
