package springboot_02_data_redis.dao;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @program:
 * @description:
 * @author: songwenjie
 * @create: 2019-02-28 14:57
 **/
@Repository
public class RedisDao {

    @Resource
    private  RedisTemplate<String,Object> redisTemplate;

//    ValueOperations是更具体的操作接口,包含在RedisTemplate模板类中
//    spring-data-redis的RedisTemplate<K, V>模板类在操作redis时默认使用JdkSerializationRedisSerializer来进行序列化
//    @Resource(name = "redisTemplate")
//    protected ValueOperations<String,Object> valueOperations;

    public void addValue(String key,Object value){
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setValueSerializer(redisSerializer);

        ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, value);
    }

    public Object getValue(String key){
        RedisSerializer<String> redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setValueSerializer(redisSerializer);

        ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }
}
