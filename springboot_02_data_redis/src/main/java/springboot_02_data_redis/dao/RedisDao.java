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

//    ValueOperations是更具体的操作接口,使用的是默认的RedisTemplate
//    默认的RedisTemplate没有提供针对key编码的处理
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
