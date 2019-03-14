package springboot_02_data_cache_rediscache.model;

import java.io.Serializable;

/**
 * @program:
 * @description:
 * @author: songwenjie
 * @create: 2019-03-14 11:23
 **/
public class User {

    public User(){

    }
    public User (String name){
        this.name = name;
    }

    public User (String name,int id){
        this.name = name;
        this.id = id;
    }

    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
