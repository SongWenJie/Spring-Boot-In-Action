package springboot_02_data_cache_rediscache.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import springboot_02_data_cache_rediscache.model.User;

import javax.xml.bind.ValidationEvent;
import java.util.Random;

/**
 * @program:
 * @description:
 * @author: songwenjie
 * @create: 2019-03-14 11:01
 **/
@Service
//@CacheConfig(cacheNames = "users") //可以使用CacheConfig统一管理缓存名称
public class RedisService {


    /**
    * @Description: 先查看缓存中是否有数据，如果有数据，则直接返回缓存数据；
     * 若没有数据，调用方法并将方法返回值放进缓存
    * @Param: [name]
    * @return: springboot_02_data_cache_rediscache.model.User
    * @Author: songwenjie
    * @Date: 2019/3/14
    */
    @Cacheable(value = "getUser",key = "#name")
    public User getUser(String name) throws Exception{
        Thread.sleep(3 * 1000);

        User user = new User(name);
        return user;
    }

    /** 
    * @Description: 不管有没有缓存都会执行方法并将结果缓存起来
    * @Param: [name] 
    * @return: springboot_02_data_cache_rediscache.model.User 
    * @Author: songwenjie 
    * @Date: 2019/3/14 
    */ 
    @CachePut(value = "getUser",key = "#result.name")
    public User putUser(String name){
        User user = new User(name,new Random().nextInt());
        return user;
    }


    /** 
    * @Description: 移除指定缓存 ,只有@CacheEvict注解的方法返回值可以为void
    * @Param: [name] 
    * @return: void 
    * @Author: songwenjie 
    * @Date: 2019/3/14 
    */ 
    @CacheEvict(value = "getUser",key = "#name")
    public void removeUser(String name){
        //删除持久化的数据
    }
}
