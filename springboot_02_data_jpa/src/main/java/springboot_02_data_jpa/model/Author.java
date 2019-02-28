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
    //JPA提供的四种标准用法为TABLE,SEQUENCE,IDENTITY,AUTO.
    //TABLE：使用一个特定的数据库表格来保存主键。
    //SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。
    //IDENTITY：主键由数据库自动生成（主要是自动增长型）
    //AUTO：主键由程序控制。
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
