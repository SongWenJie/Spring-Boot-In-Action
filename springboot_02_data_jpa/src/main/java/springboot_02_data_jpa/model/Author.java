package springboot_02_data_jpa.model;

import javax.persistence.*;

/**
 * @program:
 * @description: Author实体类
 * @author: songwenjie
 * @create: 2019-02-27 16:15
 **/
@Entity
@Table(name = "t_author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "real_name")
    private String realName;
    @Column(name="nick_name")
    private String nickName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
