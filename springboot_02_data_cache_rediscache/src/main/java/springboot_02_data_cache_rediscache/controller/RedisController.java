package springboot_02_data_cache_rediscache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot_02_data_cache_rediscache.model.User;
import springboot_02_data_cache_rediscache.service.RedisService;

/**
 * @program:
 * @description:
 * @author: songwenjie
 * @create: 2019-03-14 11:02
 **/
@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;

    @GetMapping("/getUser")
    public User getUser(String name) throws Exception{
        return redisService.getUser(name);
    }


    @PostMapping("/putUser")
    public User putUser(String name){
        return redisService.putUser(name);
    }


    @DeleteMapping("/removeUser")
    public void removeUser(String name){
        redisService.removeUser(name);
    }
}
