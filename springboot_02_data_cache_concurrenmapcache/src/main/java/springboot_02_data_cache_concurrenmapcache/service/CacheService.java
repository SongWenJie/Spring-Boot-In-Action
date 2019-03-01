package springboot_02_data_cache_concurrenmapcache.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * @program:
 * @description:
 * @author: songwenjie
 * @create: 2019-03-01 11:21
 **/
@Service
public class CacheService {

    /** 
    * @Description: @Cacheable 在方法执行前 Spring 先查看缓存中是否有数据，如果有数据，则直接返回缓存数据；
     * 若没有数据，调用方法并将方法返回值放进缓存
    * @Param: [] 
    * @return: long 
    * @Author: songwenjie 
    * @Date: 2019/3/1 
    */ 
    @Cacheable(value = "ConcurrentMapCache")
    public long getByCache(){
        try{
            Thread.sleep(3 * 1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Timestamp(System.currentTimeMillis()).getTime();
    }

    /**
    * @Description:  @CachePut与@Cacheable类似，但是它无论什么情况，都会将方法的返回值放到缓存中, 主要用于数据新增和修改方法
    * @Param: []
    * @return: long
    * @Author: songwenjie
    * @Date: 2019/3/1
    */
    @CachePut(value = "ConcurrentMapCache")
    public long save(){
        long time = new Timestamp(System.currentTimeMillis()).getTime();
        System.out.println("进行缓存");
        return time;
    }

    /** 
    * @Description: @CacheEvict 将一条或多条数据从缓存中删除, 主要用于删除方法，用来从缓存中移除相应数据
    * @Param: [] 
    * @return: void 
    * @Author: songwenjie 
    * @Date: 2019/3/1 
    */ 
    @CacheEvict(value = "ConcurrentMapCache")
    public void delete(){
        System.out.println("删除缓存");
    }

}
