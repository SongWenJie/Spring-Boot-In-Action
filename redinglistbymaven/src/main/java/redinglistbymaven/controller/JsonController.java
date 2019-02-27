package redinglistbymaven.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonController {

    @GetMapping("/getnums")
    public int[] getNums(){
        int[] nums = {1,2,3,4,5,6};
        return nums;
    }

}
