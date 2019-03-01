package springboot_02_data_transactional.model;

/**
 * @program:
 * @description: Author实体类
 * @author: songwenjie
 * @create: 2019-03-01 09:30
 **/
public class Author {
    private long id;
    private String realName;
    private String nickName;

    public Author(){
    }
    public Author(String realName,String nickName){
        this.realName = realName;
        this.nickName = nickName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
