package springboot_02_data_cache_concurrenmapcache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot_02_data_cache_concurrenmapcache.service.CacheService;

/**
 * @program:
 * @description:
 * @author: songwenjie
 * @create: 2019-03-01 11:29
 **/
@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @GetMapping("/getCache")
    public String getCache(){
       Long startTime = System.currentTimeMillis();
       long timestamp = this.cacheService.getByCache();
       Long endTime = System.currentTimeMillis();
       System.out.println("耗时: " + (endTime - startTime));
       return timestamp+"";
    }

    @PostMapping("/save")
    public void save(){
        this.cacheService.save();
    }

    @PostMapping("/delete")
    public void delete(){
        this.cacheService.delete();
    }
}
